package BOJ_4179_��_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ����� �ڷᱸ��
 * char[][] map : �̷θ� ����
 * boolean[][] visited : �������� �湮���� üũ�� ���� �迭
 * int[] dx, dy : ��ǥ�� �� �������� �̵���Ű�� ���� �迭
 * Queue<Point> q : �Ұ� �����̸� �̵���Ű�� ������ ���� ť
 * Point ��ü : ���� ��ǥ x,y�� type(����, ��), count ������ �̵��� �ð��� ����
 * 
 * ����� �Լ�
 * bfs(Queue<Point> q) : �Ұ� �����̸� ���������϶����� �̵���Ų��.
 * isEdge(int x, int y) : �Է¹��� ��ǥ�� �̷��� �����ڸ����� �Ǻ�
 *  �� �������� �̵������� �� �̷��� ������ �Ѿ�� �����ڸ��� ��
 *  isRange(int x, int y) : �Է¹��� ���� ���� �ִ��� �Ǻ�
 *  
 *  ��ü ����
 *  1. �Է��� �����鼭 �������� ��ǥ�� ���� �����صΰ�, ���� ���� queue�� �־��ش�.
 *   	ť�� �� - ������ ������ �ִ� ����?
 *   	�ҿ� Ż �� �ִ� ������ �����̸� ��ġ��Ű�� �ȵǱ� ������ �������� Ȯ�� -> ���� �̵�
 *   
 *   �� �� �������� ��ġ�� �����ڸ��� ���� �ٷ� Ż���� �� �ֱ� ������ 1�� ����ϰ� �����Ѵ�.
 *  2. bfs()�� �����Ѵ�.
 *  	1) �׹������� �̵��ϸ鼭 ������ ����ų�, ���̰ų�, ���� ���� �̵��� �� ������ continue
 *  	2) ���� �湮�� ��ǥ�� !visited[nx][ny] (������ �湮 X)�̰� �����̸� q�� �־��ش�.
 *  	3) ���� ���� map�� �ٷ� ���� Ȯ����� ǥ���ؼ� �湮üũ�� �� �� �ֵ��� �Ѵ�.
 */
public class �� {
	
	static int r,c; // ��, ��
	static char[][] map; // �̷�
	static boolean[][] visited; // �������� �̷� �湮üũ
	static Point jihun;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	// x,y ��ǥ�� ������ Point Ŭ����
	static class Point{
		int x;
		int y;
		int type;
		int count;
		
		public Point(int x, int y, int type, int count) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[r][c];
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0; i<r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				map[i][j] = temp[j];
				
				if(temp[j] == 'J') {
					// ���������� �ٷ� Ż�� ������ ���
					if (isEdge( i, j)) {
						System.out.println(1);
						return;
					}
					
					map[i][j] = '.';
					jihun = new Point(i, j, 0, 0);
			}else if(map[i][j] == 'F') {
				q.add(new Point(i,j,1,0));
			}
		}
	}
		bfs(q);
	}
	
	static void bfs(Queue<Point> q) {
		int x;
		int y;
		int count;
		
		q.add(jihun); // �� - ������ ������ queue�� �־���
		visited[jihun.x][jihun.y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			count = p.count;
			
			// ���� ����
			if( isEdge(x, y) && p.type == 0) {
				System.out.println(count + 1);
				return;
			}
			
			// 4����
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(!isRange(nx, ny) || map[nx][ny] == '#' || map[nx][ny] == 'F') {
					continue;
				}
				
				if(p.type == 0 && !visited[nx][ny] ) {
					//����
					q.add(new Point(nx, ny, p.type, count+1));
					visited[nx][ny] = true;
				}else if(p.type == 1) {
					//��
					map[nx][ny] = 'F';
					q.add(new Point(nx, ny, p.type, count+1));
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
	
	/*
	 * MAP�� ������ ������� �Ǻ�
	 * @return : �Է¹��� ��ǥ�� �������� ������ true
	 */
	
	static boolean isRange(int x, int y) {
		if( x >=0 && y >= 0 && x < r && y < c) {
			return true;
		}
		return false;
	}
	
	/*
	 * MAP�� �����ڸ����� �Ǻ�
	 * @return : �����ڸ��̸� true
	 */
	static boolean isEdge(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(nx, ny)) {
				return true;
			}
		}
		return false;
	}
}
