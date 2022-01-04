package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습_연구소 {

	static class virus {
		int x, y;
		
		virus(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int n,m;
	static int[][] map;
	static int[][] virus_Map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		// map 정보 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 벽 세우기 조합 시작
		dfs(0);
		
		System.out.println(max);
	}
	
	// 벽 세우기
	public static void dfs(int depth) {
		//벽 다 세웠다면
		if(depth == 3) {
			bfs();
			return;
		}
		
		// 벽 다 세우지 않았다면
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) { // 빈 칸이라면
					map[i][j] = 1; // 벽 세우고
					dfs(depth + 1);
					map[i][j] = 0; // 재귀 끝나면 빈칸으로
				}
			}
		}
	}
	
	// 바이러스 퍼뜨리기
	public static void bfs() {
		virus_Map = new int[n][m];
		Queue<virus> q = new LinkedList<virus>();
		
		// virus_Map에 map 카피
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				virus_Map[i][j] = map[i][j];
			}
		}
		
		// 바이러스 좌표 큐에 넣어주기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(virus_Map[i][j] == 2) { // 바이러스라면 큐에 넣기
					q.offer(new virus(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			virus v = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = v.x + dr[i];
				int nc = v.y + dc[i];
				
				// 범위 벗어나지 않으면
				if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
					if(virus_Map[nr][nc] == 0) {
						virus_Map[nr][nc] = 2;
						q.offer(new virus(nr,nc));
					}
				}
			}
		}
		// 안전영역 개수세는 함수
		countSafe(virus_Map);
	}
	
	public static void countSafe(int[][] virus_Map) {
		int count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(virus_Map[i][j] == 0) count++;
			}
		}
		
		max = Math.max(max, count);
	}
}
