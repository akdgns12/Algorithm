package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 한칸에 최대 1마리
// 아기상어의 초기 크기는 2
// 아기상어는 1초에 상하좌우 한칸 씩 이동
//몇 초동안 엄마상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하라
/*
 * 	0: 빈 칸
	1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
	9: 아기 상어의 위치
 */
public class 아기상어 {
	static class Info{
		int x,y,dist;
		
		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static boolean isRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
	static int N; // map 크기
	static int M; // 물고기 마리수
	static int size;
	static int count;
	static int time;
	static int[][] map;
	static int sharkX, sharkY; 
	
	static ArrayList<Info> fishes;
	static int[] dr = {-1,1,0,0}; // 상 하 좌 우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2; // 초기 나이 2로 세팅
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			fishes = new ArrayList<Info>(); // 먹을 수 있는 물고기의 정보를 담을 수 있는 ArrayList생성
			
			Queue<Info> q = new LinkedList<Info>(); // bfs 수행을 위한 큐 생성
			
			boolean[][] visited = new boolean[N][N]; // 방문 표시를 하기 위한 boolean 타입의 2차원 배열 생성
			
			q.offer(new Info(sharkX, sharkY, 0)); // 상어의 위치 큐에 삽입, 물고기를 먹었으므로 0으로 거리 갱신
			
			visited[sharkX][sharkY] = true;
			
			while(!q.isEmpty()) {
				Info shark = q.poll();
				
				for(int i=0; i<4; i++) { // 상하좌우 탐색
					int nx = shark.x + dr[i];
					int ny = shark.y + dc[i];
					
					if(isRange(nx,ny))
						continue; // 범위 체크
					
					if(visited[nx][ny]) 
						continue; // 방문했는지 여부 체크
					
					// 먹이를 찾은 경우(0보다 크고 상어의 사이즈보다 작은 경우만 먹을 수 있다는 조건)
					if(map[nx][ny] >= 1 && map[nx][ny] < size) {
						q.offer(new Info(nx, ny, shark.dist + 1)); // 상어의 위치 갱신
						fishes.add(new Info(nx,ny,shark.dist+1)); // 먹이 리스트에 삽입
						visited[nx][ny] = true; // 방문 표시
					}
					
					// 먹을 수는 없지만 지나갈 수 있는 경우(0이거나 상어의 사이즈와 같은 경우 지나갈 수 있다는 조건)
					else if(map[nx][ny] == size || map[nx][ny] == 0	) {
						q.offer(new Info(nx, ny, shark.dist+1)); // 상어 위치 갱신
						visited[nx][ny] = true; // 방문 표시
					}
				}
			}
			
			// 사이즈가 0인 경우 먹을 수 있는 물고기가 없는 경우이므로 출력
			if(fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			// 먹을 물고기가 있는 경우
			Info eatingFish = fishes.get(0);
			for(int i=1; i<fishes.size(); i++) {
				if(fishes.get(i).dist < eatingFish.dist) { // 거리가 최소인 물고기로 갱신
					eatingFish = fishes.get(i);
				}
				
				if(eatingFish.dist == fishes.get(i).dist) { // 거리가 같은 경우 X가 작은 물고기가 우선순위가 되므로 갱신
					if(eatingFish.x > fishes.get(i).x) {
						eatingFish = fishes.get(i);
					}
				}
			}
			
			time += eatingFish.dist; // 먹을 물고기의 거리를 time에 추가 
			count++;
			map[eatingFish.x][eatingFish.y] = 0; // 물고기를 먹은 자리 0으로 갱신
			
			if(count == size) { // 먹은 물고기의 수와 상어의 사이즈가 같은 경우
				size++; // 상어의 사이즈 1증가
				count = 0; // 다시 카운트는 0 으로 초기화
				
			}
			
			sharkX = eatingFish.x; // 상어의 위치 갱신
			sharkY = eatingFish.y; // 상어의 위치 갱신
		}
	}	
}
