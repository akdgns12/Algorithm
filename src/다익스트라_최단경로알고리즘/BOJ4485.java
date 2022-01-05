package 다익스트라_최단경로알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//
public class BOJ4485 {
	// 녹색 옷 입은 애가 젤다지? / 골드 4 / bfs같은데?
	static class Node implements Comparable<Node>{
		int x, y, count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y =y;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			return this.count - o.count;
		}
	}
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int T;
	static int N;
	static int min;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 1;
		int Idx = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			Idx++;
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			visited = new boolean[N][N];
			
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0);
		System.out.println("Problem " + Idx + ": " + min);
	} // end while
		
	}
	// 우선순위큐로 사방에 있는 좌표들을 더한 4가지 후보중 더해서 가장 작은 node.count가 골라질 수 있도록 해야함
	public static void bfs(int x, int y) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(x,y,map[x][y]));
		visited[x][y] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			// 종료조건(끝좌표에 도달했을 ��)
			if(node.x == N-1 && node.y == N-1) {
				min = node.count;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				// 범위 벗어나면 skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, node.count + map[nx][ny]));
				}
			}
		}
	}
}
