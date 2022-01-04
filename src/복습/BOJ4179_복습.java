package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179_복습 {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Node> q = new LinkedList<>();
	static Node man;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		// tyep 1 : 지훈, type 0 : 불
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') { // 지훈인 경우
					if(isEdge(i,j)) { // 만약 초기 지훈이 위치가 가장자리인 경우
						// 바로 탈출
						System.out.println(1);
						return;
					}
					
					map[i][j] = '.';
					man = new Node(i,j,1,0); 
				}else if(map[i][j] == 'F') { // 불의 초기위치인 경우
					q.offer(new Node(i,j,0,0));
				}
			}
		}
		
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
	}
	
	public static void bfs() {
		q.offer(man);
		visited[man.x][man.y]= true; 
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			// 종료조건(가장자리이고, 지훈인경우)
			if(isEdge(node.x, node.y) && node.type == 1) {
				ans = node.cnt+1;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// 범위 벗어나거나 불이거나, 벽이면 skip
				if(!isIn(nx,ny) || map[nx][ny] == 'F' || map[nx][ny] == '#') 
					continue;
				// 방문한적 없고 지훈이인 경우
				if(!visited[nx][ny] && node.type == 1) {
					q.offer(new Node(nx, ny, node.type, node.cnt +1));
					visited[nx][ny] = true;
				}else if(node.type == 0) { // 불인 경우
					map[nx][ny] = 'F';	
					q.offer(new Node(nx ,ny, node.type, node.cnt+1));
				}
			}
		}
	}
	/*
	 * 가장자리인지 판별 함수
	 * return : 가장자리이면 true
	 */
	public static boolean isEdge(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isIn(nx,ny)) {
				return true;
			}
		}
		return false;
	}
	/*
	 * 범위 내에 있는지 판별 함수
	 * return : 범위 안이면 true
	 */
	public static boolean isIn(int x, int y) {
		if(x >= 0 && y >= 0 && x < R && y < C) {
			return true;
		}
		return false;
	}

	static class Node{
		int x,y;
		int type;
		int cnt;
		
		public Node(int x, int y, int type, int cnt) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.cnt = cnt;
		}
	}
}
