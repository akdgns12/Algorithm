package �����ڵ�;

import java.util.ArrayList;
import java.util.Collections;

public class ���α׷��ӽ�_k��°�� {
	 public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        ArrayList<Integer> list = new ArrayList<>();
	        
	        for(int i=0; i<commands.length; i++) {
	        	list.clear();
	        	int start = commands[i][0] - 1;
	        	int end = commands[i][1] - 1;
	        	int k = commands[i][2] - 1;
	        	
	        	for(int j=start; j<=end; j++) {
	        		list.add(array[j]);
	        	}
	        	Collections.sort(list);
	        	answer[i] = list.get(k);
	        }
	        
	        return answer;
	    }
}
