package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �ֻ��������� {
	static int[] dice = new int[7];
	static int[][] map;
	static int[] dx = {0,0,-1,1}; // �� �� �� ��
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int dir = Integer.parseInt(st.nextToken());
			
			int nx = x + dx[dir-1];
			int ny = y + dy[dir-1];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
				changeDice(dir);
				
				if(map[nx][ny] == 0) { // �ش� ĭ�� 0�̶�� 
					map[nx][ny] = dice[6]; // �ش� ĭ�� �ֻ����� ���� ���ڷ� ����
				}else { 			// �ش� ĭ�� 0�� �ƴϸ�
					dice[6] = map[nx][ny]; // �ֻ����� ���� ���ڸ� �ش�ĭ�� ���� ���ڷ� ����
					map[nx][ny] = 0; // �ش� ĭ�� 0���� ����
				}
				
				x = nx;
				y = ny;
				System.out.println(dice[1]); // ���鿡 ���� ���� ���
			}			
		}
	}
	
	//
	public static void changeDice(int d) {
		int[] temp = dice.clone();
		// 6 �ظ�, 1 ����
		// ������ 1, ������ 2, ������ 3, ������ 4
		if(d == 1) { // ���� 1
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		}else if(d == 2) { // ���� 2
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		}else if(d == 3) { // ���� 3
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		}else if(d == 4) { // ���� 4
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}
	}
}
