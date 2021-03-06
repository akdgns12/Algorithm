package 매일코딩;

import java.util.HashMap;

public class 위클리챌린지_4주차라인공채문제복습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(String[] table, String[] languages, int[] preference) {
		// 개발자의 <언어,선호도> 데이터 삽입
		HashMap<String, Integer> lang_prefer = new HashMap<>();
		for(int i=0; i<languages.length; i++) {
			lang_prefer.put(languages[i], preference[i]);
		}
		
		int max = 0;
		String answer = "";
		
		for(String info : table) {
			String[] jobs = info.split(" "); // jobs = SI JAVA JAVASCRIPT SQL PHYTON C#
			int resultPoint = 0;
			for(int i=1, point=5; i<jobs.length; i++, point--) {
				resultPoint += lang_prefer.getOrDefault(jobs[i], 0) * point;
			}
			
			// 이름 사전순으로 리턴해야함
			if(resultPoint >= max) {
				if(resultPoint > max) {
					max = resultPoint;
					answer = jobs[0];
				}
				else {
					if(answer.compareTo(jobs[0]) < 0)
						continue;
					else
						answer = jobs[0];
				}
			}
		}
		return answer;
	}

}
