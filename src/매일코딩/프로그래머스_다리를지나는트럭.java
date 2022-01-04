package �����ڵ�;

import java.util.LinkedList;
import java.util.Queue;

public class ���α׷��ӽ�_�ٸ���������Ʈ�� {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;
        
        for(int i=0; i<truck_weights.length; i++) {
        	int truck = truck_weights[i];
        	while(true) {
        		// ť�� �ƹ��͵� ���� ��� = ��� Ʈ���� �ٸ����� ��
        		if(q.isEmpty()) {
        			q.offer(truck);
        			sum += truck;
        			time++; // �ٸ��� �������� �ð� �߰�
        			break;
        		}else if(q.size() == bridge_length) { // ť�� �ٸ����̸�ŭ Ʈ���� ���� ���
        			sum -= q.poll();
        		}else { // �ٸ� ���̸�ŭ ť�� ��������
        			// weight ���� ���� �ʴ� ������ Ʈ���� �ٸ��� �÷���
        			if(sum + truck <= weight) {
        				q.offer(truck);
        				sum += truck;
        				time++;
        				break;
        			}else {
        				// �Ѵ´ٸ� 0�� �־� �̹� ť�� �ִ� Ʈ���� �ٸ��� �ǳʰ� ����
        				q.offer(0);
        				time++;
        			}
        		}
        	}
        }
         // ������ Ʈ������ �ݺ����� �����Ƿ�, ������ ���� �ٸ� ���̸�ŭ ���������ϱ� ������ + �ٸ�����
        
        return time + bridge_length;
    }
}
