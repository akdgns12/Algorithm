package ���α׷��ӽ�_Level_1;
/*
 * �ڿ��� N�� �־�����, N�� �� �ڸ����� ���� ���ؼ� return�ϴ� solution �Լ�
 * ����.
 * ���� ��� N = 123�̸� 1+2+3 = 6�� return
 */
public class �ڸ������ϱ� {
	public int solution(int n) {
		int answer = 0;
		
		while(n != 0) {
			answer += n%10;
			n = n/10;
		}
		return answer;
	}
}
