package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 복습_파티_다익스트라 {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int N,M,X;
	static ArrayList<ArrayList<Node>> list,reverse_list;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		X = Integer.parseInt(st.nextToken()); // 모이는 마을 X
		
		list = new ArrayList<>(); // X에서 시작점 사이의 최단거리
		reverse_list = new ArrayList<>(); // 시작점에서 X 사이의 최단거리
		
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<>());
			reverse_list.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, cost));
			reverse_list.get(end).add(new Node(start, cost));
		}
		
		int[] dist1 = dijkstra(list);
		int[] dist2 = dijkstra(reverse_list);
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, dist1[i] + dist2[i]);
		}
		System.out.println(ans);
	}
	
	public static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X,0));
		
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int now = curNode.end;
			
			if(visited[now]) continue;
			
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				if(dist[node.end] > dist[now] + node.cost) {
					dist[node.end] = dist[now] + node.cost;
					pq.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
		return dist;
	}
}
