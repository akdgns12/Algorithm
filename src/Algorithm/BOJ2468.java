package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���� ���� DFS ���
public class BOJ2468 {
	static int[][] map;
	static boolean[][] visited; //�湮�� ���� Ȯ���� 2���� boolean �迭 ����
	static int n; // �迭 ������ ���� ���� ����
	static int[] dx = {0,0,-1,1}; // �����¿� �� Ȯ��
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j<n; j++) {
				map[i][j]=Integer.parseInt(str[j]);
				if(max<map[i][j]) { //�ִ� ���� ����
					max = map[i][j];
				}
			}
		}
		int maxCount = 1;
		int cnt = 0; 
		
		for(int c=0; c<=max; c++) { // �ִ� ���̸�ŭ for������ ���� ���� �ִ� ���� ã��
			visited = new boolean[n][n];
			cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]> c && visited[i][j]==false) { //������ ���̰ų� �ѹ��� �湮���� �ʾ�����
						
					}
				}
			}
		}
	}
}

