package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 순열_카드놓기복습 {
	//BOJ 5568 // 카드놓기 복습
	static int N, K;
	static String[] card;
	static boolean[] visited;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		card = new String[N];
		visited = new boolean[N];
		set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			card[i] = st.nextToken();
		}
		
		perm("", K, 0);
		
		System.out.println(set.size());
	}
	
	public static void perm(String str, int K, int count) {
		if(count == K) {
			set.add(str);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm(str + card[i], K, count+1);
				visited[i] = false;
			}
		}
	}
}
