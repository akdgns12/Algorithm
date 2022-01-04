package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �����ִܰŸ�_����� {
	static int N, M;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Node> q = new LinkedList<>();
	
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
				
				if(map[i][j] == 2) // ���� ��ǥ
					q.offer(new Node(i,j));
			}
		}
		
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > 0) // ���� ��ǥ�� �ʱⰪ�� 2�� ���� ���
					sb.append(map[i][j] - 2 + " ");
				
				else // �� �� ���� ��ġ
					sb.append(0 + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// bfs �˰������� ���� ��ġ���� ��� ���������� �Ÿ� ���ϱ�
	public static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == 1) { // �� �� �ִ� ��
					map[nx][ny] = map[node.x][node.y] + 1;
					q.offer(new Node(nx,ny));
				}
			}
		}
	}
	
	static class Node{
		int x, y;
		int cnt;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
