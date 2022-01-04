package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ���� {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	
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
		
		//bfs�� ���� ������
		int cnt = 0;
		int ans = 0;
		
		while((cnt = seperateNum()) < 2) {
			if(cnt == 0) {
				ans = 0;
				break;
			}
			bfs();
			ans++;
		}
		
		System.out.println(ans);
	}
	// ���ϰ� �� ���̷� �и��Ǿ����� Ȯ���ϴ� �Լ�
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
		
		// ���ϸ� �湮ó�� ���༭ ���� ���ϸ� ���Ͻ� ���� ���ϰ� ��� �ٴٰ� �Ȱ� �������� �ʰ� �Ѵ�.
		// �׸��� ���ϸ� ť�� �־��ش�.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					q.offer(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int seaNum = 0; // ������ �����¿� �ٴ��� �� ���� ����
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// ���� ����� skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// �湮���� �ʾҰ� �ٴٶ��
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					seaNum++;
				}
			}
			
			if(map[node.x][node.y] - seaNum < 0) {
				map[node.x][node.y] = 0; 
			}else {
				map[node.x][node.y] -= seaNum; 
			}
		}
	}
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
