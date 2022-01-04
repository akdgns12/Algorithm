package ���α׷��ӽ�level2;

import java.util.ArrayList;
import java.util.Stack;

/*
 * ��ɰ��� �۾�.
 * �� ����� ������ 100%�� �� ���񽺿� �ݿ�����
 * ��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ���
 * ���� ���ߵ� �� �ְ�, �� �� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� ����.
 * ���� �����Ǿ�� �ϴ� ������ �۾��� ������ ���� �����迭 progresses�� �� �۾���
 * ���� �ӵ��� ���� �����迭 speeds�� �־��� ��, �� �������� �� ���� ����� �����Ǵ�����
 * return �ϴ� �Լ� solution
 */
//�տ��ִ� progresses�� �Ϸ�Ǿ�� ���� ����
// 1. �־��� �迭�� �̿� �� ������ �۾��� �Ϸ�Ǵ� �ð��� stack���� ����� ����
// 2. stack �� ��(���� ó���ؾ��ϴ� �۾�)�� pop���� �����Ͽ� top�� �����ϰ�
// �������� ���� stack.peek() ���� �ش� ������ �۴ٸ� �̹� �۾��� �����ٴ� �ǹ�
// �̹Ƿ� ī����. 3. ī������ ������ s��� list�� ���ʴ�� �����ϵ� ���� �迭�� ��ȯ
public class ��ɰ��� {
	public int[] solution(int[] progresses, int[] speeds) {
		Stack<Integer> stack = new Stack<Integer>();
		
		//������ �۾��� �Ϸ�Ǵ� �ð��� stack�� ����
		for(int i= progresses.length - 1; i >=0; i--) 
			stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0)); 
		
		ArrayList<Integer> s = new ArrayList<>();
		
		while(!stack.isEmpty()) { // ���� ù �۾��� pop�ؼ� top�� �����ϰ� ���� �۾��� top���� �۴ٸ� ���� �۾��� �̹� ���� ���� 
			int cnt = 1;          // �׷��Ƿ� cnt++ ���ְ� �����۾��� pop���ش�.
			
			int top = stack.pop();
			
			while(!stack.isEmpty() && stack.peek() <= top) {
				cnt++;
				stack.pop();
			}
			
			s.add(cnt);
		}
		
		int[] answer = new int[s.size()];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = s.get(i);
		}
		
		return answer;
	}
}
