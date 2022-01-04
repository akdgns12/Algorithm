package ��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136 {
	// �� 2 ������ ���̱� / �Ｚ����
	static int[][] map;
	static int[] paper = {5,5,5,5,5}; // ������ ���� �� 5����
	static int answer = Integer.MAX_VALUE; // ������ ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * ������ ũ�Ⱑ ū ������ ���̴� �׸������� ��ҿ�
		 * DFS + ��Ʈ��ŷ Ȱ���ؼ� Ǯ�����.
		 */
		dfs(0,0,0);
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	
	// DFS + ��Ʈ��ŷ�ؼ� Ǯ��
	public static void dfs(int x, int y, int cnt) {
		// (0,0)���� ������(9,9)���� �� ��쿡 ������ �ּҰ� ���Ѵ�.
		if(x >= 9 && y > 9) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// cnt�� answer���� ũ�ų� ������ �ð� �����̱� ������ ����.
		if(cnt >= answer) return;
		
		// �ٸ��� ������ ĭ�� ���� ��� ���� �ٷ� ����
		if(y > 9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		// ������ ���� ū �ͺ��� �ٿ�����
		// �迭 ���� 1�� ������
		if(map[x][y] == 1) {
			// �����̸� ū �� ���� �غ�
			
			for(int i=4; i>=0; i--) {
				// �ٵ�, �����̰� ���� ��쿡 ���δ�.
				// �����̰� ������ �������� ũ�⸸ŭ ���� �� ������
				if(paper[i] > 0 && possible(x, y, i+1)) {
					// ������ �ٿ�, i�� 1�� ���� ������ 0~4���� 1,2,3,4,5�� �س���
					attach(x, y, i+1);
					
					// ������ ���� �ٿ�
					paper[i]--;
					
					// ������ ��
					detach(x, y, i+1);
					
					// ������ �����ϱ� ���� �÷�
					paper[i]++;
				}
			}
		}
		
		// �迭 ���� 1�� ������
					else
						dfs(x, y+1, cnt);
		
	}
	// ������ ���̱�
	public static void attach(int x, int y, int size) {
				for(int i=x; i<x+size; i++) {
					for(int j=y; j<y+size; j++) {
						map[i][j] = 0;
					}
				}
			}
	
	// ������ ����
	public static void detach(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	// �������� ũ�⸸ŭ ���� �� �ִ��� Ȯ��
	public static boolean possible(int x, int y, int size) {
		// �������� size��ŭ Ȯ���� �ϴµ�,
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				// ������ ����ų� �� ��ġ�� 1�� �ƴ϶�� false ����
				if(isIn(i,j) || map[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < 10 && y < 10;
	}
}
