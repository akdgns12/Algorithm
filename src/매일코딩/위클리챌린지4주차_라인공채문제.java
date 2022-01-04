package 매일코딩;

import java.util.Arrays;

public class 위클리챌린지4주차_라인공채문제 {

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
				int idx = Arrays.asList(t).indexOf(languages[i]); // asList : 배열을 list처럼 사용 but 원소를 새롭게 추가할 수 없음
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
