package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class 욕심쟁이판다 {
	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] dp;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st=  new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
					answer = Math.max(answer, dfs(i,j));
			}
		}
		
		System.out.println(answer);
	}
	
	public static int dfs(int x, int y) {
		// dp에 저장된 값이 있을 경우 그 값을 반환
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		
		// 판다가 대나무숲에서 최소한 1년은 살 수 있으므로
		// dp[x][y] = 1로 초기화 할 수 있음
		dp[x][y] = 1;
		
		// 상하좌우 검사
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위에서 벗어났을 경우 continue;
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			
			// 현재 대나무 숲보다 더 많은 양의 대나무가 있는 경우
			if(map[x][y] < map[nx][ny]) {
				// 상하좌우 중에서 가장 오랫동안 생존할 수 있는 기간을 계산한다.
				dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
				dfs(nx,ny);
			}
		}
		return dp[x][y];
	} 
}
