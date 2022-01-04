package 토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_7569 {
	static int m,n,h;
	static int[][][] map;
	Deque<int[]> que0; // 익지 않은 토마토를 집어넣을 큐
	static int[] dZ = {1,-1,0,0,0,0};
	static int[] dY = {0,0,1,-1,0,0};
	static int[] dX = {0,0,0,0,1,-1};
	
	public void solve() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][n][m];
		Deque<int[]> queue = new ArrayDeque(); // 익은 토마토를 집어넣을 큐
		que0 = new ArrayDeque();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k=0; k<h; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(map[i][j][k] == 0) {
						que0.add(new int[] {i,j,});
					}
					else if(map[i][j][k] == 1) {
						queue.add(new int[] {i,j,k});
					}
				}
			}
		}
		
		int r = floodfill(queue, 0);  // 0은 day start day는 0
		System.out.println(r);
	}
	
	public int floodfill(Deque<int[]> queue, int days) {
		if(IsReady())
			return days;
		
		Deque<int[]> queueNext = new ArrayDeque();
		
		while(queue.size() > 0) {
			int[] zyx = queue.pop();
			
			for(int idx = 0; idx<dZ.length; idx++) {
				int z = zyx[0] + dZ[idx];
				int y = zyx[1] + dY[idx];
				int x = zyx[2] + dX[idx];
				
				if(IsInMap(z,y,x)) {
					if(map[z][y][x] == 0) {
						map[z][y][x] = 1;
						queueNext.add(new int[] {z,y,x});
					}
					
				}
			}
			
		}
		
		if(queueNext.size()>0) {
			return floodfill(queueNext, days+1);
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BOJ_7569 main = new BOJ_7569();
		main.solve();
	}
	
	public boolean IsReady() {
		for(int[] zyx: que0) {
			int z = zyx[0];
			int y = zyx[1];
			int x = zyx[2];
			
			if(map[z][y][x] == 0) {
				return false;
			}
			else if(map[z][y][x] == 1) {
				que0.remove(zyx);
			}
		}
		
		return true;
	}
	
	public boolean IsInMap(int z, int y, int x) {
		if(0 <= z && z < h && 0 <= y && y< n && 0 <= x && x < m) {
			return true;
		}
		
		return false;
	}
}
