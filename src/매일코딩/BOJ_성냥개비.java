package 매일코딩;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_성냥개비 {
	// BOJ 3687 // 네이버 유사문제 
	// 주어진 성냥개비를 모두 사용해서 만들 수 있는 가장 작은 수와 큰수
	/*
	 * 성냥개비
	 * 2개 : 1 / 3개 : 3 / 4개 : 4 / 5개 : 2,3,5 / 6개 : 6,9,0 / 7개 : 8
	 * 
	 * 성냥개비를 가장 적게 사용하는 숫자 : 1 (2개사용)
	 * 성냥개비를 가장 많이 사용하는 숫자 : 8 (7개사용)
	 * 
	 * 가장 큰 숫자 만들기
	 * 홀수개인 경우 : 맨 앞에 홀수(3개)로 만들 수 있는 숫자를 만들고 나머지는 1(2개 사용)으로 채우기
	 * 짝수개인 경우 : 모두 1(2개 사용)로 채우기
	 * 
	 * 가장 작은 숫자 만들기
	 * 2개 : 1
	 * 3개 : 7
	 * 4개 : 4
	 * 5개 : 2 (2, 3, 5 중 가장 작은 숫자)
	 * 6개 : 6 ( 0으로는 시작할 수 없다는 조건)
	 * 7개 : 8
	 * 8개 : 10 (7개를 넘어버림-한자리 숫자 못만듬 / 꼭 2자리 숫자 이상)
	 * 9개 : 18 ( 2개로 1, 나머지 7개로 8)
	 * 10개 : 22 ( 5개로 2 , 5개로 2 / 2개로 1을 만들면 8이 남게됨)
	 */
	static int N;
	static long[] minDp;
	static int M;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase --> 0) {
			N = sc.nextInt();
			
			minDp = new long[101];
			
			Arrays.fill(minDp, Long.MAX_VALUE);
			// i는 성냥 개수 minDp[i] = i로 만들 수 있는 수
			minDp[2] = 1;
			minDp[3] = 7;
			minDp[4] = 4;
			minDp[5] = 2;
			minDp[6] = 6; // 다른 숫자 뒤에 올 때는 0
			minDp[7] = 8;
			minDp[8] = 10;
			
			String[] add = {"1","7","4","2","0","8"};
			//DP[n] = (DP[n-2] + min[2], DP[n-3] + min[3], ..., DP[n-7] + min[7]) 중 가장 작은 값
			for(int i=9; i<=100; i++) {
				//9부터 (7,0) (6,1)
				for(int j=2; j<=7; j++) {
					String line = "" + minDp[i-j] + add[j-2];
					minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
				}
			}
			
			// 가장 큰 수 구하기
			StringBuilder max = new StringBuilder();
			long a = N / 2;
			long b = N % 2;
			
			if(b == 1) {
				max.append("7");
			}else {
				max.append("1");
			}
			
			for(int i=1; i<a; i++) {
				max.append("1");
			}
			
			System.out.println(minDp[N] + " " + max.toString());
		}
	}
}
