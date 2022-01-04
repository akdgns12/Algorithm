package 매일코딩;

import java.util.PriorityQueue;

public class 프로그래머스_더맵게 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌지수 + (두 번째로 맶지 않은 음식의 스코빌 지수*2)
        // 모든 음식의 스코빌 지수가 K이상이 될때까지 두가지 음식을 반복하여 섞는다.
        // 기본으로 설정하면(우선순위가 낮은 숫자 순)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // (우선순위가 높은 숫자 순)
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int aScoville : scoville) {
        	pq.offer(aScoville);
        }
        
        while(pq.peek() <= K) {
        	if(pq.size() == 1) {
        		return - 1;
        	}
        	int a = pq.poll();
        	int b = pq.poll();
        	
        	int result = a + (b * 2);
        	pq.offer(result);
        	answer++;
        }
        return answer;
	}
}
