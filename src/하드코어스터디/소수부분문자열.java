package 하드코어스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 소수부분문자열 {
	static boolean prime[];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 부분 문자열 중에서 가장 큰 소수를 찾아라
		// 1. 부분 문자열 찾는 함수
		// 2. 찾은 부분 문자열 숫자로 변환 후 가장 큰 소수인지 판별 함수
		prime = new boolean[1000001];
		while(true) {
			int max = Integer.MIN_VALUE;
			String arr = br.readLine();
			if(arr.equals("0") && arr.length() == 1) break;
			
			int len = arr.length();
			
			for(int i=0; i<len; i++) {
				for(int j=i; j<i+6 && j<len; j++) {
						String str = arr.substring(i,j+1);
						if(str.length() > 5) continue;
						isPrime(str);
						int num = Integer.parseInt(str);
						if(num <= 100000 && prime[num] == false) { // 해당 부분 문자열이 소수라면
							max = Math.max(max, num);
						
					}
				}
			}
			
			bw.write(max + "\n");
			bw.flush();
		} // end while
		
		bw.close();
		br.close();
	}
	
	public static void isPrime(String str) {
		int num = Integer.parseInt(str);
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(prime[i]) continue;
			for(int j=i*i; j<100000; j+=i) {
				prime[j] = true;
			}
		}
	}
}

