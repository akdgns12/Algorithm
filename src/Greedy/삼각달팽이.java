package Greedy;

public class 삼각달팽이 {
		public int[] solution(int n) {
	        int[] answer = new int[(n*(n+1))/2];
	        int[][] matrix = new int[n][n];

	        int x = -1, y = 0;
	        int num = 1;
	        
	        //이중 for문으로 이차원 배열 순회
	        for (int i = 0; i < n; i++) {
	            for (int j = i; j < n; j++) { //반복되는 숫자는 1씩 감소하므로 j=0이 아닌 i부터 시작 	
	                if (i % 3 == 0) { //아래
	                    x++;
	                } else if (i % 3 == 1) { //오른쪽
	                    y++;
	                } else if (i % 3 == 2) { //대각선까지 3번씩 반복
	                    x--;
	                    y--;
	                }
	                matrix[x][y] = num++;
	            }
	        }
	        
	        int k = 0;
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < n; j++) {
	                if(matrix[i][j] == 0) 
	                	break;
	                answer[k++] = matrix[i][j];
	            }
	        }

	        return answer;
	    }
	}
