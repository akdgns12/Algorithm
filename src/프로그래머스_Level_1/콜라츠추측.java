package ���α׷��ӽ�_Level_1;
/*
 * �־��� ���� 1�� �� ������ ���� �۾��� �ݺ��ϸ�,
 * ��� ���� 1�� ���� �� �ִٴ� ����
 * 1-1. �Էµ� ���� ¦����� 2�� �����ϴ�. 
	1-2. �Էµ� ���� Ȧ����� 3�� ���ϰ� 1�� ���մϴ�.
	2. ����� ���� ���� ���� �۾��� 1�� �� ������ �ݺ��մϴ�.
 */
public class �ݶ������� {
	public int solution(long num) {
		int answer = 0;
	
		while(num != 1) {
			if(num % 2==0) {
				num = num/2;
			}else {
				num = num*3 + 1;
			}
			answer++;
			if(answer == 500) {
				answer = -1; 
				break;
			}
		}
		
		
		return answer;
	}
}
