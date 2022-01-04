package 매일코딩;

import java.util.LinkedList;
import java.util.Queue;

public class 복습2_빛의경로사이클_프로그래머스 {
	
//	public static void main(String[] args) {
//		String[] grid = {"SL","LR"};
//		
//		
//		solution(grid);
//	}
	static class Pair{
		int x, y, d;
		
		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static char[][] map;
	static int[] dx = {0,1,0,-1}; // 좌 상 우 하
	static int[] dy = {-1,0,1,0};
	static boolean[][][] visited;
	static int row, col;
	
	public static int[] solution(String[] grid) {
		int[] answer = {};
		row = grid.length;
		col = grid[0].length();
		map = new char[row][col];
		
		int idx = 0;
		for(String x : grid) {
			map[idx] = x.toCharArray();
			idx++;
		}
		visited = new boolean[4][row][col];
		
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
							if(!isPossible(nx,ny)) {
								if(nx < 0) {
									nx = row - 1;
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
							if(!isPossible(nx,ny)) {
								if(nx < 0) {
									nx = row - 1;
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
							if(!isPossible(nx,ny)) {
								if(nx < 0) {
									nx = row - 1;
								}else if(nx >= row) {
									nx = 0;
								}else if(ny < 0) {
									ny = col - 1;
								}else {
									ny = 0;
								}
							}
						}
					}
				}
			}
		}
		
		return answer;
	}
	
	public static boolean isPossible(int x, int y) {
		if(x < 0 || x >= row || y < 0 || y >= col) {
			return false;
		}
		return true;
	}
	
	// 0 1 2 3
	// 좌 상 우 하
	public static int dirL(int d) {
		if(d == 0) {
			return 1;
		}else if(d == 1) {
			return 0;
		}else if(d == 2) {
			return 3;
		}else {
			return 2;
		}
	}
	
	public static int dirR(int d) {
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
		
	}
}
