package ���α׷��ӽ�_Level_1;
/*
 * ���ڿ� s�� �� �� �̻��� �ܾ�� �����Ǿ� �ֽ��ϴ�. �� �ܾ�� �ϳ��̻���
 * ���鹮�ڷ� ���еǾ� �ִ�.
 * �� �ܾ��� ¦����° ���ĺ��� �빮�ڷ�, Ȧ����° ���ĺ��� �ҹ��ڷ� �ٲ� ���ڿ���
 * return�ϴ� �Լ�, solution
 * 
 */
// ���ڿ��� �ε��� ������ �ƴ϶� �ܾ��� ������ �������� ¦/Ȧ�� �����ϴ� �� ����
public class �̻��ѹ��ڸ���� {
	public String solution(String s) {
		String answer = "";
		String[] str = s.split("");
		int cnt = 0;
		
		for(int i=0; i< str.length; i++) {
			if(str[i].equals(" ")) {
				cnt = 0;
			}else {
				if(cnt % 2 == 0) {
					str[i] = str[i].toUpperCase();
					cnt++;
				}else {
					str[i] = str[i].toLowerCase();
					cnt++;
				}
			}
			answer += str[i];
		}
		return answer;
	}
}
