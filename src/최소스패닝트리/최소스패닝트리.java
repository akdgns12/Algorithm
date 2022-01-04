package 최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	/*
	 * 최소 스패닝 트리, -> 최소스패닝트리(최소신장트리)란 = 그래프 내의 모든 정점을 포함하는 트리형태 
	 * 조건 
	 * 1. 최소연결 = 간선의 수가 가장 적다.
	 * 2. 모든 정점들이 연결되어 있어야 하고 사이클이 포함되서는 안된다.
	 * 크루스칼 알고리즘!!
	 * 크루스칼의 기본은 간선을 중심으로 생각하는 것
	 * 간선의 가중치가 가장 작은 것을 고르고 후에 싸이클이 생기지 않고 
	 * 모든 노드를 방문할 수 있도록 고르면 된다.
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
		
		// 부모테이블 상에서 자기자신으로 초기화
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
		
		// 간선을 비용순으로 정렬
		Collections.sort(edges);
		
		// 간선을 하나씩 확인하며
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).distance;
			int a = edges.get(i).nodeA;
			int b = edges.get(i).nodeB;
			// 사이클이 발생하지 않는 경우에만 집합에 포함
			if(findParent(a) != findParent(b)) {
				unionParent(a,b);
				result += cost;
			}
		}
		
		
		System.out.println(result);
	}
	// 특정 원소가 속한 집합을 찾기
	public static int findParent(int x) {
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
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
