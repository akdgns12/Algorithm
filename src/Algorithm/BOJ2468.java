package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 안전 영역 DFS 방식
public class BOJ2468 {
	static int[][] map;
	static boolean[][] visited; //방문한 영역 확인할 2차원 boolean 배열 생성
	static int n; // 배열 사이즈 받을 변수 선언
	static int[] dx = {0,0,-1,1}; // 상하좌우 값 확인
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j<n; j++) {
				map[i][j]=Integer.parseInt(str[j]);
				if(max<map[i][j]) { //최대 높이 저장
					max = map[i][j];
				}
			}
		}
		int maxCount = 1;
		int cnt = 0; 
		
		for(int c=0; c<=max; c++) { // 최대 높이만큼 for문으로 안전 영역 최대 개수 찾기
			visited = new boolean[n][n];
			cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]> c && visited[i][j]==false) { //안잠기는 곳이거나 한번도 방문하지 않았으면
						
					}
				}
			}
		}
	}
}

