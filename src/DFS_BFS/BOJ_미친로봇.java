package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * <����>
 * DFS + ��Ʈ��ŷ
 * �ᱹ�� �������� ���ϴ� ���� ���� ���� �湮���� �ʰ� N������ �̵��� ���� Ȯ���� ���ϴ� ���̴�.
 * �� DFS�� ����Ͽ� N����ŭ �̵��ϵ� visited�Լ��� ����Ͽ� ���� ������ �湮���� �ʵ��� ó���ϸ� �ȴ�.
 * 
 * �̶� �̵��� Ȯ���� ���ϴ� ����� ���� ������ �湮���� �ʰ� �̵��ϸ�, �̵��� ������ �̵��� ������ Ȯ���� ���ؼ�
 * �� ���� ��� �����ָ� �ȴ�.
 * 
 * ������� N�� 2�̰� �� �� �� ������ �̵��� Ȯ���� ���� 25��� �� �� �� -> ������ �̵��� Ȯ���� ������ ����
 * �� -> = 25(��) * 25(��)�� �ȴ�.
 * 
 * ��, DFS�� �� �������� ��� �湮�ϵ�, ������ �湮�� ���� �湮���� ������ �ش� �������� �̵��� �� �� ������ Ȯ����
 * �����ְ� N�� �̵��� ������ �� ���� ������� �����ָ� �ȴ�.
 * 
 * �� �� N�� �ִ밪�� 15�̴�. �׷��Ƿ� ���������� 15, 15�� ��� �ּ� ��ǥ���� 0,0 / �ִ� ��ǥ���� 30, 30���� �������־���.
 * = N�� �ִ밪�� 15�̹Ƿ�...��ǥ��鿡�� �κ��� N��ŭ �̵��� ��, �κ��� �� �� �ִ� �ִ� ��ǥ�� 30,30 �׷��� 
 *  �ּ� ��ǥ�� 0,0 / �ִ� ��ǥ�� 30,30 ���� �����ϰ� �������� 15,15�� �� �� 
 */
public class BOJ_��ģ�κ� {
	//�κ��� ���� ���� �ߺ��ؼ� �̵����� ������ = �ܼ��� �̵�
	// ���� ���� �ߺ��ؼ� �̵��ϸ� �ܼ����� ���� �̵�
	// �κ��� �̵���ΰ� �ܼ��� Ȯ���� ���϶� = ���� ���� �ߺ��ؼ� �̵��� Ȯ���� ���϶�
	static int[] dx = {0,0,1,-1}; //�� �� �� �� ����
	static int[] dy = {1,-1,0,0}; 
	static double[] percent;
	static boolean[][] visited;
	static double result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		percent = new double[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
		}
		
		visited = new boolean[30][30]; //�������� 15, 15�� �������
		result = 0;
		dfs(15, 15, 0, n, 1);
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int idx, int n, double total) {
		if(idx == n) {
			result += total;
			return;
		}
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < 30 && ny < 30) {
				if(visited[nx][ny] == false ) {
					visited[nx][ny] = true;
					dfs(nx, ny, idx + 1, n, total * percent[i]);
					visited[nx][ny] = false;
				}
			}
		}
	}
	}
