package NHN기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 복습_행렬의영역 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					dfs(i,j,map);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		
		
		Collections.sort(list);
		System.out.println(list.size());
		
		for(int i : list) {
			System.out.print(i + " ");
		}
		
		
	}
	
	public static void dfs(int x, int y, int[][] map) {
		visited[x][y] = true;
		
		int nx;
		int ny;
		
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			// 범위 벗어나지 않아야 함
			if(nx >=0 && ny >=0 && nx < N && ny < N) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny, map);
					cnt++;
				}
			}
		}
		
	}
}
