package 프로그래머스level2;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼낸다
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기
 * 목록의 가장 마지막에 넣는다
 * 3. 그렇지 않으면 J를 인쇄
 */
//우선순위 큐 문제 
public class 프린터 {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		// 우선순위 큐는 그냥 만들면 최솟값 기준으로 우선순위
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int priority : priorities) {
			pq.offer(priority);
		}
		
		while(!pq.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(pq.peek() == priorities[i]) {
					pq.poll();
					answer++;
					if(location==i) {
						pq.clear();
						break;
					}
				}
			}
		}
		
		return answer;
	}
}
/*
 * import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
			q.offer(new Printer(i, priorities[i]));
		}

		while (!q.isEmpty()) {

			boolean flag = false;
			int com = q.peek().prior;
			for (Printer p : q) {
				if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
					flag = true;
				}
			}

			if (flag) {
				q.offer(q.poll());
			} else {// 현재 맨앞의 숫자가 가장 클 때
				if (q.poll().location == location) {
					answer = priorities.length - q.size();
				}
			}
		}
        return answer;
    }
    class Printer {
		int location;
		int prior;

		Printer(int location, int prior) {
			this.location = location;
			this.prior = prior;
		}
	}
}
 */
