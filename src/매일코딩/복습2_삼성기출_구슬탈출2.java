package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습2_삼성기출_구슬탈출2 {
	static class Marble{
		int rx, ry;
		int bx, by;
		int cnt;
		
		public Marble(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	static int N, M;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Marble red, blue;
	static int holeX, holeY;
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'O') {
					holeX = i;
					holeY = j;
				}else if(map[i][j] == 'R') {
					red = new Marble(i,j,0,0,0);
				}else if(map[i][j] == 'B') {
					blue = new Marble(0,0,i,j,0);
				}
			}
		}
		
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
			
			if(curCnt > 10) { // 이동횟수 10회 넘어가면 -1 리턴
				return -1;
			}
			
			for(int i=0; i<4; i++) {
				int nextRx = curRx;
				int nextRy = curRy;
				int nextBx = curBx;
				int nextBy = curBy;
				
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				// 빨간구슬 이동 -> 벽 만날때까지
				while(map[nextRx + dx[i]][nextRy + dx[i]] != '#') {
					nextRx += dx[i];
					nextRy += dy[i];
					
					// 구멍을 만나면
					if(nextRx == holeX && nextRy == holeY) {
						isRedHole = true;
						break;
					}
				}
				
				// 파란구슬 이동 -> 벽만날때까지
				while(map[nextBx + dx[i]][nextBy + dy[i]] != '#') {
					nextBx += dx[i];
					nextBy += dy[i];
					
					// 구멍을 만나면
					if(nextBx == holeX && nextBy == holeY) {
						isBlueHole = true;
						break;
					}
				}
				
				if(isBlueHole) { // 파란구슬이 구멍에 빠지면 실패
					continue;  // 큐에 남은 다음 좌표들도 살펴봐야 하니 일단 스킵
				}
				
				if(isRedHole && !isBlueHole) { // 빨간구슬만 구멍에 빠지면 성공
					return curCnt;
				}
				
				// 둘 다 구멍에 빠지지 않았는데 이동할 위치가 같다면 -> 위치 조정
				if(nextRx == nextBx && nextRy == nextBy) {
					if(i == 0) { // 위로 기울이기
						// 더 큰 x값을 가진 구슬이 뒤로감
						if(curRx > curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 1) { // 아래로 기울이기
						// 더 작은 x값을 가진 구슬이 뒤로감
						if(curRx < curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 2) { // 왼쪽으로 기울이기
						// 더 큰 y값을 가진 구슬이 뒤로감
						if(curRy > curBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					}else if(i == 3) {// 오른쪽으로 기울이기
						// 더 작은 y값을 가진 구슬이 뒤로감
						if(curRy < curBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					}
				}
				
				// 방문하지 않은 곳일 경우 방문 처리 후 큐에 추가
				if(!visited[nextRx][nextRy][nextBx][nextBy]) {
					visited[nextRx][nextRy][nextBx][nextBy] = true;
					q.add(new Marble(nextRx, nextRy, nextBx, nextBy, curCnt + 1));
				}
			}
		}
		return -1;
	}
}
