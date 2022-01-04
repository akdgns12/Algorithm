package ���α׷��ӽ�level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * �׸��� ���̵� = ������ ��
 * ���� = (�����¿�� ����� ���� ������ ����)
 * 
 * picture�� �� �� 0�� ���� ��ĥ���� ���� ����
 * 
 * ������ ��ִ����� ���� ū ������ ���� ���ϱ�
 * 
 */
/*
public class īī���������÷����� {
		public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		answer[0] = numberOfArea; //������ ��
		answer[1] = maxSizeOfOneArea; //���� ���� ������ ������ �ִ� ������ ��
		
		picture = new int[m][n]; 
		boolean[][] visited = new boolean[m][n]; //�湮���� üũ
		// �湮�ߴ� ���� �ȼ��� ���ư��� ���� x,y��ǥ
		Stack<Integer> stackX = new Stack<>();
		Stack<Integer> stackY = new Stack<>();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				// ���� ������ �迭�� ã�� count �ʱ�ȭ
				int count = 0;
				
				//���� for���� ��ǥ�� �������� ������ �����ϴ� ��(0�� �ƴ�)�� �湮���� ���� �� ã��
				if(picture[i][j] > 0 && visited[i][j]==false) {
					//�湮���� �ʰ� ������ �����ϴ� ó�� ��ǥ�� stack��ǥ�� ���, �湮ǥ��, ī��Ʈ, ���󿵿� ī��Ʈ
					stackX.add(j);
					stackY.add(i);
					visited[i][j] = true;
					count++;
					answer[0]++;
				}
				
				//������ ������ ������ ���� ��ǥ�� ������ ������ while�� �ݺ�
				while(!stackX.isEmpty()) {
					
					//���� �ֱ��� x,y��ǥ�� stack���� pop()
					int x = stackX.pop();
					int y = stackY.pop();
					
					//stack��ǥ�� �������� ���� �̵�
					//�ٷ� ���� �迭�� ���� && �迭�� ������ ���� ��ǥ�� ���� && �湮���� �ʾ�����
					if(y > 0 && picture[y-1][x] == picture[i][j] && visited[y-1][x] == false) {
						stackX.add(x);
						stackY.add(y-1);
						visited[y-1][x] = true
								count++;
					}
					
					//stack��ǥ�� �������� �·� �̵�
					//���� ��ǥ ���ʿ� �迭�� ���� && �迭�� ������ ���� ��ǥ�� ���� && �湮���� �ʾ�����
					if(x>0 && picture[y][x-1] == picture[i][j] && visited[y][x-1] == false) {
						stackX.add(x-1);
						stackY.add(y);
						visited[y][x-1] = true;
						count++;
					}
					//stack��ǥ�� �������� �Ʒ��� �̵�
					//���� ��ǥ �Ʒ��ʿ� �迭�� ������ && �迭�� ������ ���� ��ǥ�� ���� && �湮���� �ʾ�����
					if( y < m-1 && picture[y+1][x] == picture[i][j] && visited[y+1][x] == false) {
						stackX.add(x);
						stackY.add(y+1);
						visited[y+1][x]=true;
						count++;
					}
					
					//stack��ǥ�� �������� �������� �̵�
					//���� ��ǥ ������ �迭�� ���� && �迭�� ������ ������ǥ�� ���� && �湮���� �ʾ�����
					if( x < n-1 && picture[y][x+1] == picture[i][j] && visited[y][x+1]==false) {
						stackX.add(x+1);
						stackY.add(y);
						visited[y][x+1]=true;
						count++;
					}
				}
				//while() stack���� ���� ���� �ֱ� ��ǥ�� �������� ��� ������ Ž���ϰ�
				// ���ÿ� ����� ��ǥ���� ������ �ǵ��ƿ��鼭 �ֺ� �迭�� Ž��
				//stack���� ��� ��ǥ�� ����������, for���� ���� ��ǥ��� ������ �迭���� ��� Ž���� ���ư�,
				//answer[1] ������ ���� ū ���� ������ Math.max(����, ����)�� �̿��Ͽ� ����
				
				answer[1] = Math.max(answer[1], count);
			}
		}//���� for������ ������ �����ϴ� ��� �迭�� �湮�� ��ġ��
		//'answer[0] : ������ ��, answer[1] : ���� ���� �ȼ��� ������ �ִ� ������ �ȼ� ��'�� ����
		
		
		
		return answer;
	}
}
*/
/*
public class īī���������÷����� {
	class Point{
		int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public int BFS(boolean[][] visited, int[][] picture, Point start) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0} , dy = {0,0,1,-1};
		int area = 1, nx, ny;
		
		visited[start.x][start.y] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;
				
				if( nx >=0 && nx < picture.length && ny >= 0 && ny < picture[0].length) {
					if(!visited[nx][ny] && picture[nx][ny] !=0 && picture[cur.x][cur.y] == picture[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Point(nx,ny));
						area++;
					}
				}
			}
		}
		return area;
	}
	public int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2];
		boolean[][] visited = new boolean[m][n];
		
		for(int i=0; i<m; i++)
			Arrays.fill(visited[i], false);
		
		for(int x = 0; x<m; x++) {
			for(int y=0; y<n; y++) {
				if(visited[x][y] || picture[x][y] == 0)
					continue;
				
				answer[1] = Math.max(answer[1], BFS(visited, picture, new Point(x,y)));
				answer[0]++;
			}
		}
			return answer;
	}
}*/
public class īī���������÷�����{
	//���� ������ ���� ���� ������
	static int numberOfArea; // ������ ����
	static int maxSizeOfOneArea; // ���� ���� ��������  ������ ������
	//�� ������ ���� �����ϴ� ����
	static int temp_cnt = 0; 
	//��ǥ������ ��,��,��,�� Ž���� ���� �迭
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	//DFS�޼ҵ�
	public static void dfs(int x, int y, int[][] picture, boolean[][] check) {
		//6. �湮�� �� �ִ� ��ǥ��� DFS����
		if(check[x][y]) return;
		
		//7.ó�� �湫�� �湮ó��.
		check[x][y] = true;
		//8. �� ������ �� ����.
		temp_cnt++;
		
		//9. �� ��ǥ���� ��,��,��,�� Ž��.
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//10.picture�迭�� ������ ����� continue.
			if( nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) continue;
			
			//11. ����ǥ�� �� == ��,��,��,�� ��ǥ�� �� && �湮�� �� ���� ��,��,��,�� ��ǥ���.
			if(picture[x][y] == picture[nx][ny] && !check[nx][ny]) {
				
				//12. DFS���ȣ��
				dfs(nx,ny,picture, check);
			}
		}
	}
	public int[] solution(int m, int n, int[][] picture) {
		//1.�ʱ�ȭ ��! �ϱ�
		numberOfArea = 0;
		maxSizeOfOneArea = 0;
				
		int[] answer = new int[2];
		answer[0]=numberOfArea;
		answer[1]=maxSizeOfOneArea;
		
		//2.DFS�� �湮���θ� üũ �� �迭.
		boolean[][] check = new boolean[m][n];
		
		//3. �־��� picture�迭�� Ž��
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				//4.���Ұ� 0�� �ƴϰ�, �湮�� ���� ���ٸ�.
				if(picture[i][j] !=0 && !check[i][j]) {
					//5.������ ���� 1�� �����ϸ� DFSŽ�� ����
					numberOfArea++;
					dfs(i,j,picture,check);
				}
				//13.�� ������ Ž���� ��� �����ٸ�, ���ǿ� ���� �ִ� ������ ���� ����
				if(temp_cnt > maxSizeOfOneArea) maxSizeOfOneArea = temp_cnt;
				//14. �� ������ ���� �ٽ� �ʱ�ȭ
				temp_cnt = 0;
			}
		}
		
		//15. �� ���� answer �迭�� ����ְ� ��
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		
		return answer;
	}
}