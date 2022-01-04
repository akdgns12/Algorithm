package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 농장관리 {
	// BOJ 농장관리 실버 1 / 그래프 탐색
	// map을 탐색하는데
	/*
	 * DFS문제..
	 */

	
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int N, M;
	static boolean flag;
	// 좌표 차이가 1 이하인 인접한 곳이니까 팔방....
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		// map 정보 입력받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					flag = true;
					dfs(i, j);
					if(flag) answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y) {
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// map 범위 넘어가면 skip
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(map[x][y] < map[nx][ny]) flag = false;
			if(!visited[nx][ny] && map[x][y] == map[nx][ny]){
				// flag = true; 여기서 flag를 바로 true로 바꿔주면 안된다.
				// 팔방을 다 검사하고 만족한 케이스만 조건에 맞는것이기때문에
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}
