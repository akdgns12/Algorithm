package 그래프탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 총 7명의 학생 조합을 뽑는데, 7명 중 최소 4명은 '이다솜파'여야 한다.
 * 이 상태에서 이 7명의 학생들이 인접해있는지 확인해야 한다.
 */
class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_소문난칠공주 {
	static int n = 5;
	static int cnt = 0;
	
	static int[] dx= {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[n][n];
		
		//map 정보 입력받기
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[25];
		//25개중 7개를 선택하는 조합
		comb(0,7);
		
		System.out.println(cnt);
	}
	
	public static void comb(int start, int r) {
		if(r==0) {
			int num = 0;
			int temp = 0;
			int x = 0;
			int y= 0;
			int[][] map2 = new int[5][5]; //선택한 자리
			for(int i=0; i<25; i++) {
				//row와 column으로 변환
				int row = i/5;
				int col = i%5;
				if(visited[i]) {
					map2[row][col] = 1; //자리 선택
					if(temp == 0) {
						x = row;
						y = col;
					}
					
					//이다솜파 몇명이 선택되었는지 세기
					if(map[row][col] == 'S')
						num++;
					temp++; //7명 모두 골랐다면 빠른 탈출
				}
				if(temp == 7)
					break;
			}
			
			//이다솜파 4명이상 선택되었다면 BFS로 연결되어 있는지 탐색
			if(num >= 4) {
				bfs(x,y,map2);
			}
			
			return;
		}
		
		for(int i=start; i<25; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(i+1, r-1);
				visited[i] = false;
			}
		}
	}
	
	static void bfs(int a, int b, int[][] arr) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		q.offer(new Pos(a,b));
		visited[a][b] = true;
		int num = 1;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//유효한 위치 && 선택된 자리 && 방문하지 않은 자리
				if(nx > 0 &&  ny > 0 && nx < 5 && ny < 5 && arr[nx][ny] == 1 && !visited[nx][ny]) {
					q.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
					num++;
				}
			}
		}
		
		//모두 연결되어 있다면 num == 7
		if(num == 7)
			cnt++;
	}
}
