package ������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * <����>
 * dfs�� L�� ���̸� �ϳ��� �÷����� Ž���ϸ� �ɰŶ� �����ߴµ�, �̰ͺ��ٴ� bfs�� ����
 * �������� ��� Ž�����ִ°� �ξ� �� ȿ�����̴�.
 * <�˰���>
 * bfs
 * 1. �켱 �������� �湮ó���ϰ� ť�� �ִ´�.
 * 2. queue�� �ƹ��͵� ������ ����������(�湮���� �������� ����������) while���� ������.
 * 3. �׸��� level���� ������ ���ؼ� ť�� �ִ� ���� ���� �湮�Ѵ�.(queue�� size��ŭ �� ����.)
 * 4. ���� �湮�ϸ鼭 4���� ���� ��� �˻��ϸ� �湮���� ���� ����� ���� �ִ��� ã�� ���� ������ �湮�ϱ� ���ؼ� queue�� �ִ´�.
 */

// �� ���� ���������� �ڵ� �Ϻ��� ��������!!!!!!!!!!!!!

public class BOJ_2589 {
	static int n,m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		} //End of Input
		
		int result = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) { // map�� ���鼭 'L'�̶��(�������) bfsŽ�� ����
				if(map[i][j]=='L') {
					visited = new boolean[n][m]; // visited�� �ʱ�ȭ.
					int val = bfs(i,j);
					result = Math.max(result, val);
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		int val = 0;
		visited[i][j] = true;			// �湮ó�� ���ش�.
		q.add(new Point(j,i,0));		// ���⼭ ť�� �־��ٶ� �� i,j ���� �ٲ��ִ����� �������� ���η�!
										/*
										 * Ȯ���Ѱ� �ƴ����� map�� ����غ��� ó���� map[n][m] ���� ���������� �� Point Ŭ������ x,y�� �������� ����
										 * x�� ���� m�� y�ప�� n�� ���ԵǾ� �ִ� �ų� ��������.. -> �׷��� ����Ʈ ��ü�� ��ǥ�� �������ָ鼭 �ٽ� �ٲ� �־��ش�?
										 * �̰� �´µ�
										 */
		
		while(!q.isEmpty()) {	// ť�� �������� �ݺ�(ť�� ������� �ʴٸ�)
			Point p = q.poll(); // Point p�� q���� �����͸� �̾Ƴ���.
			
			for(int d=0; d<4; d++) {
				int newX = p.x + dx[d];
				int newY = p.y + dy[d];
				if(newX >=0 && newX < m && newY >= 0 && newY < n && !visited[newY][newX] && map[newY][newX] == 'L') {
					visited[newY][newX] = true;
					q.add(new Point(newX, newY, p.cnt+1));
					val = Math.max(val,p.cnt+1);
				}
			}
		}
		return val;
	}
	
	public static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	}
