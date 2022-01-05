package 다익스트라_최단경로알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//
public class 산책_복습 {
	static class Node implements Comparable<Node>{
		int end, dist;
		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.dist - other.dist;
		}
	}
	static int N,M;
	static int S,E;
	static int[] distS;
	static int[] distE;
	static int[] used;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		distS = new int[N+1];
		distE = new int[N+1];
		used = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(distS, INF);
		Arrays.fill(distE, INF);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,1));
			list[b].add(new Node(a,1));
		}
		
		dijkstra(distS, S);
		dijkstra(distE, E);
		long ans = distS[E];
		
		eraseEdge(S,E);
		// 다시 다익스트라 돌리기전 distE INF로 초기화
		Arrays.fill(distE, INF);
		// E부터 모든 정점까지의 최단거리 구해주고
		dijkstra(distE, E);
		ans += distE[S];
		
		System.out.println(ans);
	}
	
	public static void dijkstra(int[] dist, int S) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(S, 0));
		dist[S] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.end]) continue;
			else visited[now.end] = true;
			
			for(Node next : list[now.end]) {
				if(used[next.end] == 1) continue;
				if(dist[next.end] > dist[now.end] + next.dist);
				 dist[next.end] = dist[now.end] + next.dist;
				 pq.offer(new Node(next.end, dist[next.end]));
			}
		}
	}
	
	public static void eraseEdge(int S, int E) {
		int pre = S;
		while(S != E) {
			int min = Integer.MAX_VALUE;
			for(Node next : list[S]) {
				int nxt = (int)next.end;
				if(distS[S] + next.dist + distE[nxt] == distS[E]) {
					min = Math.min(min, nxt);
				}
			}
			pre = S;
			S = min;
			if(S != E) used[S] = 1;
		}
	}

}
