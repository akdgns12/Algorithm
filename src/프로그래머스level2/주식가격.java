package ���α׷��ӽ�level2;

import java.util.ArrayList;

/*
 * �� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��, ������
 * �������� ���� �Ⱓ�� ���������� return �ϵ��� solution �ۼ�
 */
public class �ֽİ��� {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		
		
		for(int i=0; i<prices.length; i++) {
			int time = 0;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i] <= prices[j]) {
					time++;
				}
				else {
					time++;
					break;
				}
			}
			answer[i] = time;
		
		}
	
		return answer;
	}
}
