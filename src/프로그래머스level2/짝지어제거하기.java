package ���α׷��ӽ�level2;

import java.util.Stack;

/*
 * ���ĺ� �ҹ��ڷ� �̷���� ���ڿ� s�� �־�����
 * ���� ���ĺ� 2���� �پ��ִ� ¦�� �������� �����ؼ�
 * ��� �����Ѵٸ� ¦���� �����ϱ� ����
 * ������ �� ������ 1, �ƴϸ� 0 return
 */
public class ¦���������ϱ� {
	public int solution(String s) {
		int answer = 0;
		
		//�������� ���ٸ� pop
		//�����ʴٸ� ���ÿ� push
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
