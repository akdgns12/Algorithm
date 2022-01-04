package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �κ�û�ұ� {

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
		
		// û�ұ� �ʱ���ġ��ǥ, �������� �Է�
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// û���ϴ� �޼���
		clean(row, col, dir);
		
		System.out.println(count);
	}
	
	/*
	 * 1. ���� ��ġ�� û���Ѵ�
	 * 2. �ݽð� �������� ���鼭 �ֺ��� û���� �� �ִ��� Ȯ���Ѵ� (���� ��ġ�� �Ķ���ͷ� �Ѱ���)
	 * 3. �ֺ��� ��� û�ҵǾ� �ְų� ���� ���
	 * 	  - �ٶ󺸴� ������ ������ ä 1���� �����Ѵ�.(���� ��ġ�� �Ķ���ͷ� �Ѱ���)
	 */
	// û���ϴ� �޼���
	public static void clean(int r, int c, int d) {
		// 1. ���� ��ġ�� û���Ѵ�.
		if(map[r][c] == 0) {
			map[r][c] = 2; // û���� ���´� 2�� ����
			count++;
		}
		
		// 2. �ݽð� �������� ���鼭 û���� �� �ִ��� Ȯ���Ѵ�.
		boolean flag = false;
		int originDir = d;
		for(int i=0; i<4; i++) {
			int next_d = (d + 3) % 4;
			int next_r = r + dr[next_d];
			int next_c = c + dc[next_d];
			// 
			if(next_r > 0 && next_c > 0 && next_r < n && next_c < m	) {
				if(map[next_r][next_c] == 0) { // ���� û������ ���� �����̶��
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			d = (d + 3) % 4;
		}
		
		
		// 3. �ֺ��� ��� û�ҵǾ� �ְų� ���� ���
		if(!flag) {
			int next_d = (originDir + 2) % 4;
			int next_br = r + dr[next_d];
			int next_bc = c + dc[next_d];
			
			if(next_br > 0 && next_bc > 0 && next_br < n && next_bc < m	) {
				if(map[next_br][next_bc] != 1) {
					clean(next_br, next_bc, originDir); 
				}
			}
			
		}
	}

}
