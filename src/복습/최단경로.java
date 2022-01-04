package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
	static int[] d; // 최단경로 테이블
	static final int INF = (int)1e9;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		d = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(d, INF);
		
		for(int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, dist));
		}
		
		StringBuilder sb = new StringBuilder();
		dijkstra(start);
		
		for(int i=1; i<=V; i++) {
			if(d[i] == INF) sb.append("INF").append("\n");
			else sb.append(d[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.end;
			
			if(visited[now] == true) continue;
			else visited[now] = true;
			// 인접한 정점 검사
			for(Node next : list[now]) {
				//  ex) 예를들어
				// d[i] > d[2] + (2에서 i까지의 가중치)
				if(d[next.end] > d[now] + next.dist) {
					d[next.end]= d[now] + next.dist;
					pq.offer(new Node(next.end, d[next.end]));
				}
			}
		}
	}
	
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
}
