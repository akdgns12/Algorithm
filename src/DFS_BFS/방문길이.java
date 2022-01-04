package DFS_BFS;

public class �湮���� {
	// U,D,R,L - ��,��,��,��
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	//���� ũ�� = -5 ~ 5�����̹Ƿ� 11X11
	static boolean[][][][] visited = new boolean[11][11][11][11];
	
	public int solution(String dirs) {
		int answer = 0;
		/* x,y = ĳ���Ͱ� �̵��ϱ� �� ��ġ,
		 *  nextX, nextY = ĳ���Ͱ� �̵��� �� ��ġ */
		int x = 0;
		int y = 0;
		int nx = 5;
		int ny = 5;
		int index = 0;
		
		for(int i=0; i<dirs.length(); i++) {
			char c = dirs.charAt(i);
			//ĳ���� ������ġ ����
			x = nx;
			y = ny;
			if(c == 'U') {
				index = 0;
			}else if(c == 'L') {
				index = 1;
			}else if(c == 'R') {
				index = 2;
			}else if(c == 'D') {
				index = 3;
			}	
			
			//U,D,R,L�� �´� ĳ���� ��ġ �̵�
			nx += dx[index];
			ny += dy[index];
			
			//������ ������ ������ ���� ĳ������ ��ġ�� ������ ����� ���
			if(nx < 0 || ny < 0 || nx > 10 || ny > 10) {
				//�ٽ� ĳ���͸� ���� ��ġ�� �̵�
				nx = x;
				ny = y;
				continue;
			}
						
			//ĳ���Ͱ� ó�� �ɾ ���� ���
			if(!visited[x][y][nx][ny] && !visited[nx][ny][x][y] ) {
				//�ɾ�� �� üũ(���� �ƴ� ���̱� ������ ��������� üũ�Ѵ�)
				visited[x][y][nx][ny] = true;
				visited[nx][ny][x][y] = true;
				answer++;
			}
		}
		
		
		
		
		return answer;
	}
}
