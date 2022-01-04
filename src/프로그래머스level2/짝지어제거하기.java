package 프로그래머스level2;

import java.util.Stack;

/*
 * 알파벳 소문자로 이루어진 문자열 s가 주어지면
 * 같은 알파벳 2개가 붙어있는 짝을 연속으로 제거해서
 * 모두 제거한다면 짝지어 제거하기 종료
 * 성공할 수 있으면 1, 아니면 0 return
 */
public class 짝지어제거하기 {
	public int solution(String s) {
		int answer = 0;
		
		//스택으로 같다면 pop
		//같지않다면 스택에 push
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			if(stack.isEmpty()) {
				stack.push(String.valueOf(s.charAt(i)));
			}else {
				String lastVal = stack.peek();
				String currVal = String.valueOf(s.charAt(i));
				if(!lastVal.equals(currVal)) {
					stack.push(currVal);
				}else {
					stack.pop();
				}
			}
		}
		
		return stack.size() == 0 ? 1 : 0;
	}
}
