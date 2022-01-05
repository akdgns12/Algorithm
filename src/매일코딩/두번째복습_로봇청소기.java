package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class �ι�°����_�κ�û�ұ� {

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
		
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		// map ���� �Է�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. ���� ��ġ û��
		// 2. ���ʹ������� ���ʴ�� Ž��
		// 3. 
		clean(row, col, direction); // û�ҽ�Ű�� �Լ�
		
		System.out.println(count);
	}
	
	public static void clean(int row, int col, int direction) {
		// 1. ������ġ û��
		if(map[row][col] == 0) {
			map[row][col] = 2; // ��ġ û���ϰ� 2�� ����
			count++;		
		}
		
		// 2. ���ʹ������� ���ʴ�� Ž��
		boolean flag = false;
		int originDir = direction;
		for(int i=0; i<4; i++) {
			int next_d = (direction + 3) % 4;
			int next_r = row + dr[next_d];
			int next_c = col + dc[next_d];
			
			if(next_r > 0 && next_c > 0 && next_r < n && next_c < m) {
				if(map[next_r][next_c] == 0) { // ���� û������ ���� ĭ�̶��
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			direction = (direction + 3) % 4;
		}
		
		// 3. �� ���� ��ΰ� û�Ұ� �Ǿ��ų� ���̶��
		if(!flag) {
			int next_d = (originDir + 3) % 4;
			int next_br = row + dr[next_d];
			int next_bc = col + dc[next_d];
			
			if(next_br > 0 && next_bc > 0 && next_br < n && next_bc < m) {
				if(map[next_br][next_bc] != 1) { // 
					clean(next_br, next_bc, originDir); // ���� ������ ä �ڷ� �̵�
				}
			}
		}

	}
}
