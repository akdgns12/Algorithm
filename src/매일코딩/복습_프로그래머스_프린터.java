package �����ڵ�;

import java.util.LinkedList;
import java.util.Queue;

import �����ڵ�.���α׷��ӽ�_������.Printer;

public class ����_���α׷��ӽ�_������ {
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
				if(now < p.priority) { // �� �� ������ ū ���ڰ� �ִٸ�
					flag = true;
				}
			}
			
			if(flag) {
				q.offer(q.poll());
			}else { // ���� �Ǿ��� ���ڰ� ���� Ŭ ��
				if(q.poll().location == location) {
					answer = priorities.length - q.size();
				}
			}
		}
		 return answer;
	}
}
