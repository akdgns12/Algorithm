package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import 복습.도시분할계획복습.Node;

public class 행성연결_복습 {
	static class Node implements Comparable<Node> {
		int x,y,cost;
		
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
	static int N;
	static int[] parent;
	static ArrayList<Node> list = new ArrayList<>();
	static long result = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(cost != 0) {
					list.add(new Node(i,j,cost));
				}
			}
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			Node node = list.get(i);
			
			if(find(node.x) != find(node.y)) {
				union(node.x, node.y);
				result += node.cost;
			}
		}
		
		System.out.println(result);
	}
	
	static 	public int find(int x) {
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
