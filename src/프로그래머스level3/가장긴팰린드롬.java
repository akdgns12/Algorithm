package 프로그래머스level3;

import java.util.*;
//브루트포스
/*
 *  문제를 팰린드롬이 해당 문자열에서 가장 긴 경우
 *  (해당 문자열 그 자체인 경우)부터 가장 짧은 경우까지 하나하나 확인하면서, 
 *  만약 팰린드롬인 경우 해당 길이를 반환하도록 코드를 작성했습니다.
 */
public class 가장긴팰린드롬 {
	public int solution(String s) {
		char[] ch = s.toCharArray();
		
		//가장 긴 문자열부터 팰린드롬 검사
		for(int len=s.length(); len>1; len--) { //len > 1 팰린드롬이라면 2부터이기 때문에
			//시작 인덱스
			for(int start =0; start+len <= s.length(); start++) {
				boolean check = true;
				
				//처음부터 문자열 길이의 빈틈만큼 문자가 같은지 비교
				for(int i=0; i<len/2; i++) {
					if(ch[start + i] != ch[start + len - i -1]) {
						check = false;
						break;
					}
				}
				
				if(check) return len;
			}
		}
		return 1;
	}
}
