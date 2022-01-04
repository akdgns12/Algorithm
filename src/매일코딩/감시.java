package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 로직
 * 1. 순열로 CCTV별 감시 방향을 정해준다.
 * 1-1 감시 방향을 설정할 때 CCTV마다 규칙이 있으니 주의해서 설정
 * 2. 정해진 방향을 기준으로 감시영역을 표시한다.
 * 3. 남은 사각지대의 영역을 카운트 해준다.
 * 처음에는 CCTV
 */
public class 감시{
	static class CCTV{ // 각 cctv의 정보를 담을 객체
		int y, x, dir, type;
		
		CCTV(int y, int x, int dir, int type){
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.type = type;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}; // 우, 상, 좌, 하 -> 반시계 방향으로 인덱스를 사용할 예정
	static int[] dy = {0, -1, 0, 1};
	static ArrayList<CCTV> cctvList;
	static int result = Integer.MAX_VALUE;
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cctvList = new ArrayList<>();
			map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] >=1 && map[i][j] <= 5) { //cctv인 경우만 
						// y, x, 방향, type
						cctvList.add(new CCTV(i, j, 0, map[i][j]));
					}
				}
			} // end of input
			// type별로 CCTV의 방향을 정하자.
			selectCCTVdir(0, cctvList.size());
			System.out.println(result);
		}
		
		/*
		 * 전체 CCTV의 방향을 정할 순열 DFS
		 * idx : cctv 카운트
		 * listsize : 전체 cctv 개수
		 */
		public static void selectCCTVdir(int idx, int listsize) {
			if(idx == listsize) { // cctv 배치완료
				int[][] copyMap = new int[N][M]; // 맵 복사해서 쓸거야
				initMap(copyMap); // 맵 복사
				setRoute(copyMap); // 감시 영역 설정
				int cnt = findZero(copyMap); // 0카운트
				
				result = Math.min(result, cnt); // 최솟값 갱신
				return;
			}
			
			int dir = 4; // 2번 카메라를 제외한 나머지는 0, 1, 2, 3 방향 모두 이용
			for(int i=idx; i<listsize; i++) {
				CCTV cctv = cctvList.get(i);
				if(cctv.type == 5) { // 5번 카메라는 방향 설정 필요 x
					selectCCTVdir(i+1, listsize);
					continue;
				}
				if(cctv.type == 2) dir = 2; // 2번 카메라는 우, 상만 있으면 된다.
				for(int d=0; d<dir; d++) {
					//시작 방향을 정해주자
					cctv.dir = d;
					selectCCTVdir(i+1, listsize);
				}
			}
		}

		// 0의 갯수를 카운팅
		public static int findZero(int[][] copyMap) {
			int res = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copyMap[i][j] == 0) res++;
				}
			}
			return res;
		}
		// 맵복사
		public static void initMap(int[][] copyMap) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
		}
		
		// CCTV의 방향대로 -1을 채워주자
		public static void setRoute(int[][] copyMap) {
			// 모든 CCTV의 정보를 얻어오자
			for(int i=0; i<cctvList.size(); i++) {
				CCTV curCCTV = cctvList.get(i);
				int ny = curCCTV.y;
				int nx = curCCTV.x;
				int dir = curCCTV.dir;
				int type = curCCTV.type;
				for(int d=0; d<4; d++) {
					if(type == 1) { // 1번 카메라는 한 방향
						if(d !=0 ) continue;
					}
					else if(type == 2) { // 2번 카메라는 선택한 방향 + 180도  뒤 방향
						if(d == 1 || d == 2) continue;
					}
					else if(type == 3) { // 3번 카메라 선택 방향 + 90도
						if(d == 2 || d == 3) continue;
					}
					else if(type == 4) { // 4번 카메라 선택방향 + 90도 + 180도
						if(d == 3) continue;
					}// 5번 카메라는 4방향
					ny += dy[(dir+d)%4]; // 나머지 연산으로 인덱스 계산
					nx += dx[(dir+d)%4];
					
					// 범위를 벗어나거나 벽을 만난 경우에는 원래 자리에서 다른 방향 계산
					if(rangeCheck(ny, nx) || copyMap[ny][nx] == 6) {
						ny = curCCTV.y;
						nx = curCCTV.x;
						continue;
					}
					
					// -1 채워주자
					copyMap[ny][nx] = -1;
					d--; // bfs가 아니라 한 방향으로 나아가야하기 때문에 d--를 해주자
				}
			}
		}
		
		// 범위체크
		public static boolean rangeCheck(int y, int x) {
			return y < 0 || y >= N || x < 0 || x >= M;
		}
		
}
