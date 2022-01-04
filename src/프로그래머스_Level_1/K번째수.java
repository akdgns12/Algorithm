package ���α׷��ӽ�_Level_1;

import java.util.ArrayList;
import java.util.Collections;
/*
 * �� ����Ʈ�� �����
 * ���۹���, �� ������ �ش��ϴ� �迭�� ����Ʈ�� �ִ´�
 * ����Ʈ�� �����ϰ� �ش��ϴ� ������ �ε����� �ִ´�
 */
public class K��°�� {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<commands.length; i++) {
			list.clear();
			int start = commands[i][0]-1;
			int end = commands[i][1]-1;
			int stop = commands[i][2]-1;
			
			for(int j=start; j<=end; j++) {
				list.add(array[j]);
			}
			
			Collections.sort(list);
			answer[i] = list.get(stop);
		}
		
		
		return answer;
	}
}
