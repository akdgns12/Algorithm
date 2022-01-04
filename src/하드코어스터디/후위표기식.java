package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> st = new Stack<>();
		
		String result = "";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 'A' && c <= 'Z') { // 알파벳일 경우 바로 출력
				result += c;
			}else {
				switch(c) {
				case '(':
					st.push('(');
					break;
				case ')':
					// 여는 괄호 나올때까지 출력
					while(!st.isEmpty() && st.peek() != '(') {
						result += st.pop();
					}
					// 여는 괄호 빼기
					if(!st.isEmpty() && st.peek() =='(') st.pop();
					break;
					
				default: // 연산자
					while(!st.isEmpty() && check(st.peek()) >= check(c))
						result += st.pop();
					
					st.push(c); // 이후의 연산자 스택에 삽입
				}
			}
		}
		
		while(!st.isEmpty()) { // 스택에 남아있는 연산자를 모두 꺼내주기
			result += st.pop();
		}	
		
		System.out.println(result);
	}
	
	public static int check(char c) {
		if(c == '*' || c == '/') {
			return 2;
		}else if(c == '+' || c == '-') {
			return 1;
		}
		/*
		 * 스택 안에는 '('도 삽입될 수 있다. '('는 꺼내져서는 안되기 때문에 제일 낮은 우선순위를 갖게 해주어야 한다.
		 * 해당 과정을 빼먹으면 괄호가 있는 식에서 '(' 도 스택에서 꺼내져 같이 출력됨
		 */
		return 0;
	}
}
