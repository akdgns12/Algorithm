package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0 : 가로, 1 : 세로, 2 : 대각
		dp[0][1][0] = 1; // 초기 위치
		
		for(int x = 0; x < N; x++) {
			for(int y=1; y<N; y++) {
				if(map[x][y] == 1) continue;
				
				dp[x][y][0] += dp[x][y-1][0] + dp[x][y-1][2];
				
				if(x==0) continue;
				dp[x][y][1] += dp[x-1][y][1] + dp[x-1][y][2];
				
				if(map[x-1][y] == 0 && map[x][y-1] == 0) {
				dp[x][y][2] += dp[x-1][y-1][0] + dp[x-1][y-1][1] + dp[x-1][y-1][2];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
}
