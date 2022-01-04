package 카카오기출;
import java.util.*;

class 경주로건설_카카오인턴 {
    /*/
     * 최단비용을 구해야 하기 때문에 최단거리를 구하는 방식 -> bfs가 맞다
     * Node라는 클래스를 만들어 주어 현재 노드에 대한 x,y좌표와 현재까지의 비용,
     * 방향 정보를 담아 주었다.
     * 
     * 여기서 중요한 점은 기존의 bfs랑은 다르게 이미 방문한 노드도 재 방문이
     * 가능하다는 점이다. 재방문 했을 때의 비용이 현재 비용보다 작거나 같으면
     * 그 방향으로 계속 가도 괜찮다는 의미이고 재방문을 했을 때 비용이 더 크면
     * 그 방향으로 더 가지 말라는 의미이므로 q에 노드를 넣어주면 안된다.
     * 
     * 방문했는지 여부를 visited함수를 사용해 체크하고, 첫 방문이거나 재방문일
     * 경우 그 방향으로 갈 수 있는 경우라면 값을 갱신해준다.
     * 
     * cost를 계산하는 부분.
     * 직선으로 움직일 때는 100원, 코너일 때는 500원을 더해주도록 계산
     * 문제를 자세히 읽어보면 코너를 만들 때 500원이 '추가'로 든다. 즉 코너일 때
     * 비용이 기존 비용의 500원이 증가하는 것이 아니라 기존 직선 비용인 100원에
     * 500원이 추가한 600원이 되는 것. 유의사항
     */
    int min = Integer.MAX_VALUE;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    int n;
    boolean[][] visited;
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n];
        bfs(board);
        return min;
    }
    
    public void bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, -1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.x == n - 1 && node.y == n - 1) {
                min = Math.min(min, node.cost);
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] != 1) {
                    int newCost;
                    if(node.dir == -1 || node.dir == i) { //직진
                        newCost = node.cost + 100;
                    } else { //코너
                        newCost = node.cost + 600;
                    }
                   
                    //처음 방문하거나 이전에 방문했을 때의 cost보다 작거나 같은 비용이면
                    if(visited[nx][ny] == false || board[nx][ny] >= newCost) {
                        visited[nx][ny] = true;
                        board[nx][ny] = newCost; //값을 갱신해주고
                        q.add(new Node(nx, ny, newCost, i)); //해당 지점으로 이동한다.
                    }
                } 
            }
        }
    }
    
    class Node{
        int x;
        int y;
        int cost;
        int dir;
        
        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}