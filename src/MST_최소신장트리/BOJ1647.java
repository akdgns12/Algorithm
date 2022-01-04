package MST_�ּҽ���Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1647 {
	/*
	 * ũ�罺Į �˰���
	 * �ּҽ���Ʈ��-����Ŭ�� �߻����� �ʾƾ���.
	 * ��� ��带 �մ� ������ ä���ϴµ� �ּ� ����� �鵵��
	 * 1. �ִܰŸ��� �������� �׷����� ���Խ�Ų��
	 * 2. ����Ŭ�� �߻��� ��� skip
	 * 
	 * ����Ŭ �߻����δ� union-Find(������ ã��) �˰������� �Ǵ� ����
	 * - �̹� �θ� ���� ���ŵ� ��忡 �ٽ� ������ �ؾ��ϴ� ��찡 �߻��� ��� ����Ŭ�� ����̱� ������
	 * �Ǵ� ����
	 */
	/*
	 * �̹����� ����
	 * ����� �ּҷ� ���� �ΰ��� ������ ������..
	 *ũ�罺Į �˰��� -> �ּҰ����� �����ؼ� ��� ������ ������ ��θ� ã�� �˰���
	 *���⼭ ���� ū ������ ���ٸ� �ΰ��� ������ �����鼭 �ּҰ� �� �� �ִ�. (������ �ٽ�!)
	 */
	static class Node implements Comparable<Node>{
		int x, y, cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	static int N,M;
	static int[] parent;
	static ArrayList<Node> list;
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ���� ����
		M = Integer.parseInt(st.nextToken()); // ���� ����
		
		list = new ArrayList<>();
		// ��� ���� ���� �Է¹ޱ�
		for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				list.add(new Node(a,b,cost));
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) { // �θ� ���̺� �ڱ� �ڽ����� �ʱ�ȭ
			parent[i] = i;
		}
		
		Collections.sort(list); // ������ �������� ����
		
		// ������ �ϳ��� Ȯ���ϸ�
		int max = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            
            // ����Ŭ�� �߻����� �ʴ� ��쿡�� ���տ� ����
            if (find(node.x) != find(node.y)) {
            	max = Math.max(max,node.cost); // ����� ���� �� ���� ū ��
                union(node.x, node.y);
            	result += node.cost;
                
            }
        }
        // �� ���� ��� - ���� ū �������(�̷��� �ϸ� �ΰ��� ������ �����鼭 �ּҺ���� ������ ������� ����� ��)
        System.out.println(result-max); // ��������� ���ش� -> �ΰ��� ������ �����鼭 �ּ� ���
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}else
			return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) {
			parent[y] = x;
		}else
			parent[x] = y;
	}
}