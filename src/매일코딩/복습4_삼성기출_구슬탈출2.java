package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 빨간구슬 구멍을 통해서 뺴내기

public class 복습4_삼성기출_구슬탈출2 {
	static class Marble{
		int rx,ry;
		int bx,by;
		int cnt;
		
		public Marble(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static char[][] map;
	static int holeX, holeY;
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1}; 
	static Marble red, blue;
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		// map 정보 입력받고 각각의 구슬 구조체에 담기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'O') {
					holeX = i;
					holeY = j;
				}
				else if(map[i][j] == 'B') {
					blue = new Marble(0,0,i,j,0);
				}else if(map[i][j] == 'R') {
					red = new Marble(i,j,0,0,0);
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
			
			if(curCnt > 10) { // 이동횟수 10회 넘어가면 -1리턴
				return -1;
			}
			
			boolean isRedHole = false;
			boolean isBlueHole = false;
			
			for(int i=0; i<4; i++) {
				int nextRx = curRx;
				int nextRy = curRy;
				int nextBx = curBx;
				int nextBy = curBy;
				
				// 빨간구슬 이동 -> 벽을 만날때까지
				while(map[nextRx+dx[i]][nextRy+dy[i]] != '#') {
					nextRx += dx[i];
					nextRy += dy[i];
					
					// 만약 구멍에 빠진다면
					if(nextRx == holeX && nextRy == holeY) {
						isRedHole = true;
						break;
					}
				}
				
				// 파란구슬 이동 -> 벽을 만날때까지
				while(map[nextBx + dx[i]][nextBy + dy[i]] != '#') {
					nextBx += dx[i];
					nextBy += dy[i];
					
					// 만약 구멍을 만난다면
					if(nextBx == holeX && nextBy == holeY) {
						isBlueHole = true;
						break;
					}
				}
				
				if(isBlueHole) { // 만약 파란구슬이 구멍을 만났다면
					continue; // 일단 skip q에 남은 좌표들을 살펴봐야 하기 때문에
				}
				
				// 빨간구슬만 구멍을 만났다면 정답 리턴
				if(isRedHole && !isBlueHole) {
					return curCnt;
				}
				
				// 둘다 구멍을 만나지도 않았고 같은 좌표에 있다면 -> 위치 조정
				if(nextRx == nextBx && nextRy == nextBy) {
					if(i == 0) { // 위로 기울이기
						// 더 큰 x값이 뒤로감
						if(curRx > curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 1) { // 아래로 기울이기
						// 더 작은 x값이 뒤로감
						if(curRx < curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 2) { // 왼쪽으로 기울이기
						// 더 큰 y값이 뒤로감
						if(curRy > curBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					}else if(i == 3) { // 오른쪽으로 기울이기
						// 더 작은y값이 뒤로감
						if(curRy < curBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					}
				}
				
				// 방문하지 않은 곳만 큐에 추가
				if(!visited[nextRx][nextRy][nextBx][nextBy]) {
					visited[nextRx][nextRy][nextBx][nextBy] = true; // 방문처리
					q.add(new Marble(nextRx, nextRy, nextBx, nextBy, curCnt+1));
				}
			}
		}
		return -1;
	}
}
