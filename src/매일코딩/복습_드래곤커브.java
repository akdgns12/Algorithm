package �����ڵ�;
// �巡�� Ŀ�긦 �׸��� ��Ģ �̹��� �����ؼ� �ڵ� ¥����
// ���� ���븦 ���� �� ������(���� �ʰ� ���� �ͺ��� ù ��°����) ������ �޴´�.
// �� �� �ݽð�������� ������ �ٲ��.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * ���� 
 * 1. �巡�� Ŀ���� ������ŭ �������� �ް� �Ǵµ�
 * 1-1 �� �巡�� Ŀ�긶�� ������� map�� �׷���� �Ѵ�.(�巡�� Ŀ�갡 ������ �ִ� �������� true�� �������� �Ѵ�. map[x][y] = true)
 * 1-2 �̶� �巡�� Ŀ�긦 �׸��µ� ��Ģ�� �ִµ� ���� ���븦 �� �� �� ������(���� �ʰ� ���� �� ���� ù ��°����)������ �޴� ��. �� ��
 * �ݽð� �������� ������ �ٲ��.
 * 1-3 ���� �巡�� Ŀ�긦 �׸��� ���� �ش� ������� list�� �� ����ϰ� �ִٰ� �־��� x,y�� list��ŭ �׷��ش�.
 * 1-4 �巡�� Ŀ�� ���� N��ŭ �巡�� Ŀ�긦 map�� �׷��ش�.
 * 2. map�� �巡�� Ŀ�긦 �� �׸��� ���� 1x1 ���簢���� �� �������� ���� true�� ����� ������ ã���� �ȴ�.
 */

public class ����_�巡��Ŀ�� {
	static int N; // �巡�� Ŀ���� ����
	static int x,y; // �巡�� Ŀ���� ������
	static int d; // ���۹��� (0~3), 0: ��(X++), 1: ��(y--), 2: ��(x--), 3: ��(y++)
	static int g; // ����(0~10)
	static boolean[][] map = new boolean[101][101]; // �巡�� Ŀ�갡 ���� �ش� ������(x,y)�� true
	static List<Integer> directions; // ������ ������ ������ List
	
	//0: ��(X++), 1: ��(y--), 2: ��(x--), 3: ��(y++)
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			dragonCurve();
		}// end of input
		int result = getSquareCnt();
		System.out.println(result);
	}
	
	public static void dragonCurve() {
		// �ʱ�ȭ
		directions = new ArrayList<>();
		directions.add(d); // �ʱ� ���� �ֱ�
		
		// �巡�� Ŀ�갡 �׷����� ���� �����ϱ�
		int dir;
		// g ������� �ݺ�
		while(g --> 0) {
			// �� ������ ������ ������ stack�� ���� �׿����Ƿ� �ڿ������� get
			// k���� �巡�� Ŀ�� = k-1���� �巡��Ŀ���� ������ �ݽð�������� �׷�����.
			for(int i=directions.size()-1; i>=0; i--) {
				dir = (directions.get(i) + 1) % 4; //
				directions.add(dir);
			}
		}
		
		// map���� �巡�� Ŀ�갡 ������ ������ �׸���
		int nx, ny;
		int cx = x;
		int cy = y;
		map[x][y] = true;
		for(int i=0; i<directions.size(); i++) {
			dir = directions.get(i);
			
			nx = cx + dx[dir];
			ny = cy + dy[dir];
			
			map[nx][ny] = true;
			
			// ��� �̾ �׷����� ���̹Ƿ� cx, cy�� �ٲ����
			cx = nx;
			cy = ny;
		}
	}
	
	public static int getSquareCnt() {
		int cnt = 0;
			
		for(int i=0; i<100; i++) {// y��
			for(int j=0; j<100; j++) {// x��
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					cnt++;
			}
		}
		
		return cnt;
	}
	
	
	
	
}
