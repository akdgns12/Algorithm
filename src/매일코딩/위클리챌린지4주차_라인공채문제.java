package �����ڵ�;

import java.util.Arrays;

public class ��Ŭ��ç����4����_���ΰ�ä���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
		int score = -1;
		for(String str : table) {
			String[] t = str.split(" ");
			String tname = t[0];
			int tscore = 0;
			for(int i=0; i<languages.length; i++) {
				int idx = Arrays.asList(t).indexOf(languages[i]); // asList : �迭�� listó�� ��� but ���Ҹ� ���Ӱ� �߰��� �� ����
				if(idx > -1) tscore += preference[i] * (6 - idx);
			}
			if(score == tscore && answer.compareTo(tname) > 0)answer = tname;
			if(score < tscore) {
				score = tscore;
				answer = tname;
			}
		}
		
		return answer;
	}
}
