package N°úM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N°úM9{
	
	static int N,M;
	static int[] arr;
	static boolean visited[];
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> set;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		set = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int val : result) {
				sb.append(val).append(' ');
			}
			set.add(sb.toString());
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i])
				visited[i] = true;
				result[depth] = arr[i];
				dfs(depth+1);
				visited[i]=false;
		}
	}
}