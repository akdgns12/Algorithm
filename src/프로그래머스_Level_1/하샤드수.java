package ���α׷��ӽ�_Level_1;
/*
 * ���� ���� x�� �ϻ��� ���̷��� x�� �ڸ����� ������ x�� ���������� �Ѵ�
 * ���� ��� 18�� �ڸ��� ���� 1+8 = 9�� ������ �������Ƿ� 18�� �ϻ��� ��
 * �ڿ��� x�� �Է¹޾� x�� �ϻ��� ������ �ƴ��� �˻��ϴ� �Լ�, solution
 * 
 */
public class �ϻ���� {
	public boolean solution(int x) {
		boolean answer = true;
		int sum = 0 ;
		int a = x;
		
		while(a>=1) {
			sum += a%10;
			a /= 10;
		}
		
		if(x%sum==0) {
			return true;
		}
		else 
			return false;
		}
}
