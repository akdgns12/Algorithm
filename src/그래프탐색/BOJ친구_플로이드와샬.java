package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//
public class BOJ친구_플로이드와샬 {
	// BOJ 친구 실버 1 / 그래프 탐색 /
	/*
	 * A와 B가 친구면, B와 A도 친구이고, A와 A는 친구가 아니다.
	 * 2- 친구가 되는 조건
	 * 1. 두 사람이 친구
	 * 2. A와 친구이고 B와 친구인 C가 있어야 한다.
	 */
	
	/*
	 * [플로이드 와샬]
	 * A,B,C,D,E가 있다고 했을 때  A와 B가 친구이고, B와 C가 친구이면
	 * A와 C는 친구.그럼 C와 D가 친구일 때 A와 D가 친구? No, 2-친구이므로
	 * 친구의 친구까지만 친구. 따라서 D는 A의 3-친구. 이 문제에서는 2-친구만
	 * 원하므로 플로이드 와샬 수행해서 각 친구들이 n-친구인지 구하고 2이하인
	 * 친구들의 개수를 구하면 된다.(0일 때는 친구가 아니므로 pass, 1과 2일때만
	 * 카운트 증가하면 된다.)
	 */
	static int N;
	static final int INF = (int)1e9;
	static int[][] cost = new int[51][51];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=1; j<=N; j++) {
				if(i == j) continue;
				
				cost[i][j] = str[j-1] == 'Y' ? 1 : INF;
			}
		}
		
		// 플로이드 와샬
		for(int k=1; k<=N; k++) { // 거쳐가는 노드 K
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i == j) continue;
					
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);					
				}
			}
		} // end 플로이드

		int max = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			
			for(int j=1; j<=N; j++) {
				if(cost[i][j] == 1 || cost[i][j] == 2) cnt++;
				
				max = Math.max(max, cnt);
			}
		} 
		
		System.out.println(max);
		
	}
}
