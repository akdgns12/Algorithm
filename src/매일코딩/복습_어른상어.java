package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_���� {
	static class Shark{
		int r, c, dir;
		
		Shark(int r, int c, int dir){
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	static int N, M, K;
	static int[][] restTime; 
	static int[][] smell;
	static int[][][] priority;
	static Shark[] shark;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		restTime = new int[N+1][N+1];
		smell = new int[N+1][N+1];
		priority = new int[M+1][5][4];
		shark = new Shark[M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken()); 
				
				if(n > 0) { // ��� ��ȣ
					shark[n] = new Shark(i, j, 0);
					restTime[i][j] = K;
					smell[i][j] = n;  // ������ ���� ����� ��ȣ �迭
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
		 * 1. �����¿� �߿��� ����� ���ο� �̵� ��ġ(nr, nc)�� ã�´�.
   		1-1. ����� ���� ������ �������� ���� �켱������ ���� ������� Ž���Ѵ�.
                Ž�� ����, ������ ���� ������ ��ġ�� ã���� Ž���� �����Ѵ�.
   	    2-1. ���� ��� Ž���ߴµ� ������ ���� ���� ���ٸ�, �ڱ� �ڽ��� ������ �ִ� ������ ���� ã�´�.
                 ���������� ���� ������ �������� ���� �켱������ ���� ������� Ž���Ѵ�.
		 */
	}
	
	public static int solve() {
		int time = 0;
		
		while(true) {
			int count = 0;
			for(int m=1; m<=M; m++) {
				if(shark[m] != null) {
					count++;
				}
			}
			
				if(count == 1 && shark[1] != null) { //1�� ��� ȥ�� ���� ���
					return time;
				}
				
				// 1000�� ���� ���
				if(time >= 1000)
					return -1;
				
				// �ӽù迭
				int[][] tmp = new int[N+1][N+1];
				
				for(int m=1; m<=M; m++) {
					if(shark[m] != null) { // �� ���ȿ� �ִٸ�
						moveShark(tmp, m);
					}
				}
				
				// ���� ��ȿ�Ⱓ �ϳ��� ���̱�
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(restTime[i][j] > 0)
							restTime[i][j]--;
						
						if(restTime[i][j] == 0)
							smell[i][j] = 0;
					}
				}
				
				// �̵����� ��� ��ġ�� ���� ������ ��ȿ�Ⱓ �ʱ�ȭ
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(tmp[i][j] > 0) {
							restTime[i][j] = K;
							smell[i][j] = tmp[i][j];
						}
					}
				}
				time++;
			}
		}
	
	public static void moveShark(int[][] tmp, int m) {
		int nr = 0;
		int nc = 0;
		int d = 0;
		
		boolean flag = false;
		
		// 1-1. ���� �켱�������� ���ʴ�� Ž��
		for(int i=0; i<4; i++) {
			d = priority[m][shark[m].dir][i];
			nr = shark[m].r + dr[d];
			nc = shark[m].c + dc[d];
			
			// ��踦 ����� �����鼭, ������ ���� ���� ã���� break�� ��������
			if((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == 0) {
				flag = true;
				break;
			}
		}
		
		// 1-2. ������ ���� ���� ���� ���
		if(!flag) {
			for(int i=0; i<4; i++) {
				d = priority[m][shark[m].dir][i];
				nr = shark[m].r + dr[d];
				nc = shark[m].c + dc[d];
				
				if((1<=nr && nr <= N) && (1 <= nc && nc<=N) && smell[nr][nc] == m)
					break;
			}
		}
		
		if(tmp[nr][nc] == 0) {
			tmp[nr][nc] = m;
			shark[m].r = nr;
			shark[m].c = nc;
			shark[m].dir = d;
		}else {
			shark[m] = null;
		}
	}
}

