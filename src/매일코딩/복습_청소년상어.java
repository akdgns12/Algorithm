package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_청소년상어 {
	static class Fish {
		int id, x, y, dir;
		int alive; // 0 : 죽음, 1: 살아있음
		
		Fish(int id, int x, int y, int dir, int alive){
			this.id = id;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.alive = alive;
		}
	}
	static int[][] map;
	static Fish[] fish; // 물고기 정보 저장
	static int[] dx = {-1,-1,0,1,1,1,0,-1}; // 북 부터 반시게방향으로 팔방
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[4][4];
		fish = new Fish[17];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int id = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				fish[id] = new Fish(id, i, j, dir, 1);
				map[i][j] = id; // map에 물고기 번호 저장
			}
		}
		
		int sx = 0, sy = 0; // 초기 상어 위치
		int sd = fish[map[0][0]].dir; // 초기 상어의 방향
		int eat = map[0][0]; // 먹은 물고기 합 저장 변수 - (0,0) 물고기 먹음
		
		fish[map[0][0]].alive = 0; // (0,0) 물고기 죽음
		map[0][0] = -1; // 상어가 있는 위치는 -1로 설정
		
		dfs(sx, sy, sd, eat);
		
		System.out.println(ans);
	}
	
	public static void dfs(int sx, int sy, int sd, int eat) {
		ans = Math.max(ans, eat);
		
		//map 배열 복사
		int[][] tempMap = new int[map.length][map.length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		// Fish배열 복사
		Fish[] tempFish = new Fish[fish.length];
		for(int i=0; i<17; i++) {
			tempFish[i] = new Fish(fish[i].id, fish[i].x, fish[i].y, fish[i].dir, fish[i].alive);
		}
		
		// 물고기 이동
		moveFish();
		
		// 상어이동
		for(int i=0; i<4; i++) {
			int nx = sx + dx[sd] * i;
			int ny = sy + dy[sd] * i;
			
			// 경계를 벗어나지 않고, 물고기가 없는 빈칸이 아닐 경우
			if(nx >= 0 && ny >=0 && nx < 4 && ny < 4 && map[nx][ny] != 0) {
				int eatFish = map[nx][ny];
				int nd = fish[eatFish].dir;
				map[sx][sy] = 0;
				map[nx][ny] = -1;
				fish[eatFish].alive = 0;
				
				dfs(nx, ny, nd, eat+eatFish);
				
				fish[eatFish].alive = 1; // 물고기 상태, 상어의 위치 원래대로 되돌리기
				
				map[sx][sy] = -1;
				map[nx][ny] = eatFish;
			}
		}
		
		/*
		 * 무작정 DFS를 돌리면 원하는 결과 얻을 수 없다
		 * DFS를 돌면서 물고기가 이동하고, 상어가 이동한다
		 * 이 과정에서 물고기가 이동하고, 상어가 이동하낟.
		 * 또한 물고기의 상태 역시 살았느냐 죽었느냐로 바뀌게 된다.
		 * DFS는 재귀를 통해 진행되기 때문에, 한 경우를 체크하고 그 다음 경우를 체크하기 위해서
		 * 실행했던 내용을 취소함으로써 되돌려 놓는 과정이 필요하다.
		 * 즉, 맵과 물고기의 상태를 기억해놓고, 다시 이전의 상태로 되돌려 놓는 과정이 필요
		 */
		
		// 맵 상태, 물고기 정보 되돌리기
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				map[i][j] = tempMap[i][j];
			}
		}
		
		for(int i=0; i<17; i++) {
			tempFish[i] = new Fish(tempFish[i].id, tempFish[i].x, tempFish[i].y, tempFish[i].dir, tempFish[i].alive);
		}
	}
	
	public static void moveFish() {
		for(int i=1; i<17; i++) { // i는 현재 물고기 번호
			if(fish[i].alive == 0) { //죽은 물고기라면 넘김
				continue;
			}
			
			int cnt = 0;
			int dir = fish[i].dir; // 현재 i번째 물고기의 방향
			int nx = 0, ny = 0; // 물고기가 이동할 칸의 x,y 값
			
			while(cnt < 8) { // 이동할 수 있는 위치를 찾을때까지 45도 방향 바꾸며 반복
				dir %= 8; // 방향 +1로 범위 넘어가는걸 처리하기 위한 나머지 연산
				fish[i].dir = dir;
				
				nx = fish[i].x + dx[dir]; // 방향에 맞게 좌표이동
				ny = fish[i].y + dy[dir];
				
				// 이동할 위치에 상어가 없고, 경계를 넘지 않는다면 이동가능
				if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != -1) {
					if(map[nx][ny] == 0) { //이동할 위치가 빈칸이라면
						map[fish[i].x][fish[i].y] = 0; // 기존 위치 빈칸으로
						
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = 1;
					}else { // 이동할 위치에 다른 물고기가 있는경우
						
						// 바꿀 물고기 위치 변경
						int changeFish = fish[map[nx][ny]].id;
						
						fish[changeFish].x = fish[i].x;
						fish[changeFish].y = fish[i].y;
						map[fish[changeFish].x][fish[changeFish].y] = changeFish;
						
						// 현재 물고기 위치 변경
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					}
					break;
				}else {
					dir++;
					cnt++;
				}
				
			}
			
		}
	}
}
