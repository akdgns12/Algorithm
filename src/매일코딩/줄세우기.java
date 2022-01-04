package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. ���� �������ش� Arraylist�� �̿��Ͽ�
 * 2. indegree�� 0�� ���� ť�� ��� ����ִ´�
 * 3. ť�� �������� 0�� ���� �ϳ��� ���� �� ���� ���� �ٽ� ť�� ���� �ִ´�(�� �� �� ȭ��ǥ ���� indegree�� �ϳ��� ���δ�)
 */
public class �ټ���� {
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ���� ����(��� 
		M = Integer.parseInt(st.nextToken()); // ���� ����
		
		// �ڱ����� �� ������ ����
		int[] indegree = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // ������ ArrayList�� �̿��Ͽ� �ܹ��⼺ �׷����� �������ְ� ����Ŵ�� �޴� ������ indegree[index]�� ������ ������ �������ش�.
																// �׸��� �������� ���ش�.
		// �׷��� �ʱ�ȭ
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		
		// A�� B�տ� �����Ѵٴ� ��(�л� ��ȣ�� 1~N)
		// ���� �׷����� ��� ���� ������ �Է¹ޱ�
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // A�л� ��ȣ
			int b = Integer.parseInt(st.nextToken()); // B�л� ��ȣ
			
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		// �Է³�
		
		
		topologicalSort(indegree, graph);
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>(); // ������ ������ 0�� ������ �� ť
		Queue<Integer> result = new LinkedList<>(); // ������ ���� ����� �� ť
	
		int current;
		while(!q.isEmpty()) {
			current = q.poll();
			result.offer(current);
			
			for(int i : graph.get(current)) {
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
