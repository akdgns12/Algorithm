package ∫πΩ¿;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ∫πΩ¿_≥Ïªˆø ¿‘¿∫æ÷∞°¡©¥Ÿ¡ˆ {
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
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int min;
	static int N;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 1;
		int idx = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			idx++;
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(0,0);
			System.out.println("Problem " + idx + ": " + min);
		}
	}
	
	public static void bfs(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x, y, map[x][y]));
		visited[x][y] = true;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.x == N-1 && node.y == N-1) {
				min = node.count;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					pq.offer(new Node(nx, ny, node.count + map[nx][ny]));
				}
			}
		}
		
	}
}
