package ���ڿ�;

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
		
		// 0�� �������� ������ 30�� ����� �� �� ����
		// �� �ڸ����� ���� 3�� ����� �ƴϸ� ����
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
