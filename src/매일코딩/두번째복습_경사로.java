package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class 두번째복습_경사로 {
	static int n,l;
	static int[][] map;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		// 맵 정보 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of Input
		
		// 행 과 열 따로 계싼
		for(int i=0; i<n; i++) {
			if(checkPath(i, 0, true))
				cnt++;
			if(checkPath(0, i, false))
				cnt++;
		}
		
		System.out.println(cnt);
	}

	public static boolean checkPath(int x, int y, boolean flag) {
		
		int[] height = new int[n]; // 높이 체크하기 위한 배열
		visited = new boolean[n]; // 경사로 이미 설치되어있는지 체크
		
		for(int i=0; i<n; i++) {
			if(flag)
				height[i] = map[x][i]; // 행 검사
			else
				height[i] = map[i][y]; // 열 검사
		}
		
		for(int i=0; i<n-1; i++) {
			// 높이가 같을 때
			if(height[i] == height[i+1]) {
				continue;
			}
			
			// 내려가는 경사
			else if(height[i] - height[i+1] == 1) {
				for(int j=i+1; j<=i+l; j++) {
					// 범위 넘어가거나 낮은 지점 칸의 높이가 다르거나 이미 경사로가 있는 경우
					if(j >= n || height[i+1] != height[j] || visited[j])
						return false;
					visited[j] = true;
				}
			}
			
			// 올라가는 경사
			else if(height[i] - height[i+1] == -1) {
				for(int j=i; j>i-l; j--) {
					// 범위 넘어가거나 낮은 칸의 높이가 다르거나 이미 경사로가 있는 경우
					if(j < 0 || height[i] != height[j] || visited[j])
						return false;
					visited[j] = true;
				}
			}
			// 높이가 2칸 이상 차이 날 때(길x)
			else {
				return false;
			}
		}
		return true;
	}
}
