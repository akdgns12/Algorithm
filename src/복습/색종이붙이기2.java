package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기2 {
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static int[] paper = {0,5,5,5,5,5};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	
	public static void dfs(int idx, int cnt) {
		if(idx == 100) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// 이미 나온 답보다 더 큰 카운팅은 시간낭비
		if(answer <= cnt) {
			return;
		}
		
		int x = idx / 10;
		int y = idx % 10;
		
		
		if(map[x][y] == 1) {
			// 큰 색종이부터 사용하기
			for(int i=5; i>0; i--) {
				// 색종이가 남아있고 && 색종이 부분이 다 1인경우
				if(paper[i] > 0 && check(x,y,i)) {
					// 색종이 수 -1, 다음 탐색시 걸리지 않게 0으로 바꿈, 계속 탐색
					paper[i] -= 1;
					fill(x,y,i,0);
					dfs(idx+1, cnt+1);
					// 다시 되돌려줌, 백트래킹
					fill(x,y,i,1);
					paper[i] += 1;
				}
			}
		}else
			dfs(idx+1, cnt);	
	}
	
	public static void fill(int x, int y, int paperSize, int num) {
		for(int i=x; i<x+paperSize; i++) {
			for(int j=y; j<y+paperSize; j++) {
				map[i][j] = num;
			}
		}
	}
	
	public static boolean check(int x, int y, int paperSize) {
		if(x+paperSize > 10 || y+paperSize > 10) {
			return false;
		}
		
		for(int i=x; i<x+paperSize; i++) {
			for(int j=y; j<y+paperSize; j++) {
				if(map[i][j] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}
}
