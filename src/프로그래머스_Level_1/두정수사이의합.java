package ���α׷��ӽ�_Level_1;
/*
 * �� ���� a,b�� �־����� �� a�� b���̿� ���� ��� ������ ���� �����ϴ� �Լ�
 * solution
 * ex) a= 3, b=5�� ���, 3+4+5 = 12 ����
 */
public class �������������� {
	public long solution(int a, int b) {
		long answer = 0;
		
		if(a<b) {
			for (int i=a; i<=b; i++) {
				answer +=i;
			}
		}else
			for(int i=b; i<=a; i++) {
				answer +=i;
			}
		return answer;
	}
}
