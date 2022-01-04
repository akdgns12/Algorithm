package 매일코딩;
// 드래곤 커브를 그리는 규칙 이번엔 이해해서 코드 짜보기
// 다음 세대를 갈때 전 세대의(가장 늦게 들어온 것부터 첫 번째까지) 영향을 받는다.
// 이 때 반시계방향으로 방향이 바뀐다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 로직 
 * 1. 드래곤 커브의 갯수만큼 정보들을 받게 되는데
 * 1-1 각 드래곤 커브마다 세대까지 map에 그려줘야 한다.(드래곤 커브가 가지고 있는 곡짓점을 true로 만들어줘야 한다. map[x][y] = true)
 * 1-2 이때 드래곤 커브를 그리는데 규칙이 있는데 다음 세대를 갈 때 전 세대의(가장 늦게 들어온 것 부터 첫 번째까지)영향을 받는 것. 이 때
 * 반시계 방향으로 방향이 바뀐다.
 * 1-3 따라서 드래곤 커브를 그리기 위해 해당 방향들을 list에 다 기억하고 있다가 주어진 x,y에 list만큼 그려준다.
 * 1-4 드래곤 커브 갯수 N만큼 드래곤 커브를 map에 그려준다.
 * 2. map에 드래곤 커브를 다 그리고 나면 1x1 정사각혀의 네 꼭짓점이 전부 true인 경우의 갯수를 찾으면 된다.
 */

public class 복습_드래곤커브 {
	static int N; // 드래곤 커브의 갯수
	static int x,y; // 드래곤 커브의 시작점
	static int d; // 시작방향 (0~3), 0: 동(X++), 1: 북(y--), 2: 서(x--), 3: 남(y++)
	static int g; // 세대(0~10)
	static boolean[][] map = new boolean[101][101]; // 드래곤 커브가 들어가면 해당 꼭지점(x,y)는 true
	static List<Integer> directions; // 선들의 방향을 저장할 List
	
	//0: 동(X++), 1: 북(y--), 2: 서(x--), 3: 남(y++)
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			dragonCurve();
		}// end of input
		int result = getSquareCnt();
		System.out.println(result);
	}
	
	public static void dragonCurve() {
		// 초기화
		directions = new ArrayList<>();
		directions.add(d); // 초기 방향 넣기
		
		// 드래곤 커브가 그려지는 방향 저장하기
		int dir;
		// g 세대까지 반복
		while(g --> 0) {
			// 전 세대의 영향을 받으며 stack과 같이 쌓여지므로 뒤에서부터 get
			// k세대 드래곤 커브 = k-1세대 드래곤커브의 방향의 반시계방향으로 그려진다.
			for(int i=directions.size()-1; i>=0; i--) {
				dir = (directions.get(i) + 1) % 4; //
				directions.add(dir);
			}
		}
		
		// map에서 드래곤 커브가 지나는 꼭지점 그리기
		int nx, ny;
		int cx = x;
		int cy = y;
		map[x][y] = true;
		for(int i=0; i<directions.size(); i++) {
			dir = directions.get(i);
			
			nx = cx + dx[dir];
			ny = cy + dy[dir];
			
			map[nx][ny] = true;
			
			// 계속 이어서 그려가는 것이므로 cx, cy를 바꿔야함
			cx = nx;
			cy = ny;
		}
	}
	
	public static int getSquareCnt() {
		int cnt = 0;
			
		for(int i=0; i<100; i++) {// y축
			for(int j=0; j<100; j++) {// x축
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					cnt++;
			}
		}
		
		return cnt;
	}
	
	
	
	
}
