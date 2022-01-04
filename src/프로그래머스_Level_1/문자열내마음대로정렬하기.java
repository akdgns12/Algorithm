package 프로그래머스_Level_1;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 문자열로 구성된 리스트 strings, 정수 n이 주어질 때
 * 각 문자열의 n번째 글자를 기준으로 오름차순 정렬
 * ex) strings가 ["sun", bed", "car"]이고 n이 1이면
 * 각 단어의 인덱스 1의 문자 "u","e","a"로 strings를 정렬
 */
public class 문자열내마음대로정렬하기 {
	public String[] soltuion(String[] strings, int n) {
		String[] answer = new String[strings.length];
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<strings.length; i++) {
			list.add(strings[i].charAt(n) + strings[i]);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i).substring(1);
		}
		
		return answer;
	}
}
