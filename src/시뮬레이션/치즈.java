package �ùķ��̼�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ġ� ��� ��µ� �ɸ� �ð��� ��� ��� �� �ð� ���� �����ִ� ġ�������� �����ִ�
 * ĭ�� ���� ���ϴ� ���α׷�
 * 
 */
public class ġ�� {
	static int n,m; // ���� ����
	static int cheeze;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int time;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
	
		
		for(int i=0; i<n; i++	) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					// ���� �ٱ��� �ִ� 1���� ��� �Ǵ�����?
					cheeze++;
				}
			}
		}
		
		while(cheeze!=0) {
			time++;
			count = cheeze;
			bfs();
		}
		
		// End of Input
		System.out.println(time);
		System.out.println(count);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0,0});
		visited = new boolean[n][m];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll(); //ť�� �������� ������ �����´�
			for(int i=0; i<4; i++) {
				int	nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
				if(map[nx][ny] == 1	) {
					cheeze--;
					map[nx][ny] = 0;
				}else if(map[nx][ny] == 0) {
					q.offer(new int[] {nx,ny});
				}
				visited[nx][ny] = true;
			}
		}
		
	}
}
