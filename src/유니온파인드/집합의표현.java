package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {
	// BOJ 1717번 집합의 표현 / 유니온 파인드 /
	static int N,M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(command == 0) {
				union(a,b);
			}else {
				isSameParent(a,b);
			}
		}
		
		
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}
	
	public static void isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
