package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 각 행과 열마다 지나갈 수 있는 길인지 체크해서 갯수를 세준다.
// 2. 해당 행과 1열을 1차원 배열로 만들어 체크하기 쉽게 만든다
// 3. 조건이 맞지않는 경우 false 리턴

/*
 * 경사로는 크게 2가지
 * - 올라가는 경사로, 내려가는 경사로
 * 따로따로 구현해주어야 한다.
 */

public class 경사로 {
	static int n, l; // n : 지도크기, l : 경사로길이
	static int[][] map; // 지도
	static boolean[] visited; // 경사로 놓은지 확인
	static int pathCnt = 0; // 지나갈 수 있는 길의 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		// 길 정보 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //end of Input
		
	
		// 가능한 길인지 아닌지 체크
		for(int i=0; i<n; i++) {
			if(checkPath(i, 0, 0))// 행
				pathCnt++;
			if(checkPath(0, i, 1)) // 열
				pathCnt++;
		}
		
		System.out.println(pathCnt);
	}
	
	
	public static boolean checkPath(int x, int y, int d) {
		int[] height = new int[n]; // 높이 체크하기 위한 배열
		visited = new boolean[n]; // 경사로 놓았는지 확인
		
		if(d == 0) { // 행(가로)일 경우
			for(int i=0; i<n; i++) {
				height[i] = map[i][x];
			}
		}
		else { // 열(세로)일 경우
			for(int i=0; i<n; i++) {
				height[i] = map[y][i];
			}
		}
		
		for(int i=0; i<n-1; i++) {
			if(height[i] == height[i+1]	) {
				continue;
			} // 같은 높이인 경우는 구할 필요가 없다.
			
			if(Math.abs(height[i] - height[i+1]) != 1) {
				return false; // 경사로는 최대길이가 1이니 해당하지 않는다면 false
			}
			
			if(height[i] > height[i+1]) { // 내려가는 경사로일 경우
				for(int j=i+1; j<=i+l; j++) {
					if(j > n-1) { // 경사로가 범위를 벗어나면 false
						return false;
					}
					if(visited[j] || height[j] != height[i] - 1) {
						return false; // 경사로를 겹치게 놓을 수 없다.
					}
					visited[j] = true;
				}
			}
			else if(height[i] < height[i+1] ) { // 올라가는 경사로일 경우
				for(int j=i; j>i-l; j--) {
					if(j<0) {
						return false;
					}
					if(visited[j] || height[j] != height[i+1] - 1) {
						return false;
					}
					visited[j] = true;
				}
			}
		}
		return true;
	}
}
