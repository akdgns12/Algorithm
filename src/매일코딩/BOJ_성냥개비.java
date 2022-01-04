package �����ڵ�;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_���ɰ��� {
	// BOJ 3687 // ���̹� ���繮�� 
	// �־��� ���ɰ��� ��� ����ؼ� ���� �� �ִ� ���� ���� ���� ū��
	/*
	 * ���ɰ���
	 * 2�� : 1 / 3�� : 3 / 4�� : 4 / 5�� : 2,3,5 / 6�� : 6,9,0 / 7�� : 8
	 * 
	 * ���ɰ��� ���� ���� ����ϴ� ���� : 1 (2�����)
	 * ���ɰ��� ���� ���� ����ϴ� ���� : 8 (7�����)
	 * 
	 * ���� ū ���� �����
	 * Ȧ������ ��� : �� �տ� Ȧ��(3��)�� ���� �� �ִ� ���ڸ� ����� �������� 1(2�� ���)���� ä���
	 * ¦������ ��� : ��� 1(2�� ���)�� ä���
	 * 
	 * ���� ���� ���� �����
	 * 2�� : 1
	 * 3�� : 7
	 * 4�� : 4
	 * 5�� : 2 (2, 3, 5 �� ���� ���� ����)
	 * 6�� : 6 ( 0���δ� ������ �� ���ٴ� ����)
	 * 7�� : 8
	 * 8�� : 10 (7���� �Ѿ����-���ڸ� ���� ������ / �� 2�ڸ� ���� �̻�)
	 * 9�� : 18 ( 2���� 1, ������ 7���� 8)
	 * 10�� : 22 ( 5���� 2 , 5���� 2 / 2���� 1�� ����� 8�� ���Ե�)
	 */
	static int N;
	static long[] minDp;
	static int M;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase --> 0) {
			N = sc.nextInt();
			
			minDp = new long[101];
			
			Arrays.fill(minDp, Long.MAX_VALUE);
			// i�� ���� ���� minDp[i] = i�� ���� �� �ִ� ��
			minDp[2] = 1;
			minDp[3] = 7;
			minDp[4] = 4;
			minDp[5] = 2;
			minDp[6] = 6; // �ٸ� ���� �ڿ� �� ���� 0
			minDp[7] = 8;
			minDp[8] = 10;
			
			String[] add = {"1","7","4","2","0","8"};
			//DP[n] = (DP[n-2] + min[2], DP[n-3] + min[3], ..., DP[n-7] + min[7]) �� ���� ���� ��
			for(int i=9; i<=100; i++) {
				//9���� (7,0) (6,1)
				for(int j=2; j<=7; j++) {
					String line = "" + minDp[i-j] + add[j-2];
					minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
				}
			}
			
			// ���� ū �� ���ϱ�
			StringBuilder max = new StringBuilder();
			long a = N / 2;
			long b = N % 2;
			
			if(b == 1) {
				max.append("7");
			}else {
				max.append("1");
			}
			
			for(int i=1; i<a; i++) {
				max.append("1");
			}
			
			System.out.println(minDp[N] + " " + max.toString());
		}
	}
}
