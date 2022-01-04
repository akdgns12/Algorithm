package ���α׷��ӽ�level2;

import java.util.PriorityQueue;

/*
 * leo�� ��� ������ ���ں� ������ k�̻����� ����� �;��Ѵ�.
 * ���ں� ������ ���� ���� �� ���� ������ ��� ���ο� ������ �����.
 * ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� +(�� ��°�� ���� ���� ������ ���ں� ���� * 2)
 * ��� ������ ���ں� ������ k �̻��� �� ������ �ݺ��Ͽ� ���´�.
 * ������ ���ں� ������ ���� �迭 scoville, ���ϴ� ���ں� ���� k
 * ��� ������ ���ں� ������ k�̻����� ����� ���� ����� �ϴ� �ּ� Ƚ�� return
 */
//���� ���� ���� �ΰ� �̾ƾ� �ϴ� �켱���� ť�� ����ϸ� �ǰڴ�.
public class ���ʰ� {
	public int solution(int[] scoville, int K) {
		   int answer = 0;
	        PriorityQueue<Integer> heap = new PriorityQueue<>();

	        for (int aScoville : scoville) {
	            heap.offer(aScoville);
	        }

	        while (heap.peek() <= K) {
	            if (heap.size() == 1) {
	                return -1;
	            }
	            int a = heap.poll();
	            int b = heap.poll();


	            int result = a + (b * 2);

	            heap.offer(result);
	            answer ++;
	        }
	        return answer;
	    }
	}
