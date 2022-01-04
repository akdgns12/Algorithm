package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*DFS�� ���� ������������ depth == 4 �� �� �����Ѵٸ�, ��Ʈ�ι̳��� ������ ���� ���� ����
 (�ش� ������ ��Ī, ȸ���� �����ϴٴ� ������ �߿�
 '��' ������ ���ؼ��� ������ �޼ҵ� ����(��ȿ ���� ����)
  ���� �� �޼ҵ� ���ึ�� max �� �� ����
*/
import java.util.StringTokenizer;


/*
 * ��Ī ȸ�� ���� -> DFS ��� ����.
 * �� ����� ��� DFS ��� �Ұ���.
 * 
 * 1. map�� ��� ������ ���� 4 ũ���� ��Ʈ�ι̳븦 ����� DFS�� ������.
 * 2. ��Ʈ�ι̳��� �ִ��� ����ϸ� �����Ѵ�.
 */

public class ��Ʈ�ι̳� {
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
		// map ���� �Է¹ޱ�
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				DFS(i, j, 0, 0);
				Exception(i,j); // ������ �� ��� ���� �����ϴ� �Լ�
			}
		}
		System.out.println(max);
	}
	
	// �����¿� ������ ������ (�� ��� ����)
	// '��' ����� DFS�� ���� �Ұ�
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
	
	// '��' ��� ����
	// ������ �����δ� + ��翡�� �ϳ��� ����
	public static void Exception(int x, int y) {
		int wing = 4; // ��������� �����¿� ����
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// ������ 2���̻� ���ٸ� �� ����� �ƴϴ�. �׷��Ƿ� �Լ��� �����Ѵ�.
			if(wing <= 2)
				return;
			// ������ �� �ٱ��� �ִٸ� ������ �ƴϴ�
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[nx][ny]);
			sum = sum + map[nx][ny];
		}
		
		//������ 4���� �� ���� ���� ������ ���־� ��,��,��,��  ����� ���´�.
		if(wing == 4) {
			sum = sum - min;
		} 
		max = Math.max(max, sum);
	}
}
