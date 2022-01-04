package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_제대로 {
	static class Node implements Comparable<Node>{
		int end, dist;
		
		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return dist - other.dist;
		}
	}
	static int V,E;
	static boolean[] visited;
	static int[] distance;
	static final int INF = (int)1e9;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(distance, INF);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, dist));
		}
		
		StringBuilder sb = new StringBuilder();
		dijkstra(start);
		// 출력
		for(int i=1; i<=V; i++) {
			if(distance[i] == INF) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.end;
			
			if(visited[now] == true) continue;
			else visited[now] = true;
			
			for(Node next : list[now]) {
				if(distance[next.end] > distance[now] + next.dist) {
					distance[next.end] = distance[now] + next.dist;
					pq.offer(new Node(next.end, distance[next.end]));
				}
			}
		}
	}
}
