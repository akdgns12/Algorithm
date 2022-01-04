package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양팔저울 {
	//BOJ 2629 양팔저울 / 골드 2
	// 추들의 무게와 확인할 구슬들의 무게가 주어질 때
	// 주어진 추만을 사용하여 구슬의 무게를 확인할 수 있는지 판별
	static int chu; // 추의 개수
	static int chuW[]; // 추의 무게
	static int marble; // 구슬 개수
	static int marbleW[]; // 구슬 무게
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		chu = Integer.parseInt(br.readLine());
		for(int i=0; i<chu; i++) {
			st = new StringTokenizer(br.readLine());
			chuW[i] = Integer.parseInt(st.nextToken());
		}
		
		marble = Integer.parseInt(br.readLine());
		for(int i=0; i<marble; i++) {
			st = new StringTokenizer(br.readLine());
			marbleW[i] = Integer.parseInt(st.nextToken());
		}
		// 추의 개수 30, 추 1개의 무게 500 만들 수 있는 최대 무게 15000
		// 구슬의 최대 무게 40,000
		dp = new boolean[chu+1][55001]; 
		
		dfs(0,0);
		
		for(int i=0; i<chu; i++) {
			if(dp[chu][marbleW[i]]) {
				System.out.println("Y");
				continue;
			}
			System.out.println("N");
		}
	}
	
	public static void dfs(int count, int weight) {
		if(dp[count][weight]) return;
		dp[count][weight] = true;
		
		if(count == chu) return;
		
		dfs(count+1, weight); // 1. 추 하나 그대로의 무게
		dfs(count+1, weight + chuW[count]); // 2. 구슬 <-> 추 + 새로운 추
		dfs(count+1, Math.abs(weight - chuW[count])); // 3. 구슬 + 새로운 추 <-> 추
	}
}
