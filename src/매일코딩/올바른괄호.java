import java.util.Stack;
class Solution {
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
		} else
            return false;
		
        return answer;
    }
}