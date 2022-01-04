package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_����ħ_��Ʈ��ŷ {

	static int N,K;
	static int max = 0;
	static boolean[] visited = new boolean[26];
	static String[] strArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		strArr = new String[N];
		
		//���ؾ���� ��� �ܾ�� "anta"�� ���۵ǰ�, "tica"�� ������. a n t i c
		if(K < 5) {
			System.out.println(0);
			return;
		}else if(K == 26) {
			System.out.println(N);
			return;
		}else {
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				strArr[i] = str.substring(4, str.length()-4); // �տ� anta, �� tica ����
			}
			K -= 5;
			// visited�� ������ ��� �� �ۿ� ���� �ܾ true�� �ٲ۴�.(a,n,i,t,c)
			visited['a' - 'a'] = true; // visited[0] = true
			visited['c' - 'a'] = true;
			visited['i' - 'a'] = true;
			visited['t' - 'a'] = true;
			visited['n' - 'a'] = true;
			// ���� -> dfs
			dfs(0,0); //start, count	
			System.out.println(max);
		}
	}
	
	public static void dfs(int start, int count) {
		// �� �ܾ� 6���� a n i t c�� ������ ���� K-5 -> 1��
		if(count == K) {
			int result = 0;
			// �ܾŭ �ݺ�
			for(int i=0; i<N; i++) {
				boolean isTrue = true;
				for(int j=0; j<strArr[i].length(); j++) {
					// �������� ���� ���ĺ��� ������ �Ұ���!! ������ �н�
					if(!visited[strArr[i].charAt(j) - 'a']) {
						isTrue = false;
						break;
					}
				}
				if(isTrue) {
					result++;
				}
			}
			max = Math.max(max, result);
		}
		
		// ���ĺ� ���鼭 ������ ���� ã��
		for(int i = start; i < 26; i++) {
			// �̹� üũ�� ���ĺ��� �н�!
			if(!visited[i]) { 
				visited[i] = true;
				dfs(i, count+1);
				visited[i] = false;
			}
		}
	}
}
