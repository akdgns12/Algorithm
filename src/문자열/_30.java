package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int[] number = new int[10];
		long total = 0;
		
		for(int i=0; i<input.length(); i++) {
			int num = Integer.parseInt(input.substring(i,i+1));
			number[num]++;
			total += num;
		}
		
		// 0이 존재하지 않으면 30의 배수가 될 수 없다
		// 각 자리수의 합이 3의 배수가 아니면 종료
		if(!input.contains("0") || total % 3 != 0) {
			System.out.println("-1");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=9; i>=0; i--) {
			while(number[i] > 0) {
				sb.append(i);
				number[i]--;
			}
		}
		System.out.println(sb.toString());
	}
}
