package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//
public class 탈출{
	static class Point{
		int x, y, time;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int R,C;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Point> biber = new LinkedList<Point>();
	static Queue<Point> water = new LinkedList<>();
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') { // 비버 시작위치
					biber.add(new Point(i,j,0));
				}else if(map[i][j] == '*') { // 물일때
					water.add(new Point(i,j));
				}
			}
		}
		
		bfs();
		
		System.out.println(answer == Integer.MAX_VALUE ? "KARATUS" : answer);
	}
	
	public static void bfs() {
		
		while(!biber.isEmpty()) {
			int len = water.size();
			// 물퍼트리기
			for(int i=0; i<len; i++) {
				Point p = water.poll();
				int x = p.x;
				int y = p.y;
				
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];					          
					// 범위를 벗어나면 skip
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
					// 인접한 좌표가 도착지이거나 벽이거나 물이 차있는지역이라면 skip
					if(map[nx][ny] == 'D' || map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
					map[nx][ny] = '*';
					water.add(new Point(nx, ny)); 
				}
			}
			
			len = biber.size();
			for(int i=0; i<len; i++) {
				// 고슴도치 이동
				Point p = biber.poll();
				int x = p.x;
				int y = p.y;
				int time = p.time;
				
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
					if(map[nx][ny] == 'D') {
						answer = Math.min(answer, time+1);
						return;
					}
					else if(map[nx][ny] == '.') {
						map[nx][ny] = 'S';
						biber.add(new Point(nx, ny, time+1));
					}
				}
			}
	
		}
	}
}
