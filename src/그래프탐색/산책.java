package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//
public class 산책 {
	/*
	 * 한 정점에서 한정점까지의 최단거리 -> 다익스트라
	 */
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
	static int N, M;
	static int S,E; // 시작, 종료 정점
	static ArrayList<Node>[] list;
	// 1. S에서 E로의 최단거리 테이블
	// 2. E에서 S로의 최단거리 테이블  
	// 2개 사용 
	static int[] distS, distE; 
	static int[] used; // S -> E로 갈 때 사용한 정점 표시용
	static final int INF = (int)1e9;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		
		list = new ArrayList[N+1];
		distS = new int[N+1];
		distE = new int[N+1];
		used = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(distS, INF);
		Arrays.fill(distE, INF);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향 이동 가능
			list[a].add(new Node(b, 1));
			list[b].add(new Node(a, 1)); 
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // 시작 정점
		E = Integer.parseInt(st.nextToken()); // 목표 정점
		
		dijkstra(distS, S);
		dijkstra(distE, E);
		long ans = distS[E];
		
		// 마지막엔 distS[E] + distE[S] 리턴하면 되는데..
		// distE[S]를 구할 때 distS[E]를 구할때의 해당경로를 방문처리? 해줘야
		// 겹치지 않는다..
		eraseEdge(S, E);
		for(int i=1; i<=N; i++) distE[i] = INF;
		
		dijkstra(distE, E);
		ans += distE[S];
		
		System.out.println(ans);
				
	}
	
	public static void dijkstra(int[] dist, int S) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(S, 0));
		distS[S] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.end;
			
			if(visited[now]) continue;
			else visited[now] = true;
			
			for(Node next : list[now]) {
				if(used[next.end] == 1) continue;
				if(dist[next.end] > dist[now] + next.dist) {
					dist[next.end] = dist[now] + next.dist;
					pq.offer(new Node(next.end, distS[next.end]));
				}
			}
		}
	}
	
	public static void eraseEdge(int S, int E) {
		int pre = S;
		while(S != E) {
			int min = Integer.MAX_VALUE;
			for(Node next : list[S]) {
				if(next.end == pre) continue;
				if(distS[S] + next.dist + distE[next.end] == distS[E]) {
					min = Math.min(min, next.end);
				}
			}
			pre = S;
			S = min;
			if(S != E) used[S] = 1;
		}
	}

}
