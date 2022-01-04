package 해시;

import java.util.HashMap;

public class 카카오블라인드_숫자문자열과영단어 {
	public int solution(String s) {
		String answer = "";
		// 영단어, 숫자
		HashMap<String, Integer> map = new HashMap<>(); 
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		
		String str = "";
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 0 && c <= 9) {
				answer += c;
			}else {
				str += c;
				
				if(map.containsKey(str)) {
					answer += map.get(str);
					str = "";
				}
			}
		}
		
		return Integer.parseInt(answer);
	}
}
