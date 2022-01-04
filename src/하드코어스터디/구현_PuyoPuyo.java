package �ϵ��ھ�͵�;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_PuyoPuyo {
	// BOJ 11559 �� 5 / Ǫ��Ǫ�� / ����
	// bfs
	/*
	 * 1. �����¿� ������ �ѿ䰡 4���̻��� ��� ������.
	 * �� �������� BFSŽ���� �ϸ鼭 �� �ѿ��� ��ǥ�� �����ؾ��Ѵ�.
	 * �ѿ��� ���� 4���̻��� ��� �ش� �ѿ���� �ڸ��� '.'���� ��ü�ϴ� ���� �Ͷ߸��� ����
	 * �׷��� ������ ��ǥ�� ������ �ľ��ϱ� ���� �ڷᱸ���� List
	 * 2. �� ���忡 4�� �̻��� �ѿ䰡 ������ �־ ��������� 1ȸ�� ����
	 * �ݺ����� ���� �� ��������� ī��Ʈ�ϴ� ans ������ ���� Ÿ�̹� �߿�
	 * 3. �� ���尡 ���� �ڿ� �����ִ� ��� �ѿ���� �Ʒ��������� ������.
	 */
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static ArrayList<Color> list;
	static int N= 12, M = 6;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		// map�� Ž���Ͽ� 4�� �̻� �����ִ� ��� Ȯ��
		while(true) {
			boolean isFinished = true;
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != '.') {
						list = new ArrayList<>();
						bfs(i,j,map[i][j]);
						
						if(list.size() >= 4) {
							isFinished = false; // ���Ⱑ �Ͼ���Ƿ� �� Ž���ؾ��Ѵ�.
							for(int k=0; k<list.size(); k++) {
								map[list.get(k).x][list.get(k).y] = '.'; // ��Ʈ���� ����
							}
						}
					}
				}
			}
			if(isFinished) break;
			gravity(); // �߷��ۿ�
			count++;
		}
		System.out.println(count);
	}
	
	// �߷��ۿ�
	public static void gravity() {
		for(int i=0; i<M; i++) { // �� ���� ��ȣ
			for(int j=10; j>=0; j--) { // �� ���� ���� �� ��ȣ
				for(int k=11; k>j; k--) // �ش� ��ǥ �ؿ� �ִ� �� ������ for�� k
					if(map[j][i] != '.' && map[k][i] == '.') {
						map[k][i] = map[j][i];
						map[j][i] = '.';
						break;
					}
			}
		}
	}
	// ������ �� ���� ������ Ž��
	public static void bfs(int x, int y, char color) {
		Queue<Color> q = new LinkedList<>();
		list.add(new Color(x,y));
		q.add(new Color(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Color cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >=N || ny >= M) continue;
				if(!visited[nx][ny] && map[nx][ny] == color) { // �湮���� ���� ���������̸�
					visited[nx][ny] = true; // �湮ó�����ְ�
					q.add(new Color(nx, ny));
					list.add(new Color(nx, ny));
				}
			}
		}
	}
	static class Color{
		int x, y;
		public Color(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
