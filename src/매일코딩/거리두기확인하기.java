package 매일코딩;

public class 거리두기확인하기 {
	import java.util.*;

	class Solution {
	    static int[] dx = {-1,1,0,0};
	    static int[] dy = {0,0,-1,1};
	    
	    class node{
	        int x,y,dist;
	        public node(int x, int y, int dist){
	            this.x = x;
	            this.y = y;
	            this.dist = dist;
	        }
	    }
	    
	    public int[] solution(String[][] places) {
	        int[] answer = new int[places.length];
	        
	        for(int i=0; i<places.length; i++){
	            char[][] map = new char[5][5];
	            for(int j=0; j<5; j++){
	                for(int k=0; k<5; k++){
	                    map[j][k] = places[i][j].charAt(k);
	                }
	            }
	            
	            answer[i] = bfs(map);
	        }
	        return answer;
	    }
	    
	    public int bfs(char[][] map){
	        for(int i=0; i<5; i++){
	            for(int j=0; j<5; j++){
	                if(map[i][j] != 'P') continue; //해당지점 사람이 아니라면 skip
	                boolean[][] visited = new boolean[5][5];
	                Queue<node> q = new LinkedList<>();
	                q.add(new node(i,j,0));
	                visited[i][j] = true; //방문처리
	                
	                while(!q.isEmpty()){//큐 빌때까지 반복
	                    node cur = q.poll();
	                    
	                    for(int dir=0; dir<4; dir++){
	                        int nx = cur.x + dx[dir];
	                        int ny = cur.y + dy[dir];
	                        int ndist = cur.dist + 1;
	                        
	                        if(ndist > 2) continue; //거리 2초과하면 skip
	                        if(nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
	                        if(visited[nx][ny]) continue;
	                        if(map[nx][ny] == 'P') return 0;
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
}
