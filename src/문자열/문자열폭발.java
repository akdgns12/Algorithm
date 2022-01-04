package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ���ڿ����� {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 1. stack1�� ���ڿ��� �Է¹޴´�
		 * 2. stack2�� stack1���� pop�� ���� push�Ѵ� 
		 * 	  �ݺ��ϸ鼭 ���߹��ڿ��� �������� Ȯ���ϴ�.
		 * 3. ���߹��ڿ��� ���ð�� ���߹��ڿ��� ���̸�ŭ stack2�� pop�ϰ� 
		 *    ���߹��ڿ��� ���̸�ŭ stack2���� pop�� ���� stack1�� push
		 * 4. 2~3�� ���������� �ݺ�
		 */
		String str = br.readLine();
		String boom = br.readLine();
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			st1.push(str.charAt(i));
		}
		
		int idx = 0;
		while(!st1.isEmpty()) {
			st2.push(st1.pop());
			if(st2.peek() == boom.charAt(boom.length() - (idx+1))) { //���� ���ڿ��� ���ڰ� ������
				idx++;
			}
			else {
				idx = 0;
				if(st2.peek() == boom.charAt(boom.length() - (idx + 1))) { //�ϳ��� �ٸ��� �ʱ�ȭ
					idx++;
				}
			}
			
			if(idx == boom.length()) {//���� ���ڿ��� ������
				for(int i=0; i<boom.length(); i++) {
					st2.pop(); //���̸�ŭ ���ְ�
				}
				for(int i=0; i<boom.length(); i++) {
					if(!st2.isEmpty()) {
						st1.push(st2.pop()); //��˻縦 ���� ���߹��ڿ� ���̸�ŭ st1�� �ٽ� Ǫ��
						
					}
					else {
						break;
					}
				}
				idx = 0;
			}
			
		}
		
		if(st2.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			while(!st2.isEmpty()) {
				sb.append(st2.pop());
			}
			System.out.println(sb.toString());
		}
	}
}
