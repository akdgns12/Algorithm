package ���α׷��ӽ�_Level_1;
/*
 * ���̰� ���� �� 1���� ���� �迭 a,b�� �Ű������� �־�����
 * a�� b�� ������ return�ϵ��� solution
 * �̶�, a��b�� ������ a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
 *n�� a,b�� ����
 */
public class ���� {
	public int solution(int[] a, int[] b) {
		int answer = 1234567890;
		int temp = 0;
		for(int i=0; i<a.length; i++) {
			 temp += a[i]*b[i]; 
		}
		
		
		return answer = temp;
	}
}
