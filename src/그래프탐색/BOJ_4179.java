package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
	// 불! / 골4 / bfs / 불과 사람 동시에 퍼지도록 움직이게 하는 것이 관건인 문제
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int Sx,Sy,Fx,Fy;
	static Queue<Node> man = new LinkedList<>();
	static Queue<Node> fire = new LinkedList<>();
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		// #:벽, .:지나갈 수 있는 공간, J:지훈이의 초기위치(지나갈 수 있는 공간), F:불이난 공간
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					visited[i][j] = true;
					man.offer(new Node(i,j));
					map[i][j] = '.';
				}else if(map[i][j] == 'F') {
					visited[i][j] = true;
					fire.offer(new Node(i,j));
				}
			}
		}
		
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
	}
	
	public static void bfs() {
		// 불부터 이동(중요)
		int cnt = 0;
		while(!man.isEmpty()) {
			int fs = fire.size();
			
			for(int f=0; f<fs; f++) {
				Node node = fire.poll();
				
				for(int i=0; i<4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= R || ny >= C
							|| map[nx][ny] != '.') continue;
					
					map[nx][ny] = 'F';
					fire.offer(new Node(nx,ny));
				}
			}
			
			int ms = man.size();
			
			for(int m=0; m<ms; m++) {
				Node node = man.poll();
				
				for(int i=0; i<4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					
					// 종료 조건
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
						ans = cnt++;
						return;
					}
					
					if(visited[nx][ny] || map[nx][ny] != '.') 	continue;
					
					visited[nx][ny] = true;
					man.offer(new Node(nx, ny));
				}
			}
			cnt++;
		}
		
	}
	
	public static boolean check(int nx, int ny) {
		if((nx == 0 && ny == 0) || (nx == R-1 && ny == 0) ||
				(nx == 0 && ny == C-1) || (nx == R-1 && ny == C-1)) {
			return true;
		}
		return false;
	}
	
	static class Node{
		int x,y;
		
		public Node(int x, int y) { // fire일떄의 생성장
			this.x = x;
			this.y = y;
		}
	}
}
