package �����ڵ�;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ���α׷��ӽ�_���߿켱����ť {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		// �ּ��� - ��������
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// �ִ��� - ��������
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(String op : operations) {
			StringTokenizer st = new StringTokenizer(op);
			String judge = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			
			// �� ť�� �����͸� ���� ��û ��� ���� ����
			if(pq.size() < 1 && judge.equals("D"))
				continue;
			
			// ���� �� �ּ� ��, �ִ� ���� value �ֱ�
			if(judge.equals("I")) {
				pq.offer(value);
				maxPq.offer(value);
			}
			
			// ������ ���� D�̸鼭 value ���� 1���� -1�� �̹Ƿ�
			if(value < 0) {
				int min = pq.poll();
				maxPq.remove(min);
			}
			
			// �ִ� ������ poll�� �ּ������� �ش� ���� ����
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
