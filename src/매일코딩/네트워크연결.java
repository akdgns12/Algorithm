package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
// 모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 return해라
// 모든 컴퓨터 -> 모든 노드, 필요한 최소비용 -> 가장 적은 비용(거리)
// 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘 -> 크루스칼 알고리즘
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
public class 네트워크연결 {
	// 부모 테이블
	static int[] parent;
	// 모든 간선을 담을 리스트와, 최종 비용(거리)를 담을 변수
	static ArrayList<Edge> edgelist;
	// 노드의 개수와 간선의 개수
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		edgelist = new ArrayList<>();
		// 모든 간선에 대한 정보 입력 받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			edgelist.add(new Edge(a,b,c)); 
		}
		
		parent = new int[N+1];
		// 부모 테이블 상에서, 부모를 자기 자신으로 초기화
		for(int i=1; i<=N; i++) { // 각자 자기자신만을 원소로 가지고 있도록 초기화
			parent[i] = i;
		}
		
		// 간선을 비용(거리)순으로 정렬
		Collections.sort(edgelist); 
	
		int answer = 0;
		// 간선을 하나씩 확인하며
		for(int i=0; i<edgelist.size(); i++) {
			Edge edge = edgelist.get(i);
			
			// 사이클이 발생하지 않는 경우에만 집합에 포함
			if(find(edge.nodeA) != find(edge.nodeB)) {
				union(edge.nodeA, edge.nodeB);
				answer += edge.distance;
			}
		}
		
		System.out.println(answer);
	}
	
	// 특정 원소가 속한 집합을 찾기
	public static int find(int x) {
		// 루트 노드가 아니라면, 루트 노드를 찾을때까지 재귀적으로 호출
		if(x == parent[x]) {
			return x;
		}
		else
			return parent[x] = find(parent[x]);
	}
	
	// 두 원소가 속한 집합을 합치기
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
		}
	}
}
