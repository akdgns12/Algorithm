package ���α׷��ӽ�_Level_1;
/*
 * ���� n�� �Է¹޾� n�� ����� ��� ���� ���� return�ϴ� �Լ�, solution
 * n�� 0�̻� 3000������ ����
 * 
 */
public class ������� {
	public int soltuion(int n) {
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			if(n%i == 0) {
				answer += i;
			}
		}
		return answer;
	}
}
