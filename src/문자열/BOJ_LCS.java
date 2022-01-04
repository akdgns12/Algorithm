package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두수열이
 * 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제.
 * ex) ACAYKP 와 CAPCAK의 LCS 는 ACAK
 * 
 */
public class BOJ_LCS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		/*
		 * 1.

우리가, "ACAYKP"와 "CAPCAK"의 "최장 공통 부분 수열", "ACAK" 을 안다고 할 때, 여기에 문자를 하나씩 더한

"ACAYKPZ"와 "CAPCAKZ" 의 "최장 공통 부분 수열"은 무엇일까요?

 

각각의 문자열에 같은 문자를 더했으니, 당연히(?) "최장 공통 부분 수열, 이하 LCS"은 "ACAKZ" 가 되겠지요?

 

즉, A의 어떤 문자(A[i]) 와 B의 어떤 문자(B[j) 가 서로 같다면, 두 문자를 제외한 문자열

 

 - "ACAYKP", "CAPCAK"

 

이 가진 LCS보다 1만큼 더 커진다는 것을 알 수 있습니다. (경우 1)

 

 

2.

그렇다면, 서로 다른 문자를 더한 "ACAYKPZ" 와 "CAPCAKP"는 어떻게 될까요? 서로 다르니, "ACAK"에서 변함이 없을까요?

 

아닙니다. 자세히 보면 "ACAKP"가 새로운 "LCS"가 될 수 있다는 것을 알 수 있습니다.

그리고 "ACAKP" 는 "ACAYKP"와 "CAPCAKP" 의 "LCS"입니다! 다시 말해서, "ACAYKPZ"에서 'Z' 는 없어도 되는 것이죠.

 

즉, A의 어떤 문자(A[i]) 와 B의 어떤 문자(B[j) 가 서로 다르다면, 두 문자 중 하나를 제외한 문자열 

 

 - "ACAYKP", "CAPCAKP" 또는

 - "ACAYKPZ", "CAPCAK"

 

이 가진 LCS 중 큰 것이 우리가 원하는 LCS가 되게 됩니다. (이 경우에선 전자)

// 경우 1) A[i] = B[j],
   경우 2) A[i] != B[j]
		 */
		//먼저 두 문자열 A와 B의 인덱스 i,j를 가지고 DP를 할건데,
		/*
		 * 먼저 (M+1)(N+1) 크기를 가진 2차원 DP 배열을 만들어 줍니다.
		 * 그리고 각각의(i,j) 위치에 "A의 i번째 문자까지, B의 j번째 문자까지 이용하여 만든
		 * LCS의 값"을 저장합니다.
		 */
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		for(int i=1; i<=str1.length; i++) {
			for(int j=1; j<=str2.length; j++) {
				if(str1[i - 1] == str2[j - 1]) { // 경우 1) A[i] = B[j]
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else { // 경우 2) A[i] != B[j]
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[str1.length][str2.length]);
	}
}
