package 컴백홈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 다시 해보자 미해결 문제
// BOJ_1189
// DFS 문제
/*
 * 1. T인경우 이거나 이미 방문한 경우에는 갈 수 없는 길입니다.
 * 2. 방문을 한 후 dfs를 호출해 다음길로 가며 호출 후에는 해당 길 방문했던 기록을 없앰으로써 다른 경로에서
 * 	   온 경우를 제하는 것을 방지합니다.
 */
public class 컴백홈1 {
	
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
