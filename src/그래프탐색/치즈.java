package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 치즈 {
	/*
	 * DFS를 이용하여 풀 수 있는 문제
	 * 외부공기와 맞닿은 치즈가 녹는데,몇 초만에 모든 치즈가 녹을 것이고, 다 녹기 1초전에는 
	 * 몇 개의 치즈가 있었는지 구하는게 핵심.
	 * 처음에 치즈를 기준으로 상하좌우 방향에 공기가 있는지 확인하고, 공기가 있으면 지우는 방식으로
	 * 로직을 짜려고 했으나, 치즈 안에 공기가 있을 때는 치즈가 녹지 않는 반례가 있다.
	 * 
	 * 그래서 치즈가 아닌, 공기를 기준으로 상하좌우 방향으로 DFS로 탐색하면서 외부 공기와 맞닿은 치즈를
	 * 찾아야 한다.
	 * 문제에서 판의 테두리에는 치즈가 위치할 수 없다고 했기 때문에 (0,0)은 반드시 공기
	 * 
	 * 그리고 주의할점.
	 * (0,0)에서 시작해서 외부 공기와 맞닿은 치즈를 찾았을 때, 바로 map[i][j] = 0과 같이 그 치즈를
	 * 즉시 공기로 만들면 안된다.
	 * 
	 * 만약, 특정 판이 "011"인 구간이 있다고 가정하면, 왼쪽에서 2번째 있는 1은 공기와 맞닿아 있는 것은 자명하다.
	 * 하지만, 이 1을 바로 0으로 만들어버리면 동시에 오른쪽에서 1번째에 있는 1도 외부 공기와 맞닿아 있다고 판단하게 된다.
	 * 
	 * 따라서 바로 map[i][j] = 0으로 처리하는 것이 아니라, 임의의 숫자를 주어서 "1초 뒤 녹을 예정인 치즈"라는
	 * 의미를 담아야 한다. 나는 2라는 숫자를 주기로 했다.
	 * 
	 * 이제 DFS를 돌리면서 마지막까지 탐색이 끝났다고 합시다.
	 * 마지막 점까지 탐색이 끝났다는 의미는 1초가 지났다는 뜻이기 때문에 "1초뒤 녹을 예정인 치즈"를 모두 녹여줘야 한다.
	 * 
	 * 여기서, 나는 isCheese()라는 반환형이 boolean인 메소드하나 설정
	 * 이 메소드는 "1초 뒤 녹을 예정인 치즈"를 모두 녹여주고, 맵 전체에 하나라도 남아있는지 확인하는 메소드
	 * 
	 * 이 메소드의 반환값은 true 또는 false이기 때문에 메인 메소드의 반복문의 조건으로 지정하면, 몇 초뒤에
	 * 치즈가 녹는지 판단하기 용이하다.
	 * 
	 */
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cheesCnt;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// 0 : 치즈가 없는 부분, 1 : 치즈가 있는 부분
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		int ans;
		for(ans = 0; isCheese(); ans++) {
			// 초기 세팅
			for(boolean[] arr : visited) {
				Arrays.fill(arr,false);
			}
			
			visited[0][0] = true;
			count = 0;
			
			dfs(0,0);
		}
		
		System.out.println(ans);
	}
	
	// 판 위에 치즈가 존재하는가?
	public static boolean isCheese() {
		// map[i][j] = 2로 표시된 부분은 공기와 맞닿은 치즈이므로
		// 먼저 공기로 바꿔줘야 함.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
		
		// 판 위에 치즈가 존재하는지 체크.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) { 
				if(map[i][j] == 1) { // 치즈가 존재한다면
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(!visited[nx][ny]) {
				visited[nx][ny] = true;
				if(map[nx][ny] == 1) { // 치즈라면
					map[nx][ny] = 2;
					count++; // 다음에 지워질 치즈의 개수
				}else {
					dfs(nx,ny);
				}
			}
		} // end for
		
	} // end dfs

}
