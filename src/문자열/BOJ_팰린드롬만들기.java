package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * �Ǿձ��ڸ� ������
 * ��Ī�� ���þ��� ��� ���ڿ��鸸 �Ӹ���� �˻�
 */
public class BOJ_�Ӹ���Ҹ���� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] a = new int[26];
		for(int i=0; i<s.length(); i++) {
			a[s.charAt(i) - 'A']++;
		}
		
		int midIdx = 0, odd = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i]%2!=0) {
				midIdx = i;
				odd++;
			}
		}
		
		if((s.length() % 2 !=0 && odd > 1) || (s.length() % 2 == 0 && odd > 0)) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			String ans = "";
			for(int i=0; i<a.length; i++) {
				for(int j=0; j<a[i]/2; j++) {
					ans += ((char)(i+'A'));
				}
			}
			String rev = reverseString(ans);
			if(odd==1) ans+=((char)(midIdx + 'A'));
		}
	}
}
