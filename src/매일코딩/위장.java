package �����ڵ�;

public class ���� {
	import java.util.*;
	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 0;
	         // ���� = ���� ���� C ���� - 1?
		        // ���� ���� , �̸�?
		        HashMap<String, Integer> map = new HashMap<>();
		        
		        for(int i=0; i<clothes.length; i++) {
		        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		        }
		        
		        // key������ �� * value������ �� -1?
		        int tmp = 0;
		        for(String key : map.keySet()) {
		        	tmp += map.get(key);
		        }
		        
		         answer = map.size()*tmp -1; 
	        return answer;
	    }
	}
}
