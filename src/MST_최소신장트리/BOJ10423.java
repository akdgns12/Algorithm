package MST_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ10423 {
	// 전기가 부족해 / 골 2 / MST(크루스칼 알고리즘)
	/*
	 * 로직
	 * 1. 발전소의 루트노드를 -1로 초기화한다
	 * 2. 크루스칼 알고리즘 실행
	 * 3. 모든 노드의 루트 노드가 -1이 될 경우 종료하고, 최소 비용을 출력
	 */
	// 1번과정을 취하는 이유
	// 전자는 발전소끼리 연결되지 않도록 하기 위함, 후자는 모든 노드가 연결될 필요 없이 단순하게 루트 노드가 -1가 될 경우 종료하기 위함 
	// 한번더 개념정리 할 필요 있음
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
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		K = Integer.parseInt(st.nextToken()); // 발전소 설치된 도시 수
		
		parent = new int[N+1];
		// 부모테이블 상에서, 자기 자신으로 초기화
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		// 발전소가 있는 위치 -1로 초기화
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int plant = Integer.parseInt(st.nextToken());
			parent[plant] = -1;
		}
		// 간선 정보 받기
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

				if(find(node.x) != find(node.y)) { // 사이클이 발생하지 않을 때
					result += node.cost;
					union(node.x, node.y);
					
					// 모든 도시가 발전소에 의해 전기를 공급받고 있는 경우
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
