package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
	// 빙산 / 골4
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	
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
			}
		}
		
		/*
		 * 빙산이 2덩이로 나뉠때까지 반복문 돌려준다.
		 * bfs로 빙산 녹여준다
		 */
		int cnt = 0;
		int ans = 0;
		while((cnt = seperateNum()) < 2) {
			if(cnt == 0) {
				ans = 0;
				break;
			}
			
			bfs();
			ans++;
		}
		
		System.out.println(ans);
	}
	/*
	 * 나는 0,0부터 그냥 녹여주면 된다 생각했지만 접근 틀림!
	 * 빙산이 있는 곳의 좌표를 큐에 넣어주는 방식으로 녹여준다
	 * 주변의 빙산이 먼저 녹아 0으로 변해 바다로 인식해 다음 빙산의
	 * 녹일 양에 더해지는 경우 조심 미리 빙산좌표들 visited = true 설정해주자
	 */
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) { // 빙산이라면
					q.offer(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node= q.poll();
			
			int seaNum = 0; // 빙하 상하좌우에 존재하는 바다의 수
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// 범위 벗어나면 skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// 방문처리되지 않은(빙산이 아닌)곳이고 바다이면
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					seaNum++;
				}
			}
			
			if(map[node.x][node.y] - seaNum < 0) {
				map[node.x][node.y] = 0;
			}else {
				map[node.x][node.y] -= seaNum; 
			}
		} // end while
	}
	
	public static int seperateNum() {
		visited = new boolean[N][M];
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					dfs(i,j,visited); // dfs 방식을 통해 총 몇개의 빙하로 나누어져 있는지 구한다.
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(!visited[nx][ny] && map[nx][ny] != 0) {
				dfs(nx, ny, visited);
			}
		}
	}
	
	static class Node{
		int x,y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
