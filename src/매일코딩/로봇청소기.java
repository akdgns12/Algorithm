package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {

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
		
		// 청소기 초기위치좌표, 방향정보 입력
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 청소하는 메서드
		clean(row, col, dir);
		
		System.out.println(count);
	}
	
	/*
	 * 1. 현재 위치를 청소한다
	 * 2. 반시계 방향으로 돌면서 주변을 청소할 수 있는지 확인한다 (왼쪽 위치를 파라미터로 넘겨줌)
	 * 3. 주변이 모두 청소되어 있거나 벽인 경우
	 * 	  - 바라보는 방향을 유지한 채 1번을 수행한다.(뒤쪽 위치를 파라미터로 넘겨줌)
	 */
	// 청소하는 메서드
	public static void clean(int r, int c, int d) {
		// 1. 현재 위치를 청소한다.
		if(map[r][c] == 0) {
			map[r][c] = 2; // 청소한 상태는 2로 설정
			count++;
		}
		
		// 2. 반시계 방향으로 돌면서 청소할 수 있는지 확인한다.
		boolean flag = false;
		int originDir = d;
		for(int i=0; i<4; i++) {
			int next_d = (d + 3) % 4;
			int next_r = r + dr[next_d];
			int next_c = c + dc[next_d];
			// 
			if(next_r > 0 && next_c > 0 && next_r < n && next_c < m	) {
				if(map[next_r][next_c] == 0) { // 아직 청소하지 않은 공간이라면
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			d = (d + 3) % 4;
		}
		
		
		// 3. 주변이 모두 청소되어 있거나 벽인 경우
		if(!flag) {
			int next_d = (originDir + 2) % 4;
			int next_br = r + dr[next_d];
			int next_bc = c + dc[next_d];
			
			if(next_br > 0 && next_bc > 0 && next_br < n && next_bc < m	) {
				if(map[next_br][next_bc] != 1) {
					clean(next_br, next_bc, originDir); 
				}
			}
			
		}
	}

}
