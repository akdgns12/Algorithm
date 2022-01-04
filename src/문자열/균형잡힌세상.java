package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ������������ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals(".")) { // ���� ���ǹ�
				break;
			}
			
			System.out.println(check(input));
		}
	}
	
	public static String check(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char c= str.charAt(i);
			// ���� ��ȣ�� ��� ���ÿ� push
			if(c == '(' || c == '[') {
				st.push(c);
			}
			// �ݴ� ��ȣ�� ���
			else if(c == ')') {
				// ������ ����ְų� pop�� ���Ұ� �Ұ�ȣ�� ��Ī�� �ȵǴ°��
				if(st.isEmpty() || st.peek() != '(') {
					return "no";
				}
				else {
					st.pop();
				}
			}
			
			else if(c == ']') {
				// ������ ����ְų� pop�� ���Ұ� ���ȣ�� ��Ī�� �ȵǴ� ���
				if(st.isEmpty() || st.peek() != '[') {
					return "no";
				}
				else {
					st.pop();
				}
			}
			// �׿��� ��쿡�� ���ʿ��� ���ڵ��̱⿡ skip�Ѵ�.
			
		}
		
		if(st.isEmpty()) {
			return "Yes";
		}else {
			return "no";
		}
	}
}
