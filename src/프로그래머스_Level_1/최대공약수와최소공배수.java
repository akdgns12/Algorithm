package 프로그래머스_Level_1;

import java.util.ArrayList;

/*
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 return 하는 함수, solution
 * 을 완성하라.
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 return하면 된다.
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소 공배수는 12이므로 
 * solution(3,12)는 [3,12]를 return
 */
/*
 * 반환 수의 길이는 2로 고정이므로 answer배열의 길이는 2로 지정
 * 2. n>m 일때와 반대일 때로 나눠서 연산을 진행
 * 3. n과m 을 i로 나눴을 때 나머지가 0이면 그 수는 최대공약수가 된다(i가 여러개일 수 있지만
 * for문으로 제일 큰 i가 반환된다)
 * 이 때 answer[0] = i(최대공약수)를 넣고 answer[1] = (m*n)/i
 * (m*n)/i 최소공배수 구하는 연산
 */
public class 최대공약수와최소공배수 {
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		if(n<m) {
			for(int i=1; i<m; i++) {
				if(n%i==0 && m%i==0) {
					answer[0] = i;
					answer[1] = (m*n) /i;
				}
			}
		}else {
			for(int i=1; i<n; i++) {
				if(n%i == 0 && m %i ==0) {
					answer[0]=i;
					answer[1]= (m*n)/i;
				}
			}
		}
		
		return answer;
	}
}
/*
 * 유클리드 호제법
 * int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = n * m / answer[0]; //두수의 곱을 최대공약수로 나눠주면 = 최소공배수
		return answer;
	}
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
 */
*/