package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 수의 범위는 0~20
 * 부등호를 넣어 식을 만들 수 있지만 계산 과정 중 값이 음수가 되어서는 안됨.
 * 조건을 만족하고 올바른 등식의 수 구하는 프로그램
 *  */
// DP 문제다.
// N-1개의 수를 연산한 결과를 N번째 수와 비교해서 같은지 비교해야한다.
public class BOJ_1학년 {
	
	static int N;
	static int[] operand;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		operand = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new long[21][100]; // i: 0~20까지 등식에 올 수 있는 수
								// j: 3~100까지 등식에 들어가는 숫자의 개수
		
		for(int i=0; i<=20; i++) {
			for(int j=0; j<100; j++) {
				dp[i][j] = -1; 
			}
		}
		
		System.out.println(recursion(operand[0], 0));
	}
	
	public static long recursion(int sum, int idx) {
		// sum의 범위는 0부터 20까지.
		if(sum < 0 || sum > 20) {
			return 0;
		}
		
		// operand[0] ~ operand[N -2] 까지 연산을 완료했으면
		// 여태까지의 값과 operand[N - 1]을 비교해야함.
		if(idx == N - 2) {
			return (sum == operand[N - 1]) ? 1 : 0;
		}
		
		if(dp[sum][idx] != -1) {
			return dp[sum][idx];
		}
		
		dp[sum][idx] = 0;
		
		return dp[sum][idx] += recursion(sum + operand[idx+1], idx + 1) + recursion(sum - operand[idx+1], idx + 1);
	}
}
