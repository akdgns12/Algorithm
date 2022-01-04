package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습2_낚시왕 {
	static class Shark{
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
	static int result = 0;
	static Shark[][] map;
	
	static int[] dr = {-1,0,1,0}; // 상 좌 하 우
	static int[] dc = {0,-1,0,1};
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
				d = 2;
			
			map[r][c] = new Shark(r,c,s,d,z);
		}
		
		for(int col = 0; col < C; col++) {
			// 낚시왕 이동
			for(int row = 0; row < R; row++) {
				if(map[row][col] != null) { // null값이 아니라면 상어가 있는 것
					result += map[row][col].z; // 2. 가장 가까운 상어 크기 정답 변수에 저장
					
					map[row][col] = null; // 저장해준 뒤 map에서 상어 없애기
					break;
				}
			}
			
			//3. 상어 이동(큐를 만들어 현재 map에 있는 상어들을 큐에 추가한다)
			// (기존 맵에서 상어를 하나하나 이동시키고 이동된 위치에 상어가 있는지 없는지, 크기가 어떤지를 비교하는 것보다
			// 차라리 현재 잡히지 않고 남아있는 상어를 바탕으로 새롭게 맵을 구성하는 편이 더 낫기 때문에 만든 큐)
			// 상어들이 이동된 새로운 맵을 만들기 위해 맵을 초기화 해준다.
			// 큐에서 상를 한마리씩 꺼내서 큐가 빌때까지 상어를 이동시킨다.
			Queue<Shark> q = new LinkedList<>();
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] != null) { // 현재 map에 있는 상어들 추가
						q.add(new Shark(i,j, map[i][j].s, map[i][j].d, map[i][j].z));
					}
				}
			}
			
			map = new Shark[R][C]; // 새로운 낚시판 만들기 위해 배열 초기화
			
			// 모든 상어 한마리씩 꺼내서 이동
			while(!q.isEmpty()) {
				Shark sm = q.poll();
				
				// 속력만큼 상어 이동시키기
				int speed = sm.s; // 시간초과로 최소한의 이동을 위해 나머지 연산
				
				if(sm.d == 0 || sm.d == 2) // 상 하
					speed %= (R-1) * 2;
				else if(sm.d ==1 || sm.d ==3) // 좌 우
					speed %= (C-1) * 2;
				
				for(int s=0; s<speed; s++) {
					// 현재 r,c에 방향에 맞게 1칸씩 추가하며 위치 이동
					
					int nr = sm.r + dr[sm.d];	
					int nc = sm.c + dc[sm.d];
					
					// 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
						sm.r -= dr[sm.d];
						sm.c -= dc[sm.d];
						sm.d = (sm.d + 2) % 4; // 방향 반대로
						continue;
					}
					
					// 위치 벗어나지 않을 때는 새로운 위치로 이동
					sm.r = nr;
					sm.c = nc;
					
				}
				
				// 4. 새로운 위치가 빈 공간인지 이미 상어가 있는지 확인
				if(map[sm.r][sm.c] != null) { // 이미 상어가 있다면 두 상어 크기 비교
					if(map[sm.r][sm.c].z < sm.z) { // 기존 상어보다 현재 상어가 크면
						map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z); // 현재 상어 넣어줌
					}
				}else { // 없다면 현재 상어 바로 넣어줌
					map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
					
				}
			}
		} // 이동 for문 끝
		
		System.out.println(result);
		
		
	}
}
