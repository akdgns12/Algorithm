package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//
public class �ٸ������ {
	static int N;
	static int[][] map;
	static int[] dx = {0,0,1,-1}; //
	static int[] dy = {1,-1,0,0};
	static int landNum = 2;
	static boolean[][] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		// 0 : �ٴ� , 1: ����
		/*
		 * �� ���� �ٸ� ���� �մ� �ٸ� �ϳ��� �����(���� ª��)
		 * �� : ������������ �پ��ִ� ���
		 * ���� ª�� �ٸ� : �ٸ��� �����ϴ� ĭ�� ���� ���� ���� �ٸ�
		 * ���� ª�� �ٸ��� ���� �� ����� �����ϴ� �ٸ��� ���� return
		 */
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) { // ���� �̸��� �������� ���� ��
					makeLand(i,j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2) {
					visited = new boolean[N][N]; // ���ʱ�ȭ
					bfs(i,j);
				}
			}
		}
		
		System.out.println(answer);
	}
	// �� ���� �̸� �ٿ��ֱ�
	public static void makeLand(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		visited[x][y] = true;
		map[x][y] = landNum;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if((nx >=0 && nx < N && ny >= 0 && ny < N) 
						&& !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = landNum;
					q.offer(new Node(nx, ny, 0));
				}
			}
		}
		
		landNum++;
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y, 0));
		int currentLandNum = map[x][y]; // ���� �� ��ȣ
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if((nx >= 0 && ny >= 0 && nx < N && ny < N) 
						&& !visited[nx][ny] && map[nx][ny] != currentLandNum) { // �湮���ϰ� �ٴ� Ȥ�� �ٸ� ���� ���
					visited[nx][ny] = true;
					if(map[nx][ny] == 0) { // �ٴ�
						q.offer(new Node(nx, ny, node.cnt+1));
					}else { // �ٸ� ��
						answer = Math.min(answer, node.cnt);
					}
				}
				
				
				
			}
		}
	}
	
	static class Node{
		int x, y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}
