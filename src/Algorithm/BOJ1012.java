package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유기농 배추
// dfs

public class BOJ1012 {	
	static int[][] map;
	static int[] dy = {0,0,-1,1}; // 좌우하상
	static int[] dx = {-1,1,0,0};
	static int M,N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //가로
			N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 배추개수
			
			map = new int[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
				int count = 0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(map[i][j]==1) {
							dfs(i,j);
							count++;
						}
					}
				}
				System.out.println(count);
			}
		}
		
		static void dfs(int y, int x) {
			map[y][x]=0; //visited check
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny<0 || ny>N-1 || nx<0 || nx>M-1) continue;
				if(map[ny][nx]==1) dfs(ny,nx);
			}
			return;
		}
	}

	