package 프로그래머스_Level_1;
/*
 * 길이가 같은 두 1차원 정수 배열 a,b가 매개변수로 주어진다
 * a와 b의 내적을 return하도록 solution
 * 이때, a와b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
 *n은 a,b의 길이
 */
public class 내적 {
	public int solution(int[] a, int[] b) {
		int answer = 1234567890;
		int temp = 0;
		for(int i=0; i<a.length; i++) {
			 temp += a[i]*b[i]; 
		}
		
		
		return answer = temp;
	}
}
