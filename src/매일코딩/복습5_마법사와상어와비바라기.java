package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 복습5_마법사와상어와비바라기 {
	static class Cloud{
		int r, c;
		
		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visited; // 비구름이였는지 check할 boolean 배열
	static ArrayList<Cloud> list; // 비구름 좌표 담을 ArrayList
	
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}; // 좌부터 시계방향
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		// 초기구름 생성
		list = new ArrayList<Cloud>();
		list.add(new Cloud(N-1,0));
		list.add(new Cloud(N-1,1));
		list.add(new Cloud(N-2,0));
		list.add(new Cloud(N-2,1));
		
		for(int i=0; i<M; i++) {
			visited = new boolean[N][N]; // 새롭게 이동할 때 마다 방문배열 reset해줘야 하므로
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken()) % N;
			
			move(d, s);
			add();
			remove();
		}
		
		System.out.println(count());
	}
	
	public static void move(int d, int s) {
		for(Cloud cloud : list) {
			int nr = (cloud.r  + N + dr[d] * s) % N;
			int nc = (cloud.c  + N + dc[d] * s) % N;
			
			visited[nr][nc] = true;
			map[nr][nc] += 1;
			
			//갱신
			cloud.r = nr;
			cloud.c = nc;
		}
	}
	
	// 이동이 끝난 비구름 좌표에 대해
	// 비구름의 대각선들 중 범위를 벗어나지 않고 > 0 인것들
	public static void add() {
		for(Cloud cloud : list) {
			int cnt = 0;
			int nr = -1, nc = -1;
			for(int i=1; i<=8; i += 2) {
				 nr = cloud.r + dr[i];
				 nc = cloud.c + dc[i];
				if(canMove(nr, nc) && map[nr][nc] > 0) {
					cnt++;
				}
			}
			map[cloud.r][cloud.c] += cnt;
		}
		list.clear(); // 비를 나중에 뿌려줘야 하기 때문에 구름을 바로 삭제하지 않고
					 // 비를 뿌려준 후에 삭제한다.
	}
	
	public static boolean canMove(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}
	
	public static void remove() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2 && !visited[i][j]) {
					map[i][j] -= 2;
					
					list.add(new Cloud(i,j));
				}
			}
		}
	}
	
	public static int count() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cnt += map[i][j];
			}
		}
		return cnt;
	}
}
