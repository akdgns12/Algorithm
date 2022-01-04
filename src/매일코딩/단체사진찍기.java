package 매일코딩;

import java.util.HashMap;

class Solution {
	static HashMap<Character, Integer> map;
	static int cnt;
	static int[] position; // 카카오  프렌즈가 서는 위치
	static boolean[] visited;
		
    public int solution(int n, String[] data) {
    	int answer = 0;
    	map = new HashMap<>();
    	position = new int[8];
    	visited = new boolean[8];
    	cnt = 0;
    	
    	map.put('A', 0);
    	map.put('C', 1);
    	map.put('F', 2);
    	map.put('J', 3);
    	map.put('M', 4);
    	map.put('N', 5);
    	map.put('R', 6);
    	map.put('T', 7);
    	
    	perm(0, data);
    	
    	answer = cnt;
        return answer;
    }
    
    public static void perm(int idx, String[] data) {
    	if(idx == 8) {
    		if(isOk(data)) {
    			cnt++;
    		}
    	}
    	
    	for(int i=0; i<data.length; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			position[idx] = i;
    			perm(idx+1, data);
    			visited[i] = false;
    		}
    	}
    }
    
    public static boolean isOk(String[] data) {
    	// 조건에 맞는지 검사
    	for(int i=0; i<data.length; i++) {
    		int X = map.get(data[i].charAt(0));
    		int Y = map.get(data[i].charAt(2));
    		char type = data[i].charAt(3);
    		int diff = data[i].charAt(4) - '0';
    		int Xpos = position[X];
    		int Ypos = position[Y];
    		if(type == '=') {
    			if(Math.abs(Xpos - Ypos) - 1 != diff) {
    				return false;
    			}
    		}else if(type == '>') {
    			if(Math.abs(Xpos - Ypos) - 1 <= diff) {
    				return false;
    			}
    		}else if(type == '<') {
    			if(Math.abs(Xpos - Ypos) - 1 >= diff) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}