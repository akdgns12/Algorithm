package 프로그래머스_Level_1;

import java.util.ArrayList;

/*
 * 대문자와 소문자가 섞여이는 문자열 s가 주어진다
 * s에 p의 개수와 y의 개수를 비교해 같으면 True, 다르면 False return
 * p,y 모두 하나도 없는 경우는 항상 True
 * 단, 개수를 비교할 때 대소문자 구별 x
 */
public class 문자열내p와y의개수 {
	boolean solution(String s) {
		boolean answer = true;
		int cnt = 0;
		char ch = ' ';
		
		for(int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			if(ch == 'p' || ch == 'P')
				cnt++;
			else if(ch == 'y' || ch == 'Y')
				cnt--;
		}
		if(cnt !=0 )
			return false;
		return true;
	}
}
