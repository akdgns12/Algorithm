package �����ڵ�;

public class �湮���� {
	// ���α׷��ӽ� lv2 / �����ε� BFS���� / ����üũ �� ��ǥ ���� ����
	class Solution {
		static int[] dx = {0,0,1,-1}; // U D R L
		static int[] dy = {-1,1,0,0};
		// ����üũ ����! �׳� 2�������� �ϸ� �ȵ�. -> ������ ���̱� ������ �̵��ϱ� �� ��ǥ + �̵��� �� ��ǥ �Ѵ� üũ����ߵ�
		static boolean[][][][] visited = new boolean[11][11][11][11];
		
		public int solution(String dirs) {
			int answer = 0;
			int x = 0;
			int y = 0;
			int nx = 5;
			int ny = 5;
			
			int index = 0;
			for(int i=0; i<dirs.length(); i++) {
				x = nx;
				y = ny;
				
				char command = dirs.charAt(i);
				if(command == 'U') {
					index = 0;
				}else if(command == 'D') {
					index = 1;
				}else if(command == 'R') {
					index = 2;
				}else {
					index = 3;
				}
				
				// index�� �´� ������� ��ġ�̵�
				nx += dx[index];
				ny += dy[index];
				
				// ���� �˻� -> ������ �����
				if(nx < 0 || ny < 0 || nx > 10 || ny > 10) {
					// �̵��ϱ� ���� ��ġ�� ����ġ
					nx -= dx[index];
					ny -= dy[index];
					continue;
				}
				
				// �湮ó��
				if(!visited[x][y][nx][ny] && !visited[nx][ny][x][y]) {
					// ���̾ƴ϶� ������ ���̱� ������ ����� �˻� �������
					visited[x][y][nx][ny] = true;
					visited[nx][ny][x][y] = true;
					answer++;
				}
			}
			return answer;
		}
	}
}
