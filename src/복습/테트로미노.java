package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��Ʈ�ι̳� {
	static int[][] map;
	static int N,M;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
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
	// �Ǹ� ������ ������ ����
	public static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, depth+1, sum+map[nx][ny]);
			visited[nx][ny] = false;
		}
	}
	// �� ���
	public static void exception(int x, int y) {
		int wing = 4; // ������� �����¿� ����
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//���� 3���� ���ٸ� �� ����� �ƴϴ�.
			if(wing < 3) {
				return;
			}
			
			// ������ �ٱ��� �ֵ��� ������ �ƴϴ�
			if(nx < 0 || ny < 0 || nx >=N || ny >= M) {
				wing--; // ���� ���� ����ٸ� ���� �� ����
				continue;
			}
			
			min = Math.min(min, map[nx][ny]);
			sum = sum + map[nx][ny];
		}
		
		// ������ 4���� �� ���� ���� ������ ���־� ��� ����
		if(wing == 4) {
			sum = sum - min;
		}
		
		max = Math.max(sum, max);
	}
}
