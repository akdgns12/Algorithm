package 프로그래머스_Level_1;

import java.util.ArrayList;

/*
 * 1번 수포자 규칙 1~5 순 반복
 * 2번 수포자 규칙 
 */
public class 모의고사 {
	public int[] solution(int[] answers) {
		int[] answer = {};
		
		int[] person1 = {1,2,3,4,5};
		int[] person2 = {2,1,2,3,2,4,2,5};
		int[] person3 = {3,3,1,1,2,2,4,4,5,5};
		int answer1 = 0, answer2 = 0, answer3 =0;
		
		for(int i=0; i<answer.length; i++) {
			if(answers[i] == person1[i%5]) {
				answer1++;
			}
			if(answers[i] == person2[i%8]) {
				answer2++;
			}
			if(answers[i] == person3[i%10]) {
				answer3++;
			}
		}
		
		int max = Math.max(Math.max(answer1, answer2), answer3);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if(max == answer1) list.add(1);
		if(max == answer2) list.add(2);
		if(max == answer3) list.add(3);
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
