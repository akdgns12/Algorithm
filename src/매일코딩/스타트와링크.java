package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 팀의 능력치 차이 최소화
/*
 * 모든 조합의 경우의 수를 탐색하여 두 팀의 능력치가 최소가 되는 수를 찾고
 * 이를 출력하면 된다.
 */
public class 스타트와링크 {
	static int n;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		// 점수표 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of Input
		
		combi(0,0);
		System.out.println(min);
	}
	// idx는 인덱스, count는 조합 개수(=재귀 길이)
	public static void combi(int idx, int count) {
		// 팀 조합이 완성될 경우
		if(count == n / 2) {
			/*
			 *  방문한 팀과 방문하지 않은 팀을 각각 나누어
			 *  각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			 */
			diff();
			return;
		}
		
		for(int i=idx; i<n; i++) {
			// 방문하지 않았다면?
			if(!visited[i]) {
				visited[i] = true; // 방문으로 변경
				combi(i + 1, count + 1); // 재귀 호출
				visited[i] = false; // 재귀가 끝나면 비방문으로 변경
			}
		}
	}
	
	// 두 팀의 능력치 차이를 계산하는 함수
	public static void diff() {
		int team_start = 0;
		int team_link = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				// i번째 사람과 j번째 사람이 true라면 스타트팀으로 점수 플러스
				if(visited[i] == true && visited[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				// i번째 사람과 j번쨰 사람이 false라면 링크팀으로 점수 플러스
				else if(visited[i] == false && visited[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이(절댓값)
		int val = Math.abs(team_start - team_link);
		
		/*
		 * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		 * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
		 */
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(val, min);
	}
}
