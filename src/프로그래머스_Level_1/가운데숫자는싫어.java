package ���α׷��ӽ�_Level_1;

import java.util.ArrayList;

/*
 * �迭 arr�� �־�����, �� ���Ҵ� 0~9������ �̷���
 * ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ����
 * ���ŵ� �� ���� ���� ��ȯ
 */
public class ������ڴ½Ⱦ� {
	public int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		int current = 10; //������ 0~9�����̹Ƿ� 10�̸� ������ �ؿ� if�� ����
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != current) {
				list.add(arr[i]);
				current = arr[i];
			}
		}
		
		int [] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
