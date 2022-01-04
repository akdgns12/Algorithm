package 매일코딩;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class 복습_빛의경로사이클_프로그래머스 {
	static class Pair{
		int x, y, d;
		
		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static char[][] map;
	static int row, col;
	static int[] dx = {0,-1,0,1}; // 우상좌하
	static int[] dy = {1,0,-1,0};
	
	public int[] solution(String[] grid) {
		
		row = grid.length;
		col = grid[0].length();
		map = new char[row][col];
		int idx = 0;
		for(String x : grid) {
			map[idx] = x.toCharArray();
			idx++;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		boolean[][][] visited = new boolean[4][row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				for(int k=0; k<4; k++) {
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(i,j,k));
					int count = 0;
					if(!visited[k][i][j]) {
						visited[k][i][j] = true;
					}
					while(!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						int d = p.d;
						count++;
						int nx, ny, dirD;
						
						if(map[x][y] == 'S') {
							nx = x + dx[d];
							ny = y + dy[d];
							dirD = d;
							if(!isPossible(nx, ny)) { // 만약 범위를 벗어난다면
								if(nx < 0) {
									nx = row -1;
								}else if(nx >= row) {
									nx = 0;
								}else if(ny < 0) {
									ny = col - 1;
								}else {
									ny = 0;
								}
							}
						}else if(map[x][y] == 'L') {
							nx = x + dx[dirL(d)];
							ny = y + dy[dirL(d)];
							dirD = dirL(d);
							if(!isPossible(nx, ny)) { // 만약 범위를 벗어난다면
								if(nx < 0) {
									nx = row -1;
								}else if(nx >= row) {
									nx = 0;
								}else if(ny < 0) {
									ny = col - 1;
								}else {
									ny = 0;
								}
							}
						}else {
							nx = x + dx[dirR(d)];
							ny = y + dy[dirR(d)];
							dirD = dirR(d);
							if(!isPossible(nx, ny)) { // 만약 범위를 벗어난다면
								if(nx < 0) {
									nx = row -1;
								}else if(nx >= row) {
									nx = 0;
								}else if(ny < 0) {
									ny = col - 1;
								}else {
									ny = 0;
								}
							}
						}
						list.add(count);
					} // end while
				}
			}
		}
		
		int[] answer = new int[list.size()];
		int i = 0;
		for(int x : list) {
			answer[i++] = x; 
		}
		
		Arrays.sort(answer);
		return answer;
	}
	
	public static boolean isPossible(int x, int y) {
		if(x < 0 || x >= row || y < 0 || y >= col) {
			return false;
		}
		return true;
	}
	// 0 1 2 3
	// 우 상 좌 하
	public static int dirL(int d) {
		if(d == 0) {
			return 3;
		}else if(d == 1) {
			return 2;
		}else if(d == 2) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static int dirR(int d) {
		if(d == 0) {
			return 3;
		}else if(d == 1) {
			return 0;
		}else if(d == 2) {
			return 1;
		}else {
			return 2;
		}
	}
}	
