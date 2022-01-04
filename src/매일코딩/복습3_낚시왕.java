package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습3_낚시왕 {
	static class Shark {
		int r,c,s,d,z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			
		}
	}
	static int R,C,M;
	static Shark[][] map;
	static int[] dr = {};
	static int[] dc = {};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(d == 1)
				d = 0;
			else if(d == 4)
				d = 1;
			
			map[r][c] = new Shark(r,c,s,d,z);
		}
		
		for(int col = 0; col < C; col++) {
			// 낚시왕 이동
			for(int row = 0; row < R; row++) {
				if(map[row][col] != null) { // 널값이 아니라면 상어가 있는 것 -> 잡는다
					answer += map[row][col].z; // 가장 가까운 상어 크기 정답 변수에 저장
					
					map[row][col] = null; // 잡고난 후의 위치 null 로 바꿔주고
					break;
				}
			}
			
			// 상어이동
			Queue<Shark> q = new LinkedList<>();
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) { // 현재 map에 있는 상어들 추가
					if(map[i][j] != null) {
						q.add(new Shark(i,j,map[i][j].s, map[i][j].d, map[i][j].z));
					}
				}
			}
			
			map = new Shark[R][C]; // 새로운 낚시판 만들어준다
			
			// 모든 상어 한마리씩 꺼내서 이동
			while(!q.isEmpty()) {
				Shark sm = q.poll();
				
				int speed = sm.s;
				
				if(sm.d == 0 || sm.d == 2) // 상 하
					speed %= (R-1) * 2;
				else if(sm.d == 1 || sm.d == 3) // 좌 우
					speed %= (C-1) * 2;
				
				for(int s=0; s<speed; s++) {
					int nr = sm.r + dr[sm.d];
					int nc = sm.c + dc[sm.d];
					// 범위 벗어나 벽에 부딪히면
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
						sm.r -= dr[sm.d]; // 다시 값 돌려주고 방향 바꾼다
						sm.c -= dc[sm.d];
						sm.d = (sm.d + 2) % 4;
						continue;
					}
					
					// 위치 벗어나지 않을 때는 새로운 위치로 이동
					sm.r = nr;
					sm.c = nc;
					
				}
				
				// 새로운 위치가 빈공간인지 이미 상어가 있는 공간인지 확인
				if(map[sm.r][sm.c] != null) { // 이미 상어가 있다면
					if(map[sm.r][sm.c].z < sm.z) { // 기존 상어보다 현재 상어가 크다면
						map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
					}else { // 없다면 현재 상어 바로 넣어줌
						map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
					}
				}
			}// 이동 for문 끝
			System.out.println(answer);
		}
	}
}
