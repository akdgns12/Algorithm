package �����ڵ�;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * ���� �� 
 * NxN ���簢�� ����
 * ���� �� ���� ��ġ(1,1) ó�� ������ ������ ����
 * ���� ��� �Ӹ����� �þ
 * ��� ������ ��� �������� �Ӹ� �÷��� ���� �״��
 * ��� ������ �Ӹ� �÷��� ������ ��ġ�� ĭ �����
 */
public class �� {
	static int n; // ������ ũ��(2~100)
	static int k; // ����� ����(0~100)
	static int l; // ���� ���� ��ȯ Ƚ��(1~100)
	static int time; // ���ӽð�
	static int[][] board;
	
	static LinkedList<int[]> snake; // ���� ���� ��ġ(x,y)
	
	// ó�� ������ ������ ������ ���� ����
	// 0: ������, 1: �Ʒ���, 2: ����, 3: ��
	// D(������)�� ������ index++
	// L(����)�� ������ index--
	static int index = 0;
	static int[] dx = {0,1,0,-1}; //����
	static int[] dy = {1,0,-1,0}; //����
	
	static HashMap<Integer, String> dir; //���� ���� ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		// 1,1�� �� �� �� ����
		board = new int[n+1][n+1];
		
		// ��� ��ġ �Է�
		int row; //��
		int col; //��
		for(int i=0; i<k; i++) {
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			board[row][col] = 1; //��� ��ġ 1�� ����
		}
		
		// �� ���� ���� �Է�
		dir = new HashMap<>();
		l = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<l; i++) {
			int timeInfo = Integer.parseInt(st.nextToken());
			String directionInfo = st.nextToken();
			
			dir.put(timeInfo, directionInfo);
		}
		
		// �� ��������(1,1)(x,y)
		snake = new LinkedList<>();
		snake.add(new int[] {1,1});
		
		time = 0;
		int nx, ny; // ���� ������
		int cx, cy; // ���� ������(1,1)
		cx = 1;
		cy = 1;
		// �� ������ ����
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
				snake.add(new int[] {nx,ny}); // �Ӹ� ���� �߰�
			}
			// ��� �������� �Ӹ� �÷��� ������ ��ġ�� ĭ �����
			else {
				snake.add(new int[] {nx,ny}); // �Ӹ� ���� �߰�
				snake.remove(0); // ���� index�� 0
			}
			
			cx = nx;
			cy = ny;
			
			// �ش� �ð� ������ �� ���� ���� �����ֱ�
			if(dir.containsKey(time)) {
				// D(������)�� �ٿ��� index++
				if(dir.get(time).equals("L")) {
					index++;
					if(index == 4)
						index = 0;
				}
				// L(����)�� ������ index--
				if(dir.get(time).equals("L")) {
					index--;
					if(index == -1)
						index = 3;
				}
			}
		}
		
		System.out.println(time);
	}
	
	// ������ �������� Ȯ��
	static boolean isFinish(int nx, int ny) {
		//���� �ε����ų�
		if(nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1)
			return true;
	
		// �ڱ� ���뿡 ��ų�
		for(int i=0; i<snake.size(); i++) {
			if(nx == snake.get(i)[0] && ny == snake.get(i)[1])
				return true;
		}
		
		return false;
	}

}
