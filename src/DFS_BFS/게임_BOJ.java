package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_BOJ {
	static int n, m, max; // n : 세로, m : 가로
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
		
		//입력받은 값 맵에 넣기
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
	 * DFS알고리즘을 통해 최대 동전 게임 횟수 구하기
	 */
	
	static void dfs(int x, int y,int moveCount) {
		int moveSquareCount = Character.getNumericValue(map[y][x]); //x만큼 이동해야할 때, 그 x를 가리킴
		dp[y][x] = moveCount;
		if(moveCount > max) {
			System.out.println(moveCount + ".." + y + "," + x);
			max = moveCount;
		}
		
		for(int i = 0; i<dx.length; i++) {
			int nx = x + (moveSquareCount * dx[i]);
			int ny = y + (moveSquareCount * dy[i]);
			
			//맵 밖을 벗어나면 게임 종료
			if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
				continue;
			}
			
			//구멍에 빠지면 게임 종료
			if(map[ny][nx] == 'H') {
				continue;
			}
			
			//이미 다음 지점까지 가기 위해 게임한 횟수가 현재 지점에서 한번 더 한 것보다 크면 어차피 작으므로 할 이유 없다.
			if(moveCount < dp[ny][nx]) {
				continue;
			}
			
			//사이클 발견한 경우 조기종료
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
