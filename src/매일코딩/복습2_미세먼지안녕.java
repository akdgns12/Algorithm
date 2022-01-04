package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습2_미세먼지안녕 {
	static class Dust{
		int r,c,amount;
		
		public Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
	static int R,C; // 행,열
	static int T; // T 초후
	static int[][] map;
	static int[] cleaner = new int[2]; // 공기청정기
	static int answer = 0;
	
	static int[] dr = {-1,1,0,0}; // 상 하 좌 우
	static int[] dc = {0,0,-1,1};
	
	static Queue<Dust> dust = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		int idx = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) { //공기청정기인 경우
					cleaner[idx++] = i;
				}
			}
		}
		
		for(int i=0; i<T; i++) { // 매초마다 진행
			makeQueue();
			
			spread();
			
			operate();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0)
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
	
	public static void makeQueue() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				// 공기 청정기 위치도 아니고 빈칸도 아닌 값이 들어오면 미세먼지 저장
				if(map[i][j] != -1 && map[i][j] != 0) {
					dust.add(new Dust(i,j,map[i][j]));
				}
			}
		}
	}
	
	// 미세먼지 확산시키기
	public static void spread() {
		// 미세먼지 하나씩 꺼내 확산
		while(!dust.isEmpty()) {
			Dust cur = dust.poll();
			
			int cr = cur.r;
			int cc = cur.c;
			int camount = cur.amount;
			
			int cnt = 0; 
			int spread_amount = camount / 5;
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dr[i];
				
				// 범위 내이고 공기청정기 위치가 아니라면
				if(isRange(nr,nc) && map[nr][nc] != -1) {
					map[nr][nc] = map[nr][nc] + spread_amount;
					cnt++;
				}
			}
			
			// 조건에 따라 본인 위치 감소
			map[cr][cc] = map[cr][cc] - spread_amount * cnt >= 0 ? map[cr][cc] - spread_amount*cnt : 0;
		}
	}
	
	public static boolean isRange(int nr, int nc) {
		if(nr >=0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
	
	public static void operate() {
		int top = cleaner[0];
		int down = cleaner[1];
		
		// 반시계 방향
	
		// 위에서 아래로 당기기
		for(int i=top-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 가장 오른쪽에서 왼쪽으로 당기기
		for(int i=0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		// 우측 상단에서 아래꺼 위로 당기기
		for(int i=0; i<top; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// 가장 오른쪽에서 왼쪽에 있는거 당기기
		for(int i=C-1; i>1; i--) {
			map[top][i] = map[top][i-1];
			if(i == 2) {
				map[top][i-1] = 0; //공기청정기에서 나온 바람은 0으로
			}
		}
		
		//공기청정기 위치에 있는 애 없애기
		map[top][0] = -1; 
		
		// 시계 방향
		
		// 아래에서 위로당기기
		for(int i=down+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		// 왼쪽으로 당기기
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		// 위에서 아래로 당기기
		for(int i=R-1; i>down; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		// 왼쪽에서 오른쪽 당기기
		for(int i=C-1; i>1; i--) {
			map[down][i] = map[down][i-1];
			if(i == 2) {
				map[down][i-1] = 0;
			}
		}
		
		// 공기청정기 위치에 있는 애 없애기
		map[down][0] = -1;
	}
	
}
