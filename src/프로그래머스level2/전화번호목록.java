package 프로그래머스level2;

import java.util.HashMap;

public class 전화번호목록 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		// 전화번호에 주어진 번호 배열 중 길이가 가장 짧은 배열 번호 min값
		// 해당 min을  stack에서 pop시킨 다음 남아있는 원소들이랑비교
		// 비교하는 법 
		
		for( int i =0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book.length; j++) {
				if((i != j) && phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return answer;
	}
}
