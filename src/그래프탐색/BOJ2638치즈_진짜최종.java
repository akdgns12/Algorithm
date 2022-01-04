package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638ġ��_��¥���� {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] check; // �ش� ��ǥ�� ġ� �ܺΰ���� �´��� Ƚ�� ī���� �ϴ� check �迭
	static int sum = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)  // ġ�� ���� ���س���
					sum++;
			}
		}
		
		int time = 0;
		while(true) {
			if(sum == 0) break;
			
			check = new int[N][M];
			visited = new boolean[N][M];
			bfs();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(check[i][j] > 1)
						map[i][j] = 0;
					sum--;
				}
			}
			time++;
		}// end while
		
		System.out.println(time);
	}
	// �ܺΰ��� �����鼭 Ž�� -> ġ�� ������ check�迭 ī���� -> check ī���� Ƚ�� 2�̻��̸� ����� �ٲ���
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0,0)); // (0,0)���� ���� -> ���� ������ ����ϱ�
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == 1) { // ġ����
					check[nx][ny]++;
					continue;
				}
				
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
				}
			
			}
		} // end while 
		
	}// end bfs
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x =x;
			this.y = y;
		}
	}
}	
