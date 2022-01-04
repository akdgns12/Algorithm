package 매일코딩;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 1. 드래곤 커브를 구하는 함수
 * 2. 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인지 확인하는 함수
 */

public class 드래곤커브 {
	static int N; // 드래곤 커브의 개수
	static int x,y; // 드래곤 커브의 시작점
	static int d; // 시작방향 
	static int[] dx = {1, 0, -1, 0}; // 동 : x++ 북: y-- 서 : x-- 남 : y++
	static int[] dy = {0, -1, 0, 1};
	static int g; // 세대
	static boolean[][] map; // 드래곤 커브가 들어가면 해당 꼭짓점(y,x)는 true
	static ArrayList<Integer> directions; // 선들의 방향을 저장할 List
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 드래곤 커브의 개수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken()); 
				y = Integer.parseInt(st.nextToken()); // x,y 드래곤 커브의 시작점
				d = Integer.parseInt(st.nextToken()); // 방향 
				g = Integer.parseInt(st.nextToken()); // 세대
				
				dragonCurve();
		} // end of input
		
		int result = getSquareCnt();
		System.out.println(result);
	}
	
	// 드래곤 커브 그리기
	public static void dragonCurve() {
		// 초기화
		directions = new ArrayList<>();
		directions.add(d); // 처음 방향 넣기
		
		// 드래곤 커브가 그려지는 선 방향 저장하기
		int dir;
		// g세대까지 반복
		while(g --> 0) {
			// 전 세대의 영향을 받으며 stack과 같이 쌓여지므로 뒤에서부터 get
			for(int i=directions.size()-1; i>=0; i--) {
				dir = (directions.get(i) + 1) % 4;
				directions.add(dir);
			}
		}
		
		//map에서 드래곤 커브가 지나는 꼭짓점 그리기
		int nx, ny;
		int cx = x;
		int cy = y;
		map[x][y] = true;
		
		for(int i=0; i<directions.size(); i++) {
			dir = directions.get(i);
			
			nx = cx + dx[dir];
			ny = cy + dy[dir];
			
			map[nx][ny] = true;
			
			// 계속 이어서 그려가는 것이므로 cx, cy를 바꿔줘야함
			cx = nx;
			cy = ny;
		}
	}
	
	public static int getSquareCnt() {
		int cnt = 0;
		
		for(int i=0; i<100; i++) {// y축
			for(int j=0; j<100; j++) { // x축
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					cnt++;
			}
		}
		return cnt;
	}

}
