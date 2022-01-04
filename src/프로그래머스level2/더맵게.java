package 프로그래머스level2;

import java.util.PriorityQueue;

/*
 * leo는 모든 음식의 스코빌 지수를 k이상으로 만들고 싶어한다.
 * 스코빌 지수가 가장 낮은 두 개의 음식을 섞어서 새로운 음식을 만든다.
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 +(두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * 모든 음식의 스코빌 지수가 k 이상이 될 때까지 반복하여 섞는다.
 * 음식의 스코빌 지수를 담은 배열 scoville, 원하는 스코빌 지수 k
 * 모든 음식의 스코빌 지수를 k이상으로 만들기 위해 섞어야 하는 최소 횟수 return
 */
//가장 작은 값을 두개 뽑아야 하니 우선순위 큐를 사용하면 되겠다.
public class 더맵게 {
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
