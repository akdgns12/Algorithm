package 매일코딩;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	static class Printer{
		int location;
		int prior;
		Printer(int location, int prior){
			this.location = location;
			this.prior = prior;
		}
	}
	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Printer> q = new LinkedList<>();
		
		for(int i=0; i<priorities.length; i++) {
			q.offer(new Printer(i, priorities[i]));
		}
		
		while(!q.isEmpty()) {
			boolean flag = false;
			
			int now = q.peek().prior;
			
			for(Printer p : q) {
				if(now < p.prior) {
					flag = true;
				}
			}
			
			if(flag) {
				q.offer(p.poll());
			}else {
				if(q.poll().location == location) {
					answer = priorities.length - q.size();
				}
			}
		}
		return answer;
	}
}
