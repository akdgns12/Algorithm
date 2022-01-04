package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
	static int R, C;
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
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					if(isEdge(i,j)) { // 시작위치가 가장자리이면
						// 바로 탈출
						System.out.println(1);
						return;
					}
					map[i][j] = '.';
					man = new Node(i,j,1,0);
				}else if(map[i][j] == 'F') {
					q.offer(new Node(i,j,0,0));
				}
			}
		}
		
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
	}
		
		public static void bfs() {
			// 위에서 불 먼저 넣어주었다
			// 불먼저 넣고 지훈이 넣고 순으로 
			q.offer(man);
			visited[man.x][man.y] = true;
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				
				if(isEdge(node.x, node.y) && node.type == 1) {
					ans = node.cnt+1;
					return;
				}
				
				for(int i=0; i<4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					
					if(!isIn(nx,ny) || map[nx][ny] == '#' || map[nx][ny] == 'F') 
						continue;
					
					// 지훈인 경우
					if(node.type == 1 && !visited[nx][ny]) {
						q.offer(new Node(nx, ny, node.type, node.cnt+1));
						visited[nx][ny] = true;
					}else if(node.type == 0) {
						map[nx][ny] = 'F';
						q.offer(new Node(nx, ny, node.type, node.cnt+1));
					}
						
				}
			}
		}
		
		// 해당 좌표 가장자리인지 판별 함수
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
		
		public static boolean isIn(int x, int y) {
			if(x >= 0 && y >= 0 && x < R && y < C) {
				return true;
			}
			return false;
		}
		
		static class Node{
			int x,y;
			int type; // 지훈인지, 불인지 가릴 type변수
			int cnt;
			
			public Node(int x, int y, int type, int cnt) {
				this.x = x;
				this.y = y;
				this.type = type;
				this.cnt = cnt;
			}
		}
}
