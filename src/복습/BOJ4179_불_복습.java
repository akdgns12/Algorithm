package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179_��_���� {
	static int R,C;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int ans = Integer.MAX_VALUE;
	static Node man;
	static Queue<Node> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					// ���������� �ٷ� �r�� ������ ���
					if(isEdge(i,j)) {
						System.out.println(1);
						return;
					}
					
					map[i][j] = '.'; // ������ �ڸ����� �� �̵������� �ڸ��� �ٲ��ش�
					man = new Node(i,j,0,0);
				}else if(map[i][j] == 'F') { // �� �ʱ���ġ�� ���
					q.offer(new Node(i,j,1,0)); // ť�� �Ҹ��� �־��ش�
				}
			}				
		}
		
		bfs();
	}
	
	public static void bfs() {
		 q.offer(man); // �� - ������ ������ ť�� �־��ش� �Һ��� �־���
		 visited[man.x][man.y] = true;
		 
		 int cnt = 0;
		 while(!q.isEmpty()) {
			 Node node = q.poll();
			 
			 // ��������
			 if(isEdge(node.x, node.y) && node.type == 0) {
				 System.out.println(node.cnt+1);
				 return;
			 }
			 
			 for (int i = 0; i < 4; i++) {
	                int nx = node.x + dx[i];
	                int ny = node.y + dy[i];

	                if (!isRange(nx, ny) || map[nx][ny] == '#' || map[nx][ny] == 'F') {
	                    continue;
	                }

	                if (node.type == 0 && !visited[nx][ny]) {
	                    // ����
	                    q.add(new Node(nx, ny, node.type, node.cnt + 1));
	                    visited[nx][ny] = true;
	                } else if (node.type == 1) {
	                    // ��
	                    map[nx][ny] = 'F';
	                    q.add(new Node(nx, ny, node.type, node.cnt + 1));
	                }
	            }
	        }

	        System.out.println("IMPOSSIBLE");
	}

	/*
	 * map�� ������ ������� �Ǻ�
	 * return : �Է¹��� ��ǥ�� ���� ���� ������ true
	 */
	public static boolean isRange(int x, int y) {
		if(x >= 0 && y >= 0 && x < R && y < C) {
			return true;
		}
		return false;
	}
	
	/*
	 * map�� �����ڸ����� �Ǻ�
	 * return : �����ڸ��̸� true
	 */
	public static boolean isEdge(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(nx, ny)) {
				return true;
			}
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
