package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_�������� {
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ����� ����(��� ��)
		M = Integer.parseInt(st.nextToken()); // ������ ����
		
		int[] indegree = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// �׷��� �ʱ�ȭ
		for(int i=0; i<N+1; i++	) {
			graph.add(new ArrayList<Integer>());
		}
		
		// ���� �׷����� ��� ���� ���� �Է¹ޱ�
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b); // ���� a���� b�� �̵�����
			//��������(������ �������Ƿ�) 1����
			indegree[b]++;
		}
		
		topologicalSort(indegree, graph);
	}

	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>(); // ������ ������ 0�� ��尡 �� ť
		Queue<Integer> result = new LinkedList<>(); // ������ ���� ����� �� ť
		
		// indegree�� 0�� ��� Queue�� �ֱ�
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0)
				q.offer(i);
		}
		
		
		// q���� ��带 �ϳ��� ���� ����� ����� indegree ����
		// indegree�� 0�� �� ���� Queue�� �ֱ�
		while(!q.isEmpty()) {
			int node = q.poll();
			result.offer(node);
			
			for(int i : graph.get(node)) {
				indegree[i]--;
				
				if(indegree[i] == 0)
					q.offer(i);
			}
		}
		
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
	}
}
