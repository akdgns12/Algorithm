package �����ڵ�;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 1. �巡�� Ŀ�긦 ���ϴ� �Լ�
 * 2. ���簢���� �� �������� ��� �巡�� Ŀ���� �Ϻ����� Ȯ���ϴ� �Լ�
 */

public class �巡��Ŀ�� {
	static int N; // �巡�� Ŀ���� ����
	static int x,y; // �巡�� Ŀ���� ������
	static int d; // ���۹��� 
	static int[] dx = {1, 0, -1, 0}; // �� : x++ ��: y-- �� : x-- �� : y++
	static int[] dy = {0, -1, 0, 1};
	static int g; // ����
	static boolean[][] map; // �巡�� Ŀ�갡 ���� �ش� ������(y,x)�� true
	static ArrayList<Integer> directions; // ������ ������ ������ List
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // �巡�� Ŀ���� ����
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken()); 
				y = Integer.parseInt(st.nextToken()); // x,y �巡�� Ŀ���� ������
				d = Integer.parseInt(st.nextToken()); // ���� 
				g = Integer.parseInt(st.nextToken()); // ����
				
				dragonCurve();
		} // end of input
		
		int result = getSquareCnt();
		System.out.println(result);
	}
	
	// �巡�� Ŀ�� �׸���
	public static void dragonCurve() {
		// �ʱ�ȭ
		directions = new ArrayList<>();
		directions.add(d); // ó�� ���� �ֱ�
		
		// �巡�� Ŀ�갡 �׷����� �� ���� �����ϱ�
		int dir;
		// g������� �ݺ�
		while(g --> 0) {
			// �� ������ ������ ������ stack�� ���� �׿����Ƿ� �ڿ������� get
			for(int i=directions.size()-1; i>=0; i--) {
				dir = (directions.get(i) + 1) % 4;
				directions.add(dir);
			}
		}
		
		//map���� �巡�� Ŀ�갡 ������ ������ �׸���
		int nx, ny;
		int cx = x;
		int cy = y;
		map[x][y] = true;
		
		for(int i=0; i<directions.size(); i++) {
			dir = directions.get(i);
			
			nx = cx + dx[dir];
			ny = cy + dy[dir];
			
			map[nx][ny] = true;
			
			// ��� �̾ �׷����� ���̹Ƿ� cx, cy�� �ٲ������
			cx = nx;
			cy = ny;
		}
	}
	
	public static int getSquareCnt() {
		int cnt = 0;
		
		for(int i=0; i<100; i++) {// y��
			for(int j=0; j<100; j++) { // x��
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					cnt++;
			}
		}
		return cnt;
	}

}
