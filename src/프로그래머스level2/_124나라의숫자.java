package 프로그래머스level2;

public class _124나라의숫자 {
	public String solution(int n) {
		String answer = "";
		String[] str = { "4", "1", "2"};
		
		while(n>0) {
			// 1.나눈 나머지에 따라 해당값을 문자열에 연결
			
			answer = str[n%3] + answer;
			//2. 3의 배수인 경우는 (n-1)/3 , 아닌 경우는 그냥 n/3
			n = n%3 == 0 ? (n-1)/3 : n/3;
		}
		
		
		
		return answer;
	}
}
