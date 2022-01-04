package 매일코딩;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 규완이의 사전에서 k번째 문자열을 출력한다. 만약 규완이의 사전에 수록되어 있는
// 문자열의 개수가 k보다 작으면 -1을 출력한다.

// 범위가 10억이상 단위다.. dp문제인걸 빨리 알아차리는 연습!
// 다양한 풀이가 많지않아 완벽히 이해를 못한 문제..
// 접근방법
/*
 * 문자 A,Z 가 N개 M개로 만들 수 있는 개수는 A,Z가 N-1,M개와 N,M-1개로 만들 수 있는 개수의 합과 같다.
 * 이를 통해 K와 N+M개로 만들 수 있는 수를 비교하면서 앞에서부터 A인지 Z인지 하나씩 만들면서 정답을 도출한다.
 */
public class 사전 {
	
	static int n, m, k;
	static double[][] dp;
	static BufferedWriter answer = new BufferedWriter(new OutputStreamWriter(System.out));
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			dp = new double[n+1][m+1];
			
			if(k > numWord(n,m)) {
				System.out.println(-1);
			}else {
				getWord(n, m, k-1);
			}
			
			answer.write("\n");
			answer.close();
		}
		
		static double numWord(int A, int Z) {
			if(A == 0 || Z == 0	)
				return 1;
			if(dp[A][Z] != 0)
				return dp[A][Z];
			return dp[A][Z] = Double.min(numWord(A-1, Z) + numWord(A, Z-1), 1000000001);
		}
		
		static void getWord(int A, int Z, double before) throws IOException{
			if(A == 0) {
				for(int i=0; i<Z; i++)
					answer.write("a");
				return;
			}
			
			double tmp = numWord(A-1, Z);
			
			if(before < tmp) {
				answer.write("a");
				getWord(A-1, Z, before);
			}else {
				answer.write("z");
				getWord(A, Z-1, before - tmp);
			}
		}
}
