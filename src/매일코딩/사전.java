package �����ڵ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// �Կ����� �������� k��° ���ڿ��� ����Ѵ�. ���� �Կ����� ������ ���ϵǾ� �ִ�
// ���ڿ��� ������ k���� ������ -1�� ����Ѵ�.

// ������ 10���̻� ������.. dp�����ΰ� ���� �˾������� ����!
// �پ��� Ǯ�̰� �����ʾ� �Ϻ��� ���ظ� ���� ����..
// ���ٹ��
/*
 * ���� A,Z �� N�� M���� ���� �� �ִ� ������ A,Z�� N-1,M���� N,M-1���� ���� �� �ִ� ������ �հ� ����.
 * �̸� ���� K�� N+M���� ���� �� �ִ� ���� ���ϸ鼭 �տ������� A���� Z���� �ϳ��� ����鼭 ������ �����Ѵ�.
 */
public class ���� {
	
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
