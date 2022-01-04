package �ֳ���_��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * DFS ��ͷ� Ǯ����.
 * ���ۿ� BFSǮ�̰� ������ ù �߻��� DFS�� �����ؼ� Ǯ��´�.
 * DFS�� Ǯ�ԵǸ� Input���� �޴� �ֳ��̿� ������ ��ǥ�� �״��� �߿����� ������ �̷��� �ص� �Ǵ°��� �𸣰ڴ�.
 * <�˰���>
 * 1. '*' �ֳ����� ��ġ�� ���ö����� map�� Ž���Ѵ�.
 *  1) '*' �ֳ����� ��ġ�� ������ dfs �Լ��� �������ش�.
 * 2. dfs���� �湮ó�����ְ� 4���� Ž���� �����Ѵ�.
 *  1) Ž���ϸ鼭 1�� ���� 0���� �ٲ��ְ� 0�� ���� 1�̳��ö����� dfs�Լ��� ���ȣ�����ش�.
 *  2) ������ ��ġ�� ������ Ż���Ѵ�.
 * 3. �湮ó���� ����..
 */
public class BOJ_14497 {
	
	static int n,m;
	static char[][] map; //����
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean flag = false;
	static int x1, y1, x2, y2; // �ֳ��� ��ġ x1,y1 ���� ��ġ x2,y2
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = temp[j];
			}
		}
		
		int cnt = 0;
		
		while(true) {
			visited = new boolean[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == '*') {
					// �ֳ��� ���� dfs�� ����
					dfs(i, j);
					cnt++;
				}
			}
		}
			if(flag) {
				System.out.println(cnt);
			break;
	}
		}
	}
	
	static void dfs(int x, int y) {
		
		if(visited[x][y]) return;
		visited[x][y] = true;
		
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx< 0 || nx >= n || ny < 0 || ny >= m ) continue;
				if(map[nx][ny] == '0') dfs(nx,ny);
				
				else if(map[nx][ny] == '1') {
					// 1�̶�� 0���� �ٲ㼭 ����� ��Ű�� visited�� �ɾ���� ���߿� ���� �� ��? �׾��ֳ� �ϰ� ��͸� �� �� �� �ִ�.
					visited[nx][ny] = true;
					map[nx][ny] = '0';
				}
				else if(map[nx][ny] == '#') {
					flag = true;
					break;
				}
			
		}
		return;
	}
}
