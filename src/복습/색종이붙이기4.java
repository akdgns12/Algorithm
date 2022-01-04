package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �����̺��̱�4 {
	static int[][] map;
	static int[] paper = {0,5,5,5,5,5};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0); // idx, cnt
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	
	public static void dfs(int idx, int cnt) {
		if(idx == 100) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// �̹� ���� �亸�� ũ�ٸ� �ð�����, skip �����ش�
		if(answer <= cnt) {
			return;
		}
		
		int x = idx / 10;
		int y = idx % 10;
		if(map[x][y] == 1) {
			// ū �����̺��� Ž��
			for(int i=5; i>0; i--) {
				// ������ �����ְ� ������ �κ� �� 1�� ���
				if(paper[i] > 0 && check(x,y,i)) {
					// ������ �� �ٿ��ְ�
					paper[i] -= 1;
					// �ش� ������ �κ� 0���� �ٲ��ش�
					fill(x,y,i,0);
					dfs(idx + 1, cnt+1);
					// Ž�� ���� ��, �ǵ�����
					fill(x,y,i,1);
					paper[i] += 1;
				}
			}
		}else
			dfs(idx+1, cnt);
	}
	
	public static void fill(int x, int y, int paperSize, int num) {
		for(int i=x; i<x+paperSize; i++) {
			for(int j=y; j<y+paperSize; j++) {
				map[i][j] = num;
			}
		}
	}
	
	public static boolean check(int x, int y, int paperSize) {
		if(x + paperSize > 10 || y + paperSize > 10)
			return false;
		
		for(int i=x; i<x+paperSize; i++) {
			for(int j=y; j<y+paperSize; j++) {
				if(map[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}


