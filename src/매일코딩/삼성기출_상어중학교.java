package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
// 검은색 블록 : -1, 무지개 블록 : 0, 일반 블록: M이하의 자연수
/*
 * 1. 크기가 가장 큰 블록그룹을 찾아 제거하고 제거한 블록 제곱 점수를 얻는다
 * 2. 제거된 후의 map에서 중력작용(검은색 블록 제외하고 나머지 블록 행이 가장 큰 수로 이동)
 * 3. map 90도 반시계 회전
 * 4. 중력작용
 * 
 * 1~4 한 사이클 블록그룹이 존재하지 않을때까지 반복
 */

/*
 * <아이디어>
 * 먼저 크기가 가장 큰 블록그룹 찾는 조건 함수
 * 그룹 : 일반블록이 적어도 하나 존재, 일반 블록의 색은 모두 같아야함.
 * 		검은색블록은 포함하면 안됨, 무지개 블록은 얼마나 있든 상관 x
 * 		그룹에 속한 블록의 개수는 2보다 크거나 같아야함.
 * 		그룹에 속한 블록들은 인접하게 연결되어있어야함
 * 그룹의 기준 블록 : 무지개 블록이 아니고, 행의 번호 가장 작고 열의 번호 가장작은 블록
 *  
 * map 계속 갱신해줘야함
 */
public class 삼성기출_상어중학교 {
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int size;
		int rainbowCnt;
		
		public Point() {
			
		}
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public Point(int x, int y, int size, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.rainbowCnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if(this.size > o.size) {
				return -1;
			}else if(this.size == o.size) {
				if(this.rainbowCnt > o.rainbowCnt)
					return -1;
				else if(this.rainbowCnt == o.rainbowCnt) {
					if(this.x > o.x)
						return -1;
					else if(this.x == o.x) {
						return -1 * Integer.compare(this.y, o.y);
					}else
						return 1;
			}else
				return 1;
		}else 
			return 1;
		}
	}
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static ArrayList<Point> zeros;
	static PriorityQueue<Point> area;
	static int score = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 격자 크기
		M = Integer.parseInt(st.nextToken()); // 색상 개수
		
		map = new int[N][N];
		zeros = new ArrayList<>();
		area = new PriorityQueue<>();
		visited = new boolean[N][N];
		// 블록 정보 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			area.clear();
			visited = new boolean[N][N];
			zeros.clear();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 0) { // 무지개블록들 Point ArrayList에 넣기
						zeros.add(new Point(i,j));
					}
				}
			}
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(!visited[i][j] && map[i][j] > 0) { // 방문한 적 없고 일반블록이라면 							bfs(i, j, map[i][j]);
							bfs(i,j,map[i][j]);
						}
					}
				}
				
				// 비우기 -2는 빈 곳
				if(area.isEmpty())
					break;
				
				Point p = area.poll();
				score += Math.pow(p.size, 2);
				erase(p.x, p.y, map[p.x][p.y]);
				find();
				rotate();
				find();
			}
		
		System.out.println(score);
		
	}
		
	// 반시계 방향 90도 회전 함수
	public static void rotate() {
		
	}
	
	public static void find() {
		int blockCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == -1) // 검은색블록은 skip
					continue;
				// 일반 블록의 색은 모두 같아야함
				if(map[i][j] > 0 )
			}
		}
	}

	// 중력 작용 함수
	public static void gravity() {
		
	}
	
	public static void bfs(int x, int y, int color) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x,y,0,0)); // x,y,size,rainbowCnt
		visited[x][y] = true;
		int size = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			size++;
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
					if(!visited[nx][ny] && (map[nx][ny] == color || map[nx][ny] == 0)) {
						if(map[nx][ny] == 0)
							cnt++;
						q.offer(new Point(nx, ny, p.size+1, cnt));
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		if(size > 1)
			area.add(new Point(x, y, size, cnt));
		recoverZeros();
	}
	
	public static void recoverZeros() {
		for(Point p : zeros) {
			visited[p.x][p.y]= false; 
		}
	}
}
