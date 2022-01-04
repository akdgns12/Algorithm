package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int[][] map;
	static int N, M;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				dfs(i,j,0,0);
				exception(i,j);
			}
		}
		
		System.out.println(max);
	}
	
	// 상하좌우 가능한 모형들(ㅗ 모양제외)
	// ㅗ 모양은 dfs로 구현 불가
	public static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}
			
			if(visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, depth+1, sum + map[nx][ny]);
			visited[nx][ny] = false;
		} 
	}
	// ㅗ모양 구현
	// 간단한 원리로는 + 모양에서 하나를 뺀다.
	public static void exception(int x, int y) {
		int wing = 4; // 가운데서의 상하좌우 날개
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 날개가 2개 이상 없다면 ㅗ모양이 아니다. 그러므로 함수 종료
			if(wing <= 2) {
				return;
			}
			// 날개가 맵 바깥에 있다면 날개가 아니다.
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[nx][ny]);
			sum = sum + map[nx][ny];
		}
		
		// 날개가 4개일 때 가장 작은 날개를 없애야 ㅗ,ㅓ,ㅏ,ㅜ  모양이 나온다.
		if(wing == 4) {
			sum = sum - min;
		}
		max = Math.max(sum, max);
	}
}
