package 구현;

import java.util.Scanner;
//
public class BOJ_숫자정사각형 {
	// 완탐 & 구현 / DP문제인 가장 큰 정사각형 찾기와 비슷한 유형이나 이건 완탐으로 돌아감
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		// 먼저 주어진 N,M 중 더 작은 값을 찾는다
		// 문제에서 3X5로 주어진 경우, 최대로 가능한 정사각형은 3X3이므로,
		// 더 작은 3까지만 반복하면 되기 때문에.
		final int MIN = Math.min(N, M);
		int area = 0;
		int maxArea = 0;
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<MIN; k++) { // 배열 범위 이내
					if(i+k < N && j+k < M) {
					// 4개의 꼭짓점이 정사각형이 되는 조건
					if(map[i][j] == map[i+k][j] && map[i][j] == map[i][j+k] 
							&& map[i][j] == map[i+k][j+k]) {
						area = (k+1) * (k+1);
						maxArea = Math.max(maxArea, area);
						}
					}
				}
			}
		}
		System.out.println(maxArea);
	}
}
