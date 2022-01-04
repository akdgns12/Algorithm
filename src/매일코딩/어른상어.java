package �����ڵ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * �� �ʸ��� �����̸� ������ �Ѹ��� ������ �������� ����
 * �� ������ �ڽŵ��� �ٶ󺸴� ����� ���ؿ� ���� �������� ������ ������ ����
 * ������ ���� ���ڿ� ���ÿ� ���� �Ǹ� ���ڰ� ���� �� ���� �������� ���� ��������
 * ���� ���� 1�� �� ���� �ð��� �� �� ������ ���϶�
 * 
 * solution
 * 1�� �� ���ų� 1000�ʰ� ���������� ���������� �ݺ��ؾ� �Ѵ�
 *  1. moveShark() : ��� �̵�
 *    - ���� ���� ���
 *    - �̵�
 *    - ������ ���� ���� ��ȣ�� ��� ����
 *  2. decreaseSmellTime() : ��� ������ 1�� ����
 *  3. createSmell() : �� �̵��� �ڸ��� ���ο� ���� ����
 *  
 *  <������ ��>
 *  1. �� �̵��� �Ŀ��� ����� ������ �̵��� �������� �ٲ������
 *  2. �� �������� 2���� 3���� �ٲٰ� �Ǹ� �� ���ο� ������ �������ڸ��� 1�� ���̱� ������
 *   ������ ���Ѿ� �Ѵ�
 *  3. ��� ����Ʈ�� for������ ���鼭 ���￡�� �й��� �� �ٷ� �����ϴ� ��Ÿ�� ���� �߻�..
 *   for�� ���߿��� ��Ҹ� �������� ���� ����صξ��ٰ� ���߿� ����.
 */
public class ���� {
	static int N, M, k;
	static int[][] resttime; // �� ĭ���� ������ ����������� ���� �ð�
	static int[][] smell; // �� ĭ���� ������ �Ѹ� ����� ��ȣ(������ ������ 0)
	static int[][][] priority; // ���� ���� ���⿡���� �켱���� ex) priority[m][1][0] : m�� ����� ���� ������ ���ʹ���(1)�� ��, 0��° �켱������ �ش��ϴ� ����
	static Shark[] shark; // 1������ M������ �� ����� ��ġ(r,c)�� ����(d) ����
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
		
		// ��� ���� �Է¹ް� Shark Ŭ������ r,c,���� 0���� �ϴ� �ֱ�
		// �����ð� K
		// smell �ش� ĭ�� ������ �Ѹ� ��� ��ȣ(���� ������ 0)
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

			if (count == 1 && shark[1] != null) { // 1�� ��� ȥ�� ���� ���
				return time;
			}
			
			// 1000�� �������
			if (time >= 1000)
				return -1;

			// �ӽù迭
			int[][] tmp = new int[N + 1][N + 1];

			for (int m = 1; m <= M; m++) {

				if (shark[m] != null) { // �� ��� �ȿ� �ִٸ�
					moveShark(tmp, m);
				}
			}

			// ���� ��ȿ�Ⱓ �ϳ��� ���̱�
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (resttime[i][j] > 0)
						resttime[i][j]--; 

					if (resttime[i][j] == 0)
						smell[i][j] = 0;
				}
			}

			// �̵����� ��� ��ġ�� ���� ������ ��ȿ�Ⱓ �ʱ�ȭ�ϱ�
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

		// 1-1. ���� �켱�������� ���ʴ�� Ž��
		for (int i = 0; i < 4; i++) {

			d = priority[m][shark[m].d][i];
			nr = shark[m].r + dr[d];
			nc = shark[m].c + dc[d];

			// ��踦 ����� �����鼭, ������ ���� ���� ã���� break�� ��������
			if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && smell[nr][nc] == 0) {
				flag = true;
				break;
			}
		}

		// 1-2. ������ ���� ���� ���� ���
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
