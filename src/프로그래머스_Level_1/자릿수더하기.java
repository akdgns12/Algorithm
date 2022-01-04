package 프로그래머스_Level_1;
/*
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return하는 solution 함수
 * 만들어가.
 * 예를 들어 N = 123이면 1+2+3 = 6을 return
 */
public class 자릿수더하기 {
	public int solution(int n) {
		int answer = 0;
		
		while(n != 0) {
			answer += n%10;
			n = n/10;
		}
		return answer;
	}
}
