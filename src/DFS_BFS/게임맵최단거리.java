package DFS_BFS;

import java.util.*;

public class ���Ӹ��ִܰŸ� {
	static boolean[][] visited;
	static int n,m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public class Node{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public int bfs(int x, int y, int[][] maps) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y,1));
		visited[x][y] = true;
		
	
		
		while(q.isEmpty()) {
			Node node = q.poll();
			//ǥ�� �� ������ �Ʒ� = �������� �������� ��� cost ���
			if(node.x == n-1 && node.y == m-1 )
				return node.cost;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >=0 && ny >=0 && nx < n && ny < m) {
					if(maps[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, node.cost+1));
					}
				}
			}
		}
		return -1; //q�� �ٵ��Ҵµ��� x,y�� �������� ���ߴٸ� �����ִٴ� �ǹ̷� -1��ȯ
	}
	
	public int solution(int[][] maps) {
		//BFS, DFS?
		
		visited = new boolean[n][m];
		n = maps.length;
		m = maps[0].length;

		
		
		return bfs(0,0, maps);
	}
}
