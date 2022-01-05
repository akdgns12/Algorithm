package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 노드사이의거리 {
	// BOJ 1240  골 4 / 노드사이의 거리 / 가중치가 있는 트리의 탐색문제 기본
	// class를 이용해서 다음 방문할 위치와 거리를 입력해두고 탐색하면서 거리를 계속 
	// 더해주면 된다. 탐색은 BFS
	// 간선을 입력할 때 양쪽으로 이동이 가능하게끔 양방향으로 리스트에 넣어줘야한다.
	static class Node{
		int next, dist;
	
		public Node(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
	}
	
	static int N, M;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드의 개수
		M = Integer.parseInt(st.nextToken()); // 사이의 거리를 알고싶은 노드 쌍 개수
	
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			// 양방향 연결해준다.
			list[start].add(new Node(end, dist));
			list[end].add(new Node(start, dist));
		}
		
		// 거리를 알고싶은 노드의 쌍
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			System.out.println(find(start, end));
		}
	}
	
	public static int find(int start, int end) {
		visited = new boolean[N+1];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start, 0));
		visited[start] = true;
		
		int dist = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.next == end) {
				dist = node.dist;
				break;
			}
			
			for(Node temp : list[node.next]) {
				if(!visited[temp.next]) {
					q.offer(new Node(temp.next, node.dist + temp.dist));
					visited[temp.next] = true;  
				}
			}
		}
		return dist;
	}
}
