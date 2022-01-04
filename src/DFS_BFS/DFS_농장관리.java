package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * <문제 조건>
 * 농장에 있는 산봉우리 개수를 구하라
 * 산봉우리 : 같은 높이를 가지는 하나의 격자 혹은 인접한 격자들의 집합
 * 인접하다 : x좌표 차이와 y좌표 차이 모두 1이하일 경우  -> 상,하,좌,우 대각선에 위치한 좌표까지 인접한 케이스
 */
//DFS로 풀기에 수월한 문제
//주변이 나보다 높은지를 체크해서 꼭대기 인지를 확인해야 한다
public class DFS_농장관리 {
	static int n,m, cnt;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	//상,하,좌,우 + 대각선 = 8방 탐색
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
			//꼭대기가 아니면 값을 더하지 않기 위해 사용
			if(map[nx][ny] > map[x][y]) 
				flag = false;
			if(!visited[nx][ny] && map[nx][ny] == map[x][y])
				dfs(nx, ny);
		}
	}

}
