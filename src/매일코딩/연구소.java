package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. 벽을 3개 세운다
 * 2. 벽을 세운 상태로 바이러스를 확신시킨다.
 * 3. 안전 영역을 구한다.
 * 4. 위의 과정을 반복하며 안전영역의 최댓값을 구한다.
 */
/*
 * 가능한 위치에 벽 3개를 배치(DFS)
 * 바이러스가 퍼져나갈 수 있는 위치에 바이러스를 표시(BFS)
 * 안전영역의 갯수를 찾는다.
 */
public class 연구소{
	// 바이러스 객체
	static class virus{
		int x, y;
		
		virus(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;	// 지도의 세로 크기
	static int m;	// 지도의 가로 크기
	
	static int[][] map; // 지도
	static int[][] virus_map; // 지도 카피
	
	static int[] dr = {-1,1,0,0}; // 상 하 좌 우
	static int[] dc = {0,0,-1,1}; // 상 하 좌 우
	
	static int max = Integer.MIN_VALUE; // 안전지역 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		// 지도 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 벽 세우면서 바이러스 뿌리기 시작
		dfs(0);
		
		System.out.println(max);
	}
	
	// 벽 세우기
	public static void dfs(int depth) {
		// 벽 3개를 다 세웠으면 바이러스 뿌리기
		if(depth == 3) {
			bfs();
			return;
		}
		
		// 벽 3개 못 세웠으면 다시 세우기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) { // 빈 칸이라면
					map[i][j] = 1; // 벽세우고
					dfs(depth + 1);
					map[i][j] = 0; // 다시 돌려놓고
				}
			}
		}
	}
	
	public static void bfs() {
		virus_map = new int[n][m];
		Queue<virus> q = new LinkedList<virus>();
		
		// virus map 카피
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				virus_map[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 바이러스라면 큐에 넣어
				if(virus_map[i][j] == 2)
					q.add(new virus(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			virus v = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = v.x + dr[i];
				int nc = v.y + dc[i];
				
				// 범위 안에 있으면
				if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
					// 빈 칸이라면 바이러스 퍼뜨리고 다시 큐에 넣는다
					if(virus_map[nr][nc] == 0) {
						virus_map[nr][nc] = 2;
						q.add(new virus(nr,nc));
					}
				}
			}
		}
		
		countSafe(virus_map);
	}
	
	public static void countSafe(int[][] virus_map) {
		int count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(virus_map[i][j] == 0) count++;
			}
		}
		
		max = Math.max(count, max);
	}
}
		
