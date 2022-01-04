package 그림;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
	static int n,m;
	static int[][] map;
	static int size; // 1의 사이즈를 잰다.
	static int cnt=0; // 1의 구역 갯수
	static int max; // 1의 최고 사이즈
	static int[] dx = {1,-1,0,0}; //동 서 남 북 순으로 탐색
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	public static Queue q = new LinkedList<Point>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		// Input
		for(int i=0; i<n; i++	) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) { //map을 한 번 씩 탐색하는 for문
				if(map[i][j] == 1 && !visited[i][j]) {
					size = 0;
					q.offer(new Point(i,j));
					bfs(i,j);
					cnt++;
				}
			}
		}
		
		if(cnt == 0) {
			System.out.println(0);
			System.out.print(0);
		}else {
			System.out.println(cnt);
			System.out.println(max);
		}
	}
	
	public static void bfs(int x, int y) {
		q.offer(new Point(x,y));
		visited[x][y] = true;
		
		size++;
		while(!q.isEmpty()) { //큐가 빌때까지
			Point temp = (Point) q.poll(); // q에 넣었던 x,y좌표를 넣어주고 삭제
			
			for(int d=0; d<4; d++) { // 동 서 남 북 4방향으로 탐색
				int nx = temp.x + dx[d];
				int ny = temp.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) { // 다음 좌표가 맵을 벗어날 때
					continue;
				}
				
				if(map[nx][ny] == 0 || visited[nx][ny]) { //다음 칸이 0이거나 방문했으면
					continue; //계속 for문 돌기
				}
				
				// 다음 칸이 방문 안했고 1일 때
				
				q.offer(new Point(nx,ny));
				visited[nx][ny] = true;
				size++;
			}
		}	
			max = max > size ? max : size;
		}
}
