package 프로그래머스level2;
/*
 * 2018 카카오 공채
 * 높이 m , 폭  n
 * 
 */
public class 프렌즈4블록 {
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		/*
		 * 1. 기존에 들어온 1차원 String 배열을 직관적으로 다루기 쉽게
		 * 2차원 char배열로 만든다
		 * 2. 1,1의 요소부터 현재, 아래, 오른쪽, 오른쪽 아래의블록을 검사하고
		 * 3. 4개의 블록을 지우기위한 2차원 boolean배열에 인덱스 셋팅
		 * 4. 1,2부터 다시 현재,아래,오른쪽,오른쪽 아래를 검사하고 2차원
		 * boolean배열에 셋팅
		 * 5. n-1,n-1까지 검사(n까지 검사하면 오른쪽, 오른쪽아래는 어차피 범위 벗어나기때문에 검사할 필요 x)
		 * 6. 검사를 마치면, 다시 for문을 돌면서 2차원 boolean배열을 검사하고,
		 * 7. 이 때, 지워줄 값이 셋팅 되어있는 곳을 지워준다.
		 * 8. 해당 블록을 지우면서 해당 블록보다 위에있는 블록들을 아래로 내려준다
		 * -- 이것이 하나의 작업단위
		 * last. 모든 검사가 끝나면 다시 처음으로 돌아가서 더이상 지워줄 블록이 없을때까지
		 * 작업을 반복한다.
		 */
		char[][] map = new char[n][m];
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length(); j++) { //String에서 char배열로
				map[j][i] = board[i].charAt(j);
			}
		}
		
		boolean flag = true;
		
		while(flag) { //flag false일때까지 계속 반복 (조건(flag)이 true이면 계속반복) 자꾸 헷갈린다 ㅡㅡ
			flag = false; //지워줄 블록이 있는지 체크하기 위함
			
			int[][] visited = new int[n][m]; //지월 줄 블록을 표시할 배열
		
			//현재, 아래, 오른쪽, 오른쪽 아래 블록을 검사
			//현재에서 +1칸을 검사하기 때문에 범위를 배열길이 -1로 잡아줌
			for(int i=0; i<map.length-1; i++) {
				for(int j=0; j<map[i].length-1; j++) {
					if(map[i][j] == '0') continue; //비어있는 블록
					
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
			
			//블록을 지우고, 비어있는 곳을 채워주는 작업
			for(int i=0; i<visited.length; i++) {
				for(int j=0; j<visited[i].length; j++) {
					if(visited[i][j]==1) { //지워줄 블록이면
						answer++;
						
						for(int k=j-1; k>=0; k--) {//현재 블록의 열에 해당하는 부분을 다시 셋팅
							
						map[i][k+1] = map[i][k]; 
						map[i][k] = '0'; //비어있는 블록을 의미
						}
					}
				}
			}
		}
		
		return answer;
	}
	
}
