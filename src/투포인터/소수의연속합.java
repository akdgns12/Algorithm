package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 소수의연속합 {
	// BOJ_1644 / 소수의 연속합 / 투포인터 / 골3
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수
		 */
		int N = Integer.parseInt(br.readLine());
		
		// 1. N <= 인 소수 구하기
		boolean[] prime = new boolean[N+1];
		ArrayList<Integer> primes = new ArrayList<>();
		
		prime[0] = prime[1] = true;
		// 에라토스테네스의 체
		for(int i=2; i*i <= N; i++) {
			if(!prime[i]) {
				// i의 배수들을 걸러주기 위한 반복문
				for(int j=i*i; j<=N; j += i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!prime[i]) {
				primes.add(i);
			}
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			if(sum >= N) {
				sum -= primes.get(start++);
			}else if(end == primes.size()) {
				break;
			}else {
				sum += primes.get(end++);
			}
			if(sum == N) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	
	}

}
