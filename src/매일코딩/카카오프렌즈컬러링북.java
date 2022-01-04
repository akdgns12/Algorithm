package �����ڵ�;

// �׸��� ��� ������ �ִ����� ���� ū ������ ����
// BFS���鼭 ����Ǿ� �ִ� ������ ���� ���ϰ�
// �� ������ ĭ �� ī�����ؼ� �����س��� �� 
// ���ο� ������ ī���� ���� ���ؼ� Math.max�� ã��
public class īī���������÷����� {
	static boolean[][] visited;
	static int temp_cnt = 0; // �� ������ ĭ �� ���ϴ� ����
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	// ���� ������ ���� ���� ������
	static int numberOfArea;
	static int maxSizeOfOneArea;
    
	public int[] solution(int m, int n, int[][] picture) {
		// 1. �ʱ�ȭ �� �ϱ�
		numberOfArea = 0;
		maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		// 2. DFS�� �湮���θ� üũ�� �迭
        visited = new boolean[m][n];
        
        // 3.  picture �迭 Ž��
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		// 4. ���Ұ� 0�� �ƴϰ�, �湮�� ���� ���ٸ�
        		if(picture[i][j] != 0 && !visited[i][j]) {
        			// 5. ������ ���� 1�� �����ϸ� DFS Ž�� ����
        			numberOfArea++;
        			dfs(i,j,picture,visited);
        		}
        		
        		// 13. �� ������ Ž���� ��� �����ٸ�, ���ǿ� ���� �ִ� ������ ���� ����
        		if(temp_cnt > maxSizeOfOneArea)
        			maxSizeOfOneArea = temp_cnt;
        		// 14. �� ������ ���� �ٽ� �ʱ�ȭ
        		temp_cnt = 0;
        	}
        }
        // 15. �� ���� answer �迭�� ����ְ� ��.
        answer[0] = numberOfArea; // ������ ����
        answer[1] = maxSizeOfOneArea; // ���� ū ������ ����
        
        return answer;
    }
	
	public static void dfs(int x, int y, int[][] picture, boolean[][] visited){
		// 6. �湮�� �� �ִ� ��ǥ��� dfs����
		if(visited[x][y])
			return;
		
		// 7. ó�� �湮�� �湮ó��
		visited[x][y] = true;
		// 8. �ش� ������ �� ����
		temp_cnt++;
		
		// 9. �� ��ǥ���� �����¿� Ž��
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 10. picture�� ���� ����� continue;
			if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
				continue;
			}
			
			// 11. �� ��ǥ�� �� == �����¿� ��ǥ�� �� && �湮�� �� ���� �����¿� ��ǥ���
			if(picture[x][y] == picture[nx][ny] && !visited[nx][ny]) {
				// 12. dfs�� ���� ���ȣ��
				dfs(nx,ny,picture, visited);
			}
		}
	}
	
}
