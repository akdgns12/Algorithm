package 매일코딩;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * 매 초마다 움직이며 냄새를 뿌리는 상어들이 여러마리 존재
 * 각 상어들은 자신들이 바라보는 방향과 기준에 따라서 다음으로 움직일 방향을 선정
 * 상어들이 같은 격자에 동시에 들어가게 되면 숫자가 작은 상어만 남고 나머지는 전부 내보낸다
 * 가장 강한 1번 상어가 남는 시간은 몇 초 뒤인지 구하라
 * 
 * solution
 * 1번 상어가 남거나 1000초가 지날때까지 다음순서를 반복해야 한다
 *  1. moveShark() : 상어 이동
 *    - 다음 방향 계산
 *    - 이동
 *    - 경쟁을 통해 작은 번호의 상어 생존
 *  2. decreaseSmellTime() : 모든 냄새들 1씩 감소
 *  3. createSmell() : 상어가 이동한 자리에 새로운 냄새 생성
 *  
 *  <주의할 점>
 *  1. 상어가 이동한 후에는 상어의 방향을 이동한 방향으로 바꿔줘야함
 *  2. 위 순서에서 2번과 3번을 바꾸게 되면 상어가 새로운 냄새를 생성하자마자 1씩 깎이기 때문에
 *   순서를 지켜야 한다
 *  3. 상어 리스트를 for문으로 돌면서 경쟁에서 패밸한 상어를 바로 제거하니 런타임 에러 발생..
 *   for문 도중에는 요소를 삭제하지 말고 기록해두었다가 나중에 삭제.
 */
public class 어른상어 {
	static int N, M, k;
	static int[][] resttime; // 각 칸마다 냄새가 없어지기까지 남은 시간
	static int[][] smell; // 각 칸에의 냄새를 뿌린 상어의 번호(냄새가 없으면 0)
	static int[][][] priority; // 상어마다 현재 방향에서의 우선순위 ex) priority[m][1][0] : m번 상어의 현재 방향이 위쪽방향(1)일 때, 0번째 우선순위에 해당하는 방향
	static Shark[] shark; // 1번부터 M번까지 각 상어의 위치(r,c)와 방향(d) 정보
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);

		resttime = new int[N + 1][N + 1];
		smell = new int[N + 1][N + 1];
		priority = new int[M + 1][5][4];
		shark = new Shark[M + 1];
		
		// 상어 정보 입력받고 Shark 클래스에 r,c,방향 0으로 일단 넣기
		// 냄새시간 K
		// smell 해당 칸에 냄새를 뿌린 상어 번호(냄새 없으면 0)
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(input[j - 1]);

				if (n > 0) {
					shark[n] = new Shark(i, j, 0);
					resttime[i][j] = k;
					smell[i][j] = n;
				}
			}
		}
		input = br.readLine().split(" ");
		for (int i = 1; i <= M; i++)
			shark[i].d = Integer.parseInt(input[i - 1]);

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				input = br.readLine().split(" ");
				for (int k = 0; k < 4; k++) {
					priority[i][j][k] = Integer.parseInt(input[k]);
				}
			}
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int time = 0;

		while (true) {

			int count = 0;
			for (int m = 1; m <= M; m++) {
				if (shark[m] != null)
					count++;
			}

			if (count == 1 && shark[1] != null) { // 1번 상어 혼자 남은 경우
				return time;
			}
			
			// 1000초 지난경우
			if (time >= 1000)
				return -1;

			// 임시배열
			int[][] tmp = new int[N + 1][N + 1];

			for (int m = 1; m <= M; m++) {

				if (shark[m] != null) { // 상어가 경계 안에 있다면
					moveShark(tmp, m);
				}
			}

			// 냄새 유효기간 하나씩 줄이기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (resttime[i][j] > 0)
						resttime[i][j]--; 

					if (resttime[i][j] == 0)
						smell[i][j] = 0;
				}
			}

			// 이동후의 상어 위치의 냄새 정보와 유효기간 초기화하기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (tmp[i][j] > 0) {
						resttime[i][j] = k;
						smell[i][j] = tmp[i][j];
					}
				}
			}
			time++;
		}

	}

	public static void moveShark(int[][] tmp, int m) {

		int nr = 0;
		int nc = 0;
		int d = 0;

		boolean flag = false;

		// 1-1. 높은 우선순위부터 차례대로 탐색
		for (int i = 0; i < 4; i++) {

			d = priority[m][shark[m].d][i];
			nr = shark[m].r + dr[d];
			nc = shark[m].c + dc[d];

			// 경계를 벗어나지 않으면서, 냄새가 없는 곳을 찾으면 break로 빠져나옴
			if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == 0) {
				flag = true;
				break;
			}
		}

		// 1-2. 냄새가 없는 곳이 없는 경우
		if (!flag) {
			for (int i = 0; i < 4; i++) {

				d = priority[m][shark[m].d][i];
				nr = shark[m].r + dr[d];
				nc = shark[m].c + dc[d];

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == m)
					break;
			}
		}

		if (tmp[nr][nc] == 0) {

			tmp[nr][nc] = m;
			shark[m].r = nr;
			shark[m].c = nc;
			shark[m].d = d;
		}

		else {
			shark[m] = null;
		}

	}

	static class Shark {

		int r, c, d;

		Shark(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
