package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹 카테고리의 첫 문제
// 되추적인데, 좀 더 알고리즘적으로 설명하자면, 어떤 노드의 '유망성'을 판단한 뒤, 해당 노드가 유망하지 않다면 붐 노드로 돌아가
// 다른 자식 노드를 찾는 방법이다. 즉 모든 경우의 수를 찾아보지만, 그 중에서도 가능성만 있는 경우의 수만 찾아보는 방법
// 브루트 포스 = 말 그대로 '모든 경우의 수'를 찾아보는 것
/*
public class NM1 {
	
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 문자열 분리를 위해 StringTokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		arr = new int[M];
		visit = new boolean[N];
		dfs(N,M,0);
		System.out.println(sb);
	}
	public static void dfs(int N, int M,int depth) {
		if(depth==M) {
			for(int val:arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=i+1;
				dfs(N,M,depth+1);
				visit[i]=false;
	
			}
		}
	}
}*/
public class NM1{
	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth==M) {
			for(int val:arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=i+1;
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}	
}
/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두
구하는 프로그램을 작성하시오
* 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력 : 첫째 줄에 자연수 N과 M이 주어진다.(1<=N<=M<=8)
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는
수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분하여 출력해야 한다.
수열은 사전순을 증가하는 순설 출력해야 한다.
*/