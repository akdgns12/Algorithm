package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기2 {
	// BOJ  16927 배열돌리기 2 / 골 5
	/*
	 * 배열돌리기 1과 같은 문제이지만 더 효율적인 방법을 요구하는 문제
	 * 반복 횟수 R이 커짐에 따라 불필요한 회전이 있으므로
	 * (ex: 4*4인 map에서 R이 13으로 주어진다면 바깥그룹 크기인 12만큼 돌고 한 번 이동하는 것, 즉 13번 회전과 한 번 이동과 같다)
	 * -> 각 그룹 변의 크기에 따라 반복 횟수를  
	 * 시간을 더 단축하여 효율적인 코드를 작성해야 한다.
	 * 
	 * 배열돌리기1은 총 반복횟수를 제일 바깥 반복으로 돌렸다면
	 * 이 문제는 각 그룹에 해당하는 반복문 내부에 회전반복문을 돌려준다.
	 * 회전 반복 횟수  그룹 크기만큼 
	 */
	static int N,M,R;
	static int[][] map;
	static int[] dx = {0,1,0,-1}; // 왼, 아래, 오른, 위
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int group = Math.min(N, M)/2; // 돌아가는 그룹의 수
		
		int n = N, m = M; // 회전한 뒤 갱신해야하기 때문에 따로 변수 설정
		
		for(int i=0; i<group; i++) {
			rotate(i, 2*n + 2*m - 4); // 그룹 수, 그룹 테두리 크기
			// 한 그룹 안으로 들어갈 때마다 가로,세로 2씩 줄어듦
			n -= 2; 
			m -= 2;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void rotate(int groupIdx, int len) {
		int nR = R % len; // 회전횟수 % 그룹의 바깥크기
		for(int i=0; i<nR; i++) {
			int temp = map[groupIdx][groupIdx]; // 각 그룹의 첫번째 값 임시 저장
			int x = groupIdx;
			int y = groupIdx;
			int dir = 0;
			
			while(dir < 4) {
				// map[nx][ny] -> map[x][y]로 옮기는 작업
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx == groupIdx && ny == groupIdx) break;
				if(nx < N - groupIdx && ny < M - groupIdx &&
						nx >= groupIdx && ny >= groupIdx) { // 범위 내라면
					map[x][y] = map[nx][ny]; // 바꿔줌
					x = nx;
					y = ny;
				} else {
					// 다음에 옮길 칸이 배열 밖으로 넘어가버리면 해당 라인은 다 옮긴 것이므로 방향전환
					dir++;
				}
			}
			
			map[groupIdx + 1][groupIdx] = temp; // 임시저장해놨던 값 빈자리에 넣어줌
		}
	}
}
