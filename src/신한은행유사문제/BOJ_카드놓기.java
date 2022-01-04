package 신한은행유사문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_카드놓기 {
	static int N, K; // 카드 개수, 뽑을 카드 수
	static String[] card;
	static boolean[] visited;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		card = new String[N+1];
		visited = new boolean[N+1];
		set = new HashSet<>();
		
		for(int i=1; i<=N+1; i++) { // 카드는 1부터 시작이므로
			card[i] = br.readLine();
		}
		
		dfs(K, 1, "");
		
		System.out.println(set.size());
	}
	
	public static void dfs(int K, int idx, String str) {
		if(K == 0) {
			set.add(str);
			return;
		}
		
		if(idx > N ) {
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(K - 1, i, str + card[i]);
				visited[i] = false;
			}
		}
	}
}
