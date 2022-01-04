package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습_삼성기출_구슬탈출2 {
	static class Marble{
		int rx,ry;
		int bx,by;
		int cnt; // 이동 횟수
		
		public Marble(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	static int N, M;
	static int holeX, holeY; // 구멍 좌표
	static char[][] map;
	static Marble red, blue;
	static boolean[][][][] visited; // 빨간 구슬 좌표, 파란 구슬 좌표 따로따로 때문에 4차원 배열
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		// map 정보 받아와 class에 넣어주기 구멍좌표값 따로 저장
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'O') { // 구멍일 경우 좌표값 따로 저장
					holeX = i;
					holeY = j;
				}else if(map[i][j] == 'R') { // 빨간구슬일 경우
					red = new Marble(i,j,0,0,0);
				}else if(map[i][j] == 'B') {
					blue = new Marble(0,0,i,j,0);
				}
			}
		} // end of Input
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Marble> q = new LinkedList<>();
		q.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1)); 
		visited[red.rx][red.ry][blue.bx][blue.by] = true;
		
		while(!q.isEmpty()) {
			Marble marble = q.poll();
			int curRx = marble.rx;
			int curRy = marble.ry;
			int curBx = marble.bx;
			int curBy = marble.by;
			int curCnt = marble.cnt;
			
			if(curCnt > 10) { // 이동횟수 10회 넘어가면 리턴 -1
				return -1;
			}
			
			for(int i=0; i<4; i++) {
				int nextRx = curRx;
				int nextRy = curRy;
				int nextBx = curBx;
				int nextBy = curBy;
				
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				// 빨간구슬 이동 -> 벽을 만날떄까지
				while(map[nextRx + dx[i]][nextRy + dy[i]] != '#') {
					nextRx += dx[i];
					nextRy += dy[i];
					
					// 구멍을 만난다면 이동횟수 리턴
					if(nextRx == holeX && nextRy == holeY) {
						isRedHole = true;
						break;
					}
				}
				
				// 파란구슬 이동 -> 벽 만날떄까지
				while(map[nextBx + dx[i]][nextBy + dy[i]] != '#') {
					nextBx += dx[i];
					nextBy += dy[i];
					
					// 구멍을 만난다면
					if(nextBx == holeX && nextBy == holeY) {
						isBlueHole = true;
						break;
					}
				}
				
				if(isBlueHole) { // 파란구슬이 구멍을 만나면 실패
					continue; // but 큐에 남은 다음 좌표도 봐야하니 스킵
				}
				
				if(isRedHole && !isBlueHole) { // 빨간구슬만 구멍을 만났을 경우
					return curCnt;
				}
				
				// 이동할 좌표가 서로 같은 경우
				if(nextRx == nextBx && nextRy == nextBy) {
					if(i == 0) { // 위로 기울이기
						// 더 큰 x값을 가진 구슬이 뒤로감
						if(curRx > curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 1) { // 아래로 기울이는 경우
						// 더 작은 x값을 가진 구슬이 뒤로감
						if(curRx < curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 2) { // 왼쪽으로 기울이는 경우
						// 더 큰 y값을 가진 구슬이 뒤로감
						if(curRy > curBy) nextRy -= dy[i];
						else curBy -= dy[i];
					}else if(i == 3) { // 오른쪽으로 기울이는 경우	
						//더 작은y값을 가진 구슬이 뒤로감
						if(curRy < curBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					}
				}
				
				// 방문하지 않은 곳만 방문
				if(!visited[nextRx][nextRy][nextBx][nextBy]) {
					visited[nextRx][nextRy][nextBx][nextBy] = true;
					q.add(new Marble(nextRx, nextRy, nextBx, nextBy, curCnt+1));
				}
			} // end of 방향 for문
			
		}// end of 큐 while문
		
		return -1;
	}
	
}
