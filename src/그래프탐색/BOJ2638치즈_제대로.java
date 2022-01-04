package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 외부공기, 내부공기 어떻게 구분할 것인지가 관건
 * 1. (0,0)에서 bfs탐색을 시작해서 외부공기들만 큐에 넣으면서 탐색 외부공기는 2로 인덱싱해준다
 * 치즈는 넣지 않고 탐색했기 떄문에 내부공기에 접근하지 않는다. 탐색한 외부공기들을 2로 인덱싱하고
 * 2. 남은 치즈들을 탐색하면서 2로 인덱싱된 외부공기와 접촉하는 면이 2이상이면 녹을 대상이라고 3으로 인덱싱
 * 3. 녹을 대상(3)으로 표기된 치즈들을 외부공기로 바꿔준다(2)
 * 4. 1~3 반복
 */

// 문제점.. 로직은 맞지만 자바에서는 시초가 난다..
/*
 * 해결방법 -> 매핑해서 일일히 다시 검사하는 것보다는 첫 bfs탐색에서
 * 외부공기와 맞닿은 적이 있는 치즈를 카운팅해주는 방법으로
 * 나중에 카운팅이 2이상이면 공기로 바꿔주는 형식으로 진행해야 할 듯
 */
public class BOJ2638치즈_제대로 {
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int time;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			boolean flag = false;
			
			bfs(); // (1) 치즈 내, 외부 구분시키기
			
			// (2) 모든 치즈 칸들을 대상으로 녹을 수 있는지 확인하기
			flag = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					// 해당 칸이 치즈일경우
					if(map[i][j] == 1) {
						int cnt = 0;
						// 그 칸의 상,하,좌,우를 살펴보고 최소 2칸이  외부공기(2로매핑된)곳인지 확인
						for(int k=0; k<4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							// 범위 안이고, 외부공기와 접촉했다면
							if(nx >= 0 && ny >= 0 && nx < N && ny < M
									&& map[nx][ny] == 2) {
									flag = true;
									cnt++;
							}
						}
						if(cnt >= 2) map[i][j] = 5; // 접촉면 2이상이면 녹는대상으로 표기 = 5
					}
				}
			} // end outer for
			
			// (3) 녹는 대상으로 표기된 적이 있을 경우 외부공기로 바꾸기
			if(flag) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(map[i][j] == 5) {
							map[i][j] = 2;
						}
					}
				}
			}
			time++;
			
			flag = false;
			// 치즈가 남아있는지 재검사
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						flag = true;
					}
				}
			}
			if(!flag) break;
		} // end while
		
		
		System.out.println(time);
	}
		// 외부공기 큐에 넣어주면서 탐색
		public static void bfs() {
			
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(0,0)); // 0,0 은 무조건 공기니까 여기부터 ㄱㄱ
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					// 범위 벗어나면 skip
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					// 방문하지 않았고 && 공기이고 && 치즈가 아니라면
					if(!visited[nx][ny] && map[nx][ny] == 0 && map[nx][ny] != 1) {
						visited[nx][ny] = true;
						map[nx][ny] = 2; // 외부공기 2로 매핑
						q.offer(new Node(nx, ny));
					}
				}
			} // end while	
		}
		
		static class Node{
			int x, y;
			public Node(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	}

