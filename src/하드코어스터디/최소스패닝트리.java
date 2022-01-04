package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class �ּҽ��д�Ʈ�� {
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
	static int V,E;
	static int parent[];
	static ArrayList<Edge> edges = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(cost, a,b));
		}
		
		// ���� ����ġ ���������� ��������
		Collections.sort(edges);
		
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).distance;
			int a = edges.get(i).nodeA;
			int b = edges.get(i).nodeB;
			// ����Ŭ�� �������� �ʴ� �͸�
			if(find(a) != find(b)) {
				union(a,b);
				result += cost;
			}
		}
		
		System.out.println(result);
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}

}
