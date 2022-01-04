package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_����3 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		 * ����
		 * 1. ������ bfs�� �쿩�ش�
		 *   1-1. ���� ������ ������ ��Ƽ� 0�̵� ������ ������ ���� �� ������
		 *   	   ������� visited�� �湮ó�� ���ش�.
		 * 2. dfs�� �� ��̷� �и��Ǿ����� üũ�Ѵ�.
		 * �� ���̼��� 2�̻��� ������ 1~2�� �ݺ��Ѵ�.
		 */
		int cnt = 0;
		int ans = 0;
		
		while((cnt = seperateNum()) < 2) {
			if(cnt == 0) { // ��������. �� ���������� �и����� ������ 0���
				ans = 0;
				break;
			}
			bfs();
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static int seperateNum() {
		visited = new boolean[N][M];
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					dfs(i,j,visited);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(!visited[nx][ny] && map[nx][ny] != 0) {
				dfs(nx,ny,visited);
			}
		}
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) { // �����̶��
					// ť�� �־��ְ� �湮ó��
					q.offer(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int seaNum = 0;
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					seaNum++;
				}
			}
			if(map[node.x][node.y] - seaNum < 0) {
				map[node.x][node.y] =0;
			}else {
				map[node.x][node.y] -= seaNum; 
			}
		}
	}

	static class Node{
		int x,y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
