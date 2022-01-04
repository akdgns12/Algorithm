package 매일코딩;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 프로그래머스_이중우선순위큐 {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		// 최소힙 - 오름차순
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// 최대힙 - 내림차순
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(String op : operations) {
			StringTokenizer st = new StringTokenizer(op);
			String judge = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			
			// 빈 큐에 데이터를 삭제 요청 경우 연산 무시
			if(pq.size() < 1 && judge.equals("D"))
				continue;
			
			// 삽입 시 최소 힙, 최대 힙에 value 넣기
			if(judge.equals("I")) {
				pq.offer(value);
				maxPq.offer(value);
			}
			
			// 나머지 경우는 D이면서 value 값이 1인지 -1인 이므로
			if(value < 0) {
				int min = pq.poll();
				maxPq.remove(min);
			}
			
			// 최대 힙에서 poll후 최소힙에서 해당 원소 삭제
			int max = maxPq.poll();
			pq.remove(max);
		}
		
		if(pq.size() > 0) {
			answer[0] = maxPq.poll();
			answer[1] = pq.poll();
		}
		
		return answer;
	}
}
