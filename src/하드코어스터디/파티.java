package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {
	// BOJ 1248 파티 / 골3 / 다익스트라
	/*
	 * 1. 각 마을에서 파티가 열리는 X번 마을로 가는 경우의 최단거리
	 * 2. X번 마을에서 각 마을로 가는 경우의 최단거리
	 * 두개 종합 후 시간 가장 오래걸리는 노드 
	 */
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	    @Override
	    public int compareTo(Node other) {
	    	return distance - other.distance;
	}
	}
	static int N,M,X;
	static final int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> goList, backList;
	static int[] list, back;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 학생 수(마을개수 정점개수)
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		X = Integer.parseInt(st.nextToken()); // 모이는 마을 번호
		
		goList = new ArrayList<>();
		backList = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			goList.add(new ArrayList<>());
			backList.add(new ArrayList<>());
		}
		
		list = new int[N+1];
		back = new int[N+1];
		Arrays.fill(list, INF);
		Arrays.fill(back, INF);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken()); // 걸리는 시간
			
			goList.get(a).add(new Node(b,cost));
			backList.get(b).add(new Node(a,cost)); 
		}
		
		dijkstra(goList, X, list); // 파티가 열리는 곳으로 가는 경우
		dijkstra(backList, X, back); // 돌아오는 경우
		
		int max = 0;
		for(int i=1; i<=N; i++)
			max = Math.max(max, list[i]+back[i]);
		
		System.out.println(max);
	}
	
	public static void dijkstra(ArrayList<ArrayList<Node>> array, int start, int[] cost) {
		boolean[] visited = new boolean[N+1]; // 방문 여부 체크배열
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		pq.add(new Node(start, 0)); // 시작 시점 큐에 삽입
		cost[start] = 0; // 시작 노드 초기화
		
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			
			if(visited[now]) continue; // 이미 방문했던 곳이라면 넘어간다
			
			visited[now] = true; // 방문처리
			
			for(Node node : array.get(now)) {
				if(cost[node.index] > cost[now] + node.distance) {
					cost[node.index] = cost[now] + node.distance; // 거리 값 갱신 
					pq.offer(new Node(node.index, cost[node.index]));
				}
			}
			
		}
	}
}
