package ���α׷��ӽ�_Level_1;

import java.util.ArrayList;
import java.util.Collections;

/*
 * ���ڿ��� ������ ����Ʈ strings, ���� n�� �־��� ��
 * �� ���ڿ��� n��° ���ڸ� �������� �������� ����
 * ex) strings�� ["sun", bed", "car"]�̰� n�� 1�̸�
 * �� �ܾ��� �ε��� 1�� ���� "u","e","a"�� strings�� ����
 */
public class ���ڿ���������������ϱ� {
	public String[] soltuion(String[] strings, int n) {
		String[] answer = new String[strings.length];
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<strings.length; i++) {
			list.add(strings[i].charAt(n) + strings[i]);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i).substring(1);
		}
		
		return answer;
	}
}
