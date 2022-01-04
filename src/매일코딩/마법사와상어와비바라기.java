package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * ��ٶ�� ũ�Ⱑ NxN�� ����
 * r�� c�� A[r][c]�� r�� c���� �ִ� �ٱ��Ͽ� ����� ���Ǿ��� �ǹ�
 * ������ ���� ���� ��ĭ�� (1,1)�̰� ���� �Ʒ� ĭ��(N,N)�̴�.
 * map�� �������ʰ� �̾����ִ�.
 * 
 * ������ �̵��� M�� ���
 * 1. ��� ������ d�������� sĭ �̵�
 * 2. �� �������� �� ���� ������ �ִ� ĭ�� �ٱ��Ͽ� ����� ���� ���� 1����
 * 3. ������ ��� �������
 * 4. 2���� ���� ������ ĭ(r,c)�� ��������� ������ ����. ��������� ������ ����ϸ�, �밢�� ��������
 * �Ÿ��� 1�� ĭ�� �����ִ� �ٱ����� ����ŭ(r,c)�� �ִ� �ٱ����� ���� ���� ����
 *  - �̶��� �̵��� �ٸ��� ��踦 �Ѿ�� ĭ�� �밢�� �������� �Ÿ��� 1�� ĭ�� �ƴϴ�.
 *  - ���� ���, (N,2)���� ������ �밢�� ĭ��(N-1,1), (N-1,3)�̰� (N,N)���� ������ �밢�� ĭ��
 *  (N-1,N-1)���̴�.
 * 5. �ٱ��Ͽ� ����� ���� ���� 2 �̻��� ��� ĭ�� ������ �����, ���� ���� 2 �پ���. �� �� ������ ����� ĭ��
 *  3���� ������ ����� ĭ�� �ƴϾ�� �Ѵ�.
 */
public class ������ͻ��ͺ�ٶ�� {
	static class Air{
		int r, c;
		
		public Air(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M; // N : ���� ũ��, M : �̵�Ƚ��
	static int[][] map;
	static boolean[][] visited;
	static int[][] wind;
	
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}; // ��, �»�, ��, ���, ��, ����, �� , ����
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static ArrayList<Air> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		wind = new int[M][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			wind[i][0] = Integer.parseInt(st.nextToken()); // d
			wind[i][1] = Integer.parseInt(st.nextToken()); // s
		}
		
		list = new ArrayList<Air>();
		list.add(new Air(N-2, 0));
		list.add(new Air(N-1, 0));
		list.add(new Air(N-2, 1));
		list.add(new Air(N-1, 1));
		
		for(int i=0; i<M; i++) {
			visited = new boolean[N][N];
			int d = wind[i][0];
			int s = wind[i][1];
			move(d, s);
			add();
			remove();
		}
		
		System.out.println(count());
	}
	
	public static int count() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				cnt += map[i][j];
			}
		}
		return cnt;
	}
	
	// ���� ������� �۾�
	public static void remove() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2 && !visited[i][j]) {
					map[i][j] -= 2;
					list.add(new Air(i, j)); 
				}
			}
		}
	}
	
	public static void add() {
		for(Air air : list) {
			int cnt = 0;
			int nr = -1, nc = -1;
			for(int i=2; i<=8; i += 2) {
				nr = air.r + dr[i];
				nc = air.c + dc[i];
				if(canMove(nr, nc) && map[nr][nc] > 0) {
					cnt++;
				}
			}
			
			map[air.r][air.c] += cnt;
		}
		// �� ���߿� �ѷ���� �ϱ� ������ ������ �ٷ� �������� �ʰ� �� �ѷ��� �Ŀ� �������ش�.
		list.clear();
	}

	public static boolean canMove(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}
	
	
	public static void move(int d, int s) {
		for(Air air : list) {
			int nr = (air.r + N + dr[d]*s % N) % N;
			int nc = (air.c + N + dc[d]*s % N) % N;
			
			visited[nr][nc] = true;
			map[nr][nc] += 1;
			air.r = nr;
			air.c = nc;
		}
	}
}
