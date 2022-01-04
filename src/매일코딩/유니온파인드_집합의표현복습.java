package 매일코딩;

import java.util.Scanner;

public class 유니온파인드_집합의표현복습 {
	static int n,m;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int command = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(command == 0) {
				Union(a,b);
			}else {
				isSameParent(a,b);
			}
		}
		
		
	}
	public static int find(int x) {
		if(x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	public static void Union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static void isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
