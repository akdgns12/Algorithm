package �Ĺ�Ȩ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// �ٽ� �غ��� ���ذ� ����
// BOJ_1189
// DFS ����
/*
 * 1. T�ΰ�� �̰ų� �̹� �湮�� ��쿡�� �� �� ���� ���Դϴ�.
 * 2. �湮�� �� �� dfs�� ȣ���� ������� ���� ȣ�� �Ŀ��� �ش� �� �湮�ߴ� ����� �������ν� �ٸ� ��ο���
 * 	   �� ��츦 ���ϴ� ���� �����մϴ�.
 */
public class �Ĺ�Ȩ1 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static boolean[][] visited;
	static int r,c,k,ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(br.readLine());
			}
		}
		map[r-1][0]=1;
		dfs(r-1,0,-1);
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int distance) {
		if(distance == k && x == 0 && y == c-1) {
			ans++;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(map[nx][ny] == 'T') continue;
			if(nx<0 || nx>=r || ny <0 || ny >= c)continue;
			if(visited[nx][ny])continue;
			visited[nx][ny] = true;
			dfs(nx, ny, distance+1);
			visited[nx][ny]=false;
		}
	}
}
