package 토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs문제
/*
 * 하루에 상하좌우 한칸씩 이동하니 BFS가 바로 떠오른다.
 * 클래스에 변수를 하나 더 추가하여 카운트 하는 방법으로 풀었다.
 * 일반적으로 BFS문제에서는 visited 2차원 배열을 사용하여 중복 방문을 방지하지만
 * 이 문제에서는 1이 그 역할을 하고 있다.
 * 
 * <순서>
 * 1. 2중 for문으로 box배열을 돌면서 익은 토마토를 Queue 자료구조에 넣기
 * 2. bfs를 돌면서 토마토 모두 익게 하기
 * 3. 다시 2중 for문 돌면서 안 익은 토마토가 있다면 -1출력, 없으면 날짜 출력
 */
public class BOJ_7576 {
	
	static int m,n, count, day;
	static int[][] arr;
	static Queue q1 = new LinkedList();
	static Queue q2 = new LinkedList();
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		count = n*m;
		arr = new int[n+1][m+1];
		
		String str = br.readLine();
		for(int i=0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1) {
					--count;
					q1.add(i);
					q2.add(j);
				}else if(arr[i][j]==-1) {
					--count;
				}
			}
		} // 익은 배추를 queue에 전부 넣기
		
		while(!q1.isEmpty()) {
			
			int x = (int) q1.poll();
			int y = (int) q2.poll();
			
			for(int i=0; i<4; i++) { // 상하좌우 체크
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >=0 && ny >=0 && nx<= n-1 && ny <= m-1) {
					if(arr[nx][ny] == 0) {  //익지 않은 배추 일때만
						q1.add(nx);
						q2.add(ny);
						arr[nx][ny] = arr[x][y] + 1;
						day = arr[x][y];
						--count;
					}
				}
			}
		}
		
		if(count==0) {
			System.out.println(day); // 배추가 모두 익었으면 day 출력
		}else if(count>0) {
			System.out.println("-1"); // 익지 않은 배추가 남았으면 -1 출력
		}
	}
}
