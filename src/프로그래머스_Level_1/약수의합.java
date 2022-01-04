package 프로그래머스_Level_1;
/*
 * 정수 n을 입력받아 n의 약수를 모두 더한 값을 return하는 함수, solution
 * n은 0이상 3000이하인 정수
 * 
 */
public class 약수의합 {
	public int soltuion(int n) {
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			if(n%i == 0) {
				answer += i;
			}
		}
		return answer;
	}
}
