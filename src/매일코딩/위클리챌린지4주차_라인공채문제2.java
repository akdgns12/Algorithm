package 매일코딩;

import java.util.HashMap;
import java.util.StringTokenizer;

public class 위클리챌린지4주차_라인공채문제2 {
	public String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
		// 직업군 HashMap 생성(직업 -> 언어배열), 데이터 삽입
		HashMap<String, String[]> jobs = new HashMap<>();
		
		for(int i=0; i<table.length; i++) {
			StringTokenizer st = new StringTokenizer(table[i]);
			String job = st.nextToken();
			jobs.put(job, new String[5]);
			
			for(int j=0; j<5; j++) {
				jobs.get(job)[j] = st.nextToken();
			}
		}
		
		// 선호도 HashMap 생성(언어 -> 점수), 데이터 삽입
		HashMap<String, Integer> prefer = new HashMap<>();
		
		for(int i=0; i<languages.length; i++) {
			prefer.put(languages[i], preference[i]);
		}
		
		// 최대 점수를 나타내는 변수
		int max = -1;
		
		// 총합이 같을 경우 사전순으로 빠른 직업군을 return하므로, 사전 순 정렬
		String[] list = {"CONTENTS", "GAME", "HARDWARE", "PORTAL", "SI"};
		
		for(int i=0; i<list.length; i++) {
			int tmp = 0;
			
			String[] job_list = jobs.get(list[i]);
			
			for(int j=0; j<job_list.length; j++) {
				if(prefer.containsKey(job_list[j])) {
					tmp += ((5-j) * prefer.get(job_list[j]));
				}
			}
			
			if(tmp > max) {
				max = tmp;
				answer = list[i];
			}
		}
		return answer;
	}
}
