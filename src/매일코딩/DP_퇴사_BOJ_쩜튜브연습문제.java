package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp �迭 = x�Ϻ��� ���� �� �ִ� �ִ� �ݾ��� ����.
 * 1�Ͽ��� 3�ϵ��� ����� �� �� �����Ƿ� 1, 2, 3 ���� �Ҹ��ϰ� �˴ϴ�.
�׷� �ִ��� ���� �ݾ��� �ޱ� ���ؼ���
1�� �ݾ� + 4�Ϻ��� ���� �� �ִ� �ִ� �ݾ�
�̰��� 1�Ͽ� ����� �� ��� ���� �� �ִ� �ִ� �ݾ��Դϴ�.
x�Ϻ��� ���� �� �ִ� �ִ� �ݾ��� �����ϱ� ���� dp �迭�� ����մϴ�.
P[1] + dp[4] ��� ù��° ���� ������ϴ�.
�׷��� 1�Ͽ� ����� �ϴ� ��캸�� 2�Ͽ� ����� �ϴ� ��찡 �ְ� �ݾ��� �� �ֽ��ϴ�.
���� ��� P[1] + dp[4] �� �ݾ��� 50�ε� dp[2] �� 100 �� ���ɼ��� �ֽ��ϴ�.
�׷��Ƿ� �� ���� �� �� �� ū ���� 1�Ϻ��� ���� �� �ִ� �ִ� �ݾ��Դϴ�.
dp[1] = MAX(P[1] + dp[4], dp[2])
�Ϲ� �������� ��ȯ�ϸ�
dp[i] = MAX(P[i] + dp[i+T[i]], dp[i+1])
���� ������� ������� �ʰ��ϸ� �ڵ����� dp[i+1] �� ���� ������ �ִ� �ִ�ݾ��� �˴ϴ�.
������ ������ 1���� ����� �� �� �ֽ��ϴ�. i + T[i] <= N + 1 �� ������ ������ �մϴ�.
��� �迭�� ������ �� 1 �� ���������� �߰��� �� �����մϴ�.
 */

public class DP_���_BOJ_��Ʃ�꿬������ {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		int[] dp = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N; i>0; i--) {
			int day = i + T[i]; // i��° ���� ���Ⱓ
			
			if(day <= N+1) // ������������ 1���� ����� �� �� �ֱ� ������ N+1 ���ش�. ��� �迭�� ������ �� 1�� ���������� �߰��� �� �ش� N+2
							// ex) 1�Ͽ� ����� �ϴ°�� : 1�ϱݾ� + 4�Ϻ��� ���� �� �ִ� �ִ�ݾ� = p[1] + dp[4]
						   //     �׷��� 2�Ͽ� ����� �ϴ� ��찡 �ִ�ݾ��� ���� ���� : dp[i+1];
				dp[i] = Math.max(dp[day] + P[i], dp[i+1]);
			else // �ش� i��° ���� ���Ⱓ�� ������ �ʰ��ϸ� ���������� ���� �� �ִ� �ִ�ݾ��� �ִ밪
				dp[i] = dp[i+1];
		}
		
		System.out.println(dp[1]);
	}
}

