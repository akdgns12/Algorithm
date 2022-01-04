package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 비바라기 크기가 NxN인 격자
 * r행 c열 A[r][c]는 r행 c열에 있는 바구니에 저장된 물의양을 의미
 * 격자의 가장 왼쪽 윗칸은 (1,1)이고 가장 아랫 칸은(N,N)이다.
 * map은 끝나지않고 이어져있다.
 * 
 * 구름에 이동을 M번 명령
 * 1. 모든 구름이 d방향으로 s칸 이동
 * 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1증가
 * 3. 구름이 모두 사라진다
 * 4. 2에서 물이 증가한 칸(r,c)에 물복사버그 마법을 시전. 물복사버그 마법을 사용하면, 대각선 방향으로
 * 거리가 1인 칸에 물이있는 바구니의 수만큼(r,c)에 있는 바구니의 물의 양이 증가
 *  - 이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
 *  - 예를 들어, (N,2)에서 인접한 대각선 칸은(N-1,1), (N-1,3)이고 (N,N)에서 인접한 대각선 칸은
 *  (N-1,N-1)뿐이다.
 * 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이 때 구름이 생기는 칸은
 *  3에서 구름이 사라진 칸이 아니어야 한다.
 */
public class 마법사와상어와비바라기 {
	static class Air{
		int r, c;
		
		public Air(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M; // N : 격자 크기, M : 이동횟수
	static int[][] map;
	static boolean[][] visited;
	static int[][] wind;
	
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}; // 좌, 좌상, 상, 우상, 우, 우하, 하 , 좌하
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static ArrayList<Air> list;
	
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
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			wind[i][0] = Integer.parseInt(st.nextToken()); // d
			wind[i][1] = Integer.parseInt(st.nextToken()); // s
		}
		
		list = new ArrayList<Air>();
		list.add(new Air(N-2, 0));
		list.add(new Air(N-1, 0));
		list.add(new Air(N-2, 1));
		list.add(new Air(N-1, 1));
		
		for(int i=0; i<M; i++) {
			visited = new boolean[N][N];
			int d = wind[i][0];
			int s = wind[i][1];
			move(d, s);
			add();
			remove();
		}
		
		System.out.println(count());
	}
	
	public static int count() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				cnt += map[i][j];
			}
		}
		return cnt;
	}
	
	// 구름 사라지는 작업
	public static void remove() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2 && !visited[i][j]) {
					map[i][j] -= 2;
					list.add(new Air(i, j)); 
				}
			}
		}
	}
	
	public static void add() {
		for(Air air : list) {
			int cnt = 0;
			int nr = -1, nc = -1;
			for(int i=2; i<=8; i += 2) {
				nr = air.r + dr[i];
				nc = air.c + dc[i];
				if(canMove(nr, nc) && map[nr][nc] > 0) {
					cnt++;
				}
			}
			
			map[air.r][air.c] += cnt;
		}
		// 비를 나중에 뿌려줘야 하기 때문에 구름을 바로 삭제하지 않고 비를 뿌려준 후에 삭제해준다.
		list.clear();
	}

	public static boolean canMove(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}
	
	
	public static void move(int d, int s) {
		for(Air air : list) {
			int nr = (air.r + N + dr[d]*s % N) % N;
			int nc = (air.c + N + dc[d]*s % N) % N;
			
			visited[nr][nc] = true;
			map[nr][nc] += 1;
			air.r = nr;
			air.c = nc;
		}
	}
}
