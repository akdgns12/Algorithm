package 매일코딩;

import java.util.Stack;

public class 괄호변환 {
	public String solution(String p) {
		// 1.
		if(p.length() == 0) {
			return p;
		}
		
		StringBuilder answer = new StringBuilder();
		StringBuilder sb = new StringBuilder(p);
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		
		// 2. 균형잡힌 괄호 문자열 : 처음 ( 와 )의 수가 같아지면 u, 나머지 v
		int open = 0;
		int close = 0;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == '(')
				open++;
			if(sb.charAt(i) == ')')
				close++;
			
			if(open == close) {
				u.append(sb.substring(0,i+1));
				v.append(sb.substring(i+1));
				break;
			}
		}
		
		if(isCorrect(u.toString())) {
			return u.append(solution(v.toString())).toString();
		}
		
		answer.append("(").append(solution(v.toString())).append(")");
		
		for(int i=1; i<u.length()-1; i++) {
			if(u.charAt(i) == '(') {
				answer.append(")");
			}else {
				answer.append("(");
			}
		}
		
		return answer.toString();
	}
	
	public static boolean isCorrect(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				st.push('(');
			}else {
				if(st.isEmpty()) {
					return false;
				}else {
					st.pop();
				}
			}
		}
		return true;
	}
	
}
