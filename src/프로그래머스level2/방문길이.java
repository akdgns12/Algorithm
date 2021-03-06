package 프로그래머스level2;
/*
 * U: 위쪽으로 한 칸 가기
 * D: 아래쪽으로 한 칸 가기
 * R: 오른쪽으로 한 칸 가기
 * L: 왼쪽으로 한 칸 가기
 * 
 * 범위 벗어나는 명령어는 continue
 * 중복 제거한 나머지 길이
 */
/*
public class 방문길이 {
	//위, 아래, 오른쪽, 왼쪽순서
	static int[] intx = {0,0,1,-1};
	static int[] inty = {1,-1,0,0};
	
	public int solution(String dirs) {
		int answer = 0;
		
		boolean[][][][] visited = new boolean[11][11][11][11];
		
		char[] dirss = dirs.toCharArray();
		
		int index = 0;
		
		int x = 0;
		int y = 0;
		
		int nextx = 5;
		int nexty = 5;
		
		for(int i=0; i<dirss.length; i++) {
			int dir = dirss[i];
			
			if(dir == 'U') index = 0;
			else if(dir == 'D') index = 1;
			else if(dir == 'R') index = 2;
			else if(dir == 'L') index = 3;
			
			x = nextx;
			y = nexty;
			
			nextx += intx[index];
			nexty += inty[index];
			
			if(nextx < 0 || nextx > 10 || nexty < 0 || nexty > 10) {
				
				nextx -= intx[index];
				nexty -= inty[index];
				continue;
			}
			
			if(!visited[x][y][nextx][nexty]) {
				visited[x][y][nextx][nexty] = true;
				visited[nextx][nexty][x][y] = true;
				answer++;
			}
		}
		
		return answer;
	}
}
*/
class 방문길이{
	// U,D,R,L - 상,하,좌,우
		static int[] dx = {0,0,1,-1};
		static int[] dy = {1,-1,0,0};
		//맵의 크기 = -5 ~ 5까지이므로 11X11
		static boolean[][][][] visited = new boolean[11][11][11][11];
		
		public int solution(String dirs) {
			int answer = 0;
			/* x,y = 캐릭터가 이동하기 전 위치,
			 *  nextX, nextY = 캐릭터가 이동한 후 위치 */
			int x = 0;
			int y = 0;
			int nx = 5;
			int ny = 5;
			int index = 0;
			
			for(int i=0; i<dirs.length(); i++) {
				char c = dirs.charAt(i);
				//캐릭터 현재위치 저장
				x = nx;
				y = ny;
				if(c == 'U') {
					index = 0;
				}else if(c == 'L') {
					index = 1;
				}else if(c == 'R') {
					index = 2;
				}else if(c == 'D') {
					index = 3;
				}	
				
				//U,D,R,L에 맞는 캐릭터 위치 이동
				nx += dx[index];
				ny += dy[index];
				
				//이전에 움직인 범위에 의해 캐릭터의 위치가 지도를 벗어났을 경우
				if(nx < 0 || ny < 0 || nx > 10 || ny > 10) {
					//다시 캐릭터를 전의 위치로 이동
					nx = x;
					ny = y;
					continue;
				}
							
				//캐릭터가 처음 걸어본 길일 경우
				if(!visited[x][y][nx][ny] && !visited[nx][ny][x][y] ) {
					//걸어온 길 체크(점이 아닌 길이기 때문에 양방향으로 체크한다)
					visited[x][y][nx][ny] = true;
					visited[nx][ny][x][y] = true;
					answer++;
				}
			}
			
			
			
	        return answer;
	}
}