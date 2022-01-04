package �ϵ��ھ�͵�;

import java.util.Arrays;

public class ���ڵ�_62Unique_Paths {
	public int uniquePaths(int m, int n) {
		int map[][] = new int[m][n];
		
		// ���� ���ο� ���� ���δ� 1�� �ʱ�ȭ
		Arrays.fill(map[0], 1);
		
		for(int i=1; i<m; i++)
				map[i][0] = 1;
		
		//�밢�� �� ���ؼ� ��ã��
		for(int i=1; i<m; i++)
			for(int j=1; j<n; j++)
				map[i][j] = map[i-1][j] + map[i][j-1];
		
		return map[m-1][n-1];
	}
}
