package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// BOJ 1593 가장가까운 공통 조상 / LCA 알고리즘
public class 가장가까운공통조상 { 
	// BOJ 가장가까운공통조상 // 가장가까운 공통 조상 찾는 프로그램
	// LCA알고리즘 이용하면 된다. but DFS는 루트노드부터 출발해야 하기 때문에 루트노드가 필요한데
	// 문제에서 루트노드를 따로 정해주지 않기 때문에 부모 노드만을 저장하는 배열을 하나 만들어 루트노드를 구해줘야 한다.
	static int N;
	static int[] parent;
	static int a,b;
	static ArrayList<ArrayList<Integer>> list; // 노드간의 관계를 나타낼 list
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		for(int tc = 0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine()); // 노드의 수
			list = new ArrayList<ArrayList<Integer>>(); // list 초기화
			for(int i=0; i<=N; i++) { // 트리 생성
				list.add(new ArrayList<Integer>());
			}
			
			parent = new int[N+1];
			
			// 주어진 점들로 트리 만들기
			for(int i=0; i<N-1; i++) { // 트리 채우기
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b] = a; // b의 부모는 a라는 의미
				list.get(a).add(b);
			}
			
			// 공통 조상을 구할 두 노드
			 st = new StringTokenizer(br.readLine());
			  a = Integer.parseInt(st.nextToken());
			  b = Integer.parseInt(st.nextToken());
			 
			 int a_depth = get_depth(a);
			 int b_depth = get_depth(b);
			 
			 int same = solve(a, a_depth, b, b_depth);
			 System.out.println(same);
		} // end for문
		
		
	}
	public static int solve(int a, int a_depth, int b, int b_depth) {
		// 둘의 depth가 같아질때까지 위로 올린다
		if(a_depth > b_depth) {
			while(a_depth != b_depth) {
				a_depth--;
				a = parent[a];
			}
		}
		else if(a_depth < b_depth) {
			while(a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		} // 여기까지 depth 같게 해주는 작업 후
		
		// 이작업이 의미하는 것 = depth가 같은 상태로
		// 맞춰진 후이므로 a와 b의 최소공통 조상은 같은값
		// 고로 최소공통조상으로 맞춰주는 작업
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		 // return a, return b 둘다 똑같다 위의 과정에서
		// a와 b를 같은 값 = 최소공통조상으로 맞춰줬기 때문에
		return a;
	}
	
	public static int get_depth(int node) {
		int ret = 0;
		int cur = node;
		while(cur != 0) { // 루트노드가 될 때까지
			ret++;
			cur = parent[cur];
		}
		return ret-1; // 최종적으로 return값은 해당 노드의 depth 리턴
	}
}	
