package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M3 {
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		// 깊이가 M이랑 같아지면 출력후 return
				if (depth == M) {
					for (int i = 0; i < M; i++) {
						sb.append(arr[i] + " ");
					}
					sb.append('\n');
					return;
				}
		 
				for (int i = 1; i <= N; i++) {
					arr[depth] = i;
					dfs(depth + 1);
				}
			}
}
