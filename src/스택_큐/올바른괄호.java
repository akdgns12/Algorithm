package ����_ť;
import java.util.*;
public class �ùٸ���ȣ {
	boolean solution(String s) {
		boolean answer = true;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}else {
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}
		
		if(stack.isEmpty()) {
			answer = true;
		}else
			return false;
		
		return answer;
	}
}
