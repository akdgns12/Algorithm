package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_15652
// 백트래킹
/*
 * 1. 1부터 N까지의 자연수 중 M개를 고른 수열
 * 2. 비내림차순
 * 3. 중복되는 수열 걸러야 한다.
 */
// 비 내림차순 = 중복된 데이터 5 4 3 3 2 1의 입력을 정렬했을 때 result> 1 2 3 3 4 5로 표현되는 것
// 위와 같은 입력을 오름차순을 한다면 중복된 데이터 3으로 인해 정렬 불가

public class N과M4 {
	
	static int N,M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		// 초기 at = 1, depth = 0;
		dfs(1,0);
		System.out.println(sb);
		
	}
	
	public static void dfs(int at, int depth) {
		/*
		 * 깊이가 최대 깊이일 경우
		 * 더이상 탐색할 자식노드는 없으므로 return 해준다
		 */
		if(depth == M) {
			for(int i =0; i<M; i++) { // arr이라는 배열의 데이터를 0부터 마지막까지 val이라는 곳에 대입한다
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		/*
		 * 깊이를 1씩 증가시키면서 DFS를 
		 * 재귀호출한다
		 */
		for(int i=at; i<=N; i++	) {
			arr[depth]=i;
			dfs(i, depth+1);
		}
	}
}
/*
 * ex) N = 4 , M = 2
 * 1. i = at , i = 1 ~ i = N, i = 4
 * arr[0] = 1;
 * dfs(1, 0+1);
 * 
 * 2. i = 2, 
 * arr[1] = 2;
 * dfs(2, 1+1);
 * 
 * 2번을 마치고 depth가 M과 같은 2가된다.
 * 
 * 3. i = 3;
 * arr[2] = 3;
 * dfs(3, 2+1);
 * 
 * 4. i = 4;
 * arr[3] = 4;
 * dfs(4, 3+1);
*/