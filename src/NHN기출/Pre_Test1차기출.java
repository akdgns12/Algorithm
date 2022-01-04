package NHN기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Pre_Test1차기출 {
	// NxN 크기의 행렬에서 영역의 개수와 각 영역의 크기를 오름차순으로 출력
	// 영역은 인접한 1로 이루어진 곳
	static int N;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0}; // 상 하 좌 우 
	static int[] dy = {0,0,-1,1};
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 행렬 크기
		matrix = new int[N][N]; // 행렬
		
		visited = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<>(); // 영역의 갯수 계산을 위해
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 영역의 원소가 1이고, 방문하지 않은 곳
				if(matrix[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, matrix);
					list.add(cnt); // 영역의 개수 계산을 위해
					cnt = 0;
				}
			}
		}
		
		Collections.sort(list); // 영역은 오름차순 정렬
		System.out.println(list.size());
		
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
	
	public static void dfs(int x, int y, int[][] matrix) {
		// 방문하면 true
		visited[x][y] = true;
		
		int nx;
		int ny;
		
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			// 이동할 수 있는 최대 최소 위치안에 있어야 된다.
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(matrix[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny, matrix);
				}
			}
		}
		// 영역 크기 증가
		cnt++;
	}
}

