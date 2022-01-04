package 매일코딩;

import java.util.ArrayList;

public class 완탐_프로그래머스_모의고사 {
	 public int[] solution(int[] answers) {
	        int[] answer = {};
	        int[] person1 = {1,2,3,4,5}; // 5개
	        int[] person2 = {2,1,2,3,2,4,2,5}; // 8개
	        int[] person3 = {3,3,1,1,2,2,4,4,5,5}; // 10개
	        int answer1 = 0, answer2 = 0, answer3 = 0;
	        
	        for(int i=0; i<answers.length; i++) {
	        	if(person1[i % 5] == answers[i]) answer1++;
	        	if(person2[i % 8] == answers[i]) answer2++;
	        	if(person3[i % 10] == answers[i]) answer3++;
	        }
	        
	        int max = Math.max(Math.max(answer1, answer2), answer3);
	        ArrayList<Integer> list = new ArrayList<>();
	        if(max == answer1) list.add(1);
	        if(max == answer2) list.add(2);
	        if(max == answer3) list.add(3);
	        
	        answer = new int[list.size()];
	        
	        for(int i=0; i<list.size(); i++) {
	        	answer[i] = list.get(i);
	        }
	        return answer;
	    }
}
