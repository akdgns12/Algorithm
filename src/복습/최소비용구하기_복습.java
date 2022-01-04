package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기_복습 {
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		Node(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	static int N,M;
	static int[] dist;
	static ArrayList<ArrayList<Node>> list;
	static final int INF = (int)1e9;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		list = new ArrayList<>();
		visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		Arrays.fill(dist, INF);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int startPos = Integer.parseInt(st.nextToken());
		int endPos = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(startPos, endPos));
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[N+1];
		pq.offer(new Node(start,0));
		dist[start] = 0; // 초기 시작위치에서 자기자신까지는 0
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if(!visited[cur]) {
				visited[cur] = true;
					
			for(Node node : list.get(cur)) {
				// 해당 정점의 최단테이블 거리 < 해당정점까지의 가중치 + 현재정점까지의 최단테이블 거리
				if(!visited[node.end] && dist[node.end] > node.weight + dist[cur]) {
					dist[node.end] = node.weight + dist[cur];
					
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		
		}
		return dist[end];
	}
}
