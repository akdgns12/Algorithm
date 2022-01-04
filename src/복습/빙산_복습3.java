package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_복습3 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		 * 로직
		 * 1. 빙산을 bfs로 녹여준다
		 *   1-1. 다음 빙산이 이전의 녹아서 0이된 빙산의 영향을 받을 수 있으니
		 *   	   빙산들을 visited로 방문처리 해준다.
		 * 2. dfs로 총 몇덩이로 분리되었는지 체크한다.
		 * 총 덩이수가 2이상일 때까지 1~2를 반복한다.
		 */
		int cnt = 0;
		int ans = 0;
		
		while((cnt = seperateNum()) < 2) {
			if(cnt == 0) { // 문제조건. 다 녹을때까지 분리되지 않으면 0출력
				ans = 0;
				break;
			}
			bfs();
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static int seperateNum() {
		visited = new boolean[N][M];
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					dfs(i,j,visited);
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
				dfs(nx,ny,visited);
			}
		}
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) { // 빙산이라면
					// 큐에 넣어주고 방문처리
					q.offer(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int seaNum = 0;
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					seaNum++;
				}
			}
			if(map[node.x][node.y] - seaNum < 0) {
				map[node.x][node.y] =0;
			}else {
				map[node.x][node.y] -= seaNum; 
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
