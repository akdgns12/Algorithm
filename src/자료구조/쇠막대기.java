package �ڷᱸ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class �踷��� {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		 // '('�� ������ push
		// ')'�� pop �ٸ� �ٷ� �� ���ڰ� '('��� �װ� ������
		int result = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				st.push('(');
				continue;
			}
			if(str.charAt(i) == ')') {
				st.pop();
				
				if(str.charAt(i-1) == '(') { // �� �� ��ȣ�� ���� ��ȣ�� �������� �ǹ�
					result += st.size(); // ���� stack�� �����ŭ ������
				}else { // �� �� ��ȣ�� ���� ��ȣ�� �������� �ƴ�.
					result++; // �ܼ��� 1�� ������
				}
			}
		}
		System.out.println(result);
		
	}
}
