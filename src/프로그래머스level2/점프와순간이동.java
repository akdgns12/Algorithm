package ���α׷��ӽ�level2;
/*
 * ���� 
 * �����̵� = ������� �̵��Ÿ� *2
 * ������ �� ���͸� ��뷮 �Ÿ��� ����� �þ
 * �����̵��� �� ���͸� ���ȵ�
 * ������ ��뷮 �������� ��� return
 * 
 */
// top_down����� �����ϸ� �ݹ� Ǯ��
public class �����ͼ����̵� {
	public int solution(int n) {
		int answer = 0;
		
		//1.n�� �� �ɶ�����
		//2. n�� Ȧ���� ���� ¦���� ��
		while(n !=0) {
			if(n%2 == 0) {
				n /= 2;
			}else {
				n--;
				answer++;
			}
		}
		
		
		
		return answer;
	}
}
