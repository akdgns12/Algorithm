package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_가르침_백트래킹 {

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
		
		//남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다. a n t i c
		if(K < 5) {
			System.out.println(0);
			return;
		}else if(K == 26) {
			System.out.println(N);
			return;
		}else {
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				strArr[i] = str.substring(4, str.length()-4); // 앞에 anta, 뒤 tica 제거
			}
			K -= 5;
			// visited에 무조건 배울 수 밖에 없는 단어를 true로 바꾼다.(a,n,i,t,c)
			visited['a' - 'a'] = true; // visited[0] = true
			visited['c' - 'a'] = true;
			visited['i' - 'a'] = true;
			visited['t' - 'a'] = true;
			visited['n' - 'a'] = true;
			// 조합 -> dfs
			dfs(0,0); //start, count	
			System.out.println(max);
		}
	}
	
	public static void dfs(int start, int count) {
		// 총 단어 6개면 a n i t c를 제외한 조합 K-5 -> 1개
		if(count == K) {
			int result = 0;
			// 단어만큼 반복
			for(int i=0; i<N; i++) {
				boolean isTrue = true;
				for(int j=0; j<strArr[i].length(); j++) {
					// 조합으로 뽑힌 알파벳이 없으면 불가능!! 빠르게 패스
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
		
		// 알파벳 돌면서 가능한 조합 찾기
		for(int i = start; i < 26; i++) {
			// 이미 체크한 알파벳은 패스!
			if(!visited[i]) { 
				visited[i] = true;
				dfs(i, count+1);
				visited[i] = false;
			}
		}
	}
}
