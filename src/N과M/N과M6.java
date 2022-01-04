package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ_15655
/*
 * N개의 자연수 중에서 M개를 고른 수열
 * 오름차순
 * 중복되는 수열 걸러야 한다.
 * 출력하는 원소 모두 중복되면 안된다
 * 메서드의 매개변수를 원소 시작값과 출력을 위한 count 2 개로 한다
 * for문의 시작원소를 start로 하여 중복하지 않도록 한다
 */
public class N과M6 {
	
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
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == M) {
			for(int val : result) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
		}else {
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {	
				visited[i] = true;			// ex) 4,2  : 9 8 7 1
				result[depth] = arr[i];      // 정렬 후 arr[] = {1, 7, 8, 9}
				dfs(i+1, depth+1);
				visited[i]=false;
				}
			}
		}
	}
}
