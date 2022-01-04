package ����Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_������б� {
	static class Point implements Comparable<Point>{
		int x, y, size, rainbowCnt;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point(int x, int y, int size, int rainbowCnt) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.rainbowCnt = rainbowCnt;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (this.size > o.size) {
				return -1;
			} else if (this.size == o.size) {
				if (this.rainbowCnt > o.rainbowCnt)
					return -1;
				else if (this.rainbowCnt == o.rainbowCnt) {
					if (this.x > o.x)
						return -1;
					else if (this.x == o.x) {
						return -1 * Integer.compare(this.y, o.y);
					} else
						return 1;
				} else
					return 1;
			} else
				return 1;
		}
	}
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Point> rainbowList;
	static PriorityQueue<Point> Blockarea; // ������ ũ�Ⱑ 2�̻��� ����� �������� �켱����ť�� �־� �������� �����ϴ� ���ǿ� �´� ���� ����� ���� �տ� �ֵ��� �ϱ�.
	static int score = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		rainbowList = new ArrayList<Point>();
		Blockarea = new PriorityQueue<Point>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 
		while(true) {
			Blockarea.clear();
			visited = new boolean[N][N];
			rainbowList.clear();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 0) { // ������ ��� ��ǥ Point�� �ֱ�
						rainbowList.add(new Point(i,j));
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// map[i][j] > 0 -> �Ϲݺ���̸鼭 �湮���� ���� ��
					if(map[i][j] > 0 && !visited[i][j]) {
						// bfs�� ���� ū ��ϱ׷� ã��
						bfs(i, j, map[i][j]);
					}
				}
			}
			
			// ���� -2�� �� ��
			if(Blockarea.isEmpty())
				break;
			
			Point p = Blockarea.poll();
			score += Math.pow(p.size, 2); // ��������
			erase(p.x, p.y, map[p.x][p.y]);
			find();
			rotate();
			find();
		} // end while
		
		System.out.println(score + " ");
	}
	
	public static void rotate() {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = copy[j][N - 1 - i];
			}
		}
	}
	
	public static void find() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 0) {
					gravity(i, j);
				}
			}
		}
	}
	
	public static void gravity(int x, int y) {
		if (map[x + 1][y] != -2) {
			return;
		}
		for (int i = x + 1; i < N; i++) {
			if (map[i][y] != -2) {
				map[i - 1][y] = map[x][y];
				map[x][y] = -2;
				return;
			}
		}
		if (map[N - 1][y] == -2) {
			map[N - 1][y] = map[x][y];
			map[x][y] = -2;
			return;
		}
	}
	
	// bfs�� ���� ���� ū ������ ã�´�. �� �� ���� ����� ���� ���� ������
	// ������ ���� ã�� ���̱� ������ (0,0)���� Ž�� ����
	public static void bfs(int x, int y, int color) {
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Point(x, y, 0, 0)); // x, y, size, rainbowCnt
		int size = 0; // ��α׷� ������ ũ��
		int cnt = 0;  // ������ ��� ����
		while(!q.isEmpty()) {
			size++;
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) { // ���� ��ǥ�� ������ ����� �ʰ�
					if(!visited[nx][ny] && (map[nx][ny] == color || map[nx][ny] == 0)) { // ���� ��ǥ�� ���� �����̰ų� ���������
						if(map[nx][ny] == 0) // ������ ����̶��
							cnt++;
						q.offer(new Point(nx, ny, p.size+1, cnt));
					}
				}
			}
		} // end while
		if(size > 1) // ������ ũ�Ⱑ 2�̻��� ����� ����ũ�⸦ �켱���� ť�� �ִ´�. size = ã�� ��ϱ׷��� ũ��
			rainbowList.add(new Point(x, y, size, cnt));
		recoverrainbowList();
	}
	
	public static void recoverrainbowList() {
		for(Point p : rainbowList) {
			visited[p.x][p.y]= false; 
		}
	}
	
	// ó���� ��ϱ׷� ������ ��ǥ�� -2�� �������༭ ����� �۾� BlockSize�� rainbowCnt�� �߿����� ����
	public static void erase(int x, int y, int color) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0, 0));
		boolean[][] v = new boolean[N][N];
		v[x][y] = true;
		map[x][y] = -2;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
					if (!v[nx][ny] && (map[nx][ny] == color || map[nx][ny] == 0)) {
						queue.offer(new Point(nx, ny, 0, 0));
						map[nx][ny] = -2;
						v[nx][ny] = true;
					}
				}
			}
		}
	}
}
