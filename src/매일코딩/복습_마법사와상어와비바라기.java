package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import 매일코딩.마법사와상어와비바라기.Air;

public class 복습_마법사와상어와비바라기 {
	static class Cloud{
		int r, c;
		
		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static int[][] map;
	static int[][] wind;
	static boolean[][] visited;
	static ArrayList<Cloud> list;
	
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		wind = new int[M][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//초기 구름 생성
		list = new ArrayList<Cloud>();
		list.add(new Cloud(N - 1, 0));
		list.add(new Cloud(N - 1, 1));
		list.add(new Cloud(N - 2, 0));
		list.add(new Cloud(N - 2, 1));
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			wind[i][0] = Integer.parseInt(st.nextToken());
			wind[i][1] = Integer.parseInt(st.nextToken());
		}
	
	
	for(int i=0; i<M; i++) {
		visited = new boolean[N][N];
		int d = wind[i][0] - 1;
		int s = wind[i][1] % N;
		move(d, s);
		add();
		remove();
	}
	
	System.out.println(count());
	}
	
	public static void move(int d, int s) {
		for(Cloud cloud : list) {
			int nr = (cloud.r + N + dr[d] * s) % N;
			int nc = (cloud.c + N + dc[d] * s) % N;
			
			visited[nr][nc] = true;
			map[nr][nc] += 1; // 구름이 있는칸에 비가 1씩 내리고 사라진다
			cloud.r = nr;
			cloud.c = nc;
		}
	}
	// 범위를 벗어나지 않는 4개의 대각선 체크하여 물 더해주기
	public static void add() {
		for(Cloud cloud : list) {
			int cnt = 0; // 더해줄 물의양 카운트
			int nr = -1, nc = -1;
			for(int i=1; i<=8; i += 2) {
				nr = cloud.r + dr[i];
				nc = cloud.c + dc[i];
				if(canMove(nr, nc) && !visited[nr][nc]) {
					cnt++;
				}
			}
			map[cloud.r][cloud.c] += cnt;
		}
		list.clear();
	}
	
	public static boolean canMove(int r, int c) {
		return (r >=0 && c >= 0 && r < N && c < N);
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

