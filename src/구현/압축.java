package 구현;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {
	public int[] solution(String msg) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<27; i++) {
			char alpha = (char)(i+1);
			map.put(String.valueOf(alpha), i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<msg.length(); i++) {
			sb.append(msg.charAt(i));
			if(!map.containsKey(sb.toString())) {// 없다면?
				map.put(sb.toString(), map.size()+1); // 사전에 삽입
				result.add(map.get(sb.toString().substring(0, sb.length()-1)));
				sb = new StringBuilder();
				i--;
			}
		}
		
		result.add(map.get(sb.toString()));
		int[] answer = new int[result.size()];
		for(int i=0; i<result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}
}
