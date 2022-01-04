package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습_마법사와상어와파이어스톰 {
	static class Pos{
		int x,y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,Q,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		M = (int)Math.pow(2, N);
		
		map = new int[M][M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] level = new int[Q];
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			level[i] = Integer.parseInt(st.nextToken());
		}
		
		// 단계에 따라서 배열 돌리고 녹이기
		for(int l=0; l<Q; l++) {
			int len = (int)Math.pow(2, level[l]);
			rotate(len);
		}
		
		// 남은 얼음 합계
		int sum = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
		biggest();
	}
	
	public static void biggest() {
		int max = 0;
		boolean[][] visited = new boolean[M][M];
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					int cnt = 1;
					Queue<Pos> q = new LinkedList<>();
					q.add(new Pos(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Pos cur = q.poll();
						int x = cur.x;
						int y = cur.y;
						
						for(int k=0; k<4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx < 0 || ny < 0 || nx >= M || ny >= M)
								continue;
							if(map[nx][ny] == 0)
								continue;
							if(visited[nx][ny])
								continue;
							visited[nx][ny] = true;
							cnt += 1;
							q.add(new Pos(nx,ny));
						}
					}
					if(max < cnt)
						max = cnt;
				}
			}
		}
		System.out.println(max);
	}
	
	public static void rotate(int len) {
		int[][] map2 = new int[M][M];
		
		// 배열 90도 시계방향 회전시키기
		for(int startRow = 0; startRow < M; startRow++) {
			for(int startCol = 0; startCol < M; startCol++) {
				// 회전
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						map2[startRow+j][startCol + len - i - 1] = map[startRow + i][startCol + j];
					}
				}
			}
		}
		
		// 녹일 얼음 좌표가 들어가는 리스트
		ArrayList<Pos> arr = new ArrayList<>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				if(map2[i][j] == 0)
					continue;
				int cnt = 0; // 인접 얼음 개수
				for(int k = 0; k<4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if(x < 0 || y < 0 || x >= M || y >= M)
						continue;
					if(map2[x][y] != 0) {
						cnt++;
					}
				}
				if(cnt < 3) {
					// 녹일 곳이니 리스트에 넣어줌
					arr.add(new Pos(i,j));
				}
			}
		}
		
		//한꺼번에 녹여준다
		for(int i=0; i<arr.size(); i++) {
			int x = arr.get(i).x;
			int y = arr.get(i).y;
			map[x][y] -= 1;
		}
		
		// 원래배열에 최종 변경 값 다시 저장하기
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = map2[i][j];
			}
		}
		
	}

}
