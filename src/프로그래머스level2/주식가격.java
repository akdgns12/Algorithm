package 프로그래머스level2;

import java.util.ArrayList;

/*
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 떄, 가격이
 * 떨어지지 않은 기간은 몇초인지를 return 하도록 solution 작성
 */
public class 주식가격 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		
		
		for(int i=0; i<prices.length; i++) {
			int time = 0;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i] <= prices[j]) {
					time++;
				}
				else {
					time++;
					break;
				}
			}
			answer[i] = time;
		
		}
	
		return answer;
	}
}
