package ������������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * ������ Ȱ���� ������ �ذ��� �� �ִ�.
 * ���ÿ� ���� ��ȣ�� ���ʴ�� push ��  �ݴ� ��ȣ�� ������ ���ʴ�� pop�ؼ�
 * ���������� ���ÿ� �ƹ��͵� �������� �ʴٸ� �ùٸ� VPS
 */
public class ��ȣ {
	static int tc;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			sb.append(solve(br.readLine())).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char c= s.charAt(i);
			
			// ���� ��ȣ�� ��� ���ÿ� �ִ´�.
			if(c == '(') {
				stack.push(c);
			}
			
			//�Ʒ��� ��� �ݴ� ��ȣ�� ����
			// ������ ����ִ� ���, �� , �ݴ� ��ȣ�� �Է¹޾����� pop�� ���Ұ� ���� ���
			else if(stack.empty()) {
				return "NO";
			}
			//�� ���� ��� stack ���Ҹ� pop �Ѵ�.
			else {
				stack.pop();
			}
		}
		
		/*
		 * ��� �˻縦 ��ġ�� ���ÿ� �ܿ� ��Ұ� ������ ���� ��ȣ�� ���� ���� "NO"
		 * ������ ��������� ������ �����̹Ƿ� "YES"�̴�.
		 */
		
		if(stack.empty()) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
