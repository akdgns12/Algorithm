package 다익스트라_최단경로알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1719 {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end =  end;
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
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
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
		
		for(int i=1; i<=N; i++) {
			dijkstra(i);
		}
		
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		visited = new boolean[N+1];
		int[] path = new int[N+1]; // 노드추적
		
		// 정점 i 직전에 정점 j를 거쳐야 한다.(path[i] = j)
		dist = new int[N+1];
		
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
					path[node.end] = now;
					pq.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
		findPath(start, path);
	}
	
	public static void findPath(int start, int[] path) {
		for (int i=1; i<N+1; i++) {
            if (i == start) {
                sb.append("- ");
                continue;
            }
            int answer = 0;
            for (int j=i; j!=start; j=path[j]) {
                answer = j;
            }
            sb.append(answer + " ");
        }
        sb.append("\n");

	}

}
 
 


