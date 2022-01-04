package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class �ù�_���ͽ�Ʈ���ִܰ�� {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int N,M;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int[] dist;
	static final int INF = (int)1e9;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
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
		// �� �������� ���ͽ�Ʈ�� ����
		for(int i=1; i<N+1; i++) {
			dijkstra(i);
		}
		
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		
		boolean[] visited = new boolean[N+1];
		dist = new int[N+1];
		int[] path = new int[N+1];
		
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
					path[node.end] = now; // ���� ��� ���� 
					pq.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
		
		findPath(start, path);
	}
	
	// �������
	public static void findPath(int start, int[] path) {
		// start�������� �� ����[i]���� �ִܰ�� ����
		for(int i=1; i<N+1; i++) {
			// �ڱ��ڽ��� ���
			if(i == start) {
				sb.append("- ");
				continue;
			}
			int answer = 0;
			for(int j=i; j!=start; j=path[j]) {
				// ���� ���� �湮�Ǿ�� �ϴ� ������ �ǵ��� ����
				answer = j;
			}
			sb.append(answer + " ");
		}
		sb.append("\n");
	}
}
