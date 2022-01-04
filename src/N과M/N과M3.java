package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_15651
// 백트래킹
// (2)와 같지만  1부터 포함
// 중복 체크할 필요 x

/*
 * 1. 1~N까지의 수를 조합
 * 2. M개를 선택하여 조합한다(길이(깊이)가 M이다)
 * 3. 중복해서 조합할 수 있다
 */
public class N과M3 {
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M]; // 배열 크기 N인지 M인지 다시 보자
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		/*
		 * 깊이가 최대 깊이일 경우
		 * 더이상 탐색할 자식노드는 없으므로 return 해준다
		 */
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		/*
		 * 깊이를 1씩 증가시켜 DFS를
		 * 재귀호출한다
		 */
		for(int i=1; i<=N; i++) {
			arr[depth]=i;
			dfs(depth+1);
		}
	}
}
