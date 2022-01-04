package ���α׷��ӽ�level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * n*m  map���� 1,1���� ����� �� 
 * ����� ������ �����ϴ� ĭ�� ������ �ּڰ�
 * map���� 0�� �� 1�� ��
 * �ʱ� ���´� ĳ���ʹ� (1,1) ���� ������ (n,m)�� ��ġ
 */
/*
 * BFS�� ����ϴ� ������ �ִܰ�θ� Ž���ϱ� �����̴�. 

��������� distance�� ������ �ֱ� ���� Node class�� ����� �־���.

BFS�� ��ȯ Ÿ���� int������ ���־� x, y�� ���� ��忡 �����ߴٸ� 
�� ���� distance��, q�� �� ���Ҵµ��� x, y�� �������� ���ߴٸ� �����ִٴ� �ǹ�
�̹Ƿ� -1�� ��ȯ�ϵ��� ���־���.
 */
public class ���Ӹ��ִܰŸ� {
	  int[] dx = {0, 1, 0, -1};
	    int[] dy = {-1, 0, 1, 0};
	    boolean[][] visited;
	    int n, m;
	    
	    public int solution(int[][] maps) {
	        n = maps.length;
	        m = maps[0].length;
	        
	        visited = new boolean[n][m];
	        return bfs(0, 0, maps);
	    }
	    
	    public int bfs(int x, int y, int[][] maps) {
	        Queue<Node> q = new LinkedList<>();
	        q.offer(new Node(x, y, 1));
	        visited[x][y] = true;
	        
	        while(!q.isEmpty()) {
	            Node node = q.poll();
	            if(node.x == n - 1 && node.y == m - 1) return node.distance;
	            
	            for(int i = 0; i < 4; i++) {
	                int nx = node.x + dx[i];
	                int ny = node.y + dy[i];
	                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
	                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
	                        visited[nx][ny] = true;
	                        q.offer(new Node(nx, ny, node.distance + 1));
	                    }
	                }
	            }
	        }
	        return -1;
	    }
	    
	    public class Node {
	        int x;
	        int y;
	        int distance;
	        
	        public Node(int x, int y, int distance) {
	            this.x = x;
	            this.y = y;
	            this.distance = distance;
	        }
	    }
	}
