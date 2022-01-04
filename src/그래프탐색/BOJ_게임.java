package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_게임 {
	static int n,m;
	static char[][] map;
	static int[][] dp;
	static int cnt = 0;
	static int max = 0;
	static boolean[][] visited;
	static boolean isInfinite;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void dfs(int x, int y, int cnt) {
		if(cnt > max)
			max = cnt;
		dp[x][y] = cnt;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i] * (map[x][y] - '0');
			int ny = y + dy[i] * (map[x][y] - '0');
			
			if( nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 'H') {
				//무한루프 체크
				if(visited[nx][ny]) {
					isInfinite = true;
					return;
				}
				
				//가지치기, 방문하려는 곳이 현재 count보다 크면 굳이 방문하지 않는다
				if(dp[nx][ny] > cnt)
					continue;
				
				visited[nx][ny] = true;
				dfs(nx, ny, cnt+1);
				visited[nx][ny] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		isInfinite = false;
		visited[0][0] = true;
		dfs(0, 0, 1);
		
		if(isInfinite)
			System.out.println(-1);
		else
			System.out.println(max);
	}

}
