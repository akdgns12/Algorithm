package Algorithm;

import java.io.IOException;
import java.util.Scanner;
// ������ �� ���� N! ���� 0�� � �ٴ��� ����ϴ� ���α׷�
// 2*5 �� ������ ���� �ȴ�. -> ���������� 5�� ������ ���� �ȴ� 
public class BOJ3474 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		int count = 0;
		for(int i=0; i<testcase; i++) {
			long num = input.nextLong();
			for(int j = 5; j<=num; j*=5) {
				count += num/j;
			}
			System.out.println(count);
			count = 0;
		}
	}
}
