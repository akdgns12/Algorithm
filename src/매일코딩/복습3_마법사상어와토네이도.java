package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습3_마법사상어와토네이도 {
	static int N;
	static int[][] map;
	static int[] dx = {0,1,0,-1}; // 토네이도가 움직이는 x방향
	static int[] dy = {-1,0,1,0}; // 토네이도가 움직이는 y방향
	static int[] dc = {1,1,2,2}; // 토네이도가 움직이는 칸 수 
	static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0},{-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0},{1,1,0,0,0,0,-1,-1,-2}}; // 모래가 퍼지는 x방향
	static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},{-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}}; // 모래가 퍼지는 y방향
	static int[] sandRatio = {1,1,2,7,7,2,10,10,5}; // 모래 흩뿌려지는 비율
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = calculrateOfSand(N/2, N/2); // 시작점인 map의 중심좌표 전달
		System.out.println(result);
	}
	
	public static int calculrateOfSand(int x, int y) {
		int totalOutSand = 0;
		
		int curX = x;
		int curY = y;
		
		while(true) {
			for(int d=0; d<4; d++) {
				for(int moveCount = 0; moveCount < dc[d]; moveCount++) {
					// 현재위치에서 이동
					int nx = curX + dx[d];
					int ny = curY + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
						return totalOutSand;
					}
					
					// 모래 흩뿌리기
					int sand = map[nx][ny];
					map[nx][ny] = 0;
					int totalSpread = 0;
					
					for(int spread=0; spread<9; spread++) {
						int sandX = nx + dsx[d][spread];
						int sandY = ny + dsy[d][spread];
						int spreadAmount = (sand * sandRatio[spread]) / 100;
						
						if(sandX < 0 || sandY < 0 || sandX >= N || sandY >= N) {
							totalOutSand += spreadAmount;
						}
						else {
							map[sandX][sandY] += spreadAmount; 
						}
						
						totalSpread += spreadAmount;
					}
						// 알파
						int alphaX = nx + dx[d];
						int alphaY = ny + dy[d];
						int alphaAmount =  sand - totalSpread;
						
						if(alphaX < 0 || alphaY < 0 || alphaX >= N || alphaY >= N) {
							totalOutSand += alphaAmount;
						}
						else {
							map[alphaX][alphaY] += alphaAmount;
						}
						
						curX = nx;
						curY = ny;
					}	
				}
				
				// 횟수 업데이트
				for(int index=0; index<4; index++) {
					dc[index] += 2;
				}
			}
		}
	}

