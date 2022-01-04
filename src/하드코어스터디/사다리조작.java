package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {
	static int N, M, H;
	static int[][] map;
	static int answer;
	static boolean isFinish = false; // 조건만족 판별 여부 변수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		 
		map = new int[H+1][N+1];
		for(int i=0; i<M; i++) { // 가로선 정보
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // x 좌표
			int b = Integer.parseInt(st.nextToken()); // y 좌표
			// 0 : 가로선 없음, 1 : 진행방향 오른쪽, 2 : 진행방향 왼쪽
			map[a][b] = 1;
			map[a][b+1] = 2;
		}
		
		// 가로선 개수 3개 한정되어 있으니
		// 설치할 다리 개수 0~3개
		for(int i=0; i<=3; i++) {
			// 설치할 사다리 개수를 전역변수로 저장하고dfs의 재귀 깊이가 해당 수 만큼 진행되도록 한다.
			answer = i;
			dfs(0,1);
			if(isFinish) break;
		}
		
		System.out.println(isFinish ? answer : -1);
	}
	
	public static void dfs(int line, int start) {
		if(isFinish) return;
		if(answer == line) { // answer 개수만큼 가로줄을 만들었다면
			if(check()) isFinish = true; // 조건을 만족하는지 확인하여 isFinish 값을 바꿔준다.
			return;
		}
		
		// 맵 전체 탐색하면서 가로선 세우기
		for(int i=start; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) { // 가로선이 없는 곳이라면 
					map[i][j] = 1; // 가로선 설치에 따른 진행방향 설정해준다
					map[i][j+1] = 2;
					dfs(line+1, i); // 가로선의 개수 + 1, 다음 탐색 위치를 매개변수로 재귀호출
					map[i][j] = map[i][j+1] = 0; // 값 복귀
				}
			}
		}
	}
	// i번에서 출발해 i번에 도착하는지 체크하는 함수
	public static boolean check() {
		for(int i=1; i<=N; i++) { // 각 세로줄 탐색
			int nx = 1; // 시작하는 가로줄
			int ny = i; // 시작하는 세로줄
			
			while(nx <= H) { // 가로줄의 끝까지 탐색
				if(map[nx][ny] == 1) ny++; // 오른쪽으로 이동해야 하는 경우
				else if(map[nx][ny] == 2) ny--; // 왼쪽으로 이동해야 하는 경우
				nx++; // 다음줄로 내려가기
			}
			// 가로줄의 끝에 내려간 후 i번의 세로선의 결과가 i번이 나오는지 확인
			if(ny != i) return false;
		}
		return true;
	}
}
