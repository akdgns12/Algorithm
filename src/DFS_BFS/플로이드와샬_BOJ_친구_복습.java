package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 플로이드와샬_BOJ_친구_복습 {
	static final int INF = 987654321;
	static int[][] cost = new int[51][51];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=1; j<=n; j++) {
				if(i == j) continue;
				
			}
		}
	}
}
