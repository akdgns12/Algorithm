package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//
public class 벽부수고이동하기_복습 {
	static class Point{
		int x, y;
		int breakWall;
		int cnt;
		public Point(int x, int y, int breakWall, int cnt){
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
			this.cnt = cnt;
		}
	}
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][][] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0); // 시작점부터 탐색
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0,0,1));
		
		visited[x][y][0] = true; 
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == M-1) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int breakWall = p.breakWall;
				int cnt = p.cnt;
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == 1) { // 벽이라면
					if(breakWall == 0 && !visited[nx][ny][1]) { // 벽을 부순적 없다면
						visited[nx][ny][1] = true;
						q.offer(new Point(nx, ny, cnt+1 , 1));
					}
				}else { // 빈 칸
					if(!visited[nx][ny][breakWall]) {
						q.offer(new Point(nx, ny, cnt+1, breakWall));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
