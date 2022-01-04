package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_BOJ_포도주시식 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1]; // 포도주의 양
		int[] dp = new int[N+1]; // 먹을 수 있는 최대 양
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//최대 i-3까지 고려해 주어야 하므로, dp[1]과 dp[2]는 초기화 해준다.
		dp[1] = arr[1];
		if(N >= 2) // 이 부분이 존재하지 않으면 N이 1이 입력될 때 런타임 에러 발생.
					// 2번 배열이 존재하지 않기 때문
			dp[2] = Math.max(dp[1] + arr[2], arr[2]);
		
		for(int i=3; i<=N; i++) {// 3번 포도주부터 누적해간다.
			if(N >= 3)
				dp[i] = Math.max(dp[i-1],  Math.max(dp[i-3] + arr[i-1] + arr[i],  dp[i-2] + arr[i]));
		}
		
		System.out.println(dp[N]);
	}

}
