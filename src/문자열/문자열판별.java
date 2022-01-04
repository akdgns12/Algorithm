package ���ڿ�;
import java.util.*;
//DP������....Ȯ���� �����ؼ� �������� ������

public class ���ڿ��Ǻ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String>	 A = new HashSet<>();
		int[] dp = new int[101];
		
		String s = sc.nextLine();
		int N = sc.nextInt();
		
		//A�� ���ڿ��� ������� �Է¹޾� HashSet�� �־��ش�
		for(int i=0; i<N; i++) {
			A.add(sc.nextLine());
		}
		/*
		 * ���ʿ� �ִ� �ݺ��������� dp[1]�� ��츦 ã�Ƽ� �� ������ �κ��� üũ
		 * s.substring(i)�� �κ� ���ڿ� �ȿ��� dp[j]�� 1�� ��츦 ����
		 * s.substring(j)�� A�� ���ԵǾ� �ִٴ� �ǹ̰�, ���� s.substring(i,j)��
		 * A�� ���ԵǾ� �ִٸ� dp[i]�� 1�� �Ǵ� ����.
		 * �׸��� s.substring(i)�� ģ�� ��ü�� A�� ���ԵǾ� �ִ��� ���ε� üũ���ش�.
		 * ������ dp[0](���ڿ� A���� ���ڿ��� �̷���� �ִ��� ����)�� ���
		 */
		//i = ���ڿ� s�� ������ ó������
		for(int i=s.length()-1; i>=0; i--) {
			//j = i+1���� ���ڿ� s�� ������
			for(int j=i+1; j<s.length(); j++) {
				if(dp[j] == 1) {
					if(A.contains(s.substring(i,j))) dp[i]=1;
				}
			}
			if(A.contains(s.substring(i))) dp[i] = 1;
		}
		
		System.out.println(dp[0]);
	}
}
