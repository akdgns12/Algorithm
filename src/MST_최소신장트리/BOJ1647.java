package MST_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1647 {
	/*
	 * 크루스칼 알고리즘
	 * 최소신장트리-사이클이 발생하지 않아야함.
	 * 모든 노드를 잇는 간선을 채택하는데 최소 비용이 들도록
	 * 1. 최단거리의 간선부터 그래프에 포함시킨다
	 * 2. 사이클이 발생할 경우 skip
	 * 
	 * 사이클 발생여부는 union-Find(합집합 찾기) 알고리즘으로 판단 가능
	 * - 이미 부모 노드로 갱신된 노드에 다시 갱신을 해야하는 경우가 발생할 경우 사이클인 경우이기 떄문에
	 * 판단 가능
	 */
	/*
	 * 이문제의 관건
	 * 비용을 최소로 갖는 두개의 마을로 나눈다..
	 *크루스칼 알고리즘 -> 최소간선을 선택해서 모든 마을을 연결한 경로를 찾는 알고리즘
	 *여기서 가장 큰 간선을 뺀다면 두개의 마을로 나뉘면서 최소가 될 수 있다. (문제의 핵심!)
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
		N = Integer.parseInt(st.nextToken()); // 집의 개수
		M = Integer.parseInt(st.nextToken()); // 길의 개수
		
		list = new ArrayList<>();
		// 모든 간선 정보 입력받기
		for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				list.add(new Node(a,b,cost));
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) { // 부모 테이블 자기 자신으로 초기화
			parent[i] = i;
		}
		
		Collections.sort(list); // 간선을 비용순으로 정렬
		
		// 간선을 하나씩 확인하며
		int max = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (find(node.x) != find(node.y)) {
            	max = Math.max(max,node.cost); // 연결된 간선 중 가장 큰 값
                union(node.x, node.y);
            	result += node.cost;
                
            }
        }
        // 총 간선 비용 - 가장 큰 간선비용(이렇게 하면 두개의 마을로 나뉘면서 최소비용을 가지는 간선들로 연결된 것)
        System.out.println(result-max); // 결과값에서 빼준다 -> 두개의 마을로 나뉘면서 최소 비용
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