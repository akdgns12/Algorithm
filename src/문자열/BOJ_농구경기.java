package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_�󱸰�� {
/*
 * ���� ù ���ڰ� ���� ������ 5���� ���ٸ�, ����̴� ���� ��⸦ ���.
 * ����̴� ���� ��⸦ ���� ���� �� �ִ� ���� ù ���ڸ� ��� ���غ����� ��.
 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alpha = new int[26];
		int n = Integer.parseInt(br.readLine());
		
		//�� �Է¹޾� �ش� ���ĺ� �ڸ��� 1�� �߰�
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			char a = s.charAt(0);
			alpha[a-97]++;
		}
		
		boolean flag = false;
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i] >= 5) {
				flag = true;
				System.out.print((char)(i+97));
			}
		}
		if(!flag)
			System.out.println("PREDAJA");
	}

}
