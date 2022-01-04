package �����ڵ�;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ���¸����ѷγ����� {
	static class Node{
		int index, num;
		
		public Node(int index, int num) {
			this.index = index;
			this.num = num;
		}
	}
	// ���α׷��ӽ� ��Ŭ�� ç���� 9���� / ���̹� 2020 �Ϲݱ� 2�� ���� �������
	static ArrayList<Node>[] list;
	// 1. �� ��������
	// 2. bfs���鼭 ����� üũ
	
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		// ��尣�� ���質Ÿ�� ��������Ʈ �迭 �ʱ�ȭ
		list = new ArrayList[n+1]; 
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// NodeŬ������ ���� ���� �־���
		for(int i=0; i<n-1; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			list[a].add(new Node(b, i));
			list[b].add(new Node(a, i));
		}
		
		for(int i=0; i<n-1; i++) {
		 // i�� ���� ����
			boolean[] visited = new boolean[n+1];
			Queue<Integer> q = new LinkedList<>();
			q.offer(1);
			visited[1] = true;
			int cnt = 1;
			
			while(!q.isEmpty()) {
				int nowIndex = q.poll();
				
				// ���⼭ ���� �ε����� Node�� �־���� ������� ��
				for(Node nextNode : list[nowIndex]) {
					if(nextNode.num == i || visited[nextNode.index]) {
						continue;
					}
					
					q.offer(nextNode.index);
					visited[nextNode.index]= true;
					cnt++;
				}
			}
			
			answer = Math.min(answer, Math.abs(n - cnt - cnt));
		}

		
		
		return answer;
	}
	
	
}
