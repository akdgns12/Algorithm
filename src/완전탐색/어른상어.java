package ����Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���� {
	// BOJ 19237 / ��� 3 / ���� / ��Ž
	static class Shark{ // 1������ M������ ����� ��ǥ�� ��������
		int x, y, dir;
		
		public Shark(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int N, M, K;
	static int[][] restTime; // �� ĭ���� ������ ����������� ���� �ð�
	static int[][] smell;; // �� ĭ���� ������ �Ѹ� ����� ��ȣ(������ ������ ��ȣ0)
	static int[][][] priority; // ���� ���� ���⿡���� �켱����  ex) priority[m][1][0] m�� ����� ������ ����(1)�϶�, 0���� �켱����
	static Shark[] shark; // 1������ M������ ����� ��ǥ�� ��������
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // ��� ����
		K = Integer.parseInt(st.nextToken()); // �����ð� -> �����ð� ����������� �̵�
		
		restTime = new int[N+1][N+1];
		smell = new int[N+1][N+1];
		priority = new int[M+1][5][4];
		shark = new Shark[M+1];
		
		// ��� ���� �Է¹ް� Shark Ŭ������ x,y, ���� 0���� �ϴ� �ֱ�
		// �����ð� K
		// smell �ش� ĭ�� ������ �Ѹ� ��� ��ȣ(���� ������ 0)
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(n > 0) { // ����ȣ
					shark[n] = new Shark(i,j,0);
					restTime[i][j] = K;
					smell[i][j] = n;
				}
			}
		}
		
		// �ʱ� ��� ����
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			shark[i].dir = Integer.parseInt(st.nextToken());
		}
		
		for(int m=1; m<=M; m++) {
			for(int i=1; i<=4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				priority[m][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}	
		
		System.out.println(solve());
		/*
		 * 1 �����¿� �߿��� ����� ���ο� �̵���ġ(nx, ny)�� ã�´�
		 *  1-1. ����� ���� ������ �������� ���� �켱������ ���� ������� Ž���Ѵ�
		 *  Ž�� ����, ������ ���� ������ ��ġ�� ã���� Ž�� ����
		 * 2. ���� ��� Ž���ߴµ� ������ ���� ���� ���ٸ�, �ڱ� �ڽ��� ������ �ִ� 
		 * ������ ���� ã�´�.
		 * ���������� ���� ������ �������� ���� �켱������ ���� ������� Ž���Ѵ�.
		 */
	}
	
	public static int solve() {
		int time = 0;
		
		while(true) {
			int count = 0; // ���� ��� ���� ���� �뵵�� ����
			for(int m=1; m<=M; m++) {
				if(shark[m] != null) {
					count++;
				}
			}
			
			if(count == 1 && shark[1] != null) { // 1�� ��� ȥ�ڳ��� ���
				return time;
			}
			
			// 1000�� ���� ���
			if(time >= 1000)
				return -1;
			
			// �ӽù迭(���� ���� ������ ������ �� �̵��� ��� ���� ��)
			int[][] temp = new int[N+1][N+1];
			
			for(int m=1; m<=M; m++) {
				if(shark[m] != null) { // �� ���ȿ� �ִٸ�
					moveShark(temp, m);
				}
			}
			
			
			// M������ ��� �̵� ��� �Ϸ��ϰ� ����, �� ĭ���� ���� ���� ������Ʈ �ؾ���
			// �ð��� �ϳ� �������Ƿ� ������ ��ȿ�ð��� �ϳ��� ���ش�.
			// ���� ��ȿ�Ⱓ �ϳ��� ���̱�
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(restTime[i][j] > 0) 
						restTime[i][j] --;
						
					if(restTime[i][j] == 0) // ������ ������
						smell[i][j] = 0; // ��� ��ȣ 0 = ��� ������
					
				}
			}
			
			
			// 4. �� ��� �̵��� ��, ����� ���ο� ��ġ�� ���������� ��ġ�� ��������.
			// �Ʊ� �� �̵��ϸ鼭 �̵��� ����� temp 2���� �迭�� ������.
			// temp 2���� �迭�� �ϳ��� Ž���ϸ鼭, (i,j)��ġ�� �մ� ��� ��ȣ Ȯ���� ��,
			// �ش� ��ġ�� ���� ��ȿ�Ⱓ(resttime[i][j])�� k�� �����ϰ�, ����(smell[i][j])�� ��� ��ȣ�� �־��ش�.
			// �̵� ���� ��� ��ġ�� ���� ������ ��ȿ�Ⱓ �ʱ�ȭ
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(temp[i][j] > 0) {
						restTime[i][j] = K;
						smell[i][j] = temp[i][j];
					}
				}
			}
			time++;
		} // end While
	}
	
	public static void moveShark(int[][] temp, int m) {
		int nx = 0;
		int ny = 0;
		int d = 0;
		
		boolean flag = false;
		
		// 1-1. ���� �켱�������� ���ʴ�� Ž��
		for(int i=0; i<4; i++) {
			d = priority[m][shark[m].dir][i];
			nx = shark[m].x + dx[d];
			ny = shark[m].y + dy[d];
			
			// ��踦 ����� �����鼭, ������ ���� ���� ã���� break�� ��������
			if( (nx >= 1 && nx <= N) && (ny >=1 && ny <= N) && smell[nx][ny] == 0) {
				flag = true;
				break;
			}
		}
		
		// 1-2. ������ ���� ���� ���� ���
		if(!flag) {
			for(int i=0; i<4; i++) {
				d = priority[m][shark[m].dir][i];
				nx = shark[m].x + dx[d];
				ny = shark[m].y + dy[d];
				// ������ ����� �ʰ�, �ڱ��ڽ��� ������ �ִ� ���� ã�� ��������
				if((nx >= 1 && nx <= N) && (ny >= 1 && ny <= N) && smell[nx][ny] == m) {
					break;
				}
			}
			
			// 2.
			if(temp[nx][ny] == 0) { // ������ �̵��� �� ���ٴ� ��(��������ϱ�)
				// �� �ڸ��� ���� ����� ��ȣ �־��ְ� �������� ��ġ������ ���� �������ش�.
				temp[nx][ny] = m;
				shark[m].x = nx;
				shark[m].y = ny;
				shark[m].dir = d;
			}else { // temp[nx][ny] !=0 -> ������ �̵��� �� �ش���ǥ�� �̹� �ִ�.
				// for������ ���� ���� ����� ��ȣ�� ������� �۴�. ��, ������� �Ѱܳ���.
				shark[m] = null; // �Ѱܳ��°� �ǹ�
			}
		}
	}
}
