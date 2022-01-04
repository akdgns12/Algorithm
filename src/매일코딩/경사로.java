package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. �� ��� ������ ������ �� �ִ� ������ üũ�ؼ� ������ ���ش�.
// 2. �ش� ��� 1���� 1���� �迭�� ����� üũ�ϱ� ���� �����
// 3. ������ �����ʴ� ��� false ����

/*
 * ���δ� ũ�� 2����
 * - �ö󰡴� ����, �������� ����
 * ���ε��� �������־�� �Ѵ�.
 */

public class ���� {
	static int n, l; // n : ����ũ��, l : ���α���
	static int[][] map; // ����
	static boolean[] visited; // ���� ������ Ȯ��
	static int pathCnt = 0; // ������ �� �ִ� ���� ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		// �� ���� �Է�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //end of Input
		
	
		// ������ ������ �ƴ��� üũ
		for(int i=0; i<n; i++) {
			if(checkPath(i, 0, 0))// ��
				pathCnt++;
			if(checkPath(0, i, 1)) // ��
				pathCnt++;
		}
		
		System.out.println(pathCnt);
	}
	
	
	public static boolean checkPath(int x, int y, int d) {
		int[] height = new int[n]; // ���� üũ�ϱ� ���� �迭
		visited = new boolean[n]; // ���� ���Ҵ��� Ȯ��
		
		if(d == 0) { // ��(����)�� ���
			for(int i=0; i<n; i++) {
				height[i] = map[i][x];
			}
		}
		else { // ��(����)�� ���
			for(int i=0; i<n; i++) {
				height[i] = map[y][i];
			}
		}
		
		for(int i=0; i<n-1; i++) {
			if(height[i] == height[i+1]	) {
				continue;
			} // ���� ������ ���� ���� �ʿ䰡 ����.
			
			if(Math.abs(height[i] - height[i+1]) != 1) {
				return false; // ���δ� �ִ���̰� 1�̴� �ش����� �ʴ´ٸ� false
			}
			
			if(height[i] > height[i+1]) { // �������� ������ ���
				for(int j=i+1; j<=i+l; j++) {
					if(j > n-1) { // ���ΰ� ������ ����� false
						return false;
					}
					if(visited[j] || height[j] != height[i] - 1) {
						return false; // ���θ� ��ġ�� ���� �� ����.
					}
					visited[j] = true;
				}
			}
			else if(height[i] < height[i+1] ) { // �ö󰡴� ������ ���
				for(int j=i; j>i-l; j--) {
					if(j<0) {
						return false;
					}
					if(visited[j] || height[j] != height[i+1] - 1) {
						return false;
					}
					visited[j] = true;
				}
			}
		}
		return true;
	}
}
