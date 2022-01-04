package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import 매일코딩.마법사와상어와비바라기.Air;

// 비바라기를 시전하면 (N,1) (N,2) (N-1,1) (N-1,2)에 비구름이 생긴다.
/*
 * 구름에 이동을 M번 하라고 명령하면
 * 1. 모든 구름이 d방향으로 s칸 이동
 * 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1증가
 * 3. 구름이 모두 사라짐
 * 4. 2에서 물이 증가한 칸(r,c)에서 대각선 방향으로 거리가 1인 칸에 
 * 	    물이 있는 바구니의 수만큼(r,c)에 있는 바구니의 물이 양의 증가'
 * 	- 이때 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인칸이 아님
 * 5. 바구니에 저장된 물의양이 2이상인 모든 칸에 구름이 생기고, 물의 양이 2줄어든다.
 * 	   이 때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
 */
public class 복습2_마법사와상어와비바라기 {
	static class Air{ // 비구름 정보
		int r,c;
		
		public Air(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M; 
	static int[][] map; 
	static boolean[][] visited;
	static int[][] wind; // 비구름 이동할 때 필요한 방향, 칸 수 받을 배열
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}; // 좌부터 시계방향
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0 ,-1};
	
	static ArrayList<Air> list; // 비구름 정보 담을 ArrayList
	
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
			wind[i][0] = Integer.parseInt(st.nextToken()); // d
			wind[i][1] = Integer.parseInt(st.nextToken()); // s
		}
		
		// 초기 비구름 생성
		list = new ArrayList<Air>();
		list.add(new Air(N-2,0));
		list.add(new Air(N-1,0));
		list.add(new Air(N-2,1));
		list.add(new Air(N-1,1));
		
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
	
	// 구름 이동
	public static void move(int d, int s) {
		for(Air air : list) {
			int nr = (air.r + N + dr[d] * s) % N;
			int nc = (air.c + N + dc[d] * s) % N;
			
			visited[nr][nc] = true;
			map[nr][nc] += 1;
			air.r = nr;
			air.c = nc;
		}
	}
	
	// 구름 이동 후  비가 내리고 구름제거
	public static void remove() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >=2 && !visited[i][j]) { // 비구름이였던 칸 아니고 && 물의양 2이상이면
					map[i][j] -= 2; // 물의 양 2 줄어들고
					list.add(new Air(i, j)); // 새롭게 비구름 된다.
				}
			}
	}
}
	
	// 바구니에 있는 물의양 증가하는 작업(해당 칸의 대각선에 물이 있는지 범위를 벗어나지는 않는지 체크해야함)
	public static void add() {
		for(Air air : list) {
			int cnt = 0;
			int nr = -1, nc = -1;
			// 좌상부터 차례대로 우상 -> 우하 -> 좌하로 이어지도록 반복문 설정
			for(int i=1; i<=8; i += 2) { // 범위를 벗어나지않고 대각선들에 해당하는 칸에 물이 있을 때만 물 +1해줘야한다
				nr = air.r + dr[i];
				nc = air.c + dc[i];
				if(canMove(nr,nc) && map[nr][nc] > 0) {
					cnt++;
				}
			}
			map[air.r][air.c] += cnt;
		}
		list.clear();
	}
	
	public static boolean canMove(int r, int c) {
		return (r >=0 && c >= 0 && r < N && c < N);
	}
	
	// M번의 이동이 끝난 후 바구니에 들어있는 물의 양의 합
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
