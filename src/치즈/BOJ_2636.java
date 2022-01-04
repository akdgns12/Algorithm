package ġ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * (����)
 * 1�� �ֺ��� 0�̸� ��´�? -> ġ��� ���ۿ� �ش��ϴ� 0���� �ֱ� ������ ���� ����
 * if bfs -> queue�� 1�� �ִ´�? -> x
 * if dfs -> depth = time? -> 1 hour ���� �� ���� ���� �ٱ�  1 remove
 * <�˰���>
 * ġ�� �� ���ۿ� �ش��ϴ� 0�� �ٱ� 0�� ��� �����ϳİ� ����.
 */

/*
 * BFS�� �ٱ� ����� ���ΰ����� �������ִ°� �¾Ҵ�.
 * <�˰���>
 * 1. �ܺΰ��⸦ ��� Ž���ؼ� -1�� �ٲ۴�
 * - ������ ù��° ��� ��, ������ ��� ���� ��� �ִٰ� �Ͽ����Ƿ�(0,0)�� ��� bfs�� �����鼭 ����� ��� �����(0 �Ǵ� -1)�� ��� -1�� �ٲ��ָ� �ȴ�.
 * 2. map�� 2�� for������ Ž���ϸ�, �����ڸ��� ġ���� ��쿡�� bfs Ž���� �Ͽ� ��� �����ڸ� ġ����� ã�Ƽ� removeQ�� �־��ش�.
 * - �����ڸ��� Ž���ϴ� ������ ������ bfs�� ���鼭 ����� ��� ġ����� Ž���ϱ� ������, �ߺ� Ž���ϴ� ���� ���̱� ����.
 * - �����ڸ� ġ���� ��ǥ�� ��� removeQ�� ���� ��, �������� �ѹ��� �����ϸ� �ȴ�.
 * 3. ���� removeQ�� ũ�Ⱑ
 * - 0�̶�� ���̻� ���� ġ� ���ٴ� �ǹ��̹Ƿ� �ݺ����� ����.
 * - �ƴ϶�� removeQ�� ũ�⸦ ���� �ܰ��� ���� ġ�� ������ �ǹ��ϴ� pre���� ���� ����.
 * 4. �� �ܰ谡 �������� �� ������ phase�� +1 �Ѵ�.
 * 5. bfs�� ���鼭 ä���� removeQ�� 1���� ������ �����ڸ� ġ� �쿩�ְ�, �� �ڸ��� �ܺΰ���(-1)�� ä���ش�.
 */
/*
 * #2<�˰���>
 * 1. Input �������� ġ���� ������ �����Ѵ�.
 * 2. cheeze�� ������ 0�� �ɶ����� bfs�� �ݺ�, cnt�� �����ϰ� time�� ����.
 * 2-1 bfs(0,0)���� ����
 * 2-2 ���⸦ ������ Queue�� ����, ġ� ������ 0���� �����ϰ� ġ���� ������ ���δ�.
 * 2-3 ġ��� ���� ������� �湮ó�� �ʼ�
 */
public class BOJ_2636 {
	
	static int n,m,cheeze,cnt,time;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					cheeze++;
				}
			}
		}
		
		while(cheeze!=0) {
			time++;
			cnt = cheeze;
			bfs();
		}
		System.out.println(time);
		System.out.println(cnt);
	}
	
	// �ڵ� ���� ��������
	public static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});  // ť�� 0,0 ������ �־��ش�
		visited = new boolean[n][m];
		visited[0][0]=true;	
		
		while(!que.isEmpty()) {
			int[] cur = que.poll(); // ť�� �������� ť���� �����͸� �����´�.
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny  >= m || visited[nx][ny]) continue;
				if(map[nx][ny] == 1 ) { //���� ġ� �ִٸ� ġ� �ٿ��ְ� �װ��� 0���� �ٲ۴�.
					cheeze--;
					map[nx][ny] = 0;
				} else if( map[nx][ny] == 0) {
					que.offer(new int[] {nx,ny});
				}
				visited[nx][ny] = true; //�湮ó��
			}
		}
	}
}
/*
 *  �Է�
 *  ġ�� : 1
 *  ���� ��� : 0
 *  
 *  ���� �����ڸ�(<�׸� 1>���� �׸� ĭ�� Xģ �κ�)���� ġ� ���� ���� ������ ġ��� �ϳ� �̻��� ������ ���� �� �ִ�.
 *  -> ���� �ܺθ� ������ ���
 *  
 *  ��� 
 *  ù�� : ġ� ��µ� �ҿ�Ǵ� �ð�. -> �ð�(���� Ƚ��)
 *  ������ : ��� ��� �ѽð� �� �����ִ� ġ�� ���� ��. -> ��� �� ����
 *  
 *  map -> -1 : ġ��  / 0 : ����  / cnt : �ܺ� ���� 
 *  
 *  ġ��� �´��� ���⸦ �������� Ǯ��
 */
/*
class pair {
	int row;
	int col;

	public pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {

	static int N, M, last, cnt; 	// ��, ��, ������ ġ�� ����, �ð�
	static boolean check = true; 	// while ���� ���� boolean
	static int[][] map; 			// �Է¹��� 2���� �迭
	static boolean[][] visit; 		// �湮 ���� 2���� �迭
	static Queue<pair> updateAirQueue = new LinkedList<pair>(); // �ֺ��� �ܺ� ����� ��ȯ �� ��ǥ
	static Queue<pair> meltQueue = new LinkedList<pair>(); 		// �ֺ� ġ� ���� ���� ��ǥ

	// �����¿�
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	// ���� �˻�
	public static boolean isValid(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= M)
			return false;
		return true;
	}

	// ���� ���� -> �ܺ� ���� ���� �� ��ȯ
	public static void makeMapBFS() {

		// ù ȣ�⸸ ����
		if (updateAirQueue.isEmpty())
			updateAirQueue.offer(new pair(0, 0));

		while (!updateAirQueue.isEmpty()) {
			int row = updateAirQueue.peek().row; // peek() ť�� ù��° �� ����
			int col = updateAirQueue.poll().col;
			map[row][col] = cnt; 	// �ܺΰ��� ����
			visit[row][col] = true;

			for (int k = 0; k < 4; k++) {
				int nextRow = row + dy[k];
				int nextCol = col + dx[k];

				// ���� �˻�
				if (!isValid(nextRow, nextCol))
					continue;

				// �湮 �˻�
				if (visit[nextRow][nextCol])
					continue;

				// ���� ���� �ܺΰ���� ġȯ
				if (map[nextRow][nextCol] == 0) {
					visit[nextRow][nextCol] = true; // �湮 ó��
					updateAirQueue.offer(new pair(nextRow, nextCol));
					continue;
				}

				// �ֺ��� ġ� �ִ� ���
				if (map[nextRow][nextCol] == -1) {
					visit[nextRow][nextCol] = true;
					meltQueue.offer(new pair(row, col)); // �ֺ� ġ� ���� ���� ��ǥ�� ť�� ����.
				}
			}
		}
	}

	// ġ�� ���̱� && ġ�� -> ����� �ٲ� ��ǥ ó��
	public static void targetCheese() {

		while (!meltQueue.isEmpty()) {
			int row = meltQueue.peek().row;
			int col = meltQueue.poll().col;

			for (int k = 0; k < 4; k++) {
				int nextRow = row + dy[k];
				int nextCol = col + dx[k];

				// ���� �˻� && �ֺ��� ġ���� ���
				if (isValid(nextRow, nextCol) && map[nextRow][nextCol] == -1) {
					map[nextRow][nextCol] = cnt + 1; 					// �ش� �ڸ��� ����� ġȯ (��ȯ�� ġ���� ����)
					updateAirQueue.offer(new pair(nextRow, nextCol)); 	// ť�� �Է�(�̿��Ѱ����� Ž���ϱ� ����)
				}
			}
		}

		// ���̻� ġ� ���� ���
		if (updateAirQueue.isEmpty()) {
			check = false;
			return;
		}

		++cnt; // Ƚ�� �߰�
		last = updateAirQueue.size(); // ġ�� ����
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];		// �Է� ���� 2���� �迭
		visit = new boolean[N][M];	// �湮 ���� 2���� �迭
		cnt = 2; 	// �ܺ� ���� �� �ð� ����
		last = 0; 	// ������ ġ�� ���� ����

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1; // ġ���� ���
				}
			}
		} // end of input


		while (check) {
			makeMapBFS(); 	// ���� ����
			targetCheese(); // ġ�� ���̱�
		}

		sb.append(cnt - 2 + "\n" + last + "\n");
		br.close();
		System.out.println(sb);
	}
}
*/
