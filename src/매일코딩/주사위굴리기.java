package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class �ֻ��������� {
	static int[] dice = new int[7];
	static int N, M; // ����, ����
	static int x, y; // �ֻ��� ��ǥ x,y
	static int K; // ����� ����
	static int[][] map;
	static int[] dr = {0,0,-1,1}; // �� �� �� �� : 1 2 3 4
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �̵� �ѹ��� ������ �ֻ����� ���鿡 �ִ� �� ���
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1; // ����
			
			int nx = x + dr[dir];
			int ny = y + dc[dir];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				changeDice(dir);
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = dice[6];
				}else {
					dice[6] = map[nx][ny];
					map[nx][ny] = 0;
				}
				
				x = nx;
				y = ny;
				System.out.println(dice[1]);
			}
		}
	}

	public static void changeDice(int d) {
		int[] temp = dice.clone();
		// 6�ظ�, 1����
		// ������ 1, ������ 2, ������ 3, ������ 4
		if(d == 1) {
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		} else if(d == 2) {
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		} else if(d == 3) {
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		} else {
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}
	}
}
