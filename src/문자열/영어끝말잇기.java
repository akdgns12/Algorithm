package ���ڿ�;

import java.util.ArrayList;

public class ������ձ� {
	public int[] solution(int n, String[] words) {
	int[] answer = new int[2];
	ArrayList<String> list = new ArrayList<String>();
	// üũ�ؾ��ϴ� �� 2����
	//1. ���θ��ϴ� �ܾ��� ù���ڰ� ���� �ܾ��� ���������ڿ� �ٸ��ų�
	//2. �̹� ���� �ܾ �� ���ϴ� ���
	// list�� �ܾ� �־�鼭 ���ؼ� ���´ܾ��� ��� break;
	
	int i; //�� ���� ���� Ƚ��
	list.add(words[0]);
	for(i=1; i<words.length; i++) {
		char prev = words[i-1].charAt(words[i-1].length()-1); // ������
		
		char curr = words[i].charAt(0); // ù����
		
		if(list.contains(words[i])) break;
		
		if(prev != curr) break; // �����ڰ� ���� �ܾ��� ������ ���ڿ� �ٸ��ٸ� ����
		
		list.add(words[i]);
	}
	
	if(i == words.length) {
		answer[0] = 0;
		answer[1] = 0;
	}else {
		answer[0] = i%n +1;
		answer[1] = i/n +1;
	}
	
	
	
	return answer;
}
}
