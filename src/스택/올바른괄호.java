package ����;
import java.util.Stack;
class Solution {
	// ���α׷��ӽ� lv2 / īī�� ���� / ����
    boolean solution(String s) {
        boolean answer = true;
       Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.push(s.charAt(i));
			}else {
				if(stack.isEmpty()) return false; // ���ڿ� s�� i��°�� ')'�ε� stack�� ����ִٸ� �߸��� ��ȣ
				stack.pop();
			}
		}
		//�ݺ��� ���� �� stack�� ����ִٸ� true
		if(stack.isEmpty()) {
			answer = true;
		} else
            return false;
		
        return answer;
    }
}