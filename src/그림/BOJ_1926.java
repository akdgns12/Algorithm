package �׸�;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
	static int n,m;
	static int[][] map;
	static int size; // 1�� ����� ���.
	static int cnt=0; // 1�� ���� ����
	static int max; // 1�� �ְ� ������
	static int[] dx = {1,-1,0,0}; //�� �� �� �� ������ Ž��
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	public static Queue q = new LinkedList<Point>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		// Input
		for(int i=0; i<n; i++	) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) { //map�� �� �� �� Ž���ϴ� for��
				if(map[i][j] == 1 && !visited[i][j]) {
					size = 0;
					q.offer(new Point(i,j));
					bfs(i,j);
					cnt++;
				}
			}
		}
		
		if(cnt == 0) {
			System.out.println(0);
			System.out.print(0);
		}else {
			System.out.println(cnt);
			System.out.println(max);
		}
	}
	
	public static void bfs(int x, int y) {
		q.offer(new Point(x,y));
		visited[x][y] = true;
		
		size++;
		while(!q.isEmpty()) { //ť�� ��������
			Point temp = (Point) q.poll(); // q�� �־��� x,y��ǥ�� �־��ְ� ����
			
			for(int d=0; d<4; d++) { // �� �� �� �� 4�������� Ž��
				int nx = temp.x + dx[d];
				int ny = temp.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) { // ���� ��ǥ�� ���� ��� ��
					continue;
				}
				
				if(map[nx][ny] == 0 || visited[nx][ny]) { //���� ĭ�� 0�̰ų� �湮������
					continue; //��� for�� ����
				}
				
				// ���� ĭ�� �湮 ���߰� 1�� ��
				
				q.offer(new Point(nx,ny));
				visited[nx][ny] = true;
				size++;
			}
		}	
			max = max > size ? max : size;
		}
}
