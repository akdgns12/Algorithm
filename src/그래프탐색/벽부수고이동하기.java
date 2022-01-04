package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ���μ����̵��ϱ� {
	static class Wall{
		int x, y;
		int cnt, brokeWallCnt; // �̵��Ÿ�, �μ� Ƚ��
		public Wall(int x, int y, int cnt, int brokeWallCnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.brokeWallCnt = brokeWallCnt;
		}
	}
	static int N, M;
	static int[][] map;
//	//  ó�� ���� �����ߴ� ���..
	// �湮üũ�� �ϰ� ���� �μ� Ƚ���� ī�����ؼ� ������ üũ�����
	// �翬�� ���� �� �� ���� �μ���..���� ���� ������ �ٷ� ���׶�
//	static boolean[][] visited;
	static boolean[][][] visited; // 3�����迭�� �ν������� �Ⱥν������� �湮üũ�� �и��غ���.
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
		
		bfs(0,0); // ��������� bfs ����
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
				
				if(map[nx][ny] == 1) { // ���� ����
					if(breakWall == 0 && !visited[nx][ny][1]) { // �� �ν��� ���� ���ٸ�
						visited[nx][ny][1] = true; // �� �ν�
						q.offer(new Wall(nx, ny, cnt+1, 1));
					}
				}else { // �� ĭ
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
