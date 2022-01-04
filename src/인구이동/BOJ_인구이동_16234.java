package 인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_인구이동_16234 {
	static int[][] map;
	static boolean[][] visited;
	static int N,L,R; // n*n 크기 l 이상 r 이하
	static int teamN;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		int time = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // End of Input
		
		int count = 0;
		
		// while 반복문을 통해 
		while(true) {
			boolean hasNext = false;
			visited = new boolean[N][N]; // 방문초기화
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 방문여부, 연합의 개수를 확인하여 이번 턴에 연합이 있는지 확인
					if(!visited[i][j] && check(i,j) > 1) {
						hasNext = true;
					}
				}
			}
			
			if(hasNext) {
				count++;
			}else {
				break;
			}
		}
		
		System.out.println(count);
	}
	
	// 연합확인
	public static int check(int startX, int startY) {
		
		LinkedList<Nation> allies = new LinkedList<>();
		Queue<Nation> q = new LinkedList<>();
		Nation start = new Nation(startX, startY);
		q.add(start);
		allies.add(start);
		visited[startX][startY] = true;
		int sum = map[startX][startY];
		
		while(!q.isEmpty()) { // 큐가 빌떄까지
			
			Nation current = q.poll(); // Nation 큐에 있는 데이터를 뽑는다.
			
			for(int i=0; i<4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(isMoveable(current,nx,ny)) {
					Nation next = new Nation(nx,ny);
					q.add(next);
					allies.add(next);
					sum += map[nx][ny]; // 인근 map에 더해준다
					visited[nx][ny] = true; // 방문처리 최종적으로 해준다.
				}
			}
		}
		
		// 연합이 있으면 연합의 인구수 변경
		if(allies.size() != 1) {
			int result = sum / allies.size();
			
			for(Nation ally : allies) {
				map[ally.x][ally.y] = result;
			}
		}
		
		return allies.size();
	}
	// 이동 가능 여부 확인
	public static boolean isMoveable(Nation current, int nx, int ny) {
		if( nx >=0 && nx < N && ny >=0 && ny < N && !visited[nx][ny]) {
			
			// 인구수의 차이 확인
			int abs = Math.abs(map[current.x][current.y] - map[nx][ny]);
			
			if( L <= abs && abs <= R)
				return true;
		}
		return false;
	}
	
	static class Nation{
		public int x;
		public int y;
		
		public Nation(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	/*
	// 인구 이동 필요한지 전체 지도 확인
	public static boolean check() {
		List<Node> n_list;
		boolean isDone = true; // 이동이 더이상 필요하지 않을 경우 true. 필요한 경우 false
		for(int i=0; i<N; i++) {	
			for(int j=0; j<N; j++) {
				// 방문하지 않은 경우
				if(!visited[i][j]) {
					n_list = new LinkedList<>();
					n_list.add(new Node(i,j));
					//sum - 리스트에 저장된 값의 합.
					int sum = dfs(i,j,n_list,0);
					if(n_list.size() > 1) { // 리스트 크기가 1이상일 경우(=인구이동이 필요한 데이터가 있을 경우)
							change(sum, n_list); //평균값 계산해서 map 갱신
							isDone = false;
					}
			}
		}
	}
	return isDone;
	}
	
	public static void change(int sum, List<Node> n_list) {
		int avg = sum/n_list.size();
		for(Node node:n_list) {
			map[node.x][node.y] = avg;
		}
	}
	
	public static int dfs(int x, int y, List<Node> n_list, int sum) {
		visited[x][y] = true;
		sum = map[x][y];
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || nx >= N || ny <0 || ny >=N) {
				continue;
			}
			if(!visited[nx][ny]) {
				int d = Math.abs(map[x][y] - map[nx][ny]);
				if( d >= L && d <= R) {
					n_list.add(new Node(nx,ny));
					sum += dfs(nx,ny,n_list,sum);
				}
			}
		}
		return sum;
	} */
}

