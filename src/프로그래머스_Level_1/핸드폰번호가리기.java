package 프로그래머스_Level_1;
/*
 * 전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를
 * 제외한 나머지 숫자를 전부 *으로 가린 문자열을 return하는 함수, solution
 * 
 */
public class 핸드폰번호가리기 {
	public String solution(String phone_number) {
		String answer = "";
		for(int i=0; i<phone_number.length(); i++) {
			if(i<phone_number.length()-4) {
				answer += "*";
			}
			else {
				answer += phone_number.charAt(i);
			}
		}
		return answer;
	}
}
