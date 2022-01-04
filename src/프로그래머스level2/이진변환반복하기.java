package 프로그래머스level2;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 1. s에 있는 0 모두 제거
 * 2. s.length를 이진법 표기
 * s가 1이 될 때까지 반복
 * 사라진 0개수와 이진변환 횟수  
 */

public class 이진변환반복하기 {
	public int[] solution(String s) {
		int[] answer = {};
		answer = new int[2];
		
		int count = 0; //이진 변환 횟수
		int count_zero = 0; //사라진 0 카운트 
		
		while(!s.equals("1")) { // s가 1이랑 같지않으면 반복문 진행, s==1이 될 때까지 반복
			int count_one = 0;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '1') {
					count_one++;
				}else {
					count_zero++;
				}
			}
			s = Integer.toBinaryString(count_one);
			count++;
		}
		answer[0] = count;
		answer[1] = count_zero;
		return answer;
	}
}
