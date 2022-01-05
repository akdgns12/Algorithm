package 매일코딩;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 첫째 줄에  최소환승 횟수를 출력한다. 불가능한 경우에는 -1 출력

// 다익스트라 알고리즘

public class 최소환승문제_BOJ_2021 {
	static class Node implements Comparable<Node>{ // 우선순위 큐에 데이터가 들어갈 때마다 distance가 더 낮은 값이 우선순위가 높도록 Comparable 클래스 설정
		int index;
		int distance;
		
		Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public int getDistance() {
			return this.distance;
		}
		
		// 거리가 짧은 것이 높은 우선순위를 가지도록 설정
		@Override
		public int compareTo(Node o) {
			if(this.distance < o.distance) {
				return -1;
			}
			return 1;
		}
	} // Node
	
	static int N, L; // N 역의 개수, L 노선의 개수
	static final int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] d = new int[100001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
	}

}
