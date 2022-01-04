package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라 {
	static int N,M,T;
	static int[][] map;
	static boolean[][][] visited; // 마지막은 그람인지 아닌지 판단여부
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2]; // 0이면 그람없음, 1이면 그람있음
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = bfs(0,0);
		if(result == -1) System.out.println("Fail");
		else System.out.println(result);
	}	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0, false));
		visited[x][y][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.time > T) break;
			
			if(node.x == N-1 && node.y == M-1) {
				return node.time;
			}
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(nx >=0 && ny >= 0 && nx < N && ny < M) {
					if(!node.isGram) { // 그람이 아닐때
						if(!visited[nx][ny][0] && map[nx][ny] == 0) { // 방문하지 않았고 빈 칸이면
							q.offer(new Node(nx, ny, node.time+1, node.isGram));
							visited[nx][ny][0] = true;
						}else if(!visited[nx][ny][0] && map[nx][ny] == 2){ // 방문하지 않았고 다음 칸 그람이면
							q.offer(new Node(nx, ny, node.time+1, true));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
		return -1;
	}
	
	static class Node{
		int x,y;
		int time;
		boolean isGram;
		public Node(int x, int y, int time, boolean sword) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.isGram = isGram;
		}
	}
}
