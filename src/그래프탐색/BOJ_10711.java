package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10711 {
	// �𷡼� / ��3 / bfs
	/*
	 * �𷡸� �μ��ٴ� ���� ��ü�� Ʋ��! �̷��� �ϸ� ���ʳ�
	 * �𷡸� ť���ִ°� �ƴ� �𷡰� �ƴ� �κ��� �������� �ؾ���!
	 */
	static int H,W;
	static char[][] map;
	static int[] dx = {1,1,0,0,-1,-1,0,1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static boolean[][] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		visited = new boolean[H][W];
		
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// �𷡼����
		while(true) {
			bfs();
		}

		System.out.println(cnt);
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != '.') {
					q.offer(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int seaNum = 0;
			
			for(int i=0; i<8; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// ��������
				if(!isIn(nx,ny) || visited[nx][ny]) continue;
				
				if(map[nx][ny] == '.') {
					seaNum ++;
				} 
			}
			
			if(map[node.x][node.y] <= seaNum) {
				map[node.x][node.y] = '.'; 
			}
		}// end while
		cnt++;
	}
	
	public static boolean isIn(int x, int y) {
		if(x >=0 && y >= 0 && x < H && y < W) {
			return true;
		}
		return false;
	}
	
	static class Node{
		int x,y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
