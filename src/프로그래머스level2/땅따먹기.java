package ���α׷��ӽ�level2;
/*
 * �� ��° ����� ���� ���� ���� ���� ���ϸ鼭
 * MAX�� �־��ִ� ���
 * �� ������ ��� ����ϸ� ������ �ʱ�ȭ���� ���� �� �־� ����Ǫ�µ�
 * �ָ��� �� ������, ������ �ٸ� ���� �����صΰ� ��� �ʱ�ȭ ��Ű������ 
 * ������ �ʿ䰡 �ִ�.
 */

public class �����Ա� {
	int solution(int[][] land) {
		int answer = 0;
		
		for(int i=1;i<land.length; i++) { //��
			for(int j=0; j<=3; j++) { //��
				
				int a = land[i][j];
				
				for(int k=0; k<=3; k++) {
					if(j==k)
						continue;		
					else
						land[i][j] = Math.max(land[i][j], a + land[i-1][k]);
				}//for - k
			}//for - j - 4���� ���ڵ��� �ڱ��ڽ��� ���� �� 3���� ���ؼ� max ã��
		}//for -i
		
		for(int i=0; i<4; i++)
			answer = Math.max(answer, land[land.length-1][i]);
		
		return answer;
	}	
}
