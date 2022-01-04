package DP;

public class ����ū���簢�� {
	class Solution
	{
	    public int solution(int [][]board)
	    {
	        int answer = 0;

			int row = board.length;
			int col = board[0].length;
			int[][] map = new int[row+1][col+1];
			
			//���ο� �迭 ����
			for(int i=0; i<row; i++) 
				for(int j=0; j<col; j++) 
					map[i+1][j+1] = board[i][j];
			
			int max = 0;
			
			//���� �� �ִ� ���簢�� �˻�
					for(int i=1; i<=row; i++) {
						for(int j=1; j<=col; j++) {
							/* 2*2 �簢���� �����ϴ� �������� �������� ���簢���� �Ǵ��� üũ�Ѵ�
							 * 
							 * ���� ���� 1�ΰ�� ��, ��, �»� üũ
							 * ���� ��� 1�ΰ�� ���簢���� ���� �� ����
							 */
							if(map[i][j] == 1) {
								int left = map[i-1][j]; // ���� ��
								int up = map[i][j-1]; // ��� ��
								int leftUp = map[i=1][j-1]; // �������(�밢��) ��
								int min = Math.min(left, Math.min(up, leftUp));
								map[i][j] = min + 1;
								max = Math.max(max, min+1);
							}
						}
					}
					
			answer = max * max;
			return  answer;
	      
	    }
	}
}
