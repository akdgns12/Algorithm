package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M7 {
	/*
	 *  N개의 자연수는 모두 다른 수 
	 *  같은 수 여러번 골라도 된다.
	 */
	static int N,M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		result = new int[M];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs(0);
		System.out.println(sb);
		
}
	public static void dfs(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			result[depth] = arr[i];
			dfs(depth+1);
		}
	}
}
