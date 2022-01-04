package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_로봇청소기 {

	static int n,m;
	static int[][] map;
	static int[] dr = {-1,0,1,0}; // 북 동 남 서
	static int[] dc = {0,1,0,-1};
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		// 칸 정보 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//청소하는 함수
		clean(row, col, direction);
	}
	/*
	 * 1. 해당 칸 청소하기
	 * 2. 왼쪽 방향에 아직 청소하지 않은 공간 존재한다면, 그 방향으로 회전하고 다음 한 칸을 전진(왼쪽 방향 파라미터 전달)
	 * 3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향 유지한 채로 한 칸 후진(뒤 쪽 방향 파라미터 전달)
	 */
	public static void clean(int row, int col, int dir) {
		// 1. 현재 위치를 청소
		if(map[row][col] == 0) { // 초기위치 청소하고 count++
			map[row][col] = 2;	 // 청소한 칸은 2로 설정
			count++;
		}
		
		// 2. 왼쪽 방향부터 차례대로 탐색을 진행한다.
		boolean flag = false;
		int originDir = dir;
		for(int i=0; i<4; i++) {
			int next_d = (dir + 3) % 4;
			int next_r = row + dr[next_d];
			int next_c = col + dc[next_d];
			
			if(next_r > 0 && next_c > 0 && next_r < n && next_c < m	) {
				if(map[next_r][next_c] == 0) { // 아직 청소하지 않은 칸이라면
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			dir = (dir + 3 ) % 4;
		}
		
		// 3. 네 방향 모두 청소가 되어있거나 벽인경우
		if(!flag) {
			int next_d = (originDir + 2) % 4;
			int next_br = row + dr[next_d];
			int next_bc = col + dc[next_d];
			
			if(next_br > 0 && next_bc > 0 && next_br < n && next_bc < m) {
				if(map[next_br][next_bc] != 1) {
					clean(next_br, next_bc, originDir); // 바라보는 방향 유지한 채 후진
				}
			}
		}
	}

}
