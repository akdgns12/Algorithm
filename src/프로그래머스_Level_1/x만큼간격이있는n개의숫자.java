package ���α׷��ӽ�_Level_1;
/*
 * �Լ� solution�� ����x�� �ڿ��� n�� �Է¹޾�, x���� ������ x�� ���ϴ�
 * ���ڸ� n�� ���ϴ� ����Ʈ�� return�ؾ���.
 * n�� 1000������ �ڿ���
 * x�� -10000000�̻� 10000000������ ����
 */
public class x��ŭ�������ִ�n���Ǽ��� {
	public long[] solution(long x, int n) {
		long[] answer = new long[n];
		
		for(int i=0; i<n; i++) {
			answer[i] = x*(i+1);
		}
		return answer;
	}
}
