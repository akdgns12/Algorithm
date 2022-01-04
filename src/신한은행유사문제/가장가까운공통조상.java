package 신한은행유사문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장가까운공통조상 {
	static int N; // 노드 개수
	static ArrayList<ArrayList<Integer>> list; // 간선 관계를 나타낼 그래프 list
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		// TC개수만큼 돌리기
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<ArrayList<Integer>>(); // list 초기화
			// list 생성
			for(int i=1; i<=N; i++) {
				list.add(new ArrayList<>());
			}
			
			// 주어진 점들로 트리 만들기
			for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			parent[b] = a; // b의 부모가 a라는 뜻
				list.get(a).add(b);
			}
		
		
		// 공통조상 찾으려는 노드
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int a_depth = get_depth(a);
		int b_depth = get_depth(b);
		
		int same = solve(a, a_depth, b, b_depth);
		System.out.println(same);
		}
		
	}
	
	public static int solve(int a, int a_depth, int b, int b_depth) {
		if(a_depth > b_depth) {
			while(a_depth != b_depth) {
				a_depth--;
				a = parent[a];
			}
		}
		if(b_depth > a_depth) {
			while(a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		}
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
	
	public static int get_depth(int node) {
		int depth = 0;
		int cur = node;
		while(cur != 0) {
			depth++;
			cur = parent[cur];
		}
		return depth-1;
	}
}
