package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다른방법_연구소3 {
	static class Virus{
		int x, y, time;
		
		public Virus(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int N, M;
	static ArrayList<Virus> list = new ArrayList<>();
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int blank; // 빈칸 기록
	static int[] picked; // 뽑은 조합을 기록
	static int min = Integer.MAX_VALUE; // 결과값(최소시간)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) { // 바이러스일 경우
					list.add(new Virus(i,j,1));
				}else if(map[i][j] == 0) {
					blank++;
				}
			}
		}
		
		// 빈칸 없는 경우 바로 끝
		if(blank == 0) {
			System.out.println(0);
			return;
		}
		
		// 뽑은 조합을 저장하기 위한 배열
		picked = new int[M];
		
		// 조합 + 탐색 시작
		combination(0,0);
		
		// 다 못채우면 그냥 끝냄
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(min);
	}
	
	// cnt(현재까지 뽑은 갯수), cur(현재 가르키는 변호)
	public static void combination(int cnt, int cur) {
		if(cnt == M) {
			bfs(); // 조합 완성되면 탐색 시작
			return;
		}
		
		for(int i=cur; i<list.size(); i++) {
			picked[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		visited = new boolean[N][N];
		
		// 뽑힌 수대로 바이러스 리스트에 접근해서 Q에 삽입
		for(int i=0; i<M; i++) {
			q.add(list.get(picked[i]));
			visited[list.get(picked[i].x)][list.get(picked[i].y)];
		}
		
		int time = 0; // 걸린 시간 기록
		int count = 0; // 빈칸 확산 카운팅
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 이전에 있던 바이러스의 시간값을 받아오므로 계속 증가할 수 밖에 없음
				time = virus.time;
				
				// 범위 밖
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				// 빈칸이어서 확산한 경우
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					count++;
					q.add(new Virus(nx, ny, v.time+1));
				}
				
				// 확신은 못하지만 지나갈 수 있는 경우
				if(map[nx][ny] == 2) { // 활성화된 바이러스는 활성화되지 않은 바이러스는 지나갈 수 있음
					visited[nx][ny] = true;
					q.add(new Virus(nx , ny, v.time+1));
				}
			}
			
			// 만약 이미 빈칸이 채워졌다면 사전에 종료시킴으로써 시간값의 계속 증가를 방지
			if(count == blank) {
				time++; // 이 경우, 새로 뽑은 시간값 할당이 안되므로, 임의로 1증가
				break;
			}
		}
		
		if(count != blank) return; // 다 못채우면 그냥 끝내기
		
		// time-1의 이유 : 마지막에 +1한 상태를 q에 날리기 때문
		min = Math.min(min, time-1);
	}
}
