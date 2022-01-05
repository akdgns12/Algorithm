package 매일코딩;
//
public class 다리를지나는트럭 {
	import java.util.*;

	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        Queue<Integer> q = new LinkedList<>();
	        
	        int time = 0;
	        int sum = 0;
	        
	        for(int i=0; i<truck_weights.length; i++){
	            while(true){
	                if(q.isEmpty()){ // 큐가 비어있을 때
	                    q.offer(truck_weights[i]);
	                    sum += truck_weights[i];
	                    time++;
	                    break;
	                }else if(q.size() == bridge_length){ // 큐가 꽉찼을때(=다리가 꽉찼을때)
	                    sum -=q.poll();
	                }else{
	                    if(sum + truck_weights[i] <= weight){
	                        q.offer(truck_weights[i]);
	                        sum += truck_weights[i];
	                        time++;
	                        break;
	                    }else{ // 제한 무게를 초과한다면
	                        q.offer(0);
	                        time++;
	                        
	                    }
	                }
	            }
	        }
	        return time+bridge_length;
	    }
	}
}
