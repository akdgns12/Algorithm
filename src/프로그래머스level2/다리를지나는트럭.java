package ���α׷��ӽ�level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �Ѵ�.
 * Ʈ���� 1�ʿ� 1��ŭ �����̸�, �ٸ� ���̴� bridge_length�̰� 
 * �ٸ� ���Դ� weight���� �ߵ��
 *//*
public class �ٸ���������Ʈ�� {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		
		int max = 0;
		for(int w : truck_weights) {
			while(true) {
				if(q.isEmpty()) { // ť = �ٸ�
					q.offer(w);
					max += w;
					answer++; // �ð� 1�� �÷��ش�
					break;
				}else if(q.size() == bridge_length) {
					max -=q.poll();
				}else {
					if(max + w > weight) {
						q.offer(0);
						answer++;
					}else {
						q.offer(w);
						max += w;
						answer++;
						break;
					}
				}
			}
		}
		
		
		return answer + bridge_length;
	}
}*/
public class �ٸ���������Ʈ�� {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer =0;
		int max = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for(int w : truck_weights) {
			while(true) {
				if(q.isEmpty()) {
					q.offer(w);
					max += w;
					answer++;
					break;
				}else if(q.size() == bridge_length){
					max -= q.poll();
				}else {
					if(max + w > weight) {
						q.offer(0); // Ʈ���� �ٸ��� �ø��� ���� �ǹ̾��� 0�ø��� �ð�����
						answer++;
					}else {
						q.offer(w);
						max += w;
						answer++;
						break;
					}
				}
			}
		}
		
		return answer;
	}
}
