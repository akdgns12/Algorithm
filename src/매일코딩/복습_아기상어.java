package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습_아기상어 {
	static class Info{
		int x,y,dist;
		
		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	static int N;
	static int M;
	static int sharkX, sharkY;
	static int[][] map;
	static int size;
	static int time;
	static int count;
	static boolean[][] visited;
	static ArrayList<Info> fishes;
	static int[] dr  ={-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		size = 2;
		map = new int[N][N];
		
		// 입력으로 주어진 값을 입력받고 상어가 주어진 위치 0으로 초기화
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
			fishes = new ArrayList<Info>(); // 먹을  수 있는 물고기의 정보를 담은 ArrayList생성
			
			Queue<Info> q = new LinkedList<>();
			
			visited = new boolean[N][N];
			
			q.offer(new Info(sharkX, sharkY, 0)); // 상어의 위치 q에 삽입, 물고기를 먹었으므로 0으로 거리 갱신
			
			visited[sharkX][sharkY] = true;
			
			while(!q.isEmpty()) {
				Info shark = q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = shark.x + dr[i];
					int ny = shark.y + dc[i];
					
					if(isRange(nx,ny))
						continue;
					if(visited[nx][ny])
						continue;
					// 먹이를 찾은 경우
					if(map[nx][ny] >= 1 && map[nx][ny] < size) {
						q.offer(new Info(nx, ny, shark.dist+1));
						fishes.add(new Info(nx, ny, shark.dist+1));
						visited[nx][ny] = true;
					}
					
					// 먹을 수는 없지만 지나갈 수 있는 경우
					else if(map[nx][ny] == size || map[nx][ny] == 0) {
						q.offer(new Info(nx, ny, shark.dist+1));
						visited[nx][ny] = true;
					}
				}
			}
			
			// 사이즈가 0인 경우 먹을 수 있는 물기고기가 없는 경우이므로 출력
			if(fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			//먹을 물고기가 있는 경우
			Info eatingFish = fishes.get(0);
			for(int i=1; i<fishes.size(); i++) {
				if(fishes.get(i).dist < eatingFish.dist) { // 거리가 작은 물고기로 갱신
					eatingFish = fishes.get(i);
				}
				
				if(eatingFish.dist == fishes.get(i).dist) { // 거리가 같은 경우 X가 작은 물고기가 우선순위
					if(eatingFish.x > fishes.get(i).x) {
						eatingFish = fishes.get(i);
					}
				}
			}
			
			time += eatingFish.dist; // 먹을 물고기의 거리를 time에 추가
			count++; // 먹었으므로 카운트 증가
			map[eatingFish.x][eatingFish.y] = 0; //물고기를 먹은 자리 0 으로 갱신
			if(count == size) { //먹은 물고기 수와 상어의 사이즈가 같은 경우
				size++;
				count = 0;
			}
			
			sharkX = eatingFish.x;
			sharkY = eatingFish.y;
			
		}
		
		
	}
	
	public static boolean isRange(int x, int y) {
		return x <0 || x >= N || y < 0 || y >= N;
	}

}
