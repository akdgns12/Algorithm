package DP;

public class 가장큰정사각형 {
	class Solution
	{
	    public int solution(int [][]board)
	    {
	        int answer = 0;

			int row = board.length;
			int col = board[0].length;
			int[][] map = new int[row+1][col+1];
			
			//새로운 배열 생성
			for(int i=0; i<row; i++) 
				for(int j=0; j<col; j++) 
					map[i+1][j+1] = board[i][j];
			
			int max = 0;
			
			//만들 수 있는 정사각형 검사
					for(int i=1; i<=row; i++) {
						for(int j=1; j<=col; j++) {
							/* 2*2 사각형의 우측하단 꼭짓점을 기준으로 정사각형이 되는지 체크한다
							 * 
							 * 현재 값이 1인경우 좌, 상, 좌상 체크
							 * 값이 모두 1인경우 정사각형을 만들 수 있음
							 */
							if(map[i][j] == 1) {
								int left = map[i-1][j]; // 좌측 값
								int up = map[i][j-1]; // 상단 값
								int leftUp = map[i=1][j-1]; // 좌측상단(대각선) 값
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
