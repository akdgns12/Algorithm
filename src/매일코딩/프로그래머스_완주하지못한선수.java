package �����ڵ�;

import java.util.HashMap;

public class ���α׷��ӽ�_�����������Ѽ��� {
	 public String solution(String[] participant, String[] completion) {
	        String answer = "";
	       HashMap<String, Integer> map = new HashMap<>();
	       for(String player : participant) {
	    	   map.put(player, map.getOrDefault(player, 0) + 1);
	       }
	        return answer;
	    }
}
