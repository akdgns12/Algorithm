package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습_미세먼지안녕 {
	static class Dust{
		int r, c, amount;
		
		public Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
	static int R,C; // 행,열
	static int T; // T초 후
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[] cleaner = new int[2]; // 공기청정기
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
				
				if(map[i][j] == -1) { // 공기청정기
					cleaner[idx++] = i;
				}
			}
		}
		
		// 매초마다 한세트로 이루어진다
		for(int i=0; i<T; i++) {
			makeQueue(); // 미세먼지가 있는 곳 좌표(original) 큐에 넣어두기
			
			spread(); // 미세먼지 확산시키기
			 
			play(); // 공기청정기 작동 
		}
	}
	
	public static void makeQueue() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) { 
				// 공기청정기도 아니고 어떠한 값이 들어왔다 --> 미세먼지 --> 행,열,양 저장
				if(map[i][j] != -1 && map[i][j] != 0) 
				dust.add(new Dust(i,j,map[i][j]));
			}
		}
	}
	
	public static void spread() {
		// 기존 큐에 있는거 꺼내면서 확신시키기
		while(!dust.isEmpty()) {
			// 하나 꺼내
			Dust cur = dust.poll();
			int cr = cur.r;
			int cc = cur.c;
			int camount = cur.amount;
			
			// 주변 확산시키고, 갯수 세주자
			int cnt = 0;
			int spread_amount = camount / 5;
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				// 맵안에 있고, 공기청정기 없는 위치에
				if(isIn(nr,nc) && map[nr][nc] != -1) {
					map[nr][nc] = map[nr][nc] + spread_amount;
					cnt++;
				}
			}
			
			// 본인 위치 감소시키고
			map[cr][cc] = map[cr][cc] - spread_amount*cnt >= 0 ? map[cr][cc] - spread_amount * cnt : 0;
		}
	}
	
	public static boolean isIn(int nr,int nc) {
		if(nr >=0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
	
	public static void play() {
		int top = cleaner[0];
		int down = cleaner[1];
		
		// cleaner 상부 반시계 방향
		
		// 위쪽 아래로 당기기
		for(int i=top-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 왼쪽으로 당기기
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
			if(i == 2) { // 공기청정기에서 부는 바람은 미세먼지가 없는 바람이므로
				map[top][i-1] = 0; // 공기청정기에서 나온 바람은 0으로 해준다.
			}
		}
		
		//공기 청정기 위치에 있는 애 공기 없애기
		map[top][0] = -1;
		
		// cleaner 시계방향
		
		// 아래에서 위로 당기기
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
		// 왼쪽에서 오른쪽으로 당기기
		for(int i=C-1; i>1; i--) {
			map[down][i] = map[down][i-1];
			if(i == 2) {
				map[down][i-1] = 0;
			}
		}
		
		map[down][0] = -1;
	}
}
