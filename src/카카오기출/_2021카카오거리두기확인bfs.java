package 카카오기출;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	class node {
		int x, y, dist;
		public  node(int x,int y,int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int index = 0; index<places.length; index++) {
        	char[][] map = new char[5][5];
        	for(int i=0; i<5; i++) {
        		for(int j=0; j<5; j++) {
        			map[i][j] = places[index][i].charAt(j);
        		}
        	}
        	answer[index] = bfs(map);
        }
        return answer;
    }
    
    public int bfs(char[][] map) {
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<5; j++) {
    			if(map[i][j] != 'P') continue; //해당지점 사람아니라면 skip
    			boolean[][] visited = new boolean[5][5];
    			Queue<node> q = new LinkedList<>();
    			q.add(new node(i,j,0));
    			visited[i][j] = true;
    			
    			while(!q.isEmpty()) {
    				node cur = q.poll();
    				
    				for(int dir=0; dir<4; dir++) {
    					int nx = cur.x + dx[dir];
    					int ny = cur.y + dy[dir];
    					int ndist = cur.dist + 1;
    					
    					if(ndist > 2) continue;
    					if(nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
    					if(visited[nx][ny]) continue;
    					if(map[nx][ny] == 'P') continue;
    					if(map[nx][ny] == 'O') {
    						visited[nx][ny] = true;
    						q.add(new node(nx,ny,ndist));
    					}
    				}
    			}
    		}
    	}
    	return 1;
    }
}