package ��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N��M2 {
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	/*
	 * ���̰� M�� ����
	 * 1. 1~N���� �ڿ��� �� �ߺ����� M���� ����
	 * 2. �� ������ ��������
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		
		dfs(0, 0);
	}
	
	public static void dfs(int depth, int start) {
		if(depth == M) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				//visited[i] = true;
				arr[depth] = i+1;
				dfs(depth+1, i+1);
				//visited[i] = false;
			}
		}
	}
}
