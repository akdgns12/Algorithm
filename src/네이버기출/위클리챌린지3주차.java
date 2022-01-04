package 네이버기출;

public class 위클리챌린지3주차 {
	// 프로그래머스 위클리 챌린지 3주차 / 퍼즐조각채우기 /
	static int[][] map;
	static int[] dx = {-1,,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public int solution(int[][] game_board, int[][] table) {
		int answer = -1;
		
		for(int i=0; i<game_board.length; i++) {
			for(int j=0; j<game_board[0].length; j++) {
				map[i][j] = game_board[i][j];
				
				if(map[i][j] == 0) {
					
				}
			}
		}
		
		return answer;
	}
}
