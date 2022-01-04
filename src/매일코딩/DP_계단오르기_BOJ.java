package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_��ܿ�����_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+2];
		int[] step = new int[N+2]; // �� ��� ����
		
		// ��� �Է�
		for(int i=1; i<=N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = step[1];
		dp[2] = Math.max(step[1] + step[2], step[2]); // ������ ù ��° ����� ��°� ����
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2] + step[i], dp[i-3] + step[i-1] + step[i]);
		}
		
		System.out.println(dp[N]);
	}
}