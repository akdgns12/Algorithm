package BOJ_4179_불_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 사용한 자료구조
 * char[][] map : 미로를 저장
 * boolean[][] visited : 지훈이의 방문여부 체크를 위한 배열
 * int[] dx, dy : 좌표를 네 방향으로 이동시키기 위한 배열
 * Queue<Point> q : 불과 지훈이를 이동시키는 순서를 위한 큐
 * Point 객체 : 현재 좌표 x,y와 type(지훈, 불), count 값으로 이동한 시간을 저장
 * 
 * 사용한 함수
 * bfs(Queue<Point> q) : 불과 지훈이를 종료조건일때까지 이동시킨다.
 * isEdge(int x, int y) : 입력받은 좌표가 미로의 가장자리인지 판별
 *  네 방향으로 이동시켰을 때 미로의 범위를 넘어가면 가장자리인 것
 *  isRange(int x, int y) : 입력받은 범위 내에 있는지 판별
 *  
 *  전체 로직
 *  1. 입력을 받으면서 지훈이의 좌표는 따로 저장해두고, 불인 경우는 queue에 넣어준다.
 *   	큐에 불 - 지훈의 순서로 넣는 이유?
 *   	불에 탈 수 있는 공간에 지훈이를 위치시키면 안되기 때문에 불을먼저 확산 -> 지훈 이동
 *   
 *   이 때 지훈이의 위치가 가장자리인 경우는 바로 탈출할 수 있기 때문에 1을 출력하고 종료한다.
 *  2. bfs()를 수행한다.
 *  	1) 네방향으로 이동하면서 범위를 벗어나거나, 벽이거나, 불인 경우는 이동할 수 없으니 continue
 *  	2) 다음 방문할 좌표가 !visited[nx][ny] (이전에 방문 X)이고 지훈이면 q에 넣어준다.
 *  	3) 불인 경우는 map에 바로 불이 확산됨을 표시해서 방문체크를 할 수 있도록 한다.
 */
public class 불 {
	
	static int r,c; // 행, 열
	static char[][] map; // 미로
	static boolean[][] visited; // 지훈이의 미로 방문체크
	static Point jihun;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	// x,y 좌표를 저장할 Point 클래스
	static class Point{
		int x;
		int y;
		int type;
		int count;
		
		public Point(int x, int y, int type, int count) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[r][c];
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0; i<r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				map[i][j] = temp[j];
				
				if(temp[j] == 'J') {
					// 시작점에서 바로 탈출 가능한 경우
					if (isEdge( i, j)) {
						System.out.println(1);
						return;
					}
					
					map[i][j] = '.';
					jihun = new Point(i, j, 0, 0);
			}else if(map[i][j] == 'F') {
				q.add(new Point(i,j,1,0));
			}
		}
	}
		bfs(q);
	}
	
	static void bfs(Queue<Point> q) {
		int x;
		int y;
		int count;
		
		q.add(jihun); // 불 - 지훈의 순서로 queue에 넣어줌
		visited[jihun.x][jihun.y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			count = p.count;
			
			// 종료 조건
			if( isEdge(x, y) && p.type == 0) {
				System.out.println(count + 1);
				return;
			}
			
			// 4방향
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(!isRange(nx, ny) || map[nx][ny] == '#' || map[nx][ny] == 'F') {
					continue;
				}
				
				if(p.type == 0 && !visited[nx][ny] ) {
					//지훈
					q.add(new Point(nx, ny, p.type, count+1));
					visited[nx][ny] = true;
				}else if(p.type == 1) {
					//불
					map[nx][ny] = 'F';
					q.add(new Point(nx, ny, p.type, count+1));
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
	
	/*
	 * MAP의 범위를 벗어나는지 판별
	 * @return : 입력받은 좌표가 범위내에 있으면 true
	 */
	
	static boolean isRange(int x, int y) {
		if( x >=0 && y >= 0 && x < r && y < c) {
			return true;
		}
		return false;
	}
	
	/*
	 * MAP의 가장자리인지 판별
	 * @return : 가장자리이면 true
	 */
	static boolean isEdge(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(nx, ny)) {
				return true;
			}
		}
		return false;
	}
}
