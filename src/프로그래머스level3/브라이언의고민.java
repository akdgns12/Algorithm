package ���α׷��ӽ�level3;

public class ����̾��ǰ�� {
	public String solution(String sentence) {
		String answer = "";
		int[] alp = new int[26];
		//���� �յ� ���� ������ϰ� �ܾ������ ������ �ѱ����̿�����.
		//��Ģ�� �°� ��ȯ�� �� ������ invalid ����
		//
		
		for(int i=0; i<sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(c <= 'z' && c >= 'a') {
				alp[c - 'a']++;
			}else if(c == ' ') {
				return answer = "invalid";
			}
		}
		
		//��Ģ 1
		for(int i=0; i<alp.length; i++) {
			char ch = (char)('a' + i);
			if(alp[i] > 0) {
				int s = answer.indexOf(ch);
				int e = answer.lastIndexOf(ch);
				
				if(alp[i] == 1) {
			}
		}
		
		return answer;
	}
}
