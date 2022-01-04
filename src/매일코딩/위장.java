package 매일코딩;

public class 위장 {
	import java.util.*;
	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 0;
	         // 조합 = 옷의 개수 C 종류 - 1?
		        // 옷의 종류 , 이름?
		        HashMap<String, Integer> map = new HashMap<>();
		        
		        for(int i=0; i<clothes.length; i++) {
		        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		        }
		        
		        // key값들의 합 * value값들의 합 -1?
		        int tmp = 0;
		        for(String key : map.keySet()) {
		        	tmp += map.get(key);
		        }
		        
		         answer = map.size()*tmp -1; 
	        return answer;
	    }
	}
}
