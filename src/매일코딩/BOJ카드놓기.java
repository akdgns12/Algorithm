package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ카드놓기 {
	 // BOJ 5568 카드놓기 // 만들 수 있는 정수의 개수
	// 순열을 사용하여, 가능한 경우의 수를 모두 뽑은 뒤에 Set을 사용하여
	// 중복을 제거한다 -> why? 문제를 잘읽자 문제에서 제시한 것 처럼 다른 것 뽑아도 결국 같은 정수 만들어 질 수 있으므로
	// Set이용해서 중복은 제거해줘야 한다.
	static int N,K;	
	static String[] card;
	static boolean[] visited;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 카드 개수
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()); // 뽑는 개수
		
		card = new String[N];
		visited = new boolean[N];
		set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			card[i] = st.nextToken();
		}
		
		perm("", K, 0); // 조합된 문자열 저장 변수, 뽑는 개수, count
		
		System.out.println(set.size());
	}
	
	public static void perm(String str, int k, int count) {
		if(count == K) {
			set.add(str);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm(str+card[i], K, count+1);
				visited[i] = false;
			}
		}
	}
}

