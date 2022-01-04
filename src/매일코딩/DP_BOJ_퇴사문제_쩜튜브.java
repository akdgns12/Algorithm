package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 브루트포스 DFS로 풀을 경우
 * idx일이 n일까지 끝낼 수 있는 것인지 확인한 후 가능하다면 그일을 한다.
 * idx일을 하지 않는 경우도 체크한다.
 * idx == n이면 상담이 없으므로 max설정하고 종료한다.
 * 
 */
public class DP_BOJ_퇴사문제_쩜튜브 {
	static int n;
	static int max = 0;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // 상담기간
			map[i][1] = Integer.parseInt(st.nextToken()); // 수입금
		}
		
		dfs(0, 0); // idx, sum(상담일, 수입금)
		System.out.println(max);
	}
	
	public static void dfs(int idx, int sum) {
		if(idx == n) { // 이 때 상담이 없으므로 max 설정하고 종료
			max = Math.max(max,  sum);
			return;
		}
		
		if(idx + map[idx][0] <= n) {
			dfs(idx + map[idx][0], sum + map[idx][1]);
		}
			dfs(idx + 1, sum);
	}

}
