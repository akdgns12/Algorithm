package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//
public class ��å {
	/*
	 * �� �������� ������������ �ִܰŸ� -> ���ͽ�Ʈ��
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
	static int S,E; // ����, ���� ����
	static ArrayList<Node>[] list;
	// 1. S���� E���� �ִܰŸ� ���̺�
	// 2. E���� S���� �ִܰŸ� ���̺�  
	// 2�� ��� 
	static int[] distS, distE; 
	static int[] used; // S -> E�� �� �� ����� ���� ǥ�ÿ�
	static final int INF = (int)1e9;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ������ ����
		M = Integer.parseInt(st.nextToken()); // ������ ����
		
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
			
			// ����� �̵� ����
			list[a].add(new Node(b, 1));
			list[b].add(new Node(a, 1)); 
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // ���� ����
		E = Integer.parseInt(st.nextToken()); // ��ǥ ����
		
		dijkstra(distS, S);
		dijkstra(distE, E);
		long ans = distS[E];
		
		// �������� distS[E] + distE[S] �����ϸ� �Ǵµ�..
		// distE[S]�� ���� �� distS[E]�� ���Ҷ��� �ش��θ� �湮ó��? �����
		// ��ġ�� �ʴ´�..
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
