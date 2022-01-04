package 매일코딩;

public class 카펫 {
	import java.util.*;

	class Solution{
	    public int[] solution(int brown, int yellow){
	        int[] answer = new int[2];
	        int area = brown + yellow;
	        
	        for(int i=1; i<=area; i++){
	            int row = i;
	            int col = area/row;
	            
	            if(row > col)
	                continue;
	            
	            if((row-2)*(col-2)==yellow){
	                answer[0] = col;
	                answer[1] = row;
	                return answer;
	            }
	        }
	        
	        return answer;
	    }
	}
}
