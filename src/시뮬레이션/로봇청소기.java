package �ùķ��̼�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * �κ� û�ұⰡ û���ϴ� ������ ������ ���ϴ� ���α׷�
 * N*M ũ���� ���簢�� map
 * ������ ĭ�� �� �Ǵ� �� ĭ
 * û�ұ�� �ٶ󺸴� ������ �ְ�, �������� �� �ϳ�
 * ������ �� ĭ�� (r,c)�� ��Ÿ�� �� �ְ�
 * r�� �������κ��� ������ ĭ�� ����
 * c�� �������κ��� ������ ĭ�� ����
 * 
 * û�ұ� ���� ���
 * 1. ���� ��ġ�� û��
 * 2. ���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž��
 *  a. ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� ��������
 *  ȸ���� ���� �� ĭ�� �����ϰ� 1������ ����
 *  b. ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���
 *  c. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��,
 *  �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���
 *  d. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶�
 *  ������ �� �� ���� ��쿡�� �۵��� ����.
 */
public class �κ�û�ұ� {
	static int n,m; // ����, ����
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0}; // ��������
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		int x,y,d; // �κ� û�ұ��� x,y��ǥ, ����
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(clean(x,y,d));
	}
	// �κ� û�ұ�� 1���� 2���� �ݺ��ϱ� ������ 2���� while�� ���
	// while���� 2���̱� ������, �������� �� �ֵ��� flag���
	private static int clean(int x, int y, int d) {
		int dirCount = 0, clean = 0, nx, ny;
		boolean flag = true;
		
		while(flag) { //1���� ���� �ݺ���
			if(map[x][y] == 0) {
				map[x][y] = 2;
				clean++;
			}
			
			while(true) { //2���� ���� �ݺ���
				if(dirCount==4) {
					nx = x - dx[d];
					ny = y - dy[d];
					
					if(map[nx][ny] == 1) {// ��ĭ�� ��
						flag = false;
						break;
					} else {
						x = nx;
						y = ny;
						dirCount = 0;
					}
				}
				
				d = (d + 3) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(map[nx][ny] == 0 ) {
					dirCount = 0;
					x = nx; y = ny;
					break;
				} else {
					dirCount++;
					continue;
				}
			}
		}
		return clean;
	}
}
