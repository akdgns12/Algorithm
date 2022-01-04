package 프로그래머스_Level_1;
/*
 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 한다
 * 예를 들어 18의 자릿수 합은 1+8 = 9로 나누어 떨어지므로 18은 하샤드 수
 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution
 * 
 */
public class 하샤드수 {
	public boolean solution(int x) {
		boolean answer = true;
		int sum = 0 ;
		int a = x;
		
		while(a>=1) {
			sum += a%10;
			a /= 10;
		}
		
		if(x%sum==0) {
			return true;
		}
		else 
			return false;
		}
}
