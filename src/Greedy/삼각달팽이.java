package Greedy;

public class �ﰢ������ {
		public int[] solution(int n) {
	        int[] answer = new int[(n*(n+1))/2];
	        int[][] matrix = new int[n][n];

	        int x = -1, y = 0;
	        int num = 1;
	        
	        //���� for������ ������ �迭 ��ȸ
	        for (int i = 0; i < n; i++) {
	            for (int j = i; j < n; j++) { //�ݺ��Ǵ� ���ڴ� 1�� �����ϹǷ� j=0�� �ƴ� i���� ���� 	
	                if (i % 3 == 0) { //�Ʒ�
	                    x++;
	                } else if (i % 3 == 1) { //������
	                    y++;
	                } else if (i % 3 == 2) { //�밢������ 3���� �ݺ�
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
