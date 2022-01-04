package 보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * <착상>
 * dfs로 L의 깊이를 하나씩 늘려가며 탐색하면 될거라 생각했는데, 이것보다는 bfs를 통해
 * 시작점을 잡고 탐색해주는게 훨씬 더 효과적이다.
 * <알고리즘>
 * bfs
 * 1. 우선 시작점을 방문처리하고 큐에 넣는다.
 * 2. queue에 아무것도 남은게 없을때까지(방문하지 않은곳이 없을때까지) while문을 돌린다.
 * 3. 그리고 level별로 나누기 위해서 큐에 있는 점을 먼저 방문한다.(queue의 size만큼 다 돈다.)
 * 4. 점을 방문하면서 4가지 방향 모두 검사하며 방문하지 않은 연결된 점이 있는지 찾고 다음 레벨에 방문하기 위해서 queue에 넣는다.
 */

// 이 문제 개복습하자 코드 완벽히 이해하자!!!!!!!!!!!!!

public class BOJ_2589 {
	static int n,m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		} //End of Input
		
		int result = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) { // map을 돌면서 'L'이라면(육지라면) bfs탐색 시작
				if(map[i][j]=='L') {
					visited = new boolean[n][m]; // visited를 초기화.
					int val = bfs(i,j);
					result = Math.max(result, val);
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		int val = 0;
		visited[i][j] = true;			// 방문처리 해준다.
		q.add(new Point(j,i,0));		// 여기서 큐에 넣어줄때 왜 i,j 순서 바꿔주는지도 이해하자 씨부레!
										/*
										 * 확실한건 아니지만 map을 상상해보면 처음에 map[n][m] 으로 선언해줬을 땐 Point 클래스의 x,y축 개념으로 보면
										 * x축 값에 m이 y축값에 n이 대입되어 있는 거나 마찬가지.. -> 그래서 포인트 객체에 좌표로 저장해주면서 다시 바꿔 넣어준다?
										 * 이게 맞는듯
										 */
		
		while(!q.isEmpty()) {	// 큐가 빌때까지 반복(큐가 비어있지 않다면)
			Point p = q.poll(); // Point p는 q에서 데이터를 뽑아낸다.
			
			for(int d=0; d<4; d++) {
				int newX = p.x + dx[d];
				int newY = p.y + dy[d];
				if(newX >=0 && newX < m && newY >= 0 && newY < n && !visited[newY][newX] && map[newY][newX] == 'L') {
					visited[newY][newX] = true;
					q.add(new Point(newX, newY, p.cnt+1));
					val = Math.max(val,p.cnt+1);
				}
			}
		}
		return val;
	}
	
	public static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	}
