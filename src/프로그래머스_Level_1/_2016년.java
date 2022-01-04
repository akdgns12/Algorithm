package 프로그래머스_Level_1;
/*
 * 두 수 a,b를 입력받아 2016년 무슨요일인지 리턴하는 함수 solution
 * 요일의 이름은 일요일부터 토요일까지 SUN,MON,TUE,WED,THU,FRI,SAT
 * 2016년은 윤년
 */
// 윤년 = 4년에 한번 씩 2.29까지 있는 해로 366일
public class _2016년 {
	public String solution(int a, int b) {
		String answer = "";
		int total = 0;
		String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int[] m = {31,29,31,30,31,30,31,31,30,31,30,31};
		for(int i=0; i<a-1; i++) {
			total += m[i];
		}
		
		total += b-1;
		answer = day[total%7];
		return answer;
	}
}
