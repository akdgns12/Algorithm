package ���α׷��ӽ�_Level_1;
/*
 * �ܾ� s�� ��� ���ڸ� ��ȯ�ϴ� �Լ� solution
 * �ܾ��� ���̰� ¦����� ��� �α��ڸ� ��ȯ
 */
public class ������ڰ������� {
	public String solution(String s	) {
		String answer = "";
		
		//¦���� Ȧ���� ���� ������ ����
		if(s.length()%2 == 0) {
			answer = s.substring(s.length()/2 -1 , s.length()/2 +1	);
		}else {
			answer = s.substring(s.length()/2, s.length()/2+1);
		}
		return answer;
	}
}
