package 매일코딩;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_다리를지나는트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;
        
        for(int i=0; i<truck_weights.length; i++) {
        	int truck = truck_weights[i];
        	while(true) {
        		// 큐에 아무것도 없는 경우 = 어떠한 트럭도 다리위에 없
        		if(q.isEmpty()) {
        			q.offer(truck);
        			sum += truck;
        			time++; // 다리에 오를때만 시간 추가
        			break;
        		}else if(q.size() == bridge_length) { // 큐에 다리길이만큼 트럭이 다찬 경우
        			sum -= q.poll();
        		}else { // 다리 길이만큼 큐가 차지않음
        			// weight 값을 넘지 않는 선에서 트럭을 다리에 올려줌
        			if(sum + truck <= weight) {
        				q.offer(truck);
        				sum += truck;
        				time++;
        				break;
        			}else {
        				// 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듦
        				q.offer(0);
        				time++;
        			}
        		}
        	}
        }
         // 마지막 트럭에서 반복문이 끝나므로, 마지막 역시 다리 길이만큼 지나가야하기 때문에 + 다리길이
        
        return time + bridge_length;
    }
}
