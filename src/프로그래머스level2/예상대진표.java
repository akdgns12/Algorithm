package ���α׷��ӽ�level2;


public class �������ǥ {
	public int solution(int n, int a, int b) {
		int answer = 1;
		/*
		 * ó���� a�� b�� �� ū���� �����ʿ� ���� ���� ���� ���ʿ� �����۾� ����
		 * �� ���� ���� 1�̸� �ݺ��� Ż������
		 * 
		 */
		//�������� �ش�
		int left = 0;
		int right = 0;
		
		if( a > b) {
			left = b;
			right = a;
		}else {
			left = a;
			right = b;
		}
		
		while(true) {
			if(left % 2 !=0 && right - left == 1) {
				break;
			}
			
			left = (left + 1) / 2;
			right = (right + 1) / 2;
			answer++;
		}
		return answer;
	}
}
/*
 * �� �� ����غ��� �����ϰ� ���� ����
 * int answer = 0;
 * while(a !=b){ // a�� b�� ������ ����
 *  a = (a+1) / 2;
 *  b = (b+1) / 2;
 *  answer++;
 */
*/