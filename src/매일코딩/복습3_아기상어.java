package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����3_�Ʊ��� {
	static class Info{
		int x,y,dist;
		
		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int sharkX,sharkY; // ��� ��ġ
	static int time;
	static int count;
	static int size;
	
	static ArrayList<Info> fishes; // ���� �� �ִ� ����� ����
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2;
		
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
			fishes = new ArrayList<Info>(); // ���� �� �ִ� ����� ���� ���� ArrayList ����
			
			Queue<Info> q = new LinkedList<>();
			
			visited = new boolean[N][N];
			
			q.offer(new Info(sharkX, sharkY, 0));
			
			visited[sharkX][sharkY] = true;
			
			while(!q.isEmpty()) {
				Info shark = q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = shark.x + dr[i];
					int ny = shark.y + dc[i];
					
					if(isRange(nx, ny))
						continue;
					if(visited[nx][ny])
						continue;
					
					// ���� �� �ִ� ����� ã�� ���
					if(map[nx][ny] >= 1 && map[nx][ny] < size) {
						q.offer(new Info(nx, ny, shark.dist+1));
						fishes.add(new Info(nx, ny, shark.dist+1));
						visited[nx][ny] = true;
					}else if(map[nx][ny] == 0 || map[nx][ny] == size) { //���� ���� ������ ������ �� �ִ� ���
						q.offer(new Info(nx, ny, shark.dist+1));
						visited[nx][ny] = true;
					}
				}
			}
			
			//����� 0�� ��� ���� �� ���� ������̹Ƿ� ���
			if(fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			//���� �� �ִ� ������� ���
			Info eatingFish = fishes.get(0);
			for(int i=1; i<fishes.size(); i++) {
				if(eatingFish.dist > fishes.get(i).dist) { // �Ÿ��� �ּ��� ������ ����
					eatingFish = fishes.get(i);
				}
				
				if(eatingFish.dist == fishes.get(i).dist) { // �Ÿ��� ���� ��� x�� �� ���� ����Ⱑ �켱����
					if(eatingFish.x > fishes.get(i).x) {
						eatingFish = fishes.get(i);
					}
				}
			}
			
			time += eatingFish.dist; // ���� ������� �Ÿ��� time�� �߰�
			count++; //�Ծ����Ƿ� ī��Ʈ ����
			map[eatingFish.x][eatingFish.y] = 0;
			
			if(count == size) {
				size++;
				count = 0;
			}
			
			sharkX = eatingFish.x;
			sharkY = eatingFish.y;
		}
	}

	public static boolean isRange(int x, int y) {
		return x < 0  || x >= N || y < 0 || y >= N;
	}
}
