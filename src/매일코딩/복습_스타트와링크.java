package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_스타트와링크 {
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
		
		// 능력치 정보 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of Input
		
		// 가능한 모든 조합을 찾아 최소의 경우 return
		dfs(0,0);
		System.out.println(min);
			
	}
	
	// idx는 인덱스, count는 조합개수
	public static void dfs(int idx, int count) {
		if(count == N / 2) { // 팀 조합이 완성되는 경우
			diff(); // 두 팀의 능력치 차이 계산하는 함수
			return;
		}
		
		for(int i=idx; i<N; i++) {
			// 방문하지 않았다면?
			if(!visited[i]) {
				visited[i] = true;
				dfs(idx+1, count+1); // 재귀호출
				visited[i] = false; // 재귀가 끝나면 비방문으로 변경
			}
		}
	}
	
	// 하나의 조합 완성된 후 두 팀의 능력치 차이 계산하는 함수
	public static void diff() {
		int team_start = 0;
		int team_link = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				// i번쨰 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
				if(visited[i] == true  && visited[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				
				// i번째 사람과 j번째 사람이 false라면 링크팀으로 점수 플러스
				else if(visited[i] == false && visited[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		
		// 두 팀의 점수 차이(절댓값)
		int val = Math.abs(team_start - team_link);
		
		// 만약 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		// 더이상 탐색할 필요 x
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
	}
}
