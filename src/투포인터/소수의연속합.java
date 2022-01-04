package ��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class �Ҽ��ǿ����� {
	// BOJ_1644 / �Ҽ��� ������ / �������� / ��3
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * �ڿ��� N�� ���ӵ� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ��
		 */
		int N = Integer.parseInt(br.readLine());
		
		// 1. N <= �� �Ҽ� ���ϱ�
		boolean[] prime = new boolean[N+1];
		ArrayList<Integer> primes = new ArrayList<>();
		
		prime[0] = prime[1] = true;
		// �����佺�׳׽��� ü
		for(int i=2; i*i <= N; i++) {
			if(!prime[i]) {
				// i�� ������� �ɷ��ֱ� ���� �ݺ���
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
