package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.xml.soap.Node;

public class 택배배송_다익스트라복습 {
	static int N,M;
	static final int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] d = new int[50001];
	static int start = 1;
	
	public static void main(String[] args) throws IOException{
		/*
		 * 현서 -> 찬홍
		 * 소들에게 여물을 줘야한다
		 * N (헛간, 노드)
		 * M(길, 간선)
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//그래프 초기화
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//최단거리 테이블 최대로 초기화
		Arrays.fill(d, INF);
		
		//다익스트라 알고리즘 실행
		dijkstra();
		
		System.out.println();
		
		
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//시작 지점은 1
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance(); // 현재 노드까지의 거리
			int now = node.getIndex(); // 현재 노드
			
			if(d[now] < dist) {
				continue;
			}
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
			
		}
	} //dijkstra
	
	static class Node implements Comparable<Node> {
		private int index;
		private int distance;
		
		Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}
		
		private int getIndex() {
			return this.index;
		}
		
		private int getDistance() {
			return this.distance;
		}
		
		@Override
		public int compareTo(Node other) {
			if(this.distance < other.distance) {
				return  -1;
			}
			return 1;
		}
	} // Node
}
