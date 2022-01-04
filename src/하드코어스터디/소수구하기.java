package 하드코어스터디;

import java.util.Scanner;

public class 소수구하기 {
	// 에라토스테네스의 체 알고리즘(소수판별 알고리즘)
	/* 1~N까지 중 소수 판별 알고리즘
	 * k=2 ~ 판별하고자 하는 수의 루트까지
	 * k의 배수를 제외시킨다. 
	 * 남은 수들이 소수들임 
	 */
		public static boolean[] prime;
		public static void main(String[] args) {
	 
			Scanner in = new Scanner(System.in);
			int M = in.nextInt();
			int N = in.nextInt();
			
			prime = new boolean[N + 1];
			get_prime();
					
			for(int i = M; i <= N; i++) {
				// false = 소수 
				if(!prime[i]) System.out.println(i);
			}
		}
	 
	 
		// 에라토스테네스의 체 알고리즘
		public static void get_prime() {
			// true = 소수아님 , false = 소수 
			prime[0] = prime[1] = true;
			
			// 제곱근 함수 : Math.sqrt()
			for(int i = 2; i <= Math.sqrt(prime.length); i++) {
				// 이미 체크된 배열이면 다음 반복문으로 skip
				if(prime[i]) continue;
				// i의 배수들을 걸러주기 위한 반복문
				for(int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
}