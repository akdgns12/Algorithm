package 하드코어스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 웜홀 {
	// BOJ 1865 / 웜홀 / 골 3 / 벨만포드알고리즘
	/*
	 * 음수의 간선 - 벨만포드 알고리즘
	 */
	// 문제에서 웜홀은 줄어드는 시간을 의미하므로 -> 음수 가중치를 의미
	/*
	 * 	벨만포드 최단경로 알고리즘 동작과정
 * 1. 출발 노드를 설정합니다.
 * 2. 최단 거리 테이블을 초기화합니다.(다른 모든 노드에 대해서 거리가 무한으로 초기화)
 * 3. 다음의 과정을 N-1번 반복합니다.
 *    1. 전체 간선 E개를 하나씩 확인합니다.
 *    2. 각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신합니다.
 *  만약 '음수 간선 순환이 발생하는지 체크하고 싶다면' 3번의 과정을 한번 더 수행합니다.
 *   이때 최단 거리 테이블이 갱신된다면 음수 간선 순환이 존재하는 것.
 *   
 *   벨만포드 알고리즘 vs 다익스트라 알고리즘
 *   
 *   - 다익스트라 알고리즘 
 *     - '매번 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택'
 *     - 음수 간선이 없다면 최적의 해를 찾을 수 있다.
 *   - 벨만포드 알고리즘
 *     - '매번 모든 간선을 전부 확인'
 *       - 따라서 "다익스트라 알고리즘에서의 최적의 해를 항상 포함"
 *     - 다익스트라 알고리즘에 비해서 시간이 오래 걸리지만 음수 간선 순환을 탐지할 수 있다.
	 */
	// 간략히 말하자면 총 N개의 노드가 있고 M개의 간선이 있다면, |N-1|번 M개의 간선에 대해 dist[]를 갱신해주고
	// 1번 M개의 간선에 대해 dist[]를 갱신하려고 할 때 갱신이 된다면 음의 사이클이 있는것.
	static class Node{
		int start, end, cost;
		
		public Node(int start, int end,int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	static int TC;
	static int N,M,W;
	static final int INF = (int)1e9;
	static int[] dist; 
	static ArrayList<Node> graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 
		TC = Integer.parseInt(br.readLine());
		while(TC-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지점의 수 - 노드의 수
			M = Integer.parseInt(st.nextToken()); // 도로의 수 - 간선의 수 
			W = Integer.parseInt(st.nextToken()); // 웜홀 개수
			
			graph = new ArrayList<>();
			dist = new int[N+1];
			Arrays.fill(dist, INF);
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				// 도로는 양방향 그래프
				graph.add(new Node(start, end,cost));
				graph.add(new Node(end, start,cost));
			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				// 웜홀은 단방향 그래프
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.add(new Node(start, end,-cost));
			}
			
			
			if(bellmanFord())  // 음수 사이클이 있는 경우
				System.out.println("YES");
			else  // 음수 사이클이 없는 경우
				System.out.println("NO");
		} // end while
		
	}
	
	public static boolean bellmanFord() {
		dist[1] = 0; // 시작점을 1번노드로 지정하고 0으로 초기화
		
		// N-1번  M개의 간선에 대해 dist[]를 갱신해준다.
		for(int i=1; i<N; i++) { // 남은 각 노드에서
			for(int j=0; j<graph.size(); j++) { //간선 개수만큼 *주의할 점 : 간선 갯수만큼 돌아줘야 하는데 전역변수로 입력받은 M으로 설정하면 안된다.
				// 웜홀 또한 그래프의 일부분이기 때문에 graph.size()가 간선의 개수가 된다. 전역변수로 받은 M만큼만 돌면 웜홀 간선 무시하는 case가 된다.
				Node cur = graph.get(j);
				int start = cur.start;
				int end = cur.end;
				int cost = cur.cost;
				// 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(dist[start] != INF && dist[end] > dist[start] + cost) {
					dist[end] = dist[start] + cost;
				}
			}
		}
		
		//다 돌리고 나서 음수 사이클 유무 확인
		for(int i=0; i<graph.size(); i++) {
			Node cur = graph.get(i);
			int start = cur.start;
			int end = cur.end;
			int cost = cur.cost;
			// 갱신이 또 된 경우
			if(dist[start] != INF && dist[end] > dist[start] + cost) {
				return true;
			}
		}
		// 갱신이 되지 않은 경우
		return false;
	}
}
