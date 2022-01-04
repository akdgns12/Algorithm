package 프로그래머스level2;
/*
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자
 * 주어진 문자열 s 를 JadenCase로 바꾼 문자열을 return하는 solution
 * 
 */
// 문자열에 공백으로 시작하거나 공백이 2개들어오거나 마지막에 공백이 들어오는 경우도
// 생각해야 한다!
public class JadenCase문자열만들기 {
	public String solution(String s) {
		String answer = "";
		// 소문자로 바꾸고 한문자씩 String배열에 담기
		String[] sp = s.toLowerCase().split("");
		boolean flag = true; //다음 문자가 문자열의 맨 앞에 있는 문자인지 판별
		
		for(String ss : sp) {
			answer += flag ? ss.toUpperCase() : ss;
			flag = ss.equals(" ") ? true : false;
		}
		//s를 모두 소문자로 바꾼 뒤 한 문자씩 String배열에 담는다
		// flag로 다음 문자가 문자열의 맨 앞에 있는 문자인지 판별 후,
		// 맞을 경우 대문자로 변경해준다
		// 문자를 한개씩 자르니까 공백도 그대로 들어가기 때문에 따로 공백 처리를
		// 해주지 않아도 된다.
		
		
		
		return answer;
	}
}
