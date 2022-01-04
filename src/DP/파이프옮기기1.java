package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �������ű��1 {
	static int N;
	static int[][] map;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �ʱ� ������ ��ġ map[0][0] = 0, map[0][1] = 1
		// x,y,dir
		// dir 0: ����, 1: ����, 2: �밢��
		move(0,1,0); // x, y, dir -> �������� ���� N-1,N-1�� �����ϸ� ��
		
		System.out.println(count);
	}
	
	public static void move(int x, int y, int dir) {
		// N*N�� �����ϸ鼭 �� ��ġ�� �������� ������
		if(x == N-1 && y == N-1 && map[x][y] != 1) {
			count++;
			return;
		}
		
		// �������� ������ ��
		if(dir == 0) {
			// ���η� �� ��
			if(isIn(x,y+1) && map[x][y+1] == 0)
				move(x,y+1,0);
			
			// ������ �Ʒ� �밢������ �� ��
			// ������ġ ������, ������ �밢��, �Ʒ��� ��� 0�̸� �̵�
			if(isIn(x+1,y+1) && map[x][y+1] == 0 && map[x+1][y+1] == 0 && map[x+1][y] == 0)
				move(x+1,y+1,2);
		}else if(dir == 1) { // �������� ������ ��
			// ���η� �� ��
			if(isIn(x+1,y) && map[x+1][y] == 0) move(x+1,y,1);
			
			// �밢������ �� ��
			// ������ġ�� ������, �Ʒ�, �밢��
			if(isIn(x+1,y+1) && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0)
				move(x+1,y+1,2);
		}else if(dir == 2) { // �������� �밢���� ��
			// ���η� �ж�
			if(isIn(x,y+1) && map[x][y+1] == 0) 
				move(x,y+1,0);
			
			// ���η� �� ��
			if(isIn(x+1,y) && map[x+1][y] == 0)
				move(x+1,y,1);
			
			// �밢������ �� ��
			// ������ġ�� ������, �Ʒ�, �밢���˻� 
			if(isIn(x+1,y+1) && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0)
				move(x+1,y+1,2);
		}
	}
	
	public static boolean isIn(int x, int y) {
		return (x >= 0 && y >= 0 && x < N && y < N);
	}
}
