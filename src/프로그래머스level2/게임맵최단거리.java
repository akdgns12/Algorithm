package 프로그래머스level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * n*m  map에서 1,1에서 출발할 때 
 * 상대팀 진영에 도달하는 칸의 개수의 최솟값
 * map에서 0인 벽 1은 길
 * 초기 상태는 캐릭터는 (1,1) 상대방 진영은 (n,m)에 위치
 */
/*
 * BFS를 사용하는 이유는 최단경로를 탐색하기 때문이다. 

현재까지의 distance를 저장해 주기 위해 Node class를 만들어 주었다.

BFS의 반환 타입을 int형으로 해주어 x, y가 도착 노드에 도착했다면 
그 때의 distance를, q를 다 돌았는데도 x, y에 도착하지 못했다면 막혀있다는 의미
이므로 -1을 반환하도록 해주었다.
 */
public class 게임맵최단거리 {
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
