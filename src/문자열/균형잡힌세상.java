package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 균형잡힌세상 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals(".")) { // 종료 조건문
				break;
			}
			
			System.out.println(check(input));
		}
	}
	
	public static String check(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char c= str.charAt(i);
			// 여는 괄호일 경우 스택에 push
			if(c == '(' || c == '[') {
				st.push(c);
			}
			// 닫는 괄호일 경우
			else if(c == ')') {
				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는경우
				if(st.isEmpty() || st.peek() != '(') {
					return "no";
				}
				else {
					st.pop();
				}
			}
			
			else if(c == ']') {
				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우
				if(st.isEmpty() || st.peek() != '[') {
					return "no";
				}
				else {
					st.pop();
				}
			}
			// 그외의 경우에는 불필요한 문자들이기에 skip한다.
			
		}
		
		if(st.isEmpty()) {
			return "Yes";
		}else {
			return "no";
		}
	}
}
