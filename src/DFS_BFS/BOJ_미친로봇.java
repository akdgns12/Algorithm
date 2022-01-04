package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * <로직>
 * DFS + 백트래킹
 * 결국엔 문제에서 구하는 값은 같은 곳을 방문하지 않고 N번동안 이동할 때의 확률을 구하는 것이다.
 * 즉 DFS를 사용하여 N번만큼 이동하되 visited함수를 사용하여 같은 공간을 방문하지 않도록 처리하면 된다.
 * 
 * 이때 이동할 확률을 구하는 방법은 같은 공간을 방문하지 않고 이동하며, 이동할 때마다 이동할 방향의 확률을 곱해서
 * 그 값을 모두 더해주면 된다.
 * 
 * 예를들어 N이 2이고 동 서 남 북으로 이동할 확률이 각각 25라고 할 때 동 -> 동으로 이동할 확률은 다음과 같다
 * 동 -> = 25(동) * 25(동)이 된다.
 * 
 * 즉, DFS로 한 방향으로 계속 방문하되, 이전에 방문한 곳은 방문하지 않으며 해당 방향으로 이동할 때 그 방향의 확률을
 * 곱해주고 N번 이동이 끝나면 그 값을 결과값에 더해주면 된다.
 * 
 * 이 때 N의 최대값은 15이다. 그러므로 시작지점을 15, 15로 잡고 최소 좌표값을 0,0 / 최대 좌표값을 30, 30으로 설정해주었다.
 * = N의 최대값이 15이므로...좌표평면에서 로봇이 N만큼 이동할 때, 로봇이 갈 수 있는 최대 좌표는 30,30 그래서 
 *  최소 좌표값 0,0 / 최대 좌표값 30,30 으로 설정하고 시작점을 15,15로 한 것 
 */
public class BOJ_미친로봇 {
	//로봇이 같은 곳을 중복해서 이동하지 않으면 = 단순한 이동
	// 같은 곳을 중복해서 이동하면 단순하지 않은 이동
	// 로봇의 이동경로가 단순할 확률을 구하라 = 같은 곳을 중복해서 이동할 확률을 구하라
	static int[] dx = {0,0,1,-1}; //동 서 남 북 순서
	static int[] dy = {1,-1,0,0}; 
	static double[] percent;
	static boolean[][] visited;
	static double result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		percent = new double[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
		}
		
		visited = new boolean[30][30]; //시작점을 15, 15로 잡기위함
		result = 0;
		dfs(15, 15, 0, n, 1);
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int idx, int n, double total) {
		if(idx == n) {
			result += total;
			return;
		}
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < 30 && ny < 30) {
				if(visited[nx][ny] == false ) {
					visited[nx][ny] = true;
					dfs(nx, ny, idx + 1, n, total * percent[i]);
					visited[nx][ny] = false;
				}
			}
		}
	}
	}
