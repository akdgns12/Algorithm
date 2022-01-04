package 매일코딩;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
// 1. 유니온 파인드란?
/*
 * 대표적 그래프 알고리즘으로 '합집합 찾기'라는 의미를 가지고 있다.
 * 상호 배타적 집합이라고도 한다.
 * 여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘
 * 2가지 연산으로 이루어져 있다.
 * - Find : x가 어떤 집합에 포함되어 있는지 찾는 연산
 * - Union : x와 y가 포함되어 있는 집합을 합치는 연산
 */
// 1. parent[] 배열을 초기화 해줍니다.
// 2. find(), union(), isSameParent() 메소드를 만들어 줍니다.
// 3. 여기서 isSameParent()는 임의의 이름으로 만든 함수명.. find(), union() 메소드의 작동 원리만
//    파악해도 충분히 풀 수 있다. 
public class 집합의표현_유니온파인드 {
	public static int[] parent;
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		// 같은 부모를 가지고 있지 않을 떄
		if(x != y) {
			// y가 x보다 크다는 것을 가정한다면 아래와 같이 표현
			parent[y] = x;
		}
	}
	// 같은 부모 노드를 가지는지 확인
	public static void isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(a == 0) {
				union(x,y);
			}else {
				isSameParent(x,y);
			}
		}
	}
}
