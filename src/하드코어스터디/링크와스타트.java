package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 링크와스타트 {
	// BOJ 15661 링크와스타트 / 실버 1
	// 두 팀의 능력치 차이 최소화
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int num = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 팀의 팀원수를 구하는 경우의 수에 따라
		// 능력치 차이 모두 구하고 그 중 최솟값 리턴
		for(num = 1; num<N; num++) { // num : 팀원 수
			combi(0,0);
		}
		
		System.out.println(min);
	}
	// 한팀이 되는 인원 수 경우 구하기
	public static void combi(int depth, int start) {
		if(depth == num) {
			calc();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	// 능력치 계산
	public static void calc() {
		 int start = 0; // visited[i] = true : start팀
		 int link = 0; // visited[i] = false : link팀
		 for(int i=0; i<N; i++) {
			 for(int j=i+1; j<N; j++) {
				 if(visited[i] && visited[j]) {
					 start += (map[i][j] + map[j][i]);
				 }else if(!visited[i] && !visited[j]) {
					 link += (map[i][j] + map[j][i]);
				 }
			 }
		 }
		 
		min = Math.min(min, Math.abs(start-link)); // 최솟값 갱신
		
		if(min == 0) { // 능력치 차 0이면 바로 종료 더 빠른속도 위해
			System.out.println(0);
			System.exit(0);
		}
	}
}
