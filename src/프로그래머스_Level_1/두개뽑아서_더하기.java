package ���α׷��ӽ�_Level_1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * ���� �迭 numbers�� �־����� numbers���� ���� �ٸ� �ε����� �ִ�
 * �� ���� ���� �̾� ���ؼ� ���� �� �ִ� ��� ���� �迭�� ������������ ���
 * return
 */
public class �ΰ��̾Ƽ�_���ϱ� {
	public int[] solution(int[] numbers	) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++	) {
				int a = numbers[i] + numbers[j];
				if(list.indexOf(a) < 0) {
					list.add(a);
				}
			}
		}
		int [] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
			
		}
		Arrays.sort(answer);
		
		return answer;
	}
}
