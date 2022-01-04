package ���α׷��ӽ�_Level_1;

import java.util.ArrayList;

/*
 * �� ���� �Է¹޾� �� ���� �ִ������� �ּҰ������ return �ϴ� �Լ�, solution
 * �� �ϼ��϶�.
 * �迭�� �� �տ� �ִ�����, �״��� �ּҰ������ �־� return�ϸ� �ȴ�.
 * ���� ��� �� �� 3, 12�� �ִ������� 3, �ּ� ������� 12�̹Ƿ� 
 * solution(3,12)�� [3,12]�� return
 */
/*
 * ��ȯ ���� ���̴� 2�� �����̹Ƿ� answer�迭�� ���̴� 2�� ����
 * 2. n>m �϶��� �ݴ��� ���� ������ ������ ����
 * 3. n��m �� i�� ������ �� �������� 0�̸� �� ���� �ִ������� �ȴ�(i�� �������� �� ������
 * for������ ���� ū i�� ��ȯ�ȴ�)
 * �� �� answer[0] = i(�ִ�����)�� �ְ� answer[1] = (m*n)/i
 * (m*n)/i �ּҰ���� ���ϴ� ����
 */
public class �ִ��������ּҰ���� {
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		if(n<m) {
			for(int i=1; i<m; i++) {
				if(n%i==0 && m%i==0) {
					answer[0] = i;
					answer[1] = (m*n) /i;
				}
			}
		}else {
			for(int i=1; i<n; i++) {
				if(n%i == 0 && m %i ==0) {
					answer[0]=i;
					answer[1]= (m*n)/i;
				}
			}
		}
		
		return answer;
	}
}
/*
 * ��Ŭ���� ȣ����
 * int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = n * m / answer[0]; //�μ��� ���� �ִ������� �����ָ� = �ּҰ����
		return answer;
	}
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
 */
*/