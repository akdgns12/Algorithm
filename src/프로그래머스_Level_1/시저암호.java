package ���α׷��ӽ�_Level_1;
/*
 * � ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ
 * ����� ���� ��ȣ�� �Ѵ�.
 * ���� ��� "AB"�� 1��ŭ �и� "BC"�� �ǰ�, 3��ŭ �и� "DE"�� �ȴ�.
 * "z"�� 1��ŭ �и� "a"�� �ȴ�.
 * ���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�
 * solution
 * 
 */
public class ������ȣ {
	public String solution(String s, int n) {
		String answer = "";
		
		for(int i=0; i<s.length(); i++) {
			char alpha = s.charAt(i);
			
			if(alpha >= 'a' && alpha <= 'z') {
				if(alpha +n > 'z')
					answer += (char)(alpha + n -26);
				else answer += (char)(alpha + n);
			}
			else if(alpha >= 'A' && alpha <= 'Z') {
				if(alpha + n > 'Z')
					answer += (char)(alpha + n - 26);
				else answer += (char)(alpha + n);
			}
			//������ ���� �ٿ���� �ϱ� ������
			else answer += (char)alpha;
		}
		return answer;
	}
}
