package ����;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
/*
 * ���� �־��� N, M �� �� ū���� ã�´�.

�������� 3 x 5�� �־��� ���, �ִ�� ������ ���簢���� 3 x 3�̹Ƿ�, �� ���� 3������ �ݺ��ϸ� �Ǳ� �����̴�.

area = 4���� �������� ���簢���϶�, ���̸� ���ϴ� ������

maxArea = �� area�� ���ؼ� �� ū���� �����ϰ�, ���������� ����� ������.

i+k �� j+k�� ���� M, N ���� �۾ƾ� �迭�� ���� �̳���� �� �� �ִ�.

4���� �������� ���� ������ 3���� �������� Ȯ�����ָ� �ȴ�.

(0,0) , (0,1)

(1,0) , (1,1)

���� ���� 4���� ���� ������, A = B && A = C && A = D �̸� �ڵ������� B = C = D �� ����Ǳ� �����̴�.

���� 4���� ���� ã�� ���� �ε����� �����ؾ��ϴµ�, ��� ��, �࿭�� ���� k�� ���ϸ� ������ 4���� �������� �ȴ�.
 */
public class �������簢�� {
	static int n,m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int min = Math.min(n, m);
		int area = 0;
		int maxArea = 0;
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<min; k++) {
					if(i+k < n && j+k < m) { //�迭 ���� �̳�
						//4���� �������� ���簢���� �Ǵ� ����
						if(map[i][j] == map[i][j+k] && map[i][j] == map[i+k][j] && map[i][j] == map[i+k][j+k]) {
							area = (k+1) * (k+1);
							maxArea = Math.max(maxArea, area);
						}
					}
				}
			}
		}
		System.out.println(maxArea);
		
	}
}
