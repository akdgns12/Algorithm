package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �迭������2 {
	// BOJ  16927 �迭������ 2 / �� 5
	/*
	 * �迭������ 1�� ���� ���������� �� ȿ������ ����� �䱸�ϴ� ����
	 * �ݺ� Ƚ�� R�� Ŀ���� ���� ���ʿ��� ȸ���� �����Ƿ�
	 * (ex: 4*4�� map���� R�� 13���� �־����ٸ� �ٱ��׷� ũ���� 12��ŭ ���� �� �� �̵��ϴ� ��, �� 13�� ȸ���� �� �� �̵��� ����)
	 * -> �� �׷� ���� ũ�⿡ ���� �ݺ� Ƚ����  
	 * �ð��� �� �����Ͽ� ȿ������ �ڵ带 �ۼ��ؾ� �Ѵ�.
	 * 
	 * �迭������1�� �� �ݺ�Ƚ���� ���� �ٱ� �ݺ����� ���ȴٸ�
	 * �� ������ �� �׷쿡 �ش��ϴ� �ݺ��� ���ο� ȸ���ݺ����� �����ش�.
	 * ȸ�� �ݺ� Ƚ��  �׷� ũ�⸸ŭ 
	 */
	static int N,M,R;
	static int[][] map;
	static int[] dx = {0,1,0,-1}; // ��, �Ʒ�, ����, ��
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int group = Math.min(N, M)/2; // ���ư��� �׷��� ��
		
		int n = N, m = M; // ȸ���� �� �����ؾ��ϱ� ������ ���� ���� ����
		
		for(int i=0; i<group; i++) {
			rotate(i, 2*n + 2*m - 4); // �׷� ��, �׷� �׵θ� ũ��
			// �� �׷� ������ �� ������ ����,���� 2�� �پ��
			n -= 2; 
			m -= 2;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void rotate(int groupIdx, int len) {
		int nR = R % len; // ȸ��Ƚ�� % �׷��� �ٱ�ũ��
		for(int i=0; i<nR; i++) {
			int temp = map[groupIdx][groupIdx]; // �� �׷��� ù��° �� �ӽ� ����
			int x = groupIdx;
			int y = groupIdx;
			int dir = 0;
			
			while(dir < 4) {
				// map[nx][ny] -> map[x][y]�� �ű�� �۾�
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx == groupIdx && ny == groupIdx) break;
				if(nx < N - groupIdx && ny < M - groupIdx &&
						nx >= groupIdx && ny >= groupIdx) { // ���� �����
					map[x][y] = map[nx][ny]; // �ٲ���
					x = nx;
					y = ny;
				} else {
					// ������ �ű� ĭ�� �迭 ������ �Ѿ������ �ش� ������ �� �ű� ���̹Ƿ� ������ȯ
					dir++;
				}
			}
			
			map[groupIdx + 1][groupIdx] = temp; // �ӽ������س��� �� ���ڸ��� �־���
		}
	}
}
