package Algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// BFS 문제 , 영역 구하기
public class BOJ2583 {
	
	// 영역 구하기
	// 상우하좌
	static int[] dx = {0,1,0,-1}; // 우,좌
	static int[] dy = {1,0,-1,0}; // 상,하
	static int m;
	static int n;
	static int k;
	static boolean[][] visited; // 방문여부 판단
	static int[][] map; // m*n map 작성
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[m][n];
		visited = new boolean[m][n];
		int count =0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<k; i++) {
			int lx = sc.nextInt(); // 왼쪽 위x
			int ly = sc.nextInt(); // 왼쪽 위 y
			int rx = sc.nextInt(); // 오른쪽 아래 x
			int ry = sc.nextInt(); // 오른쪽 아래 y
			// 색칠되는 사각형 영역에 해당하는 배열에 1을 넣기 
			for(int y=ly; y<ry; y++) {
				for(int x=lx; x<rx; x++) {
					map[y][x]=1; 
				}
			}
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j] ==0) {
					int data = bfs(i,j);
					list.add(data);
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
	}
	
	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();  // 큐 
		queue.offer(new int[] {x,y});
		visited[x][y]=true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] data = queue.poll();
			int curX = data[0];
			int curY = data[1];
			
			for(int i=0; i<4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				
				if(nextX >=0 && nextY >=0 && nextX < m && nextY < n) {
					if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
						visited[nextX][nextY] = true;
						queue.offer(new int[]{nextX, nextY});
						cnt++;
					}
		}
			}
		}
		return cnt;
	}
}
	