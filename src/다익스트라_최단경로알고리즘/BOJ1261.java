package 다익스트라_최단경로알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//
public class BOJ1261 {
	// 알고스팟 / 골드4 / bfs인듯?
	static class Node implements Comparable<Node>{
		int x,y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			return this.count - o.count;
		}
	}
	static int N,M;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		// 부셔야 하는 벽의 최소 개수
		bfs(0,0);
		System.out.println(result);
	}
	
	public static void bfs(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[N][M];
		pq.offer(new Node(x,y,0));
		visited[x][y] = true;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
				
			// 종료조건(도착점 도달했으면 종료)
			if(node.x == N-1 && node.y == M-1) {
				result = node.count;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				// 범위 벗어나면 skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 1) { // 벽인경우
					// 부시고 빈방으로 바꿔주고 카운트 증가
					visited[nx][ny] = true;
					map[nx][ny] = 0;
					pq.offer(new Node(nx, ny, node.count+1));
				}else if(!visited[nx][ny] && map[nx][ny] == 0){ // 빈 방인경우 그냥 다음좌표 우선순위큐에 넣어줌
					visited[nx][ny] = true;
					pq.offer(new Node(nx, ny, node.count));
				}
			}
		}
		
	}
}
