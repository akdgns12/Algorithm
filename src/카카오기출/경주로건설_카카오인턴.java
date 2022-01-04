package īī������;
import java.util.*;

class ���ַΰǼ�_īī������ {
    /*/
     * �ִܺ���� ���ؾ� �ϱ� ������ �ִܰŸ��� ���ϴ� ��� -> bfs�� �´�
     * Node��� Ŭ������ ����� �־� ���� ��忡 ���� x,y��ǥ�� ��������� ���,
     * ���� ������ ��� �־���.
     * 
     * ���⼭ �߿��� ���� ������ bfs���� �ٸ��� �̹� �湮�� ��嵵 �� �湮��
     * �����ϴٴ� ���̴�. ��湮 ���� ���� ����� ���� ��뺸�� �۰ų� ������
     * �� �������� ��� ���� �����ٴ� �ǹ��̰� ��湮�� ���� �� ����� �� ũ��
     * �� �������� �� ���� ����� �ǹ��̹Ƿ� q�� ��带 �־��ָ� �ȵȴ�.
     * 
     * �湮�ߴ��� ���θ� visited�Լ��� ����� üũ�ϰ�, ù �湮�̰ų� ��湮��
     * ��� �� �������� �� �� �ִ� ����� ���� �������ش�.
     * 
     * cost�� ����ϴ� �κ�.
     * �������� ������ ���� 100��, �ڳ��� ���� 500���� �����ֵ��� ���
     * ������ �ڼ��� �о�� �ڳʸ� ���� �� 500���� '�߰�'�� ���. �� �ڳ��� ��
     * ����� ���� ����� 500���� �����ϴ� ���� �ƴ϶� ���� ���� ����� 100����
     * 500���� �߰��� 600���� �Ǵ� ��. ���ǻ���
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
                    if(node.dir == -1 || node.dir == i) { //����
                        newCost = node.cost + 100;
                    } else { //�ڳ�
                        newCost = node.cost + 600;
                    }
                   
                    //ó�� �湮�ϰų� ������ �湮���� ���� cost���� �۰ų� ���� ����̸�
                    if(visited[nx][ny] == false || board[nx][ny] >= newCost) {
                        visited[nx][ny] = true;
                        board[nx][ny] = newCost; //���� �������ְ�
                        q.add(new Node(nx, ny, newCost, i)); //�ش� �������� �̵��Ѵ�.
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