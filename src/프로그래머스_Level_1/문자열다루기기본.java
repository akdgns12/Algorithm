package ���α׷��ӽ�_Level_1;
/*
 * ���ڿ� s�� ���̰� 4Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�
 * solution 
 * ���� ��� s�� "a234"�̸� False�� return "1234" �̸� True
 */
public class ���ڿ��ٷ��⺻ {
	public boolean solution(String s	) {
		boolean answer = true;
		char ch = ' ';
		int length = s.length();
		if(length != 4 && length != 6) {
			return false;
		}
		for(int i=0; i<length; i++) {
			char c = s.charAt(i);
			if(c < '0' || c > '9') {
				return false;
			}
		}
		return answer;
	}
}
