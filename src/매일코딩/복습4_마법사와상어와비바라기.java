package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 복습4_마법사와상어와비바라기 {
	static class Cloud{
		int r, c;
		
		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M; // 격자 칸수, 이동 횟수
	static int[][] map;
	static boolean[][] visited; // 새롭게 구름이 생기는 칸은 구름이 사라진 칸이 아니어야 하는 부분 체크
	static ArrayList<Cloud> list;  // 비구름 좌표
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초기구름 생성
		list = new ArrayList<Cloud>();
		list.add(new Cloud(N-2,0));
		list.add(new Cloud(N-1,0));
		list.add(new Cloud(N-2,1));
		list.add(new Cloud(N-1,1));
		
		for(int i=0; i<M; i++) {
			visited = new boolean[N][N]; // 이동 한번 끝나고 다시 새로운 방문처리 해야하므로 이동횟수 반복문에 visited 배열 초기화해준다.
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken()) % N;
			
			move(d, s);
			add();
			remove();
		}
		
		System.out.println(count());
	}
	
	public static void move(int d, int s) {
		for(Cloud cloud : list) {
			int nr = (cloud.r + N + dr[d]*s) % N;
			int nc = (cloud.c + N + dc[d]*s) % N;
			
			visited[nr][nc] = true;
			map[nr][nc] += 1; // 비구름 이동한 뒤  물의양 1 늘려주기
			// 비구름 이동한 뒤  Cloud list 내의 기존 구름 좌표 갱신된 구름 좌표로 갱신
			cloud.r = nr; 
			cloud.c = nc;
		}
	}
	
	public static void add() {
		for(Cloud cloud : list) {
			int cnt = 0;
			int nr = -1, nc = -1;
			for(int i=1; i<=8; i+=2) {
				nr = cloud.r + dr[i];
				nc = cloud.c + dc[i];
				if(canMove(nr,nc) && map[nr][nc] > 0	) {
					cnt++;
				}
			}
			map[cloud.r][cloud.c] += cnt;
		}
		list.clear(); // 비구름 list 초기화 해준다..
	}
	
	public static boolean canMove(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}
	
	public static void remove() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2 && !visited[i][j]) { // 비구름이 아니였던 칸이고 물의양이 2이상이면 
					map[i][j] -= 2; // 구름이 생기고 물의양이 2만큼 줄어든다.
					list.add(new Cloud(i,j)); // 새롭게 생긴 비구름 list에 추가
				}
			}
		}
	}
	
	public static int count() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cnt += map[i][j];
			}
		}
		
		return cnt;
	}

}
