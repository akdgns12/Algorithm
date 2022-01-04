package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ��_�����ѹ��� {
	static int n; // ������ ũ��
	static int k; // ����� ����
	static int l; // �� ���� ��ȯ Ƚ��
	static int[][] board; 
	static int time;
	
	static LinkedList<int[]> snake; // �� ���� ����
	
	static HashMap<Integer, String> dir; // �� �Ӹ� ���� ����
	
	static int index = 0;
	static int[] dx = {0,1,0,-1}; // ����  ��,��,��,��
	static int[] dy = {1,0,-1,0}; // ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		// ��� ��ġ ���� �Է� �ޱ�
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			board[row][col] = 1; // ��� ��ġ 1�� ����
		}
		
		// ���� ���� �Է�
		dir = new HashMap<>();
		l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int timeInfo = Integer.parseInt(st.nextToken());
			String directionInfo = st.nextToken();
			
			dir.put(timeInfo, directionInfo); // Hashmap�� (�ð�, ����) �ֱ�
		}
		
		// �� �ʱ���ġ(1,1) (x,y)
		snake = new LinkedList<>();
		snake.add(new int[] {1,1}); 
		
		
		time = 0;
		int nx, ny; // ���� ������
		int cx, cy; // ���� ������
		cx = 1;
		cy = 1;
		
		while(true) {
			time++;
			
			// ���� ������(�Ӹ� ������)
			nx = cx + dx[index];
			ny = cy + dy[index];
			
			// �������� Ȯ��
			if(isFinish(nx, ny)) break;
			
			// ��� �ִ��� Ȯ��
			// ��� ������ ��� �������� �Ӹ� �÷��� ���� �״��
			if(board[nx][ny] == 1) {
				board[nx][ny] = 0;
				snake.add(new int[] {nx, ny});
			}
			else { 
				// ��� ���ٸ� �Ӹ� �÷��ְ�
				// ���� ��ġ ����
				snake.add(new int[] {nx,ny});
				snake.remove(0);
			}
			
			cx = nx;
			cy = ny;
			
			// �ش� �ð� ������ �� ���� �����ֱ�
			if(dir.containsKey(time)) {
				if(dir.get(time).equals("D")) {
					index = (index+1) % 4;
				}
				else
					index = (index + 3) % 4;
					
			}
			
		}
		
		System.out.println(time);
	}

	// ���� �������� Ȯ��
	public static boolean isFinish(int nx, int ny) {
		// ���� �ε����ų�
		if(nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1)
			return true;
		
		// ���뿡 �ε����ų�
		for(int i=0; i<snake.size(); i++) {
			if(nx == snake.get(i)[0] && ny == snake.get(i)[1])
				return true;
		}
		
		return false;
	}
}
