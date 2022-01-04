package 알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알파벳
/*
 * 0,0 부터 시작해서, 상하좌우로 이동을 하는 좌표에서 이전에 지나온 알파벳은 지나갈 수 없다.
 * map 배열에 [r][c] 크기의 알파벳을 입력하여 2차원 배열을 생성한다.
 * 0,0 부터 DFS로 map 전체를 탐색하면서 visited배열을 1차원 배열로 선언하여 중복된 알파벳을 방문하였는지 판단한다.
 * 중복된 알파벳을 발견하였다면 이동거리를 갱신하고 리턴한다.
 * 다른 루트로 DFS 탐색하기 위해 visited 배열을 방문하지 않은 상태로 초기화 한다.
 */

public class BOJ_1987 {

	static int R, C;
	static int[][] map;
	static boolean[] visit = new boolean[26];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans = 0;

	public static void dfs(int x, int y, int count) {
		if (visit[map[x][y]]) { // 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면,
			ans = Math.max(ans, count); // 정답을 갱신해준다.
			return; // 조건에 만족하므로 리턴.
		} else {
			visit[map[x][y]] = true;
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
					dfs(cx, cy, count + 1);
				}

			}

			visit[map[x][y]] = false;

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) { 
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);
		// (0,0)부터 시작하며, 현재 이동한 위치는 0회

		System.out.println(ans);
	}
}
