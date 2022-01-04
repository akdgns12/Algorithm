package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N*N크기의 땅, 각각의 땅에는 나라가 하나씩 존재
 * r행 c열 A[r][c]명이 살고 있다. 인접한 나라에는 국경이 존재.
 * 인구이동 조건 - 조건에 맞게 더이상 인구이동이 없을 때까지 계속
 * 1. 국경선을 공유하는 두 나라의 인구차이가 L명 이상, R명이하라면 
 * 두나라가 공유하는 국경선을 오늘 하루동안 연다
 * 2. 위의 조건에 따라 열어야하는 국경선이 모두 열렸다면, 인구이동 시작
 * 3. 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있다면 그 나라를
 * 오늘 하루 동안은 연합이라한다
 * 4.연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
 * 소수점은 버린다
 * 5. 연합을 해체하고 모든 국경선을 닫는다
 */
public class 인구이동 {
	static int N,L,R;
	static int[][] map;
	static int[][] visited = new int[50][50];
	static int cnt; // 연합을 이루는 총 개수
	
	static int find(int r, int c, int value) {
		if(r < 0 || r > N-1 || c < 0 || c > N-1) return 0;
		if(visited[r][c] != 0) return 0;
		
		if(value != -1) {
		int diff = Math.abs(value - map[r][c]);
		if(diff < L || diff > R) return 0;
		}
		
		visited[r][c] = 1;
		cnt++;
		
		int sum = map[r][c];
		sum += find(r-1, c, map[r][c]);
		sum += find(r+1, c, map[r][c]);
		sum += find(r, c-1, map[r][c]);
		sum += find(r, c+1, map[r][c]);
		
		return sum; // sum = 연합을 이루는 총 인구 수
	}
	
	static void move(int r, int c, int value) {
		if(r < 0 ||  r > N-1 || c < 0 || c> N-1) return;
		if(visited[r][c] != 1) return;
		
		visited[r][c] = 2;
		
		map[r][c] = value;
		move(r-1, c, value);
		move(r+1, c, value);
		move(r, c-1, value);
		move(r, c+1, value);
	}
	// visited[i][j] = 0, 1, 2 = 방문 하지않은 곳, 연합을 이루는 국가, 인구이동 마친곳;
	static int solve() {
		int ret = 0;
		boolean flag;
		
		do {
			flag = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = 0;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] == 0) {
					    cnt = 0;
						int sum = find(i,j,-1);
						if( cnt > 1) { // 연합을 이루는 총 국가가 2개이상이면 move(인구이동)실행
							flag = true;
							move(i, j, sum / cnt);
						} else {
							visited[i][j] = 2;
						}
					}
				}
			}
			if(flag) ret++;
		}while(flag);
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[50][50];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve());
	}
}
