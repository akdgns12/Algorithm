package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_계단오르기_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+2];
		int[] step = new int[N+2]; // 각 계단 점수
		
		// 계단 입력
		for(int i=1; i<=N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = step[1];
		dp[2] = Math.max(step[1] + step[2], step[2]); // 무조건 첫 번째 계단을 밟는게 좋다
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2] + step[i], dp[i-3] + step[i-1] + step[i]);
		}
		
		System.out.println(dp[N]);
	}
}