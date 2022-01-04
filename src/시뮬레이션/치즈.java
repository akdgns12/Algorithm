package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 치즈가 모두 녹는데 걸린 시간과 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여있는
 * 칸의 개수 구하는 프로그램
 * 
 */
public class 치즈 {
	static int n,m; // 세로 가로
	static int cheeze;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int time;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
	
		
		for(int i=0; i<n; i++	) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					// 제일 바깥에 있는 1인지 어떻게 판단하지?
					cheeze++;
				}
			}
		}
		
		while(cheeze!=0) {
			time++;
			count = cheeze;
			bfs();
		}
		
		// End of Input
		System.out.println(time);
		System.out.println(count);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0,0});
		visited = new boolean[n][m];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll(); //큐가 빌때까지 데이터 꺼내온다
			for(int i=0; i<4; i++) {
				int	nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
				if(map[nx][ny] == 1	) {
					cheeze--;
					map[nx][ny] = 0;
				}else if(map[nx][ny] == 0) {
					q.offer(new int[] {nx,ny});
				}
				visited[nx][ny] = true;
			}
		}
		
	}
}
