package ��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft {
	// ���� 1005 ACM_Craft / �� 3 / �������İ�����?
	/*
	 * a->b ������ �ִµ� b->a�� �������� �ʴ� 
	 * ������ ������ ����Ŭ�� ���� �׷���(DAG) -> ��������
	 */
	// �Ϲ����� �������İ� �ٸ��� .. ����� ������ �ƴ϶� �ҿ�ð��� ����ؾ� �Ѵ�
	// result �迭�� ����� �� �ҿ�ð� �����ص���
	/*
	 * 1. ó�� indegree�� 0�� �ǹ����� ���� ��ũ�� ���� ������ �� �ҿ�ð��� d[i]
	 * 2. Queue���� �ǹ��� ���鼭 �ش� �Ŵ����� ����� �ٸ� �ǹ����� result�� �������ش�
	 * 3. ���������� �ҿ�ð� result[node] + ���� �ǹ��� �ҿ�ð� d[i]�� �̷������
	 * ���� ��ũ�� ���� �ö󰡾� ���� �ǹ��� ���� �� �ֱ� ������ ���� ���� �ɸ��� �ð����� �������ش�.(Math.max)���
	 */
	static int N, K; // ��� ����, ���� ����
	static int[] d;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽�
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			d = new int[N+1];
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<N+1; i++)
				list.add(new ArrayList<Integer>());
			
			int[] indegree = new int[N+1]; // �ش� ��带 ����Ű�� ������ ���� ��� ���� �迭
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				d[i] = Integer.parseInt(st.nextToken()); // �� �ǹ��� �Ǽ��ð�
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				// a -> b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				indegree[b]++; // b�� ����Ű�� �������� ����
			}
		
			int W = Integer.parseInt(br.readLine());
			
			topologicalSort(indegree, list, W);
		} // end of TC
		
		
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> list, int W) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] result = new int[N+1];
		
		// �ǹ����� �⺻ �ð��� d[i]
		for(int i=1; i<=N; i++) {
			result[i] = d[i];
			
			if(indegree[i] == 0) { // ���������� 0�� ������ ť�� ����
				q.offer(i);
			}
		}
		
		// �ǹ��� �� �ҿ�ð� = ���������� �ҿ�ð� + ���� �ǹ� �ҿ�ð�
		// Max ���ִ� ������ ���� ��ũ�� �� �ö�� ���� �ǹ��� ���� �� �ֱ� ����
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Integer i : list.get(node)) {
				result[i] = Math.max(result[i], result[node] + d[i]);
				indegree[i]--;
				
				if(indegree[i] == 0)
					q.offer(i);
			}
		}
		
		System.out.println(result[W]);
	}
}
