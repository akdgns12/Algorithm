package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ������� {
	// BOJ ������� �ǹ� 1 / �׷��� Ž��
	// map�� Ž���ϴµ�
	/*
	 * DFS����..
	 */

	
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int N, M;
	static boolean flag;
	// ��ǥ ���̰� 1 ������ ������ ���̴ϱ� �ȹ�....
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		// map ���� �Է¹ޱ�
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
			// map ���� �Ѿ�� skip
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(map[x][y] < map[nx][ny]) flag = false;
			if(!visited[nx][ny] && map[x][y] == map[nx][ny]){
				// flag = true; ���⼭ flag�� �ٷ� true�� �ٲ��ָ� �ȵȴ�.
				// �ȹ��� �� �˻��ϰ� ������ ���̽��� ���ǿ� �´°��̱⶧����
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}
