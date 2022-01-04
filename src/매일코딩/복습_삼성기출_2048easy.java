package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_삼성기출_2048easy {
	static int N;
	static int[][] map;
	static int[][] temp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = 0;
	
	static int[] direct;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		direct = new int[4];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(5,0);
		System.out.println(max);
	}
	
	public static void dfs(int end, int index) {
		if(count == end) {
			confirm();
			return;
		}else {
			for(int i=0; i<4; i++) {
				direct[index] = i;
				dfs(end, index+1);
			}
		}
	}
	
	public static int confirm() {
		temp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			temp[i] = map[i].clone();
		}
		
		for(int d=0; d<direct.length; d++) {
			visited = new boolean[N][N];
			
			if(direct[d] == 0) { // 상
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						move(i,j,direct[d]);
					}
				}
			}else if(direct[d] == 1) { // 하
				
			}
		}
		
		
	}
	
	public static void move(int x, int y, int dir) {
		if(temp[x][y] == 0) {
			return;
		}
		
	}
}
