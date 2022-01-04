package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전쟁전투 {
	// BOJ 전쟁전투 실버 1 / 그래프 탐색 / 
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int totalWhite = 0, totalBlue = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		map = new char[M][N];
		
		// map 정보 받아오고
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					if(map[i][j] == 'W') {
						int num = bfs(i,j, 'W');
						totalWhite += num * num;
					}else {
						int num = bfs(i,j,'B');
						totalBlue += num * num;
					}
				}
			}
		}
		
		System.out.println(totalWhite + " " + totalBlue);
	}
	
	public static int bfs(int x, int y, char color) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y));
		visited[x][y] = true;
		// while문 끝나고 다음 뭉친 집단 검사할 때 다시 cnt = 1로 초기화되어진 상태
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(!visited[nx][ny] && map[nx][ny] == color) {
					q.add(new Node(nx,ny));
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}