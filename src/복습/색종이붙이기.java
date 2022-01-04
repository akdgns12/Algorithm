package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {
	/*
	 * 풀이
	 * 1. 가장 적게 색종이를 사용하므로 5x5의 색종이부터 탐색
	 * 2. 해당 색종이 영역이 다 1인지 확인 -> 다 1이면 사용할 수 있다는 의미
	 * 3. 해당 색종이를 사용할 수 있다면 사용하고 다른 색종이에 걸리지 않도록 0으로 바꿔줌
	 * 4. 0으로 바꾼 후 계속해서 탐색 진행
	 * 5. 탐색 후 색종이를 사용한 경우 역시 탐색해야 하므로 되돌려줌 -> 백트래킹
	 */
	static int[][] map;
	static int[] paper = {0,5,5,5,5,5}; // 각 색종이의 각 개수
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	public static void dfs(int idx, int cnt) {
		// 완전탐색을 위해 0,0부터 ~ 10,10까지를 인덱스로 표현
		if(idx == 100) {
			result = Math.min(result, cnt);
			return;
		}
		
		// 이미 나온 답보다 큰 경우 더이상의 탐색 불필요
		if(result <= cnt)
			return;
		
		int x = idx / 10;
		int y = idx % 10;
		
		if(map[x][y] == 1) {
			// 큰 색종이부터 사용하기
			for(int i=5; i>0; i--) {
				// 색종이가 남아있고 && 색종이 부분이 다 1인경우
				if(paper[i] > 0 && check(x,y, i)) {
					// 색종이 수 -1, 다음 탐색시 걸리지 않게 0으로 바꿈, 계속 탐색
					paper[i] -= 1;
					fill(x,y,i,0);
					dfs(idx + 1, cnt+1);
					// 탐색 후 돌려줌
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
		if(x+paperSize > 10 || y + paperSize > 10) {
			return false;
		}
		
		for(int i=x; i<x+paperSize; i++) {
			for(int j=y; j<y+paperSize; j++) {
				if(map[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}
