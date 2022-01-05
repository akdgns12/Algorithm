package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//
public class 말이되고픈원숭이 {
	// BOJ 말이되고픈 원숭이 / 골 4 / 
	static class Monkey{
		int x, y, cnt, k;
		public Monkey(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
	static int K;
	static int W, H;
	static int[][] map;
	static int cnt = 0; // 원숭이 이동횟수
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] horseMoveX = {-1,-2,-2,-1,1,2,2,1};
	static int[] horseMoveY = {-2,-1,1,2,2,1,-1,-2};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine()); // 이동 횟수
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로
		H = Integer.parseInt(st.nextToken()); // 세로
		map = new int[H][W];
		visited = new boolean[H][W][31];
		// 0 : 평지, 1 : 장애물
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0][0] = true;
		bfs();
		
	}
	
	public static void bfs() {
		Queue<Monkey> q = new LinkedList<>();
		q.offer(new Monkey(0,0,0,K));
		
		
		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			int cnt = cur.cnt;
			int curK = cur.k;
			
			if(curX == H -1 && curY == W -1) { // 끝에 다다르면 종료
				System.out.println(cnt);
				return;
			}
			// 범위 벗어나면 skip
			if(curX < 0 || curY < 0 || curX >= H || curY >= W) continue; 
			
			if(map[curX][curY] == 1) continue;
			if(visited[curX][curY][curK]) continue;
			visited[curX][curY][curK] = true;
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				q.offer(new Monkey(nx, ny, cnt+1, curK));
			}
			
			if(curK == 0) continue;
			for(int i=0; i<8; i++) {
				int nx = curX + horseMoveX[i];
				int ny = curY + horseMoveY[i];
				
				q.offer(new Monkey(nx, ny, cnt+1, curK-1));
			}
		}  // end while
		
		System.out.println("-1");
		return;
	}
}
