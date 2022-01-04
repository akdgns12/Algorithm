package ��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		map = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dfs(0,0);
	}
	
	public static void dfs(int row, int col) {
		// �ش� ���� �� ä������ ��� ���� ���� ù��° ������ ����
		if(col == 9) { // ���� 9��� �ش� �� �� ä���� ��
			dfs(row+1, 0);
			return;
		}
		
		// ��� ���� ��� ä������ ��� ��� �� ����
		if(row == 9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.println(map[i][j] + " ");
				}
				System.out.println();
			}
			// ��� �� �ý��� ����
			System.exit(0);
		}
		
		// ���� �ش� ��ġ�� 0�̶�� 1���� 9���� �� ������ �� Ž��
		if(map[row][col] == 0) {
			for(int i=1; i<=9; i++) {
				// i���� �ߺ����� �ʴ��� �˻�
				if(check(row, col, i)) {
					map[row][col] = i;
					dfs(row, col+1);
				}
			}
			map[row][col] = 0;
			return;
		}
		
		dfs(row, col + 1);
	}
	
	// ��, ��, Ž���Ϸ��� ��
	public static boolean check(int row, int col, int value) { 
		
		// ���� �࿡ �ִ� ���ҵ� �� ��ġ�� �� ���Ұ� �ִ��� �˻�
		for(int i=0; i<9; i++) {
			if(map[row][i] == value) {
				return false;
			}
		}
		
		// ���� ���� �ִ� ���ҵ� �� ��ġ�� �� ���Ұ� �ִ��� �˻�
		for(int i=0; i<9; i++) {
			if(map[i][col] == value) {
				return false;
			}
		}
		
		// 3x3ĭ�� �ߺ��Ǵ� ���Ұ� �ִ��� �˻�
		int set_row = (row / 3) * 3; // value�� ���� 3x3�� ���� ù ��ġ
		int set_col = (col / 3) * 3; // value�� ���� 3x3�� ���� ù ��ġ
		
		for(int i=set_row; i<set_row+3; i++) {
			for(int j=set_col; j<set_col+3; j++) {
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		return true; // �ߺ��Ǵ� ���� ���� ��� true ��ȯ
	}
}
