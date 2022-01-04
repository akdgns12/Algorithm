package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 도시분할계획복습2 {
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
	static int N, M;
	static int[] parent;
	static ArrayList<Node> list = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Node(a,b,cost));
		}
		
		Collections.sort(list);
		
		int max = 0;
		for(int i=0; i<list.size(); i++) {
			Node node = list.get(i);
			
			if(find(node.x) != find(node.y)) {
				max = Math.max(max, node.cost);
				union(node.x, node.y);
				result += node.cost;
			}
		}
		
		System.out.println(result - max);
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}

}
