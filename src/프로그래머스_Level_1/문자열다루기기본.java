package 프로그래머스_Level_1;
/*
 * 문자열 s의 길이가 4혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수
 * solution 
 * 예를 들어 s가 "a234"이면 False를 return "1234" 이면 True
 */
public class 문자열다루기기본 {
	public boolean solution(String s	) {
		boolean answer = true;
		char ch = ' ';
		int length = s.length();
		if(length != 4 && length != 6) {
			return false;
		}
		for(int i=0; i<length; i++) {
			char c = s.charAt(i);
			if(c < '0' || c > '9') {
				return false;
			}
		}
		return answer;
	}
}
