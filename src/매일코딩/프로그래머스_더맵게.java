package �����ڵ�;

import java.util.PriorityQueue;

public class ���α׷��ӽ�_���ʰ� {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        // ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں����� + (�� ��°�� ���� ���� ������ ���ں� ����*2)
        // ��� ������ ���ں� ������ K�̻��� �ɶ����� �ΰ��� ������ �ݺ��Ͽ� ���´�.
        // �⺻���� �����ϸ�(�켱������ ���� ���� ��)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // (�켱������ ���� ���� ��)
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
