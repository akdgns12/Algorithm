package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. 미세먼지 있는 곳 "큐"로 만들어주기(매초마다)
 * 2. 확신시키며 갱신하기
 * 3. 공기청정기 작동시키기
 */
public class 미세먼지안녕 {
	static class Dust{
		int r,c,amount;
		
		public Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
	static int R,C; // 행, 열
	static int T; // T초 후
	static int[][] map;
	static int[] dr = {-1,1,0,0}; // 상 하 좌 우
	static int[] dc = {0,0,-1,1};
	
	static Queue<Dust> dust = new LinkedList<>();
	static int[] cleaner = new int[2]; // 공기 청정기 위치 [0] = 상부, [1] = 하부
	static int answer = 0;
	
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
				
				// 공기 청정기 위치
				if(map[i][j] == -1) {
					cleaner[idx++] = i;
				}
			}
		}
		
		//0. 1번과 2번을 계속 반복하는거 1초마다 한번씩 - 매초
		for(int t=0; t<T; t++) {
			//1. 미세먼지가 있는 곳(좌표, 값) - original -> 큐에 다 넣어두기
			makeQueue();
			// 2.map = 확산시키며 갱신[기준은 큐에 있는거 하나씩 꺼내면서]
			spread();
			//test
			//3. 공기청정기 작동 시켜서 미세먼지 이동시키기
			// * 주의할점 : 공기청정기 부분과 같은 위치에 들어오는 미세먼지들은 사라짐
			play();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) 
					answer += map[i][j];
			}
		}
		
		System.out.println(answer);
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
		 // 우측 상단에서 아래꺼 당기기
		 for(int i=0; i<top; i++) {
			 map[i][C-1] = map[i+1][C-1];
		 }
		 // 가장 오른쪽에서 왼쪽에 있는거 당기기
		 for(int i=C-1; i>1; i--) {
			 map[top][i] = map[top][i-1];
			 if(i == 2)
				 map[top][i-1] = 0;
		 }
		 
		 // 공기청정기 위치에 있는 애 공기 없애기
		 map[top][0] = -1;
		 // cleaner 하부 시계 방향
		 // 아래 있는거 위로 당기기
		 for(int i=down+1; i<R-1; i++) {
			 map[i][0] = map[i+1][0];
		 }
		 // 왼쪽으로 당기기
		 for(int i=0; i<C-1; i++) {
			 map[R-1][i] = map[R-1][i+1];
		 }
		 // 아래로 내리기
		 for(int i=R-1; i>down; i--) {
			 map[i][C-1] = map[i-1][C-1];
		 }
		 // 가장 오른쪽에서 왼쪽에 있는거 당기기
		 for(int i=C-1; i>1; i--) {
			 map[down][i] = map[down][i-1];
			 if(i == 2) 
				 map[down][i-1] = 0;
		 }
		 map[down][0] = -1;
	}
	
	public static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.println(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void spread() {
		// 기존 큐에 있는거 하나씩 꺼내면서 확신 시키기
		while(!dust.isEmpty()) {
			// 하나 꺼내
			Dust cur = dust.poll();
			int cr = cur.r;
			int cc = cur.c;
			int camount = cur.amount;
			
			// 주변에 확산시키고, 확산된 갯수 세주자
			int cnt=0;
			int spread_amount = camount / 5;
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				// 맵안에 있고, 공기청정기가 없는 위치에
				if(isIn(nr,nc) && map[nr][nc] != -1) {
					map[nr][nc] = map[nr][nc] + spread_amount;
					cnt++;
				}
			}
			
			// 본인 위치 감소시키고
			map[cr][cc] = map[cr][cc] - spread_amount * cnt >= 0 ? map[cr][cc] - spread_amount * cnt : 0;
		}
	}
	
	public static boolean isIn(int nr, int nc) {
		if(nr >= 0 &&  nr < R && nc >=0 && nc < C)
			return true;
		return false;
	}
	
	public static void makeQueue() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				// 공기 청정기 위치도 아니고, 어떠한 값이 들어왔다, 행 + 열 + 먼지의 양 저장
				if(map[i][j] !=0 && map[i][j] != -1)
					dust.add(new Dust(i,j,map[i][j]));
			}
		}
	}

}
