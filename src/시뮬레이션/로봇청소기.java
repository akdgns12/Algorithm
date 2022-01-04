package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 로봇 청소기가 청소하는 영역의 개수를 구하는 프로그램
 * N*M 크기의 직사각형 map
 * 각각의 칸은 벽 또는 빈 칸
 * 청소기는 바라보는 방향이 있고, 동서남북 중 하나
 * 지도의 각 칸은 (r,c)로 나타낼 수 있고
 * r은 북쪽으로부터 떨어진 칸의 개수
 * c는 서쪽으로부터 떨어진 칸의 개수
 * 
 * 청소기 동작 방식
 * 1. 현재 위치를 청소
 * 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색
 *  a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로
 *  회전한 다음 한 칸을 전진하고 1번부터 진행
 *  b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다
 *  c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는,
 *  바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다
 *  d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라
 *  후진도 할 수 없는 경우에는 작동을 멈춤.
 */
public class 로봇청소기 {
	static int n,m; // 세로, 가로
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0}; // 동서남북
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		int x,y,d; // 로봇 청소기의 x,y좌표, 방향
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(clean(x,y,d));
	}
	// 로봇 청소기는 1번과 2번을 반복하기 때문에 2개의 while문 사용
	// while문이 2개이기 때문에, 빠져나올 수 있도록 flag사용
	private static int clean(int x, int y, int d) {
		int dirCount = 0, clean = 0, nx, ny;
		boolean flag = true;
		
		while(flag) { //1번을 위한 반복문
			if(map[x][y] == 0) {
				map[x][y] = 2;
				clean++;
			}
			
			while(true) { //2번을 위한 반복문
				if(dirCount==4) {
					nx = x - dx[d];
					ny = y - dy[d];
					
					if(map[nx][ny] == 1) {// 뒷칸도 벽
						flag = false;
						break;
					} else {
						x = nx;
						y = ny;
						dirCount = 0;
					}
				}
				
				d = (d + 3) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(map[nx][ny] == 0 ) {
					dirCount = 0;
					x = nx; y = ny;
					break;
				} else {
					dirCount++;
					continue;
				}
			}
		}
		return clean;
	}
}
