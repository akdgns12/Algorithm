package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3 {
	// 바이러스 모두 퍼질때 걸리는 최소시간
	/*
	 * 1. M개의 바이러스를 선택하는 Combination(백트래킹)
	 * 2. 바이러스의 좌표 ArrayList<Virus> viruses에 저장
	 * 3. 재귀를 통해 활성화시킬 바이러스 리스트인 Virus[] active에 받아 저장
	 * 4. 바이러스 퍼트리기는 BFS로
	 * 5. 바이러스 퍼트릴 맵은 따로 복사해서 사용
	 */
	static class Virus{
		int x, y, time;
		
		public Virus(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Virus> viruses = new ArrayList<>();
	static Virus[] active;
	static int result = Integer.MAX_VALUE;
	static int OriginEmptySpace = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		active = new Virus[M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) { // 바이러스
					viruses.add(new Virus(i,j,0));
				}else if(map[i][j] == 0) { // 빈 공간
					OriginEmptySpace ++;
				}
			}
		}
		
		if(OriginEmptySpace == 0) {
			System.out.println(0);
		}else {
			selectVirus(0,0);
			// 퍼트릴 수 없는 경우에는 -1 출력
			System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		}
		
		
		
	}
	
	// 백트래킹으로 M개의 바이러스를 선택하는 Combination 구현
	public static void selectVirus(int start, int selectCount) {
		if(selectCount == M) { // M개의 바이러스 모두 선택했다면 바이러스 퍼트리기
			spreadVirus(OriginEmptySpace);
			return;
		}
		
		for(int i=start; i<viruses.size(); i++) {
			active[selectCount] = viruses.get(i);
			selectVirus(i + 1, selectCount + 1);
		}
	}
	
	// 바이러스 퍼트리기
	public static void spreadVirus(int emptySpace) {
		Queue<Virus> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<M; i++) {
			Virus virus = active[i];
			visited[virus.x][virus.y] = true;
			// 큐에 활성화된 바이러스 넣기
			q.add(virus);
		}
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];
				
				// map의 범위 벗어나는 경우 skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				// 이미 방문했거나 벽인경우 skip
				if(visited[nx][ny] || map[nx][ny] == 1) continue;
				
				if(map[nx][ny] == 0) { // 빈공간이라면
					emptySpace--;
				}
				
				if(emptySpace == 0) {
					result = Math.min(result, virus.time + 1);
					return;
				}
				
				visited[nx][ny] = true;
				q.add(new Virus(nx, ny, virus.time + 1));
			}
		}
	}
}
