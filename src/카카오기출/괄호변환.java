package 카카오기출;
import java.util.*;

public class 괄호변환 {
	//올바른 괄호인지 아닌지 체크하는 함수
	int pos;
	boolean isCorrect(String str) {
		boolean ret = true;
		int open = 0, close = 0;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				open++;
				stack.push('(');
			}else {
				close++;
				//스택이 비어있다면 짝이 안맞는 경우니까 올바른 괄호 x
				if(stack.isEmpty()) 
					ret = false;
				else
					stack.pop();
			}
			if(open == close) {
				pos = i+1;
				return ret;
			}
		}
		
		return true;
	}
	
	public String solution(String p) {
	//1.빈 문자열인 경우 빈 문자열 반환
		if(p.equals(""))
		return "";
	
	boolean correct = isCorrect(p);
	String u = p.substring(0, pos);
	String v = p.substring(pos, p.length());
	
	if(correct) {
		return u + solution(v);
	}
	
	String answer ="(" + solution(v) + ")";
	//1부터 시작 , length()-1 해서 첫,끝 문자 제거
	for(int i=1; i<u.length()-1; i++) {
		if(u.charAt(i) == '(')
			answer += ")";
		else
			answer += "(";
	}
	
	return answer;
	}
}
