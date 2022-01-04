package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라 {
	static int N, M, T;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	// 그람이냐 아니냐 판단을 위해 3차원 boolean 배열
	static boolean[][][] visited;
	static int result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 시간제한 T시간 초과하면 실패
		map = new int[N][M];
		visited = new boolean[N][M][2]; // 0은 그람이 없을 때,1은 그람이 있을 때
		
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
		q.offer(new Node(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.time > T) break;
			if(node.x == N-1 && node.y == M-1)
				return node.time;
			
			if(map[node.x][node.y] == 2) node.isGram = 1;
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(node.isGram == 0) { // 그람 없을 때
					if(visited[nx][ny][0]) continue;
					if(map[nx][ny] == 1) continue;
					
					q.offer(new Node(nx, ny, node.time+1, node.isGram));
					visited[nx][ny][0] = true;
				}
				else { // 그람 있을 때
					if(visited[nx][ny][1]) continue;
					
					q.offer(new Node(nx, ny, node.time+1, node.isGram));
					visited[nx][ny][1] = true;
				}
			}
		}
		return -1;
	}
	static class Node{
		int x, y;
		int time;
		int isGram;
		
		public Node(int x, int y, int time, int isGram) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.isGram = isGram;
		}
	}
}
