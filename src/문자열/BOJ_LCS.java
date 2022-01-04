package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * LCS(Longest Common Subsequence, ���� ���� �κ� ����)������ �μ�����
 * �־����� ��, ����� �κ� ������ �Ǵ� ���� �� ���� �� ���� ã�� ����.
 * ex) ACAYKP �� CAPCAK�� LCS �� ACAK
 * 
 */
public class BOJ_LCS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		/*
		 * 1.

�츮��, "ACAYKP"�� "CAPCAK"�� "���� ���� �κ� ����", "ACAK" �� �ȴٰ� �� ��, ���⿡ ���ڸ� �ϳ��� ����

"ACAYKPZ"�� "CAPCAKZ" �� "���� ���� �κ� ����"�� �����ϱ��?

 

������ ���ڿ��� ���� ���ڸ� ��������, �翬��(?) "���� ���� �κ� ����, ���� LCS"�� "ACAKZ" �� �ǰ�����?

 

��, A�� � ����(A[i]) �� B�� � ����(B[j) �� ���� ���ٸ�, �� ���ڸ� ������ ���ڿ�

 

 - "ACAYKP", "CAPCAK"

 

�� ���� LCS���� 1��ŭ �� Ŀ���ٴ� ���� �� �� �ֽ��ϴ�. (��� 1)

 

 

2.

�׷��ٸ�, ���� �ٸ� ���ڸ� ���� "ACAYKPZ" �� "CAPCAKP"�� ��� �ɱ��? ���� �ٸ���, "ACAK"���� ������ �������?

 

�ƴմϴ�. �ڼ��� ���� "ACAKP"�� ���ο� "LCS"�� �� �� �ִٴ� ���� �� �� �ֽ��ϴ�.

�׸��� "ACAKP" �� "ACAYKP"�� "CAPCAKP" �� "LCS"�Դϴ�! �ٽ� ���ؼ�, "ACAYKPZ"���� 'Z' �� ��� �Ǵ� ������.

 

��, A�� � ����(A[i]) �� B�� � ����(B[j) �� ���� �ٸ��ٸ�, �� ���� �� �ϳ��� ������ ���ڿ� 

 

 - "ACAYKP", "CAPCAKP" �Ǵ�

 - "ACAYKPZ", "CAPCAK"

 

�� ���� LCS �� ū ���� �츮�� ���ϴ� LCS�� �ǰ� �˴ϴ�. (�� ��쿡�� ����)

// ��� 1) A[i] = B[j],
   ��� 2) A[i] != B[j]
		 */
		//���� �� ���ڿ� A�� B�� �ε��� i,j�� ������ DP�� �Ұǵ�,
		/*
		 * ���� (M+1)(N+1) ũ�⸦ ���� 2���� DP �迭�� ����� �ݴϴ�.
		 * �׸��� ������(i,j) ��ġ�� "A�� i��° ���ڱ���, B�� j��° ���ڱ��� �̿��Ͽ� ����
		 * LCS�� ��"�� �����մϴ�.
		 */
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		for(int i=1; i<=str1.length; i++) {
			for(int j=1; j<=str2.length; j++) {
				if(str1[i - 1] == str2[j - 1]) { // ��� 1) A[i] = B[j]
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else { // ��� 2) A[i] != B[j]
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[str1.length][str2.length]);
	}
}
