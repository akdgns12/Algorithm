package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179_불_복습 {
	static int R,C;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int ans = Integer.MAX_VALUE;
	static Node man;
	static Queue<Node> q = new LinkedList<>();
	
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
					// 시작점에서 바로 탍출 가능한 경우
					if(isEdge(i,j)) {
						System.out.println(1);
						return;
					}
					
					map[i][j] = '.'; // 지훈이 자리였던 곳 이동가능한 자리로 바꿔준다
					man = new Node(i,j,0,0);
				}else if(map[i][j] == 'F') { // 불 초기위치인 경우
					q.offer(new Node(i,j,1,0)); // 큐에 불먼저 넣어준다
				}
			}				
		}
		
		bfs();
	}
	
	public static void bfs() {
		 q.offer(man); // 불 - 지훈의 순서로 큐에 넣어준다 불부터 넣어줌
		 visited[man.x][man.y] = true;
		 
		 int cnt = 0;
		 while(!q.isEmpty()) {
			 Node node = q.poll();
			 
			 // 종료조건
			 if(isEdge(node.x, node.y) && node.type == 0) {
				 System.out.println(node.cnt+1);
				 return;
			 }
			 
			 for (int i = 0; i < 4; i++) {
	                int nx = node.x + dx[i];
	                int ny = node.y + dy[i];

	                if (!isRange(nx, ny) || map[nx][ny] == '#' || map[nx][ny] == 'F') {
	                    continue;
	                }

	                if (node.type == 0 && !visited[nx][ny]) {
	                    // 지훈
	                    q.add(new Node(nx, ny, node.type, node.cnt + 1));
	                    visited[nx][ny] = true;
	                } else if (node.type == 1) {
	                    // 불
	                    map[nx][ny] = 'F';
	                    q.add(new Node(nx, ny, node.type, node.cnt + 1));
	                }
	            }
	        }

	        System.out.println("IMPOSSIBLE");
	}

	/*
	 * map의 범위를 벗어나는지 판별
	 * return : 입력받은 좌표가 범위 내에 있으면 true
	 */
	public static boolean isRange(int x, int y) {
		if(x >= 0 && y >= 0 && x < R && y < C) {
			return true;
		}
		return false;
	}
	
	/*
	 * map의 가장자리인지 판별
	 * return : 가장자리이면 true
	 */
	public static boolean isEdge(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(nx, ny)) {
				return true;
			}
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
