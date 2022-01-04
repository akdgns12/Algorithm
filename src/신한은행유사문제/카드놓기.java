package 신한은행유사문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 카드놓기 {
	// BOJ 5568 카드놓기 / 신한유사문제 / 숫자를 보는게 아닌 각 입력값의 idx를
	// 순서를 구분해서 뽑는 과정, 1234~1432, 2134~2431.. 순서를 전부 확인하는
	// 백트래킹 코드를 짜주면 된다.
	static int N, K; // 카드의 수, 뽑는 갯수
	static HashSet<String> hs;
	static String[] card;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		card = new String[N+1];
		visited = new boolean[N+1];
		hs = new HashSet<>();
		
		for(int i=1; i<=N; i++){
			card[i] = br.readLine();
		}
		
		dfs(K, 1, "");
		
		System.out.println(hs.size());
	}
	
	public static void dfs(int K, int idx, String str) {
		if(K == 0) {
			hs.add(str);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(K-1, i, str + card[i]);
				visited[i] = false;
			}
		}
	}
	
}
