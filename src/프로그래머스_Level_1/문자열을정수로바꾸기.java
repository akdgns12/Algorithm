package 프로그래머스_Level_1;
/*
 * 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution
 * 제한조건
 * 1. s의 길이는 1이상 5이하
 * 2. s의 맨앞에는 부호(+,-)가 올 수 있다.
 * 3. s는 부호와 숫자로만 이루어져 있다
 * 4. s는 "0"으로 시작하지 않는다.
 */
public class 문자열을정수로바꾸기 {
	public int solution(String s) {
		return Integer.parseInt(s);
	}
}
