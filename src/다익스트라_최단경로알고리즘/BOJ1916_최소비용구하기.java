package 다익스트라_최단경로알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//
public class BOJ1916_최소비용구하기 {
	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	static int N, M;
	static int[] dist;
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException{
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
		
		// 단방향 인접리스트 구현
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// start에서 end로 가는 weight(가중치)
			list.get(start).add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int startPos = Integer.parseInt(st.nextToken());
		int endPos =  Integer.parseInt(st.nextToken());
		
		 System.out.println(dijkstra(startPos, endPos));
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[N+1];
		pq.add(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if(!visited[cur]) {
				visited[cur] = true;
			
			for(Node node : list.get(cur)) {
				if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
			}
		}
		return dist[end];
	}
}
