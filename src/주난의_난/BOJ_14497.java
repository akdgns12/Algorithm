package 주난의_난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * DFS 재귀로 풀었다.
 * 구글엔 BFS풀이가 많은데 첫 발상을 DFS로 접근해서 풀어냈다.
 * DFS로 풀게되면 Input으로 받는 주난이와 범인의 좌표가 그다지 중요하지 않은데 이렇게 해도 되는건지 모르겠다.
 * <알고리즘>
 * 1. '*' 주난이의 위치가 나올때까지 map을 탐색한다.
 *  1) '*' 주난이의 위치가 나오면 dfs 함수를 실행해준다.
 * 2. dfs에서 방문처리해주고 4방향 탐색을 시작한다.
 *  1) 탐색하면서 1인 곳은 0으로 바꿔주고 0인 곳은 1이나올때까지 dfs함수를 재귀호출해준다.
 *  2) 범인의 위치가 나오면 탈출한다.
 * 3. 방문처리에 유의..
 */
public class BOJ_14497 {
	
	static int n,m;
	static char[][] map; //교실
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean flag = false;
	static int x1, y1, x2, y2; // 주난이 위치 x1,y1 범인 위치 x2,y2
	
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
					// 주난의 점핑 dfs로 시작
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
					// 1이라면 0으로 바꿔서 사망을 시키고 visited를 걸어놔야 나중에 왔을 때 어? 죽어있네 하고 재귀를 안 할 수 있다.
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
