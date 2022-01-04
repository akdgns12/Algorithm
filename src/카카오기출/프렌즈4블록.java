package 카카오기출;

public class 프렌즈4블록 {
		 public int solution(int m, int n, String[] board) {
		        int answer = 0;
		      char[][] map = new char[n][m];
				
				for(int i=0; i<board.length; i++) {
					for(int j=0; j<board[i].length(); j++) { 
						map[j][i] = board[i].charAt(j);
					}
				}
				
		        
				boolean flag = true;
				
				while(flag) { 
					flag = false; 
					
					int[][] visited = new int[n][m]; 
		            
					for(int i=0; i<map.length-1; i++) {
						for(int j=0; j<map[i].length-1; j++) {
							if(map[i][j] == '0') continue;
							
							//4블록 검사
							 if (map[i][j] == map[i+1][j] && map[i+1][j] == map[i+1][j+1]
			                            && map[i][j+1] == map[i+1][j+1] && map[i][j+1] == map[i][j])
							 {
								//지워줄 배열을 셋팅
								visited[i][j] =1;
								visited[i+1][j]=1;
								visited[i+1][j+1]=1;
								visited[i][j+1]=1;
								
								flag = true; //지워줄 블록이 있으므로
							}
						}
					}
					
					
					for(int i=0; i<visited.length; i++) {
						for(int j=0; j<visited[i].length; j++) {
							if(visited[i][j]==1) { //지워줄 블록이면
								answer++;
								
								for(int k=j-1; k>=0; k--) {	
								map[i][k+1] = map[i][k]; 
								map[i][k] = '0'; 
								}
							}
						}
					}
				}
		        return answer;
	}
}
