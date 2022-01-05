package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//
public class 다리만들기 {
	static int N;
	static int[][] map;
	static int[] dx = {0,0,1,-1}; //
	static int[] dy = {1,-1,0,0};
	static int landNum = 2;
	static boolean[][] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		// 0 : 바다 , 1: 육지
		/*
		 * 한 섬과 다른 섬을 잇는 다리 하나만 만들고(가장 짧게)
		 * 섬 : 동서남북으로 붙어있는 덩어리
		 * 가장 짧은 다리 : 다리가 차지하는 칸의 수가 가장 작은 다리
		 * 가장 짧은 다리를 놓아 두 대륙을 연결하는 다리의 길이 return
		 */
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) { // 아직 이름이 정해지지 않은 섬
					makeLand(i,j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2) {
					visited = new boolean[N][N]; // 재초기화
					bfs(i,j);
				}
			}
		}
		
		System.out.println(answer);
	}
	// 섬 별로 이름 붙여주기
	public static void makeLand(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		visited[x][y] = true;
		map[x][y] = landNum;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if((nx >=0 && nx < N && ny >= 0 && ny < N) 
						&& !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = landNum;
					q.offer(new Node(nx, ny, 0));
				}
			}
		}
		
		landNum++;
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y, 0));
		int currentLandNum = map[x][y]; // 현재 섬 번호
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if((nx >= 0 && ny >= 0 && nx < N && ny < N) 
						&& !visited[nx][ny] && map[nx][ny] != currentLandNum) { // 방문안하고 바다 혹은 다른 섬인 경우
					visited[nx][ny] = true;
					if(map[nx][ny] == 0) { // 바다
						q.offer(new Node(nx, ny, node.cnt+1));
					}else { // 다른 섬
						answer = Math.min(answer, node.cnt);
					}
				}
				
				
				
			}
		}
	}
	
	static class Node{
		int x, y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}
