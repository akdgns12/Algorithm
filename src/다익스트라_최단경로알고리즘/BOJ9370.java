package 다익스트라_최단경로알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//
public class BOJ9370 {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
	static int n,m,t,start,g,h;
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	static int[] dist;
	static final int INF = (int)1e9;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for(int j=0; j<n+1; j++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list.get(a).add(new Node(b,cost));
				list.get(b).add(new Node(a,cost));
			}
			
			int[] candidate = new int[t];
			for(int j=0; j<t; j++) {
				candidate[j] = Integer.parseInt(br.readLine());
			}
			
			// s-x 최단경로와 같은 s-g-h-x 혹은 s-h-g-x 최단경로 찾기
			PriorityQueue<Integer> result = new PriorityQueue<>();
			for(int x : candidate) {
				long res1 = dijkstra(start,g) + dijkstra(g,h) + dijkstra(h,x);
				long res2 = dijkstra(start,h) + dijkstra(h,g) + dijkstra(g,x);
				long res3 = dijkstra(start, x);
				
				if(Math.min(res1, res2) == res3) {
					result.offer(x);
				}
			}
			
			while(!result.isEmpty()) {
				sb.append(result.poll() + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static long dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		dist = new int[n+1];
		visited = new boolean[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int now = curNode.end;
			
			for(Node node : list.get(now)) {
				if(dist[node.end] > dist[now] + node.cost) {
					dist[node.end]= dist[now] + node.cost;
					pq.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
		return dist[end];
	}
}
