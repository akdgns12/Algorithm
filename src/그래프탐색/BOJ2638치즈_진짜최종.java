package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638치즈_진짜최종 {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] check; // 해당 좌표의 치즈가 외부공기와 맞닿은 횟수 카운팅 하는 check 배열
	static int sum = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)  // 치즈 개수 구해놓기
					sum++;
			}
		}
		
		int time = 0;
		while(true) {
			if(sum == 0) break;
			
			check = new int[N][M];
			visited = new boolean[N][M];
			bfs();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(check[i][j] > 1)
						map[i][j] = 0;
					sum--;
				}
			}
			time++;
		}// end while
		
		System.out.println(time);
	}
	// 외부공기 넣으면서 탐색 -> 치즈 만나면 check배열 카운팅 -> check 카운팅 횟수 2이상이면 공기로 바꿔줌
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0,0)); // (0,0)부터 시작 -> 여긴 무조건 공기니까
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == 1) { // 치즈라면
					check[nx][ny]++;
					continue;
				}
				
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
				}
			
			}
		} // end while 
		
	}// end bfs
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x =x;
			this.y = y;
		}
	}
}	
