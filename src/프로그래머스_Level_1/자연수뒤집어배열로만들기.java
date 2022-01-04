package 프로그래머스_Level_1;
/*
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 return
 * 예를 들어 n이 12345이면 [5,4,3,2,1]dmf return
 */
public class 자연수뒤집어배열로만들기 {
	public int[] solution(long n) {
		String a = "" + n;
		int[] answer = new int[a.length()];
		int cnt = 0;
		while(n !=0 ) {
			answer[cnt]= (int)(n%10);
			n /= 10;
			cnt++;
		}
		return answer;
	}
}
