package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
	static class Wall{
		int x, y;
		int cnt, brokeWallCnt; // 이동거리, 부순 횟수
		public Wall(int x, int y, int cnt, int brokeWallCnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.brokeWallCnt = brokeWallCnt;
		}
	}
	static int N, M;
	static int[][] map;
//	//  처음 내가 생각했던 방식..
	// 방문체크만 하고 벽을 부순 횟수만 카운팅해서 조건을 체크해줬다
	// 당연히 벽을 딱 한 번만 부순다..다음 벽을 만나면 바로 �그랑
//	static boolean[][] visited;
	static boolean[][][] visited; // 3차원배열로 부쉈을��와 안부쉈을��의 방문체크를 분리해보자.
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
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
		
		bfs(0,0); // 출발점에서 bfs 시작
	}
	
	public static void bfs(int x, int y) {
		Queue<Wall> q = new LinkedList<>();
		visited[x][y][0] = true;
		
		q.offer(new Wall(x,y,1, 0));
		
		while(!q.isEmpty()) {
			Wall cur = q.poll();
		
			if(cur.x == N-1 && cur.y == M-1) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int breakWall = cur.brokeWallCnt;
				int cnt = cur.cnt;
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == 1) { // 벽을 만남
					if(breakWall == 0 && !visited[nx][ny][1]) { // 벽 부신적 없이 없다면
						visited[nx][ny][1] = true; // 벽 부심
						q.offer(new Wall(nx, ny, cnt+1, 1));
					}
				}else { // 빈 칸
					if(!visited[nx][ny][breakWall]) {
						q.offer(new Wall(nx, ny, cnt+1, breakWall));
						visited[nx][ny][breakWall] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
