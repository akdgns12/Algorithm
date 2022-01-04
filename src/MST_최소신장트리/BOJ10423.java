package MST_�ּҽ���Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ10423 {
	// ���Ⱑ ������ / �� 2 / MST(ũ�罺Į �˰���)
	/*
	 * ����
	 * 1. �������� ��Ʈ��带 -1�� �ʱ�ȭ�Ѵ�
	 * 2. ũ�罺Į �˰��� ����
	 * 3. ��� ����� ��Ʈ ��尡 -1�� �� ��� �����ϰ�, �ּ� ����� ���
	 */
	// 1�������� ���ϴ� ����
	// ���ڴ� �����ҳ��� ������� �ʵ��� �ϱ� ����, ���ڴ� ��� ��尡 ����� �ʿ� ���� �ܼ��ϰ� ��Ʈ ��尡 -1�� �� ��� �����ϱ� ���� 
	// �ѹ��� �������� �� �ʿ� ����
	static class Node implements Comparable<Node>{
		int x, y, cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int N, M, K;
	static int[] parent;
	static ArrayList<Node> list = new ArrayList<>();
	static int result = 0;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ����
		M = Integer.parseInt(st.nextToken()); // ����
		K = Integer.parseInt(st.nextToken()); // ������ ��ġ�� ���� ��
		
		parent = new int[N+1];
		// �θ����̺� �󿡼�, �ڱ� �ڽ����� �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		// �����Ұ� �ִ� ��ġ -1�� �ʱ�ȭ
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int plant = Integer.parseInt(st.nextToken());
			parent[plant] = -1;
		}
		// ���� ���� �ޱ�
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
				
			list.add(new Node(a,b,cost));
		}
		
		Collections.sort(list);
		
		
		for(int i=0; i<list.size(); i++) {
			Node node = list.get(i);

				if(find(node.x) != find(node.y)) { // ����Ŭ�� �߻����� ���� ��
					result += node.cost;
					union(node.x, node.y);
					
					// ��� ���ð� �����ҿ� ���� ���⸦ ���޹ް� �ִ� ���
					if(isAllconnect()) {
						break;
					}
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean isAllconnect() {
		for(int i=1; i<parent.length; i++) {
			if(parent[i] != -1) {
				return false;
			}
			
		}
		return true;
	}
	
	public static int find(int x) {
		if(parent[x] == -1) {
			return -1;
		}
		
		if(x == parent[x]) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x == -1) {
				parent[y] = x;
			}else if(y == -1) {
				parent[x] = y;
			}else {
				if(x == - 1 && y == -1) {
					return;
				}else {
					parent[y] = x;
				}
			}
		}
	}
}
