package �����ڵ�;

public class ����_���ʰ� {
	import java.util.*;

	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	       Arrays.sort(scoville);
	        PriorityQueue<Integer> heap = new PriorityQueue<>();
	        
	        for(int aScoville : scoville){
	            heap.offer(aScoville);
	        }
	        
	        while(heap.peek() <= K){
	            if(heap.size() == 1){
	                return -1;
	            }
	            
	            int a = heap.poll();
	            int b = heap.poll();
	            
	            int result = a + (b * 2);
	            heap.offer(result);
	            answer++;
	        }
	        return answer;
	    }
	}
}
