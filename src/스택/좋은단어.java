package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ_3986
// ����
/*
 * A B A B
 * A A B B
 * A B B A
 * stack�� ù ��° ���ڸ� push
 * ���ڿ��� �ι� ° ���� ������ Ž���ϸ鼭
 * stack.peek() ������ ž ���� ���� ���ڿ� ���� Ž���ϰ� �ִ� ���ڿ� ��
 * ������ stack.pop
 * �ٸ��� stack.push
 * ���� Ž���� �� stack.isempty() �� ���� stack�� ��������� �����ܾ�, ������� ������ ���� ���� �ܾ�.
 */

public class �����ܾ� {
	
	static int N;
	public static void main(String[] args)	throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int count=0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			int len = str.length();
			stack.push(str.charAt(0));
			
			for(int j=1; j<str.length(); j++) {
				char nowCh = str.charAt(j);
				if(!stack.isEmpty()) {
					char prevCh = stack.peek();
					if(prevCh == nowCh) {
						stack.pop();
						continue;
					}
				}
				stack.push(nowCh);
			}
			
			if(stack.isEmpty()) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}
