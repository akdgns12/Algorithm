package N과M;


// N과M (5) 백트래킹 문제
// DFS는 현재지점에서 방문할 곳이 있으면 재귀호출을 이용해서 계속 이동하는 것.
// 백트래킹은 DFS에 가지치기를 통해 가도되지 않는 루트는 고려하지 않고 탐색하는 완전탐색 기법
// 입력받은 수들은 오름차순으로 정렬하며
// 방문 배열을 만들어 중복된 수가 없게 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5{
	
	static int N,M;
	static int[] array, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		// 카운트 값이 자연수 M과 같다면
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i] == true) continue; // continue 해당 반복 부분만 탈출하고 다음번 반복을 이어서한다.
			visited[i] = true; // 몇번째 방인지 true false;
			result[depth] = array[i];
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}