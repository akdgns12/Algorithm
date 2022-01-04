package 프로그래머스_Level_1;
/*
 * 단어 s의 가운데 글자를 반환하는 함수 solution
 * 단어의 길이가 짝수라면 가운데 두글자를 반환
 */
public class 가운데글자가져오기 {
	public String solution(String s	) {
		String answer = "";
		
		//짝수와 홀수인 경우로 나눠서 생각
		if(s.length()%2 == 0) {
			answer = s.substring(s.length()/2 -1 , s.length()/2 +1	);
		}else {
			answer = s.substring(s.length()/2, s.length()/2+1);
		}
		return answer;
	}
}
