package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_숫자정사각형 {
	// BOJ / 숫자정사각형 / DP
	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken(""));
			}
		}
		
		// 꼭짓점에 쓰여있는 수가 모두 같은 정사각형 넓이 리턴
		// 이건 DP가 아니라 걍 dfs 돌리는 것 같은데?
		dfs(i,j,map);
	}
	
	public static void dfs(int x, int y, int[][] map) {
		
	}
}
