package �����ڵ�;
//
public class �ٸ���������Ʈ�� {
	import java.util.*;

	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        Queue<Integer> q = new LinkedList<>();
	        
	        int time = 0;
	        int sum = 0;
	        
	        for(int i=0; i<truck_weights.length; i++){
	            while(true){
	                if(q.isEmpty()){ // ť�� ������� ��
	                    q.offer(truck_weights[i]);
	                    sum += truck_weights[i];
	                    time++;
	                    break;
	                }else if(q.size() == bridge_length){ // ť�� ��á����(=�ٸ��� ��á����)
	                    sum -=q.poll();
	                }else{
	                    if(sum + truck_weights[i] <= weight){
	                        q.offer(truck_weights[i]);
	                        sum += truck_weights[i];
	                        time++;
	                        break;
	                    }else{ // ���� ���Ը� �ʰ��Ѵٸ�
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
