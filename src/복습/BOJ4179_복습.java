package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179_���� {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Node> q = new LinkedList<>();
	static Node man;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		// tyep 1 : ����, type 0 : ��
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') { // ������ ���
					if(isEdge(i,j)) { // ���� �ʱ� ������ ��ġ�� �����ڸ��� ���
						// �ٷ� Ż��
						System.out.println(1);
						return;
					}
					
					map[i][j] = '.';
					man = new Node(i,j,1,0); 
				}else if(map[i][j] == 'F') { // ���� �ʱ���ġ�� ���
					q.offer(new Node(i,j,0,0));
				}
			}
		}
		
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
	}
	
	public static void bfs() {
		q.offer(man);
		visited[man.x][man.y]= true; 
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			// ��������(�����ڸ��̰�, �����ΰ��)
			if(isEdge(node.x, node.y) && node.type == 1) {
				ans = node.cnt+1;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// ���� ����ų� ���̰ų�, ���̸� skip
				if(!isIn(nx,ny) || map[nx][ny] == 'F' || map[nx][ny] == '#') 
					continue;
				// �湮���� ���� �������� ���
				if(!visited[nx][ny] && node.type == 1) {
					q.offer(new Node(nx, ny, node.type, node.cnt +1));
					visited[nx][ny] = true;
				}else if(node.type == 0) { // ���� ���
					map[nx][ny] = 'F';	
					q.offer(new Node(nx ,ny, node.type, node.cnt+1));
				}
			}
		}
	}
	/*
	 * �����ڸ����� �Ǻ� �Լ�
	 * return : �����ڸ��̸� true
	 */
	public static boolean isEdge(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isIn(nx,ny)) {
				return true;
			}
		}
		return false;
	}
	/*
	 * ���� ���� �ִ��� �Ǻ� �Լ�
	 * return : ���� ���̸� true
	 */
	public static boolean isIn(int x, int y) {
		if(x >= 0 && y >= 0 && x < R && y < C) {
			return true;
		}
		return false;
	}

	static class Node{
		int x,y;
		int type;
		int cnt;
		
		public Node(int x, int y, int type, int cnt) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.cnt = cnt;
		}
	}
}
