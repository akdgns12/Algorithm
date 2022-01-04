package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136 {
	// 골 2 색종이 붙이기 / 삼성기출
	static int[][] map;
	static int[] paper = {5,5,5,5,5}; // 색종이 개수 각 5개씩
	static int answer = Integer.MAX_VALUE; // 색종이 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * 색종이 크기가 큰 순부터 붙이는 그리디적인 요소와
		 * DFS + 백트래킹 활용해서 풀어야함.
		 */
		dfs(0,0,0);
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	
	// DFS + 백트래킹해서 풀기
	public static void dfs(int x, int y, int cnt) {
		// (0,0)부터 마지막(9,9)까지 갈 경우에 색종이 최소값 구한다.
		if(x >= 9 && y > 9) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// cnt가 answer보다 크거나 같으면 시간 낭비이기 때문에 종료.
		if(cnt >= answer) return;
		
		// 줄마다 마지막 칸을 넘을 경우 다음 줄로 가기
		if(y > 9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		// 색종이 제일 큰 것부터 붙여보자
		// 배열 값에 1이 있으면
		if(map[x][y] == 1) {
			// 색종이를 큰 것 부터 준비
			
			for(int i=4; i>=0; i--) {
				// 근데, 색종이가 있을 경우에 붙인다.
				// 색종이가 있으면 색종이의 크기만큼 붙일 수 있으면
				if(paper[i] > 0 && possible(x, y, i+1)) {
					// 색종이 붙여, i에 1을 더한 이유는 0~4까지 1,2,3,4,5로 해놔서
					attach(x, y, i+1);
					
					// 색종이 개수 줄여
					paper[i]--;
					
					// 색종이 뗴
					detach(x, y, i+1);
					
					// 색종이 땠으니까 개수 늘려
					paper[i]++;
				}
			}
		}
		
		// 배열 값에 1이 없으면
					else
						dfs(x, y+1, cnt);
		
	}
	// 색종이 붙이기
	public static void attach(int x, int y, int size) {
				for(int i=x; i<x+size; i++) {
					for(int j=y; j<y+size; j++) {
						map[i][j] = 0;
					}
				}
			}
	
	// 색종이 떼기
	public static void detach(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	// 색종이의 크기만큼 붙일 수 있는지 확인
	public static boolean possible(int x, int y, int size) {
		// 색종이의 size만큼 확인을 하는데,
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				// 범위를 벗어나거나 그 위치가 1이 아니라면 false 리턴
				if(isIn(i,j) || map[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < 10 && y < 10;
	}
}
