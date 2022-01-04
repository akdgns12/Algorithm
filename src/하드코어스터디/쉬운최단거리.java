package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		// 0 : 갈 수 없는 땅, 1 : 갈 수 있는 땅, 2 : 목표지점
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) map[i][j] = 0;
				
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		
	}

	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		
		visited[x][y] = true;
		q.offer(new Node(x,y,1));
		result = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(map[node.x][node.y]== 2) {
				map[x][y] = node.cnt;			
			}
			
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(map[nx][ny] == 0) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					q.offer(new Node(nx, ny, node.cnt+1));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	static class Node{
		int x,y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
