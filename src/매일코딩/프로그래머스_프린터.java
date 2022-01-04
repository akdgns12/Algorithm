package �����ڵ�;

import java.util.LinkedList;
import java.util.Queue;

public class ���α׷��ӽ�_������ {
	static class Printer{
		int location;
		int priority;
		
		Printer(int location, int prioirty){
			this.location = location;
			this.priority = priority;
		}
	}
	  public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<Printer> q = new LinkedList<>();
	        
	        for(int i=0; i<priorities.length; i++) {
	        	// printť�� �ε�����ȣ, �켱���� ����
	        	q.add(new Printer(i, priorities[i])); 
	        }
	        
	        while(!q.isEmpty()) {
	        	boolean flag = false;
	        	int com = q.peek().priority;
	        	
	        	for(Printer p : q) {
	        		if(com < p.priority) { // �Ǿ��� ������ ū ���ڰ� �ִٸ�
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
