package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 문제 조건
// i번 세로선의 결과가 i번이 나오도록 사다리 게임을 조작해야할 때, 추가해야 하는 가로선 개수의 최솟값
// 만약 3보다 큰 값이면 -1 출력, 또 불가능한 경우에도 -1 출력

/*
 * 로직
 * 가로선의 정보를 어떤 식으로 저장할까 고민해보자..
 * 그동안 풀어왔던 y축 x축의 map 칸으로 생각하면 된다.
 * 블로그에 참조되어있는 그림을 보며 정확히 이해하자.
 * 
 * 그림에서 최상단 좌측을 (1,1)이라 두고, 값이 저장되는 세 가지 경우를 나누자
 * 0 : 해당 칸에는 가로선이 없다.
 * 1 : 해당 칸을 기준으로 우측으로 연결되는 가로선이 있다.
 * 2 : 해당 칸을 기준으로 좌측으로 연결되는 가로선이 있다.
 * 
 * 1번 높이의 1번과 2번 세로선을 연결하는 가로선이 있다면, map[1][1] = 1; , map[1][2] = 2; 이런식으로 저장
 * 
 * 그런 다음 i번에서 출발해서 i번에 도착하는지 확인하는 체크 용도의 함수가 필요
 * 
 * 마지막으로 DFS탐색의 파라미터로 추가할 가로선의 개수를 지정해줘야 한다. 이게 DFS탐색의 종료조건이 되기 때문
 * 최대 3개의 가로선을 추가할 수 있으므로, 이를 반복문으로 놔두고 각 내부에서 DFS를 호출하는 방법을 이용
 */
public class 사다리조작 {
	static int n, m; // n: 세로선의 개수, m: 가로선의 개수
	static int h; // H:세로선마다 가로선을 놓을 수 있는 위치
	static int ans;
	static int[][] map;
	static boolean isFinish = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // 연결된 가로선의 갯수
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			// x 높이에서 y번과 y+1번 세로선을 연결한다.
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			 
			map[x][y] = 1; // 1 : 우측으로 이동
			map[x][y+1] = 2; // 2 : 좌측으로 이동
		}
		
		// 추가할 가로선의 갯수를 미리 정해놔야 탐색 종료 조건으로 걸 수 있다.
		// 아래 반복문에서 i는 추가할 가로선의 수
		for(int i=0; i<=3; i++) {
			ans = i;
			dfs(1, 1, 0);
			if(isFinish) break;
		}
		
		System.out.println((isFinish ? ans : -1));
	}
	
	// count : 추가한 가로선의 갯수(3개가 넘어가면 더이상 탐색이 무의미) 	
	public static void dfs(int x, int y, int count) {
		if(isFinish) return;
		if(ans == count	) {
			if(check()) isFinish = true;
			return;
		}
		
		for(int i=y; i<= h; i++) {
			for(int j=x; j<n; j++) {
				// 가로선 두 개가 연속으로 놓여질 수 없기 때문에 가로선을 추가하기 전에 연결된 가로선이 있는지 확인한다.
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					//가로선을 추가한다.
					map[i][j] = 1;
					map[i][j+1] = 2;
					
					dfs(1, 1, count+1);
					
					// 추가했던 가로선을 다시 제거한다(백트래킹)
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
			int ny = 1;
			
			while(ny <= h) {
				if(map[ny][nx] == 1) nx++; // 우측으로 이동
				else if(map[ny][nx] == 2) nx--; // 좌측으로 이동
				ny++; // y축 +1칸으로 이동한다. (아래로 이동)
			}
			
			if(nx != i) return false; // i번으로 출발해서 i번으로 도착하지 않는게 하나라도 있다면 리턴
		}
		
		return true;
	}
}
