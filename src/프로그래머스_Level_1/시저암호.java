package 프로그래머스_Level_1;
/*
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화
 * 방식을 시저 암호라 한다.
 * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 된다.
 * "z"는 1만큼 밀면 "a"가 된다.
 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수
 * solution
 * 
 */
public class 시저암호 {
	public String solution(String s, int n) {
		String answer = "";
		
		for(int i=0; i<s.length(); i++) {
			char alpha = s.charAt(i);
			
			if(alpha >= 'a' && alpha <= 'z') {
				if(alpha +n > 'z')
					answer += (char)(alpha + n -26);
				else answer += (char)(alpha + n);
			}
			else if(alpha >= 'A' && alpha <= 'Z') {
				if(alpha + n > 'Z')
					answer += (char)(alpha + n - 26);
				else answer += (char)(alpha + n);
			}
			//공백일 때도 붙여줘야 하기 때문에
			else answer += (char)alpha;
		}
		return answer;
	}
}
