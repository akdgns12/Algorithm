package ���α׷��ӽ�_Level_1;

	import java.util.ArrayList;
	import java.util.Arrays;

/*
 * array�� �� element�� divisor�� ������ �������� ���� ������������
 * ������ �迭�� ��ȯ�ϴ� �Լ�, solution
 * divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ���
 * ��ȯ
 */
public class ����������¼��ڹ迭 {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};	
		ArrayList<Integer> list = new ArrayList<>();	
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%divisor == 0) {
					list.add(arr[i]);
			}
		}
		
		if(list.isEmpty()) {
			list.add(-1);
		}
		answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
}
