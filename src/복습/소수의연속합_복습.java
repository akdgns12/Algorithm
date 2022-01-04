package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 소수의연속합_복습 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[N+1];
		
		isPrime[0] = isPrime[1] = true;
		
		for(int i=2; i*i<=N; i++) {
			if(!isPrime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					isPrime[j] = true;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>(); // 소수를 담는 arrayList
		
		for(int i=2; i<=N; i++) {
			if(!isPrime[i]) {
				list.add(i);
			}
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			if(sum >= N) {
				sum -= list.get(start++);
			}else if(end == list.size()) {
				break;
			}else if(sum < N) {
				sum += list.get(end++);
			}
			
			if(sum == N)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
