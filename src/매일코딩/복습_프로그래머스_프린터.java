package 매일코딩;

import java.util.LinkedList;
import java.util.Queue;

import 매일코딩.프로그래머스_프린터.Printer;

public class 복습_프로그래머스_프린터 {
	static class Printer{
		int location;
		int priority;
		
		Printer(int location, int priority){
			tihs.location = location;
			this.priority = priority;
		}
	}
	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Printer> q = new LinkedList<>();
		
		for(int i=0; i<priorities.length; i++) {
			q.add(new Printer(i, priorities[i]));
		}
		
		while(!q.isEmpty()) {
			boolean flag = false;
			int now = q.peek().priority;
			
			for(Printer p : q) {
				if(now < p.priority) { // 맨 앞 수보다 큰 숫자가 있다면
					flag = true;
				}
			}
			
			if(flag) {
				q.offer(q.poll());
			}else { // 현재 맨앞의 숫자가 가장 클 때
				if(q.poll().location == location) {
					answer = priorities.length - q.size();
				}
			}
		}
		 return answer;
	}
}
