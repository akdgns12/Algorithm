package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_BOJ {
	static int n, m, max; // n : ����, m : ����
	static boolean isCycle = false;
	static int[][] dp;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dp = new int[n][m];
		map = new char[n][m];
		visited = new boolean[n][m];
		
		//�Է¹��� �� �ʿ� �ֱ�
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}
		
		visited[0][0] = true;
		dfs(0, 0, 1);
		if(isCycle) {
			System.out.println("-1");
		}
		else {
			System.out.println(max);
		}
	}
	
	/*
	 * DFS�˰����� ���� �ִ� ���� ���� Ƚ�� ���ϱ�
	 */
	
	static void dfs(int x, int y,int moveCount) {
		int moveSquareCount = Character.getNumericValue(map[y][x]); //x��ŭ �̵��ؾ��� ��, �� x�� ����Ŵ
		dp[y][x] = moveCount;
		if(moveCount > max) {
			System.out.println(moveCount + ".." + y + "," + x);
			max = moveCount;
		}
		
		for(int i = 0; i<dx.length; i++) {
			int nx = x + (moveSquareCount * dx[i]);
			int ny = y + (moveSquareCount * dy[i]);
			
			//�� ���� ����� ���� ����
			if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
				continue;
			}
			
			//���ۿ� ������ ���� ����
			if(map[ny][nx] == 'H') {
				continue;
			}
			
			//�̹� ���� �������� ���� ���� ������ Ƚ���� ���� �������� �ѹ� �� �� �ͺ��� ũ�� ������ �����Ƿ� �� ���� ����.
			if(moveCount < dp[ny][nx]) {
				continue;
			}
			
			//����Ŭ �߰��� ��� ��������
			if(visited[ny][nx]) {
				isCycle = true;
				return;
			}
			
			visited[ny][nx] = true;
			dfs(nx, ny, moveCount+1);
			visited[ny][nx] = false;
		}
	}
}
