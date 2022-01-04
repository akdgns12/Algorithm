package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
// ��� ��ǻ�͸� �����ϴµ� �ʿ��� �ּҺ���� ù° �ٿ� return�ض�
// ��� ��ǻ�� -> ��� ���, �ʿ��� �ּҺ�� -> ���� ���� ���(�Ÿ�)
// ���� ���� ������� ��� ��带 �����ϱ� ���� ����ϴ� �˰��� -> ũ�罺Į �˰���
class Edge implements Comparable<Edge>{
	int nodeA;
	int nodeB;
	int distance;
	
	Edge(int nodeA, int nodeB, int distance){
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Edge o) {
		return distance - o.distance;
	}
}
public class ��Ʈ��ũ���� {
	// �θ� ���̺�
	static int[] parent;
	// ��� ������ ���� ����Ʈ��, ���� ���(�Ÿ�)�� ���� ����
	static ArrayList<Edge> edgelist;
	// ����� ������ ������ ����
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		edgelist = new ArrayList<>();
		// ��� ������ ���� ���� �Է� �ޱ�
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			edgelist.add(new Edge(a,b,c)); 
		}
		
		parent = new int[N+1];
		// �θ� ���̺� �󿡼�, �θ� �ڱ� �ڽ����� �ʱ�ȭ
		for(int i=1; i<=N; i++) { // ���� �ڱ��ڽŸ��� ���ҷ� ������ �ֵ��� �ʱ�ȭ
			parent[i] = i;
		}
		
		// ������ ���(�Ÿ�)������ ����
		Collections.sort(edgelist); 
	
		int answer = 0;
		// ������ �ϳ��� Ȯ���ϸ�
		for(int i=0; i<edgelist.size(); i++) {
			Edge edge = edgelist.get(i);
			
			// ����Ŭ�� �߻����� �ʴ� ��쿡�� ���տ� ����
			if(find(edge.nodeA) != find(edge.nodeB)) {
				union(edge.nodeA, edge.nodeB);
				answer += edge.distance;
			}
		}
		
		System.out.println(answer);
	}
	
	// Ư�� ���Ұ� ���� ������ ã��
	public static int find(int x) {
		// ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�������� ��������� ȣ��
		if(x == parent[x]) {
			return x;
		}
		else
			return parent[x] = find(parent[x]);
	}
	
	// �� ���Ұ� ���� ������ ��ġ��
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
		}
	}
}
