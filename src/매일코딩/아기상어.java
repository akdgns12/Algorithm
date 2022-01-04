package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ��ĭ�� �ִ� 1����
// �Ʊ����� �ʱ� ũ��� 2
// �Ʊ���� 1�ʿ� �����¿� ��ĭ �� �̵�
//�� �ʵ��� �������� ������ ��û���� �ʰ� ����⸦ ��Ƹ��� �� �ִ��� ���϶�
/*
 * 	0: �� ĭ
	1, 2, 3, 4, 5, 6: ĭ�� �ִ� ������� ũ��
	9: �Ʊ� ����� ��ġ
 */
public class �Ʊ��� {
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
	static int N; // map ũ��
	static int M; // ����� ������
	static int size;
	static int count;
	static int time;
	static int[][] map;
	static int sharkX, sharkY; 
	
	static ArrayList<Info> fishes;
	static int[] dr = {-1,1,0,0}; // �� �� �� ��
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2; // �ʱ� ���� 2�� ����
		
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
			fishes = new ArrayList<Info>(); // ���� �� �ִ� ������� ������ ���� �� �ִ� ArrayList����
			
			Queue<Info> q = new LinkedList<Info>(); // bfs ������ ���� ť ����
			
			boolean[][] visited = new boolean[N][N]; // �湮 ǥ�ø� �ϱ� ���� boolean Ÿ���� 2���� �迭 ����
			
			q.offer(new Info(sharkX, sharkY, 0)); // ����� ��ġ ť�� ����, ����⸦ �Ծ����Ƿ� 0���� �Ÿ� ����
			
			visited[sharkX][sharkY] = true;
			
			while(!q.isEmpty()) {
				Info shark = q.poll();
				
				for(int i=0; i<4; i++) { // �����¿� Ž��
					int nx = shark.x + dr[i];
					int ny = shark.y + dc[i];
					
					if(isRange(nx,ny))
						continue; // ���� üũ
					
					if(visited[nx][ny]) 
						continue; // �湮�ߴ��� ���� üũ
					
					// ���̸� ã�� ���(0���� ũ�� ����� ������� ���� ��츸 ���� �� �ִٴ� ����)
					if(map[nx][ny] >= 1 && map[nx][ny] < size) {
						q.offer(new Info(nx, ny, shark.dist + 1)); // ����� ��ġ ����
						fishes.add(new Info(nx,ny,shark.dist+1)); // ���� ����Ʈ�� ����
						visited[nx][ny] = true; // �湮 ǥ��
					}
					
					// ���� ���� ������ ������ �� �ִ� ���(0�̰ų� ����� ������� ���� ��� ������ �� �ִٴ� ����)
					else if(map[nx][ny] == size || map[nx][ny] == 0	) {
						q.offer(new Info(nx, ny, shark.dist+1)); // ��� ��ġ ����
						visited[nx][ny] = true; // �湮 ǥ��
					}
				}
			}
			
			// ����� 0�� ��� ���� �� �ִ� ����Ⱑ ���� ����̹Ƿ� ���
			if(fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			// ���� ����Ⱑ �ִ� ���
			Info eatingFish = fishes.get(0);
			for(int i=1; i<fishes.size(); i++) {
				if(fishes.get(i).dist < eatingFish.dist) { // �Ÿ��� �ּ��� ������ ����
					eatingFish = fishes.get(i);
				}
				
				if(eatingFish.dist == fishes.get(i).dist) { // �Ÿ��� ���� ��� X�� ���� ����Ⱑ �켱������ �ǹǷ� ����
					if(eatingFish.x > fishes.get(i).x) {
						eatingFish = fishes.get(i);
					}
				}
			}
			
			time += eatingFish.dist; // ���� ������� �Ÿ��� time�� �߰� 
			count++;
			map[eatingFish.x][eatingFish.y] = 0; // ����⸦ ���� �ڸ� 0���� ����
			
			if(count == size) { // ���� ������� ���� ����� ����� ���� ���
				size++; // ����� ������ 1����
				count = 0; // �ٽ� ī��Ʈ�� 0 ���� �ʱ�ȭ
				
			}
			
			sharkX = eatingFish.x; // ����� ��ġ ����
			sharkY = eatingFish.y; // ����� ��ġ ����
		}
	}	
}
