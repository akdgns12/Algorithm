package 매일코딩;

public class 복습_기능개발 {
	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        Queue<Integer> q = new LinkedList<>();
	        ArrayList<Integer> result = new ArrayList<>();
	        
	        for(int i=0; i<progresses.length; i++){
	            int day = (100 - progresses[i]) / speeds[i];
	            if((100 - progresses[i]) % speeds[i] != 0) day++;    
	            
	            q.add(day);
	        }
	        
	        int prev = q.poll();
	        int count = 1;
	        while(!q.isEmpty()){
	            int now = q.poll();
	            if(prev >= now){
	                count++;
	        }else{
	            result.add(count);
	            count = 1;
	            prev = now;
	        }
	        }
	            
	        result.add(count);
	        int[] answer = new int[result.size()];
	        for(int i=0; i<result.size(); i++){
	            answer[i] = result.get(i);
	        }
	            
	        return answer;
	    
	    }
	}
}
