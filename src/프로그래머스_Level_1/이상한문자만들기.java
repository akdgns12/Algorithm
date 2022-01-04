package 프로그래머스_Level_1;
/*
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나이상의
 * 공백문자로 구분되어 있다.
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을
 * return하는 함수, solution
 * 
 */
// 문자열의 인덱스 순서가 아니라 단어의 공백을 기준으로 짝/홀을 구분하는 것 주의
public class 이상한문자만들기 {
	public String solution(String s) {
		String answer = "";
		String[] str = s.split("");
		int cnt = 0;
		
		for(int i=0; i< str.length; i++) {
			if(str[i].equals(" ")) {
				cnt = 0;
			}else {
				if(cnt % 2 == 0) {
					str[i] = str[i].toUpperCase();
					cnt++;
				}else {
					str[i] = str[i].toLowerCase();
					cnt++;
				}
			}
			answer += str[i];
		}
		return answer;
	}
}
