package �ּҽ��д�Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class �ּҽ��д�Ʈ�� {
	/*
	 * �ּ� ���д� Ʈ��, -> �ּҽ��д�Ʈ��(�ּҽ���Ʈ��)�� = �׷��� ���� ��� ������ �����ϴ� Ʈ������ 
	 * ���� 
	 * 1. �ּҿ��� = ������ ���� ���� ����.
	 * 2. ��� �������� ����Ǿ� �־�� �ϰ� ����Ŭ�� ���ԵǼ��� �ȵȴ�.
	 * ũ�罺Į �˰���!!
	 * ũ�罺Į�� �⺻�� ������ �߽����� �����ϴ� ��
	 * ������ ����ġ�� ���� ���� ���� ���� �Ŀ� ����Ŭ�� ������ �ʰ� 
	 * ��� ��带 �湮�� �� �ֵ��� ���� �ȴ�.
	 */
	static class Edge implements Comparable<Edge>{
		int distance;
		int nodeA;
		int nodeB;
		
		public Edge(int distance, int nodeA, int nodeB) {
			this.distance = distance;
			this.nodeA = nodeA;
			this.nodeB = nodeB;
		}
		
		@Override
		public int compareTo(Edge other) {
			return this.distance - other.distance;
		}
	}
	
	static int V, E;
	static int[] parent;
	static ArrayList<Edge> edges = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		
		// �θ����̺� �󿡼� �ڱ��ڽ����� �ʱ�ȭ
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(cost, a, b));
		}
		
		// ������ �������� ����
		Collections.sort(edges);
		
		// ������ �ϳ��� Ȯ���ϸ�
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).distance;
			int a = edges.get(i).nodeA;
			int b = edges.get(i).nodeB;
			// ����Ŭ�� �߻����� �ʴ� ��쿡�� ���տ� ����
			if(findParent(a) != findParent(b)) {
				unionParent(a,b);
				result += cost;
			}
		}
		
		
		System.out.println(result);
	}
	// Ư�� ���Ұ� ���� ������ ã��
	public static int findParent(int x) {
		// ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
		if(x == parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}

}
