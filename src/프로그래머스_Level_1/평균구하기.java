package ���α׷��ӽ�_Level_1;
/*
 * ������ ��� �ִ� �迭 arr�� ��հ��� return�ϴ� �Լ�, solution��
 * �ϼ��϶�
 * 
 */
public class ��ձ��ϱ� {
	public double solution(int[] arr) {
		double answer = 0;
		double sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		answer = sum/arr.length;
		return answer;
	}
}
