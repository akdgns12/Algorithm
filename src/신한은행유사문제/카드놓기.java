package �����������繮��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ī����� {
	// BOJ 5568 ī����� / �������繮�� / ���ڸ� ���°� �ƴ� �� �Է°��� idx��
	// ������ �����ؼ� �̴� ����, 1234~1432, 2134~2431.. ������ ���� Ȯ���ϴ�
	// ��Ʈ��ŷ �ڵ带 ¥�ָ� �ȴ�.
	static int N, K; // ī���� ��, �̴� ����
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
