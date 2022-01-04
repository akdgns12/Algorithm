package 치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * (착상)
 * 1의 주변이 0이면 녹는다? -> 치즈속 구멍에 해당하는 0들이 있기 때문에 예외 존재
 * if bfs -> queue에 1을 넣는다? -> x
 * if dfs -> depth = time? -> 1 hour 지날 때 마다 가장 바깥  1 remove
 * <알고리즘>
 * 치즈 속 구멍에 해당하는 0을 바깥 0과 어떻게 구별하냐가 문제.
 */

/*
 * BFS로 바깥 공기와 내부공간을 구별해주는게 맞았다.
 * <알고리즘>
 * 1. 외부공기를 모두 탐색해서 -1로 바꾼다
 * - 언제나 첫번째 행과 열, 마지막 행과 열은 비어 있다고 하였으므로(0,0)을 잡고 bfs를 돌리면서 연결된 모든 공기들(0 또는 -1)을 모두 -1로 바꿔주면 된다.
 * 2. map을 2중 for문으로 탐색하며, 가장자리의 치즈인 경우에만 bfs 탐색을 하여 모든 가장자리 치즈들을 찾아서 removeQ에 넣어준다.
 * - 가장자리만 탐색하는 이유는 어차피 bfs를 돌면서 연결된 모든 치즈들을 탐색하기 때문에, 중복 탐색하는 낭비를 줄이기 위함.
 * - 가장자리 치즈의 좌표는 모두 removeQ에 넣은 뒤, 마지막에 한번에 제거하면 된다.
 * 3. 만약 removeQ의 크기가
 * - 0이라면 더이상 녹일 치즈가 없다는 의미이므로 반복문을 종료.
 * - 아니라면 removeQ의 크기를 이전 단계의 녹일 치즈 갯수를 의미하는 pre변수 값에 저장.
 * 4. 몇 단계가 지났는지 셀 변수인 phase를 +1 한다.
 * 5. bfs를 돌면서 채웠던 removeQ를 1개씩 뽑으며 가장자리 치즈를 녹여주고, 그 자리는 외부공기(-1)로 채워준다.
 */
/*
 * #2<알고리즘>
 * 1. Input 과정에서 치즈의 개수를 저장한다.
 * 2. cheeze의 개수가 0이 될때까지 bfs를 반복, cnt를 저장하고 time을 증가.
 * 2-1 bfs(0,0)에서 시작
 * 2-2 공기를 만나면 Queue에 삽입, 치즈를 만나면 0으로 변경하고 치즈의 개수를 줄인다.
 * 2-3 치즈와 공기 상관없이 방문처리 필수
 */
public class BOJ_2636 {
	
	static int n,m,cheeze,cnt,time;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					cheeze++;
				}
			}
		}
		
		while(cheeze!=0) {
			time++;
			cnt = cheeze;
			bfs();
		}
		System.out.println(time);
		System.out.println(cnt);
	}
	
	// 코드 참조 복습하자
	public static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});  // 큐에 0,0 시작점 넣어준다
		visited = new boolean[n][m];
		visited[0][0]=true;	
		
		while(!que.isEmpty()) {
			int[] cur = que.poll(); // 큐가 빌때까지 큐에서 데이터를 꺼내온다.
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny  >= m || visited[nx][ny]) continue;
				if(map[nx][ny] == 1 ) { //만약 치즈가 있다면 치즈를 줄여주고 그곳을 0으로 바꾼다.
					cheeze--;
					map[nx][ny] = 0;
				} else if( map[nx][ny] == 0) {
					que.offer(new int[] {nx,ny});
				}
				visited[nx][ny] = true; //방문처리
			}
		}
	}
}
/*
 *  입력
 *  치즈 : 1
 *  없는 경우 : 0
 *  
 *  판의 가장자리(<그림 1>에서 네모 칸에 X친 부분)에는 치즈가 놓여 있지 않으며 치즈에는 하나 이상의 구멍이 있을 수 있다.
 *  -> 내부 외부를 구분할 방법
 *  
 *  출력 
 *  첫줄 : 치즈가 녹는데 소요되는 시간. -> 시간(수행 횟수)
 *  다음줄 : 모두 녹기 한시간 전 남아있는 치즈 조각 수. -> 출력 전 조각
 *  
 *  map -> -1 : 치즈  / 0 : 내부  / cnt : 외부 공기 
 *  
 *  치즈와 맞닿은 공기를 기준으로 풀이
 */
/*
class pair {
	int row;
	int col;

	public pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {

	static int N, M, last, cnt; 	// 행, 렬, 마지막 치즈 조각, 시간
	static boolean check = true; 	// while 문을 위한 boolean
	static int[][] map; 			// 입력받을 2차원 배열
	static boolean[][] visit; 		// 방문 관리 2차원 배열
	static Queue<pair> updateAirQueue = new LinkedList<pair>(); // 주변을 외부 공기로 변환 할 좌표
	static Queue<pair> meltQueue = new LinkedList<pair>(); 		// 주변 치즈를 녹일 공기 좌표

	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	// 범위 검사
	public static boolean isValid(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= M)
			return false;
		return true;
	}

	// 내부 공기 -> 외부 공기 구분 및 변환
	public static void makeMapBFS() {

		// 첫 호출만 동작
		if (updateAirQueue.isEmpty())
			updateAirQueue.offer(new pair(0, 0));

		while (!updateAirQueue.isEmpty()) {
			int row = updateAirQueue.peek().row; // peek() 큐의 첫번째 값 참조
			int col = updateAirQueue.poll().col;
			map[row][col] = cnt; 	// 외부공기 구분
			visit[row][col] = true;

			for (int k = 0; k < 4; k++) {
				int nextRow = row + dy[k];
				int nextCol = col + dx[k];

				// 범위 검사
				if (!isValid(nextRow, nextCol))
					continue;

				// 방문 검사
				if (visit[nextRow][nextCol])
					continue;

				// 내부 공기 외부공기로 치환
				if (map[nextRow][nextCol] == 0) {
					visit[nextRow][nextCol] = true; // 방문 처리
					updateAirQueue.offer(new pair(nextRow, nextCol));
					continue;
				}

				// 주변에 치즈가 있는 경우
				if (map[nextRow][nextCol] == -1) {
					visit[nextRow][nextCol] = true;
					meltQueue.offer(new pair(row, col)); // 주변 치즈를 녹일 공기 좌표를 큐에 삽입.
				}
			}
		}
	}

	// 치즈 녹이기 && 치즈 -> 공기로 바뀐 좌표 처리
	public static void targetCheese() {

		while (!meltQueue.isEmpty()) {
			int row = meltQueue.peek().row;
			int col = meltQueue.poll().col;

			for (int k = 0; k < 4; k++) {
				int nextRow = row + dy[k];
				int nextCol = col + dx[k];

				// 범위 검사 && 주변이 치즈인 경우
				if (isValid(nextRow, nextCol) && map[nextRow][nextCol] == -1) {
					map[nextRow][nextCol] = cnt + 1; 					// 해당 자리는 공기로 치환 (변환된 치즈의 개수)
					updateAirQueue.offer(new pair(nextRow, nextCol)); 	// 큐에 입력(이웃한값들을 탐색하기 위해)
				}
			}
		}

		// 더이상 치즈가 없는 경우
		if (updateAirQueue.isEmpty()) {
			check = false;
			return;
		}

		++cnt; // 횟수 추가
		last = updateAirQueue.size(); // 치즈 개수
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];		// 입력 받을 2차원 배열
		visit = new boolean[N][M];	// 방문 관리 2차원 배열
		cnt = 2; 	// 외부 공기 및 시간 관리
		last = 0; 	// 마지막 치즈 조각 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1; // 치즈인 경우
				}
			}
		} // end of input


		while (check) {
			makeMapBFS(); 	// 공기 구분
			targetCheese(); // 치즈 녹이기
		}

		sb.append(cnt - 2 + "\n" + last + "\n");
		br.close();
		System.out.println(sb);
	}
}
*/
