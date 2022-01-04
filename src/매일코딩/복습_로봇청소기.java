package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_�κ�û�ұ� {

	static int n,m;
	static int[][] map;
	static int[] dr = {-1,0,1,0}; // �� �� �� ��
	static int[] dc = {0,1,0,-1};
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		// ĭ ���� �Է�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//û���ϴ� �Լ�
		clean(row, col, direction);
	}
	/*
	 * 1. �ش� ĭ û���ϱ�
	 * 2. ���� ���⿡ ���� û������ ���� ���� �����Ѵٸ�, �� �������� ȸ���ϰ� ���� �� ĭ�� ����(���� ���� �Ķ���� ����)
	 * 3. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ���� ������ ä�� �� ĭ ����(�� �� ���� �Ķ���� ����)
	 */
	public static void clean(int row, int col, int dir) {
		// 1. ���� ��ġ�� û��
		if(map[row][col] == 0) { // �ʱ���ġ û���ϰ� count++
			map[row][col] = 2;	 // û���� ĭ�� 2�� ����
			count++;
		}
		
		// 2. ���� ������� ���ʴ�� Ž���� �����Ѵ�.
		boolean flag = false;
		int originDir = dir;
		for(int i=0; i<4; i++) {
			int next_d = (dir + 3) % 4;
			int next_r = row + dr[next_d];
			int next_c = col + dc[next_d];
			
			if(next_r > 0 && next_c > 0 && next_r < n && next_c < m	) {
				if(map[next_r][next_c] == 0) { // ���� û������ ���� ĭ�̶��
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			dir = (dir + 3 ) % 4;
		}
		
		// 3. �� ���� ��� û�Ұ� �Ǿ��ְų� ���ΰ��
		if(!flag) {
			int next_d = (originDir + 2) % 4;
			int next_br = row + dr[next_d];
			int next_bc = col + dc[next_d];
			
			if(next_br > 0 && next_bc > 0 && next_br < n && next_bc < m) {
				if(map[next_br][next_bc] != 1) {
					clean(next_br, next_bc, originDir); // �ٶ󺸴� ���� ������ ä ����
				}
			}
		}
	}

}
