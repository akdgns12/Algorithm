package 매일코딩;

public class 방문길이 {
	// 프로그래머스 lv2 / 구현인데 BFS느낌 / 범위체크 밑 좌표 설정 연습
	class Solution {
		static int[] dx = {0,0,1,-1}; // U D R L
		static int[] dy = {-1,1,0,0};
		// 범위체크 주의! 그냥 2차원으로 하면 안됨. -> 지나온 길이기 때문에 이동하기 전 좌표 + 이동한 후 좌표 둘다 체크해줘야됨
		static boolean[][][][] visited = new boolean[11][11][11][11];
		
		public int solution(String dirs) {
			int answer = 0;
			int x = 0;
			int y = 0;
			int nx = 5;
			int ny = 5;
			
			int index = 0;
			for(int i=0; i<dirs.length(); i++) {
				x = nx;
				y = ny;
				
				char command = dirs.charAt(i);
				if(command == 'U') {
					index = 0;
				}else if(command == 'D') {
					index = 1;
				}else if(command == 'R') {
					index = 2;
				}else {
					index = 3;
				}
				
				// index에 맞는 방향따라 위치이동
				nx += dx[index];
				ny += dy[index];
				
				// 범위 검사 -> 범위를 벗어나면
				if(nx < 0 || ny < 0 || nx > 10 || ny > 10) {
					// 이동하기 전의 위치로 원위치
					nx -= dx[index];
					ny -= dy[index];
					continue;
				}
				
				// 방문처리
				if(!visited[x][y][nx][ny] && !visited[nx][ny][x][y]) {
					// 점이아니라 지나온 길이기 때문에 양방향 검사 해줘야함
					visited[x][y][nx][ny] = true;
					visited[nx][ny][x][y] = true;
					answer++;
				}
			}
			return answer;
		}
	}
}
