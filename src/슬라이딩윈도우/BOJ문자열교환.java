package �����̵�������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ���ڿ���ȯ {
	// BOJ 1522 ���ڿ���ȯ ��� 5 / �����̵� ������
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int a_cnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a') 
				a_cnt++;
		}
		
		int b_cnt = 0;
		for(int i=0; i<a_cnt; i++) {
			if(s.charAt(i) == 'b') 
				b_cnt++;
		}
		
		int ans = b_cnt;
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i-1) == 'b') {
				b_cnt--;
			}
			int endWindow = i+a_cnt-1;
			if(endWindow >= s.length()) {
				endWindow -= s.length();
			}
			if(s.charAt(endWindow) == 'b')
				b_cnt++;
			ans = Math.min(ans, b_cnt);
		}
	}
}
