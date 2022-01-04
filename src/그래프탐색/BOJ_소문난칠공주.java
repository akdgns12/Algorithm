package �׷���Ž��;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * �� 7���� �л� ������ �̴µ�, 7�� �� �ּ� 4���� '�̴ټ���'���� �Ѵ�.
 * �� ���¿��� �� 7���� �л����� �������ִ��� Ȯ���ؾ� �Ѵ�.
 */
class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_�ҹ���ĥ���� {
	static int n = 5;
	static int cnt = 0;
	
	static int[] dx= {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[n][n];
		
		//map ���� �Է¹ޱ�
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[25];
		//25���� 7���� �����ϴ� ����
		comb(0,7);
		
		System.out.println(cnt);
	}
	
	public static void comb(int start, int r) {
		if(r==0) {
			int num = 0;
			int temp = 0;
			int x = 0;
			int y= 0;
			int[][] map2 = new int[5][5]; //������ �ڸ�
			for(int i=0; i<25; i++) {
				//row�� column���� ��ȯ
				int row = i/5;
				int col = i%5;
				if(visited[i]) {
					map2[row][col] = 1; //�ڸ� ����
					if(temp == 0) {
						x = row;
						y = col;
					}
					
					//�̴ټ��� ����� ���õǾ����� ����
					if(map[row][col] == 'S')
						num++;
					temp++; //7�� ��� ����ٸ� ���� Ż��
				}
				if(temp == 7)
					break;
			}
			
			//�̴ټ��� 4���̻� ���õǾ��ٸ� BFS�� ����Ǿ� �ִ��� Ž��
			if(num >= 4) {
				bfs(x,y,map2);
			}
			
			return;
		}
		
		for(int i=start; i<25; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(i+1, r-1);
				visited[i] = false;
			}
		}
	}
	
	static void bfs(int a, int b, int[][] arr) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		q.offer(new Pos(a,b));
		visited[a][b] = true;
		int num = 1;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//��ȿ�� ��ġ && ���õ� �ڸ� && �湮���� ���� �ڸ�
				if(nx > 0 &&  ny > 0 && nx < 5 && ny < 5 && arr[nx][ny] == 1 && !visited[nx][ny]) {
					q.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
					num++;
				}
			}
		}
		
		//��� ����Ǿ� �ִٸ� num == 7
		if(num == 7)
			cnt++;
	}
}
