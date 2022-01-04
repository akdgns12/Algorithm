package ���α׷��ӽ�level2;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� ������
 * 2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ���
 * ����� ���� �������� �ִ´�
 * 3. �׷��� ������ J�� �μ�
 */
//�켱���� ť ���� 
public class ������ {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		// �켱���� ť�� �׳� ����� �ּڰ� �������� �켱����
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

		for (int i = 0; i < priorities.length; i++) { // printť�� �ε�����ȣ, �켱���� ����
			q.offer(new Printer(i, priorities[i]));
		}

		while (!q.isEmpty()) {

			boolean flag = false;
			int com = q.peek().prior;
			for (Printer p : q) {
				if (com < p.prior) { // �Ǿ��� ������ ū ���ڰ� �����ϸ�
					flag = true;
				}
			}

			if (flag) {
				q.offer(q.poll());
			} else {// ���� �Ǿ��� ���ڰ� ���� Ŭ ��
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
