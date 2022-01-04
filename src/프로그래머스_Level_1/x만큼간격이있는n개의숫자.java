package 프로그래머스_Level_1;
/*
 * 함수 solution은 정수x와 자연수 n을 입력받아, x부터 시작해 x씩 즐가하는
 * 숫자를 n개 지니는 리스트를 return해야함.
 * n은 1000이하인 자연수
 * x는 -10000000이상 10000000이하인 정수
 */
public class x만큼간격이있는n개의숫자 {
	public long[] solution(long x, int n) {
		long[] answer = new long[n];
		
		for(int i=0; i<n; i++) {
			answer[i] = x*(i+1);
		}
		return answer;
	}
}
