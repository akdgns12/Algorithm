package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		 // '('을 만나면 push
		// ')'는 pop 다만 바로 전 문자가 '('라면 그건 레이저
		int result = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				st.push('(');
				continue;
			}
			if(str.charAt(i) == ')') {
				st.pop();
				
				if(str.charAt(i-1) == '(') { // 그 전 괄호가 열린 괄호면 레이저를 의미
					result += st.size(); // 현재 stack의 사이즈만큼 더해줌
				}else { // 그 전 괄호가 닫힌 괄호면 레이저가 아님.
					result++; // 단순히 1을 더해줌
				}
			}
		}
		System.out.println(result);
		
	}
}
