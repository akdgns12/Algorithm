package 백트래킹;

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
		// 해당 행이 다 채워졌을 경우 다음 행의 첫번째 열부터 시작
		if(col == 9) { // 열이 9라면 해당 행 다 채워진 것
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
		
		// 만약 해당 위치가 0이라면 1부터 9까지 중 가능한 수 탐색
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
		
		dfs(row, col + 1);
	}
	
	// 행, 열, 탐색하려는 값
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
		
		// 3x3칸에 중복되는 원소가 있는지 검사
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
		
		for(int i=set_row; i<set_row+3; i++) {
			for(int j=set_col; j<set_col+3; j++) {
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		return true; // 중복되는 것이 없을 경우 true 반환
	}
}
