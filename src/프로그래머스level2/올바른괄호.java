package 프로그래머스level2;

import java.util.Stack;

/*
 * () (()) 이런식으로 올바르게 열린 괄호에 대해 닫혔는지 
 * 올바른 괄호이면 true, else false return
 * 
 */
//stack을 이용하여 문자열 s의 i번째가 
// '('라면 push() 실행
// ')'라면 pop() 실행
/*
 * i번째가 ')'일 때 이전에 스택이 비어있다면
 * 올바른 괄호 페어가 되지 않기 때문에 return false
 * 
 * 반복문 종료 후 stack이 비어있는지 검사하여
 * 비어있다면 문자열 s가 올바른 괄호로 이루어져 있다는 것이기 때문에 true를 반환
 */
public class 올바른괄호 {
	boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.push(s.charAt(i));
			}else {
				if(stack.isEmpty()) return false; // 문자열 s의 i번째가 ')'인데 stack이 비어있다면 잘못된 괄호
				stack.pop();
			}
		}
		//반복문 종료 후 stack이 비어있다면 true
		if(stack.isEmpty()) {
			answer = true;
		}else
			return false;
		
		return answer;
	}
}
