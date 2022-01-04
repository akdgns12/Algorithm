package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp 배열 = x일부터 받을 수 있는 최대 금액을 저장.
 * 1일에는 3일동안 상담을 할 수 있으므로 1, 2, 3 일을 소모하게 됩니다.
그럼 최대한 많은 금액을 받기 위해서는
1일 금액 + 4일부터 받을 수 있는 최대 금액
이것이 1일에 상담을 할 경우 얻을 수 있는 최대 금액입니다.
x일부터 받을 수 있는 최대 금액을 저장하기 위해 dp 배열을 사용합니다.
P[1] + dp[4] 라는 첫번째 식을 얻었습니다.
그런데 1일에 상담을 하는 경우보다 2일에 상담을 하는 경우가 최고 금액일 수 있습니다.
예를 들어 P[1] + dp[4] 의 금액이 50인데 dp[2] 가 100 일 가능성이 있습니다.
그러므로 두 개의 값 중 더 큰 값이 1일부터 받을 수 있는 최대 금액입니다.
dp[1] = MAX(P[1] + dp[4], dp[2])
일반 수식으로 변환하면
dp[i] = MAX(P[i] + dp[i+T[i]], dp[i+1])
만약 상담일이 퇴사일을 초과하면 자동으로 dp[i+1] 의 값이 받을수 있는 최대금액이 됩니다.
마지막 날에도 1일의 상담을 할 수 있습니다. i + T[i] <= N + 1 로 수식을 세워야 합니다.
대신 배열을 선언할 때 1 의 여유공간을 추가로 더 선언합니다.
 */

public class DP_퇴사_BOJ_쩜튜브연습문제 {

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
			int day = i + T[i]; // i번째 날의 상담기간
			
			if(day <= N+1) // 마지막날에도 1일의 상담을 할 수 있기 때문에 N+1 해준다. 대신 배열을 선언할 때 1의 여유공간을 추가로 더 준다 N+2
							// ex) 1일에 상담을 하는경우 : 1일금액 + 4일부터 받을 수 있는 최대금액 = p[1] + dp[4]
						   //     그런데 2일에 상담을 하는 경우가 최대금액일 수도 있음 : dp[i+1];
				dp[i] = Math.max(dp[day] + P[i], dp[i+1]);
			else // 해당 i번째 날의 상담기간이 범위를 초과하면 다음날부터 얻을 수 있는 최대금액이 최대값
				dp[i] = dp[i+1];
		}
		
		System.out.println(dp[1]);
	}
}

