package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현_유니온파인드_복습 {
	static int n,m;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int a = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				union(x, y);
			}else {
				isSameParent(x,y);
			}
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) 
				return x;
			else 
				return parent[x] = find(parent[x]);
		
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parent[y] = x;
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
