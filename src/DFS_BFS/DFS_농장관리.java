package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * <���� ����>
 * ���忡 �ִ� ����츮 ������ ���϶�
 * ����츮 : ���� ���̸� ������ �ϳ��� ���� Ȥ�� ������ ���ڵ��� ����
 * �����ϴ� : x��ǥ ���̿� y��ǥ ���� ��� 1������ ���  -> ��,��,��,�� �밢���� ��ġ�� ��ǥ���� ������ ���̽�
 */
//DFS�� Ǯ�⿡ ������ ����
//�ֺ��� ������ �������� üũ�ؼ� ����� ������ Ȯ���ؾ� �Ѵ�
public class DFS_������� {
	static int n,m, cnt;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	//��,��,��,�� + �밢�� = 8�� Ž��
	static int[] dx = {-1,1,0,0,1,1-1,-1};
	static int[] dy = {0,0,-1,1,1,-1,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					flag = true;
					dfs(i,j);
					if(flag) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			//����Ⱑ �ƴϸ� ���� ������ �ʱ� ���� ���
			if(map[nx][ny] > map[x][y]) 
				flag = false;
			if(!visited[nx][ny] && map[nx][ny] == map[x][y])
				dfs(nx, ny);
		}
	}

}
