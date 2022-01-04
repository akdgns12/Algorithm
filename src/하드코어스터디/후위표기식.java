package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ����ǥ��� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> st = new Stack<>();
		
		String result = "";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 'A' && c <= 'Z') { // ���ĺ��� ��� �ٷ� ���
				result += c;
			}else {
				switch(c) {
				case '(':
					st.push('(');
					break;
				case ')':
					// ���� ��ȣ ���ö����� ���
					while(!st.isEmpty() && st.peek() != '(') {
						result += st.pop();
					}
					// ���� ��ȣ ����
					if(!st.isEmpty() && st.peek() =='(') st.pop();
					break;
					
				default: // ������
					while(!st.isEmpty() && check(st.peek()) >= check(c))
						result += st.pop();
					
					st.push(c); // ������ ������ ���ÿ� ����
				}
			}
		}
		
		while(!st.isEmpty()) { // ���ÿ� �����ִ� �����ڸ� ��� �����ֱ�
			result += st.pop();
		}	
		
		System.out.println(result);
	}
	
	public static int check(char c) {
		if(c == '*' || c == '/') {
			return 2;
		}else if(c == '+' || c == '-') {
			return 1;
		}
		/*
		 * ���� �ȿ��� '('�� ���Ե� �� �ִ�. '('�� ���������� �ȵǱ� ������ ���� ���� �켱������ ���� ���־�� �Ѵ�.
		 * �ش� ������ �������� ��ȣ�� �ִ� �Ŀ��� '(' �� ���ÿ��� ������ ���� ��µ�
		 */
		return 0;
	}
}
