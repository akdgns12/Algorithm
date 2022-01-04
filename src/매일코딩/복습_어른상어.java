package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_어른상어 {
	static class Shark{
		int r, c, dir;
		
		Shark(int r, int c, int dir){
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	static int N, M, K;
	static int[][] restTime; 
	static int[][] smell;
	static int[][][] priority;
	static Shark[] shark;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		restTime = new int[N+1][N+1];
		smell = new int[N+1][N+1];
		priority = new int[M+1][5][4];
		shark = new Shark[M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken()); 
				
				if(n > 0) { // 상어 번호
					shark[n] = new Shark(i, j, 0);
					restTime[i][j] = K;
					smell[i][j] = n;  // 냄새를 남긴 상어의 번호 배열
				}
			}
		}
		
		// 초기 상어 방향
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			shark[i].dir = Integer.parseInt(st.nextToken());
		}
		
		for(int m=1; m<=M; m++) {
			for(int i=1; i<=4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					priority[m][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(solve());
		/*
		 * 1. 상하좌우 중에서 상어의 새로운 이동 위치(nr, nc)를 찾는다.
   		1-1. 상어의 현재 방향을 기준으로 가장 우선순위가 높은 방향부터 탐색한다.
                탐색 도중, 냄새가 없고 인접한 위치를 찾으면 탐색을 종료한다.
   	    2-1. 만약 모두 탐색했는데 냄새가 없는 곳이 없다면, 자기 자신의 냄새가 있는 인접한 곳을 찾는다.
                 마찬가지로 현재 방향을 기준으로 가장 우선순위가 높은 방향부터 탐색한다.
		 */
	}
	
	public static int solve() {
		int time = 0;
		
		while(true) {
			int count = 0;
			for(int m=1; m<=M; m++) {
				if(shark[m] != null) {
					count++;
				}
			}
			
				if(count == 1 && shark[1] != null) { //1번 상어 혼자 남은 경우
					return time;
				}
				
				// 1000초 지난 경우
				if(time >= 1000)
					return -1;
				
				// 임시배열
				int[][] tmp = new int[N+1][N+1];
				
				for(int m=1; m<=M; m++) {
					if(shark[m] != null) { // 상어가 경계안에 있다면
						moveShark(tmp, m);
					}
				}
				
				// 냄새 유효기간 하나씩 줄이기
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(restTime[i][j] > 0)
							restTime[i][j]--;
						
						if(restTime[i][j] == 0)
							smell[i][j] = 0;
					}
				}
				
				// 이동후의 상어 위치의 냄새 정보와 유효기간 초기화
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(tmp[i][j] > 0) {
							restTime[i][j] = K;
							smell[i][j] = tmp[i][j];
						}
					}
				}
				time++;
			}
		}
	
	public static void moveShark(int[][] tmp, int m) {
		int nr = 0;
		int nc = 0;
		int d = 0;
		
		boolean flag = false;
		
		// 1-1. 높은 우선순위부터 차례대로 탐색
		for(int i=0; i<4; i++) {
			d = priority[m][shark[m].dir][i];
			nr = shark[m].r + dr[d];
			nc = shark[m].c + dc[d];
			
			// 경계를 벗어나지 않으면서, 냄새가 없는 곳을 찾으면 break로 빠져나옴
			if((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == 0) {
				flag = true;
				break;
			}
		}
		
		// 1-2. 냄새가 없는 곳이 없는 경우
		if(!flag) {
			for(int i=0; i<4; i++) {
				d = priority[m][shark[m].dir][i];
				nr = shark[m].r + dr[d];
				nc = shark[m].c + dc[d];
				
				if((1<=nr && nr <= N) && (1 <= nc && nc<=N) && smell[nr][nc] == m)
					break;
			}
		}
		
		if(tmp[nr][nc] == 0) {
			tmp[nr][nc] = m;
			shark[m].r = nr;
			shark[m].c = nc;
			shark[m].dir = d;
		}else {
			shark[m] = null;
		}
	}
}

