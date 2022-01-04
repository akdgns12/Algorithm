package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습2_스타트와링크 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		// 능력치 정보 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of Input
		
		// 가능한 조합 모두 찾아서 최솟값인 경우 return
		dfs(0,0);
		System.out.println(min);
	}
	
	// idx 인덱스, count 조합의 수
	public static void dfs(int idx, int count) {
		if(count == N / 2) {
			// 하나의 조합, 경우의 수 찾으면 능력치 차이 계산
			diff();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, count+1); // 재귀 호출
				visited[i] = false;
			}
		}
	}
	
	public static void diff() {
		int start = 0;
		int link = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] == true && visited[j] == true) {
					start += map[i][j];
					start += map[j][i];
				}
				else if(visited[i] == false && visited[j] == false) {
					link += map[i][j];
					link += map[j][i];
				}
			}
		}
		
		// 두 팀의 능력치 차이(절댓값)
		int val = Math.abs(start - link);
		
		
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(val, min);
	}
}
