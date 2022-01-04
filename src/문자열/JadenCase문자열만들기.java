package 문자열;

public class JadenCase문자열만들기 {
	public int solution(int[] arr) {
		int answer = lcm(arr[0], arr[1]);
		
		for(int i=2; i<arr.length; i++) {
			answer =  lcm(answer,arr[i]);
		}
		
		return answer;
	}
	
	public int gcd(int a, int b	) {
		while(b != 0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public int lcm ( int a, int b) {
		return (int) a*b / gcd(a,b);
	}
}
