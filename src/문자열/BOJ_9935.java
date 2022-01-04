package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
	// ���ڿ����� / ��� 4
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String boom = br.readLine();
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			st1.push(input.charAt(i));
		}
		
		int idx = 0;
		while(!st1.isEmpty()) {
			st2.push(st1.pop());
			if(st2.peek() == boom.charAt(boom.length() - (idx+1))){ // ���� ���ڿ��� ������
				idx++;
			}else {
				idx = 0;
				if(st2.peek() == boom.charAt(boom.length() - (idx+1))) { // �ϳ��� �ٸ��� �ʱ�ȭ
					idx++;
				}
			}
			
			if(idx == boom.length()) { // ���߹��ڿ��� ������
				for(int i=0; i<boom.length(); i++) {
					st2.pop(); // ���̸�ŭ ���ְ�
				}
				for(int i=0; i<boom.length(); i++) {
					if(!st2.isEmpty()) {
						st1.push(st2.pop()); // ��˻縦 ���� ���� ���ڿ� ���̸�ŭ st1�� �ٽ� Ǫ��
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
