package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * B���ڿ��� �ϳ��� A���ڿ���ŭ ���鼭
 * A���ڿ����� ���̰� ���� ���� �� �� ���̸�
 * ����ϸ� �Ǵ� ����
 * 
 */
public class BOJ_���ڿ� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		int answer = A.length();
		
		for(int i=0; i<B.length() - A.length(); i++) {
			int cnt = 0;
			for(int j=0; j<A.length(); j++) {
				if(A.charAt(j) != B.charAt(i+j))
					cnt++;
			}
			answer = Math.min(cnt, answer);
		}
		System.out.println(answer);
		
	}
}
