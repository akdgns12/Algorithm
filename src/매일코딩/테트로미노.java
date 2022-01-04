package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*DFS를 통해 기저조건으로 depth == 4 일 때 정지한다면, 테트로미노의 도형과 같은 것을 이해
 (해당 문제에 대칭, 회전이 가능하다는 문장이 중요
 'ㅗ' 도형에 대해서는 별도로 메소드 관리(유효 범위 주의)
  위의 두 메소드 수행마다 max 값 비교 갱신
*/
import java.util.StringTokenizer;


/*
 * 대칭 회전 가능 -> DFS 사용 가능.
 * ㅗ 모양의 경우 DFS 사용 불가능.
 * 
 * 1. map의 모든 구간에 대해 4 크기의 테트로미노를 만드는 DFS를 돌린다.
 * 2. 테트로미노의 최댓값을 계산하면 갱신한다.
 */

public class 테트로미노 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int max;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		max = 0;
		// map 정보 입력받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				DFS(i, j, 0, 0);
				Exception(i,j); // 예외인 ㅗ 모양 따로 구현하는 함수
			}
		}
		System.out.println(max);
	}
	
	// 상하좌우 가능한 모형들 (ㅗ 모양 제외)
	// 'ㅗ' 모양은 DFS로 구현 불가
	public static void DFS(int row, int col, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M ) {
				continue;
			}
			if(visited[nextRow][nextCol]) {
				continue;
			}
			visited[nextRow][nextCol] = true;
			DFS(nextRow, nextCol, depth + 1, sum + map[nextRow][nextCol]);
			visited[nextRow][nextCol] = false;
		
		}
	}
	
	// 'ㅗ' 모양 구현
	// 간단한 원리로는 + 모양에서 하나를 뺀다
	public static void Exception(int x, int y) {
		int wing = 4; // 가운데에서의 상하좌우 날개
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 날개가 2개이상 없다면 ㅗ 모양이 아니다. 그러므로 함수를 종료한다.
			if(wing <= 2)
				return;
			// 날개가 맵 바깥에 있다면 날개가 아니다
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[nx][ny]);
			sum = sum + map[nx][ny];
		}
		
		//날개가 4개일 때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ  모양이 나온다.
		if(wing == 4) {
			sum = sum - min;
		} 
		max = Math.max(max, sum);
	}
}
