package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.xml.soap.Node;
//주의사항
/*
 * 1. 다익스트라 알고리즘
 * 2. 양방향
 */
public class 택배배송 {
	static int n,m;
	static final int INF = (int) 1e9;
	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int start = 1;
	// 최단 거리 테이블 만들기
	static int[] d = new int[50001];
	
	public static void main(String[] args) throws IOException{
		// 현서 -> 찬홍
		// 중간에 소들에게 여물을 줘야한다.
		// 최소한의 소만 만나고 싶다
		
		// N(헛간, 정점)
		// M(길, 간선)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 양방향 고려해준다.
			graph.get(a).add(new Node(b,c)); // a -> b 노드로 가는 비용 c
			graph.get(b).add(new Node(a,c)); // b -> a 노드로 가는 비용 c
		}
		
		// 최단 거리 테이블을 모두 무한으로 초기화
		Arrays.fill(d, INF);
		
		dijkstra();
		
		System.out.println(d[n]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//시작 지점은 1 start = 1
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) { // 큐가 비어있지 않다면
			// 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
			Node node = pq.poll();
			int dist = node.distance; // 현재 노드까지의 거리
			int now = node.index; // 현재 노드
			
			// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
			/*
			 * why ? -> 이미 방문해서 노드에 대한 거리가 최단거리테이블에 갱신된 상태라면
			 *			우선순위큐에서 꺼내온 노드에 대한 거리보다 > 비교할 해당 노드의 거리
			 *			이기 때문에 방문처리 배열 따로 생성하지 않고 비교할 수 있다.
			 */
			if(d[now] < dist) {
				continue;
			}
			
			// 현재 노드와 연결된 다른 인접한 노드들을 확인
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				// 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{ // 우선순위 큐에 데이터가 들어갈 때 distance가 더 낮은 값이 높은 우선순위를 가질 수 있도록 하기위해 comparable 클래스 사용
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
		
		// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
		@Override
		public int compareTo(Node o) {
			if(this.distance < o.distance) {
				return -1;
			}
			return 1;
		}
	} //Node
}
