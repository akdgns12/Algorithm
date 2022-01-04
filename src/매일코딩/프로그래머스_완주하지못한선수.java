package 매일코딩;

import java.util.HashMap;

public class 프로그래머스_완주하지못한선수 {
	 public String solution(String[] participant, String[] completion) {
	        String answer = "";
	       HashMap<String, Integer> map = new HashMap<>();
	       for(String player : participant) {
	    	   map.put(player, map.getOrDefault(player, 0) + 1);
	       }
	        return answer;
	    }
}
