package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 복습_파티 {
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		public Node(int index, int disntance) {
			this.index = index;
			this.distance = distance;
		}
		@Override
		public int compareTo(Node other) {
			return distance - other.distance;
		}
	}
	static int N,M,X;
	static final int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> go_party, back_home;
	static int[] go, back;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		go_party = new ArrayList<>();
		back_home = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			go_party.add(new ArrayList<>());
			back_home.add(new ArrayList<>());
		}
		
		go = new int[N+1];
		back = new int[N+1];
		Arrays.fill(go, INF);
		Arrays.fill(back, INF);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			go_party.get(a).add(new Node(b,c));
			back_home.get(b).add(new Node(a,c));
		}
		
		dijkstra(go_party, X, go);
		dijkstra(back_home, X, back);
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, go[i] + back[i]);
			
		}
		System.out.println(max);
		
	}
	
	public static void dijkstra(ArrayList<ArrayList<Node>> array, int start, int[] distance) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			
			if(visited[now]) continue;
			
			visited[now] = true;
			
			for(Node node : array.get(now)) {
				if(distance[node.index] > distance[now] + node.distance) {
					distance[node.index] = distance[now] + node.distance; 
					pq.offer(new Node(node.index, distance[node.index]));
				}
			}
		}
	}
}
