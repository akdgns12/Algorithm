package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 상어중학교 {
	static int[][] map;
	static boolean[][] visit;
	static int n, m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Point> zeros;
	static PriorityQueue<Point> area;
	static int score = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		map = new int[n][n];
		zeros = new ArrayList<>();
		area = new PriorityQueue<>();
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		while (true) {
			area.clear();
			visit = new boolean[n][n];
			zeros.clear();
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					if(map[i][j] == 0)
						zeros.add(new Point(i, j));
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j] && map[i][j] > 0) {
						bfs(i, j, map[i][j]);
					}
				}
			}
			// 비우기 -2는 빈곳
			if (area.isEmpty())
				break;

			Point p = area.poll();
			score += Math.pow(p.size, 2);
			erase(p.x, p.y, map[p.x][p.y]);
			find();
			rotate();
			find();
		}
		bw.write(score + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static void rotate() {
		// TODO Auto-generated method stub
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			copy[i] = map[i].clone();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = copy[j][n - 1 - i];
			}
		}
	}

	private static void find() {
		// TODO Auto-generated method stub
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] >= 0) {
					gravity(i, j);
				}
			}
		}
	}

	private static void gravity(int x, int y) {
		if (map[x + 1][y] != -2) {
			return;
		}
		for (int i = x + 1; i < n; i++) {
			if (map[i][y] != -2) {
				map[i - 1][y] = map[x][y];
				map[x][y] = -2;
				return;
			}
		}
		if (map[n - 1][y] == -2) {
			map[n - 1][y] = map[x][y];
			map[x][y] = -2;
			return;
		}
	}

	private static void bfs(int x, int y, int color) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0, 0));
		visit[x][y] = true;
		int size = 0;
		int cnt = 0;
		while (!queue.isEmpty()) {
			size++;
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n)) {
					if (!visit[nx][ny] && (map[nx][ny] == color || map[nx][ny] == 0)) {
						if (map[nx][ny] == 0)
							cnt++;
						queue.offer(new Point(nx, ny, p.size + 1, cnt));
						visit[nx][ny] = true;
					}
				}
			}
		}
		if (size > 1)
			area.add(new Point(x, y, size, cnt));
		recoverZeros();
	}

	private static void recoverZeros() {
		for (Point p : zeros) {
			visit[p.x][p.y] = false;
		}
	}

	private static void erase(int x, int y, int color) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0, 0));
		boolean[][] v = new boolean[n][n];
		v[x][y] = true;
		map[x][y] = -2;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n)) {
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

class Point implements Comparable<Point> {
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
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", size=" + size + "]";
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
