package ���α׷��ӽ�level2;

import java.util.ArrayList;

/*
 * ����� �� n, ������� ������� ���� �ܾ� words 
 * ���� ���� Ż���ϴ� ����� ��ȣ�� �� ����� �ڽ��� �� ���� ���ʿ� Ż���ϴ�����
 * ���ؼ� return �ϵ��� �ϴ� solution
 * 
 */
public class ������ձ� {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		ArrayList<String> list = new ArrayList<>();
		// üũ�ؾ��� ���� 2����
		//1. ���θ��ϴ� �ܾ��� ù ���ڰ� ���� �ܾ��� ���������ڿ� �ٸ��ų�
		//2. �̹� ���� �ܾ �� ���ϴ� ���
	
		int i; //�� ������ ����Ǵ� Ƚ��
		list.add(words[0]);
		for( i=1; i<words.length; i++) {
			char prev = words[i-1].charAt(words[i-1].length() -1); // ���ܾ�
			char curr = words[i].charAt(0); //���� ó���ܾ�
			
			if(list.contains(words[i])) break; //���ԵǾ� �ִٸ� ����
			
			if(prev != curr) break; //���� ù �ܾ�� ���� ������ �ܾ �ٸ��� ����
			
			list.add(words[i]); //���� �ܾ �ߺ� ����Ʈ�� ��´�.
		}
		
		if(i == words.length) { //Ż���ڰ� ������ ���� ��,
			answer[0] = 0;
			answer[1] = 0;
		}else { // Ż���ڰ� ������ ��,
			answer[0] = i%n +1; //�� Ƚ���� n������ ���� ������ +1�� ���� Ż������ ��ȣ
			answer[1] = i/n +1; // �� +1�� �� ���������� �˷���
		}
			
		
		return answer;
	}
}
