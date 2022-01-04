package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// ���� ����
// i�� ���μ��� ����� i���� �������� ��ٸ� ������ �����ؾ��� ��, �߰��ؾ� �ϴ� ���μ� ������ �ּڰ�
// ���� 3���� ū ���̸� -1 ���, �� �Ұ����� ��쿡�� -1 ���

/*
 * ����
 * ���μ��� ������ � ������ �����ұ� ����غ���..
 * �׵��� Ǯ��Դ� y�� x���� map ĭ���� �����ϸ� �ȴ�.
 * ��α׿� �����Ǿ��ִ� �׸��� ���� ��Ȯ�� ��������.
 * 
 * �׸����� �ֻ�� ������ (1,1)�̶� �ΰ�, ���� ����Ǵ� �� ���� ��츦 ������
 * 0 : �ش� ĭ���� ���μ��� ����.
 * 1 : �ش� ĭ�� �������� �������� ����Ǵ� ���μ��� �ִ�.
 * 2 : �ش� ĭ�� �������� �������� ����Ǵ� ���μ��� �ִ�.
 * 
 * 1�� ������ 1���� 2�� ���μ��� �����ϴ� ���μ��� �ִٸ�, map[1][1] = 1; , map[1][2] = 2; �̷������� ����
 * 
 * �׷� ���� i������ ����ؼ� i���� �����ϴ��� Ȯ���ϴ� üũ �뵵�� �Լ��� �ʿ�
 * 
 * ���������� DFSŽ���� �Ķ���ͷ� �߰��� ���μ��� ������ ��������� �Ѵ�. �̰� DFSŽ���� ���������� �Ǳ� ����
 * �ִ� 3���� ���μ��� �߰��� �� �����Ƿ�, �̸� �ݺ������� ���ΰ� �� ���ο��� DFS�� ȣ���ϴ� ����� �̿�
 */
public class ��ٸ����� {
	static int n, m; // n: ���μ��� ����, m: ���μ��� ����
	static int h; // H:���μ����� ���μ��� ���� �� �ִ� ��ġ
	static int ans;
	static int[][] map;
	static boolean isFinish = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // ����� ���μ��� ����
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			// x ���̿��� y���� y+1�� ���μ��� �����Ѵ�.
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			 
			map[x][y] = 1; // 1 : �������� �̵�
			map[x][y+1] = 2; // 2 : �������� �̵�
		}
		
		// �߰��� ���μ��� ������ �̸� ���س��� Ž�� ���� �������� �� �� �ִ�.
		// �Ʒ� �ݺ������� i�� �߰��� ���μ��� ��
		for(int i=0; i<=3; i++) {
			ans = i;
			dfs(1, 1, 0);
			if(isFinish) break;
		}
		
		System.out.println((isFinish ? ans : -1));
	}
	
	// count : �߰��� ���μ��� ����(3���� �Ѿ�� ���̻� Ž���� ���ǹ�) 	
	public static void dfs(int x, int y, int count) {
		if(isFinish) return;
		if(ans == count	) {
			if(check()) isFinish = true;
			return;
		}
		
		for(int i=y; i<= h; i++) {
			for(int j=x; j<n; j++) {
				// ���μ� �� ���� �������� ������ �� ���� ������ ���μ��� �߰��ϱ� ���� ����� ���μ��� �ִ��� Ȯ���Ѵ�.
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					//���μ��� �߰��Ѵ�.
					map[i][j] = 1;
					map[i][j+1] = 2;
					
					dfs(1, 1, count+1);
					
					// �߰��ߴ� ���μ��� �ٽ� �����Ѵ�(��Ʈ��ŷ)
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
	}
	
	// i������ ����ؼ� i������ �����ϴ��� Ȯ���Ѵ�.
	public static boolean check() {
		for(int i=1; i<=n; i++) {
			int nx = i;
			int ny = 1;
			
			while(ny <= h) {
				if(map[ny][nx] == 1) nx++; // �������� �̵�
				else if(map[ny][nx] == 2) nx--; // �������� �̵�
				ny++; // y�� +1ĭ���� �̵��Ѵ�. (�Ʒ��� �̵�)
			}
			
			if(nx != i) return false; // i������ ����ؼ� i������ �������� �ʴ°� �ϳ��� �ִٸ� ����
		}
		
		return true;
	}
}
