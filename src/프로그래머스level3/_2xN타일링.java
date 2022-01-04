package 프로그래머스level3;

public class _2xN타일링 {
	public int solution(int n) {
		int answer = 1;
		//dp문제
		
		int a = 1;
		int b = 1;
		
		for(int i=1; i<n; i++) {
			int c = (a + b) % 1000000007;
			
			a = b;
			b = c;
		}
		return answer;
	}
}
