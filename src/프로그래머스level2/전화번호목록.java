package ���α׷��ӽ�level2;

import java.util.HashMap;

public class ��ȭ��ȣ��� {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		// ��ȭ��ȣ�� �־��� ��ȣ �迭 �� ���̰� ���� ª�� �迭 ��ȣ min��
		// �ش� min��  stack���� pop��Ų ���� �����ִ� ���ҵ��̶���
		// ���ϴ� �� 
		
		for( int i =0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book.length; j++) {
				if((i != j) && phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return answer;
	}
}
