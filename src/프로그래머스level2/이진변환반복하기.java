package ���α׷��ӽ�level2;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 1. s�� �ִ� 0 ��� ����
 * 2. s.length�� ������ ǥ��
 * s�� 1�� �� ������ �ݺ�
 * ����� 0������ ������ȯ Ƚ��  
 */

public class ������ȯ�ݺ��ϱ� {
	public int[] solution(String s) {
		int[] answer = {};
		answer = new int[2];
		
		int count = 0; //���� ��ȯ Ƚ��
		int count_zero = 0; //����� 0 ī��Ʈ 
		
		while(!s.equals("1")) { // s�� 1�̶� ���������� �ݺ��� ����, s==1�� �� ������ �ݺ�
			int count_one = 0;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '1') {
					count_one++;
				}else {
					count_zero++;
				}
			}
			s = Integer.toBinaryString(count_one);
			count++;
		}
		answer[0] = count;
		answer[1] = count_zero;
		return answer;
	}
}
