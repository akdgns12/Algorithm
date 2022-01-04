package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	static int N;
	static int[][] map;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기 파이프 위치 map[0][0] = 0, map[0][1] = 1
		// x,y,dir
		// dir 0: 가로, 1: 세로, 2: 대각선
		move(0,1,0); // x, y, dir -> 파이프의 끝이 N-1,N-1에 도착하면 끝
		
		System.out.println(count);
	}
	
	public static void move(int x, int y, int dir) {
		// N*N에 도착하면서 그 위치가 파이프가 없으면
		if(x == N-1 && y == N-1 && map[x][y] != 1) {
			count++;
			return;
		}
		
		// 파이프가 가로일 때
		if(dir == 0) {
			// 가로로 밀 때
			if(isIn(x,y+1) && map[x][y+1] == 0)
				move(x,y+1,0);
			
			// 오른쪽 아래 대각선으로 밀 때
			// 현재위치 오른쪽, 오른쪽 대각선, 아래가 모두 0이면 이동
			if(isIn(x+1,y+1) && map[x][y+1] == 0 && map[x+1][y+1] == 0 && map[x+1][y] == 0)
				move(x+1,y+1,2);
		}else if(dir == 1) { // 파이프가 세로일 때
			// 세로로 밀 때
			if(isIn(x+1,y) && map[x+1][y] == 0) move(x+1,y,1);
			
			// 대각선으로 밀 때
			// 현재위치의 오른쪽, 아래, 대각선
			if(isIn(x+1,y+1) && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0)
				move(x+1,y+1,2);
		}else if(dir == 2) { // 파이프가 대각선일 때
			// 가로로 밀때
			if(isIn(x,y+1) && map[x][y+1] == 0) 
				move(x,y+1,0);
			
			// 세로로 밀 때
			if(isIn(x+1,y) && map[x+1][y] == 0)
				move(x+1,y,1);
			
			// 대각선으로 밀 때
			// 현재위치의 오른쪽, 아래, 대각선검사 
			if(isIn(x+1,y+1) && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0)
				move(x+1,y+1,2);
		}
	}
	
	public static boolean isIn(int x, int y) {
		return (x >= 0 && y >= 0 && x < N && y < N);
	}
}
