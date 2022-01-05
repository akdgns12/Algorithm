package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class �ι�°����_���� {
	static int n,l;
	static int[][] map;
	static boolean[] visited;
	static int cnt = 0;
	
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
		} // end of Input
		
		// �� �� �� ���� ���
		for(int i=0; i<n; i++) {
			if(checkPath(i, 0, true))
				cnt++;
			if(checkPath(0, i, false))
				cnt++;
		}
		
		System.out.println(cnt);
	}

	public static boolean checkPath(int x, int y, boolean flag) {
		
		int[] height = new int[n]; // ���� üũ�ϱ� ���� �迭
		visited = new boolean[n]; // ���� �̹� ��ġ�Ǿ��ִ��� üũ
		
		for(int i=0; i<n; i++) {
			if(flag)
				height[i] = map[x][i]; // �� �˻�
			else
				height[i] = map[i][y]; // �� �˻�
		}
		
		for(int i=0; i<n-1; i++) {
			// ���̰� ���� ��
			if(height[i] == height[i+1]) {
				continue;
			}
			
			// �������� ���
			else if(height[i] - height[i+1] == 1) {
				for(int j=i+1; j<=i+l; j++) {
					// ���� �Ѿ�ų� ���� ���� ĭ�� ���̰� �ٸ��ų� �̹� ���ΰ� �ִ� ���
					if(j >= n || height[i+1] != height[j] || visited[j])
						return false;
					visited[j] = true;
				}
			}
			
			// �ö󰡴� ���
			else if(height[i] - height[i+1] == -1) {
				for(int j=i; j>i-l; j--) {
					// ���� �Ѿ�ų� ���� ĭ�� ���̰� �ٸ��ų� �̹� ���ΰ� �ִ� ���
					if(j < 0 || height[i] != height[j] || visited[j])
						return false;
					visited[j] = true;
				}
			}
			// ���̰� 2ĭ �̻� ���� �� ��(��x)
			else {
				return false;
			}
		}
		return true;
	}
}
