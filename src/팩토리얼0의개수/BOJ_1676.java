package 팩토리얼0의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가장 끝의 0의 개수가 M개인 N! 중에서 가장 작은 N을 찾는 프로그램

public class BOJ_1676 {
	
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(M>=5) {
			count += M / 5;
			M /= 5;
		}
		System.out.println(count);
	}
	
	
}
