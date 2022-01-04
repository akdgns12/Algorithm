package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠복습 {
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		map = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
	}
	
	public static void dfs(int row, int col) {
		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if(col == 9) {
			dfs(row+1, 0);
			return;
		}
		
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if(row == 9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.println(map[i][j] + " ");
				}
				System.out.println();
			}
			// 출력 뒤 시스템 종료
			System.exit(0);
		}
		
		// 만약 해당 위치가 0 이면 1부터 9까지 중 가능한 수 검사
		if(map[row][col] == 0) {
			for(int i=1; i<=9; i++) {
				// i값이 중복되지 않는지 검사
				if(check(row, col, i)) {
					map[row][col] = i;
					dfs(row, col+1);
				}
			}
			map[row][col] = 0;
			return;
		}
		
		dfs(row, col+1);
	}
	
	// 검사 함수
	public static boolean check(int row, int col, int value) {
		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for(int i=0; i<9; i++) {
			if(map[row][i] == value) {
				return false;
			}
		}
		
		// 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for(int i=0; i<9; i++) {
			if(map[i][col] == value) {
				return false;
			}
		}
		
		// 3x3 칸에 중복된 원소가 있는지 검사
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
		
		for(int i=set_row; i<set_row+3; i++) {
			for(int j=set_col; j<set_col+3; j++) {
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
}
