package ���α׷��ӽ�_Level_1;
/*
 * ��ȭ��ȣ�� ���ڿ� phone_number�� �־����� ��, ��ȭ��ȣ�� �� 4�ڸ���
 * ������ ������ ���ڸ� ���� *���� ���� ���ڿ��� return�ϴ� �Լ�, solution
 * 
 */
public class �ڵ�����ȣ������ {
	public String solution(String phone_number) {
		String answer = "";
		for(int i=0; i<phone_number.length(); i++) {
			if(i<phone_number.length()-4) {
				answer += "*";
			}
			else {
				answer += phone_number.charAt(i);
			}
		}
		return answer;
	}
}
