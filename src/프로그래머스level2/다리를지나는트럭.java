package 프로그래머스level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 한다.
 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 
 * 다리 무게는 weight까지 견딘다
 *//*
public class 다리를지나는트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		
		int max = 0;
		for(int w : truck_weights) {
			while(true) {
				if(q.isEmpty()) { // 큐 = 다리
					q.offer(w);
					max += w;
					answer++; // 시간 1초 늘려준다
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
public class 다리를지나는트럭 {
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
						q.offer(0); // 트럭을 다리에 올리지 말고 의미없는 0올리고 시간증가
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
