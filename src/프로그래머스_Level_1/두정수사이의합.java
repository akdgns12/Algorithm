package 프로그래머스_Level_1;
/*
 * 두 정수 a,b가 주어졌을 때 a와 b사이에 속한 모든 정수의 합을 리턴하는 함수
 * solution
 * ex) a= 3, b=5인 경우, 3+4+5 = 12 리턴
 */
public class 두정수사이의합 {
	public long solution(int a, int b) {
		long answer = 0;
		
		if(a<b) {
			for (int i=a; i<=b; i++) {
				answer +=i;
			}
		}else
			for(int i=b; i<=a; i++) {
				answer +=i;
			}
		return answer;
	}
}
