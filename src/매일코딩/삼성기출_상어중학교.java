package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
// ������ ��� : -1, ������ ��� : 0, �Ϲ� ���: M������ �ڿ���
/*
 * 1. ũ�Ⱑ ���� ū ��ϱ׷��� ã�� �����ϰ� ������ ��� ���� ������ ��´�
 * 2. ���ŵ� ���� map���� �߷��ۿ�(������ ��� �����ϰ� ������ ��� ���� ���� ū ���� �̵�)
 * 3. map 90�� �ݽð� ȸ��
 * 4. �߷��ۿ�
 * 
 * 1~4 �� ����Ŭ ��ϱ׷��� �������� ���������� �ݺ�
 */

/*
 * <���̵��>
 * ���� ũ�Ⱑ ���� ū ��ϱ׷� ã�� ���� �Լ�
 * �׷� : �Ϲݺ���� ��� �ϳ� ����, �Ϲ� ����� ���� ��� ���ƾ���.
 * 		����������� �����ϸ� �ȵ�, ������ ����� �󸶳� �ֵ� ��� x
 * 		�׷쿡 ���� ����� ������ 2���� ũ�ų� ���ƾ���.
 * 		�׷쿡 ���� ��ϵ��� �����ϰ� ����Ǿ��־����
 * �׷��� ���� ��� : ������ ����� �ƴϰ�, ���� ��ȣ ���� �۰� ���� ��ȣ �������� ���
 *  
 * map ��� �����������
 */
public class �Ｚ����_������б� {
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
		
		N = Integer.parseInt(st.nextToken()); // ���� ũ��
		M = Integer.parseInt(st.nextToken()); // ���� ����
		
		map = new int[N][N];
		zeros = new ArrayList<>();
		area = new PriorityQueue<>();
		visited = new boolean[N][N];
		// ��� ���� �Է�
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
					if(map[i][j] == 0) { // ��������ϵ� Point ArrayList�� �ֱ�
						zeros.add(new Point(i,j));
					}
				}
			}
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(!visited[i][j] && map[i][j] > 0) { // �湮�� �� ���� �Ϲݺ���̶�� 							bfs(i, j, map[i][j]);
							bfs(i,j,map[i][j]);
						}
					}
				}
				
				// ���� -2�� �� ��
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
		
	// �ݽð� ���� 90�� ȸ�� �Լ�
	public static void rotate() {
		
	}
	
	public static void find() {
		int blockCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == -1) // ����������� skip
					continue;
				// �Ϲ� ����� ���� ��� ���ƾ���
				if(map[i][j] > 0 )
			}
		}
	}

	// �߷� �ۿ� �Լ�
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
