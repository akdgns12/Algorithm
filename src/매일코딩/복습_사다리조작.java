package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_사다리조작 {
	static int n,m; // n: 세로선의 개수, m:가로선의 개수
	static int h; // 세로선마다 가로선을 놓을 수 있는 위치의 개수 h
	static int ans;
	static int[][] map;
	static boolean isFinish = true;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a 높이에서 b번과 b+1번 세로선을 연결한다.
			map[a][b] = 1; // 1 : 우측으로 이동
			map[a][b+1] = 2; // 2 : 좌측으로 이동.
		}
		
		//추가할 가로선의 갯수를 미리 정해놔야 탐색종료 조건으로 걸 수 있다.
		// 아래 반복문에서 i는 추가할 가로선의 갯수
		for(int i=0; i<=3; i++) {
			ans = i;
			dfs(1, 1, 0);
			if(isFinish) break;
		}
		
		System.out.println((isFinish ? ans : -1));
	}
	
	public static void dfs(int x, int y, int count) {
		if(isFinish) return;
		if(ans == count) {
			if(check()) isFinish = true;
			return;
		}
		
		for(int i=y; i<=h; i++) {
			for(int j=x; j<n; j++) {
				// 가로선 두개가 연속으로 놓여질 수 없기 때문에 가로선을 추가하기 전에 연결된 가로선이 있는지 확인한다.
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					// 가로선을 추가한다.
					map[i][j] = 1;
					map[i][j+1] = 2;
					
					dfs(1, 1, count+1);
					
					//추가했던 가로선을 다시 제거한다.(백트래킹)
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
	}
	
	// i번으로 출발해서 i번으로 도착하는지 확인한다.
	public static boolean check() {
		for(int i=1; i<=n; i++) {
			int nx = i;
			int ny = i;
			
			while(ny <= h) {
				if(map[ny][nx] == 1) nx++; // 우측으로 이동
				else if(map[ny][nx] == 2) nx--; // 좌측으로 이동
				ny++; // y축+1칸 이동한다.(아래로 이동)
			}
			
			if(nx != i) return false; // i번으로 출발해서 i번으로 도착하지 않는게 하나라도 있다면 리턴
		}
		
		return true;
	}

}
