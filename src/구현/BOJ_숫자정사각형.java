package ����;

import java.util.Scanner;
//
public class BOJ_�������簢�� {
	// ��Ž & ���� / DP������ ���� ū ���簢�� ã��� ����� �����̳� �̰� ��Ž���� ���ư�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		// ���� �־��� N,M �� �� ���� ���� ã�´�
		// �������� 3X5�� �־��� ���, �ִ�� ������ ���簢���� 3X3�̹Ƿ�,
		// �� ���� 3������ �ݺ��ϸ� �Ǳ� ������.
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
				for(int k=0; k<MIN; k++) { // �迭 ���� �̳�
					if(i+k < N && j+k < M) {
					// 4���� �������� ���簢���� �Ǵ� ����
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
