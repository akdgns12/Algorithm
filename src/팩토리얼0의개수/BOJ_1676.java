package ���丮��0�ǰ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���� ���� 0�� ������ M���� N! �߿��� ���� ���� N�� ã�� ���α׷�

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
