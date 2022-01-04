package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라경로추적봇브 {
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
	static int N, M;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int[] dist;
	static final int INF = (int)1e9;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, cost));
			list.get(end).add(new Node(start, cost));
		}
		
		// 각 정점에 대해 다익스트라 수행하며 경로추적
		for(int i=1; i<N+1; i++) {
			dijkstra(i);
		}
		
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		boolean[] visited = new boolean[N+1];
		dist = new int[N+1];
		int[] path = new int[N+1]; // 경로추적할 배열
		
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		path[start] = start;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int now = curNode.end;
			
			if(visited[now]) continue;
			
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				if(dist[node.end] > dist[now] + node.cost) {
					dist[node.end] = dist[now] + node.cost;
					// node.end를 가기 위해선 직전 경로인 now를 거쳐가야한다 now를 path배열에 저장
					// 이런식으로 계속해서 갱신되다보면 
					path[node.end] = now; // 직전 경로 저장 
					pq.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
		
		findPath(start, path);
	}
	
	public static void findPath(int start, int[] path) {
		// start 정점에서 각 정점까지 최단경로 추적
		for(int i=1; i<N+1; i++) {
			// 자기 자신인 경우
			if(i == start) {
				sb.append("- ");
				continue;
			}
			int answer = 0;
			for(int j=i; j!=start; j=path[j]) {
				// 가장 먼저 방문해야되는 정점이 되도록 갱신
				answer = j;
			}
			sb.append(answer + " ");
		}
		sb.append("\n");
	}
}
