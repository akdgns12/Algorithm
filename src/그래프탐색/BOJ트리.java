package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ트리 {
	static int N;
	static int root; // 루트 노드를 저장할 변수
	static int delete; // 삭제할 노드 번호
	static int answer;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 트리의 노드 개수
		
		tree = new ArrayList[N];
		for(int i=0; i<N; i++) { // 트리 초기 설정
			tree[i] = new ArrayList<>(); 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken()); // 각 노드의 부모
			
			if(parent == -1 ) root = i; // 부모가 없다면 -1이 주어진다. 즉 루트이다.
			else
				tree[parent].add(i); 
		}
		
		delete = Integer.parseInt(br.readLine());
		
		dfs(root); // 루트부터 탐색
		
		System.out.println(answer);
	}
	
	public static void dfs(int node) {
		if(node == delete) return; // 삭제할 노드이면 탐색 중지
		
		if(tree[node].size() == 0) {
			// 자식이 없다 -> 리프노드이다.
			answer++;
			return;
		}
		
		for(int v : tree[node]) {
			if(v == delete && tree[node].size() == 1) {
				// 현재 노드가 삭제할 노드만을 자식으로 가지고 있다. -> 리프노드가 된다.
				answer++;
				return;
			}
			dfs(v);
		}
		
	}
}
