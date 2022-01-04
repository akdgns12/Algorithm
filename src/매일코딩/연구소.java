package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. ���� 3�� �����
 * 2. ���� ���� ���·� ���̷����� Ȯ�Ž�Ų��.
 * 3. ���� ������ ���Ѵ�.
 * 4. ���� ������ �ݺ��ϸ� ���������� �ִ��� ���Ѵ�.
 */
/*
 * ������ ��ġ�� �� 3���� ��ġ(DFS)
 * ���̷����� �������� �� �ִ� ��ġ�� ���̷����� ǥ��(BFS)
 * ���������� ������ ã�´�.
 */
public class ������{
	// ���̷��� ��ü
	static class virus{
		int x, y;
		
		virus(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;	// ������ ���� ũ��
	static int m;	// ������ ���� ũ��
	
	static int[][] map; // ����
	static int[][] virus_map; // ���� ī��
	
	static int[] dr = {-1,1,0,0}; // �� �� �� ��
	static int[] dc = {0,0,-1,1}; // �� �� �� ��
	
	static int max = Integer.MIN_VALUE; // �������� ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		// ���� �Է�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �� ����鼭 ���̷��� �Ѹ��� ����
		dfs(0);
		
		System.out.println(max);
	}
	
	// �� �����
	public static void dfs(int depth) {
		// �� 3���� �� �������� ���̷��� �Ѹ���
		if(depth == 3) {
			bfs();
			return;
		}
		
		// �� 3�� �� �������� �ٽ� �����
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) { // �� ĭ�̶��
					map[i][j] = 1; // �������
					dfs(depth + 1);
					map[i][j] = 0; // �ٽ� ��������
				}
			}
		}
	}
	
	public static void bfs() {
		virus_map = new int[n][m];
		Queue<virus> q = new LinkedList<virus>();
		
		// virus map ī��
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				virus_map[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// ���̷������ ť�� �־�
				if(virus_map[i][j] == 2)
					q.add(new virus(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			virus v = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = v.x + dr[i];
				int nc = v.y + dc[i];
				
				// ���� �ȿ� ������
				if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
					// �� ĭ�̶�� ���̷��� �۶߸��� �ٽ� ť�� �ִ´�
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
		
