package 프로그래머스_Level_1;

import java.util.ArrayList;

/*
 * 자연수 n이 매개변수
 * n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return
 */
public class _3진법뒤집기 {
	public int solution(int n) {
		int answer = 0;
		ArrayList<Integer> temp =new ArrayList<>();
		
		//10진법 -> 3진법(역순)
		while(true) {
			if(n<3) {
				temp.add(n); 
				break;
			}
			temp.add(n%3);
			n = n/3;
		}
		//3진법(역순) -> 10진법
		int x = 1;
		for(int i=temp.size()-1; i>=0; i--) {
			answer += temp.get(i)*x;
			x *= 3;
		}
		
		return answer;
		
	}
}
