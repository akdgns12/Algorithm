package 프로그래머스_Level_1;
/*
 * 정수 num이 짝수일 경우 "Even"을 반환하고
 * 홀수인 경우 "Odd"을 반환하는 함수
 * solution
 * 
 */
public class 짝수와홀수 {
		public String solution(int num) {
			String answer = "";
			
			if(num % 2 == 0) {
				answer = "Even";
			}else 
				answer = "Odd";
			
			return answer;
		}
}
