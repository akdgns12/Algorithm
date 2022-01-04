package 하드코어스터디;

import java.util.Arrays;

public class 릿코드_62Unique_Paths {
	public int uniquePaths(int m, int n) {
		int map[][] = new int[m][n];
		
		// 왼쪽 세로와 위쪽 가로는 1로 초기화
		Arrays.fill(map[0], 1);
		
		for(int i=1; i<m; i++)
				map[i][0] = 1;
		
		//대각선 값 더해서 길찾기
		for(int i=1; i<m; i++)
			for(int j=1; j<n; j++)
				map[i][j] = map[i-1][j] + map[i][j-1];
		
		return map[m-1][n-1];
	}
}
