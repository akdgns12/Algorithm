package �ϵ��ھ�͵�;

import java.util.Scanner;

public class �Ҽ����ϱ� {
	// �����佺�׳׽��� ü �˰���(�Ҽ��Ǻ� �˰���)
	/* 1~N���� �� �Ҽ� �Ǻ� �˰���
	 * k=2 ~ �Ǻ��ϰ��� �ϴ� ���� ��Ʈ����
	 * k�� ����� ���ܽ�Ų��. 
	 * ���� ������ �Ҽ����� 
	 */
		public static boolean[] prime;
		public static void main(String[] args) {
	 
			Scanner in = new Scanner(System.in);
			int M = in.nextInt();
			int N = in.nextInt();
			
			prime = new boolean[N + 1];
			get_prime();
					
			for(int i = M; i <= N; i++) {
				// false = �Ҽ� 
				if(!prime[i]) System.out.println(i);
			}
		}
	 
	 
		// �����佺�׳׽��� ü �˰���
		public static void get_prime() {
			// true = �Ҽ��ƴ� , false = �Ҽ� 
			prime[0] = prime[1] = true;
			
			// ������ �Լ� : Math.sqrt()
			for(int i = 2; i <= Math.sqrt(prime.length); i++) {
				// �̹� üũ�� �迭�̸� ���� �ݺ������� skip
				if(prime[i]) continue;
				// i�� ������� �ɷ��ֱ� ���� �ݺ���
				for(int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
}