package ���α׷��ӽ�level2;

import java.util.Stack;

/*
 * () (()) �̷������� �ùٸ��� ���� ��ȣ�� ���� �������� 
 * �ùٸ� ��ȣ�̸� true, else false return
 * 
 */
//stack�� �̿��Ͽ� ���ڿ� s�� i��°�� 
// '('��� push() ����
// ')'��� pop() ����
/*
 * i��°�� ')'�� �� ������ ������ ����ִٸ�
 * �ùٸ� ��ȣ �� ���� �ʱ� ������ return false
 * 
 * �ݺ��� ���� �� stack�� ����ִ��� �˻��Ͽ�
 * ����ִٸ� ���ڿ� s�� �ùٸ� ��ȣ�� �̷���� �ִٴ� ���̱� ������ true�� ��ȯ
 */
public class �ùٸ���ȣ {
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
		}else
			return false;
		
		return answer;
	}
}
