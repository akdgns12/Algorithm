package 해시;
import java.util.*;

public class 전화번호목록 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i<phone_book.length; i++) {
			map.put(phone_book[i], "prefix");
		}
		
		for(String phone : phone_book) {
			for(int idx=0; idx<phone.length(); idx++) {
			if(map.containsKey(phone.substring(0, idx))) {
				answer = false;
			}
			}
		}
		
		
		
		
		
		return answer;
	}
}

//	for(int i=0; i<phone_book.length; i++) {
//		for(int j=0; j<phone_book.length; j++) {
//			if(i==j) continue;
//			if(phone_book[i].length() > phone_book[j].length())continue;
//			if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i])));
//			return false;
//		}
//	}
