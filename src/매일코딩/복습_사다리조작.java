package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_��ٸ����� {
	static int n,m; // n: ���μ��� ����, m:���μ��� ����
	static int h; // ���μ����� ���μ��� ���� �� �ִ� ��ġ�� ���� h
	static int ans;
	static int[][] map;
	static boolean isFinish = true;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a ���̿��� b���� b+1�� ���μ��� �����Ѵ�.
			map[a][b] = 1; // 1 : �������� �̵�
			map[a][b+1] = 2; // 2 : �������� �̵�.
		}
		
		//�߰��� ���μ��� ������ �̸� ���س��� Ž������ �������� �� �� �ִ�.
		// �Ʒ� �ݺ������� i�� �߰��� ���μ��� ����
		for(int i=0; i<=3; i++) {
			ans = i;
			dfs(1, 1, 0);
			if(isFinish) break;
		}
		
		System.out.println((isFinish ? ans : -1));
	}
	
	public static void dfs(int x, int y, int count) {
		if(isFinish) return;
		if(ans == count) {
			if(check()) isFinish = true;
			return;
		}
		
		for(int i=y; i<=h; i++) {
			for(int j=x; j<n; j++) {
				// ���μ� �ΰ��� �������� ������ �� ���� ������ ���μ��� �߰��ϱ� ���� ����� ���μ��� �ִ��� Ȯ���Ѵ�.
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					// ���μ��� �߰��Ѵ�.
					map[i][j] = 1;
					map[i][j+1] = 2;
					
					dfs(1, 1, count+1);
					
					//�߰��ߴ� ���μ��� �ٽ� �����Ѵ�.(��Ʈ��ŷ)
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
			int ny = i;
			
			while(ny <= h) {
				if(map[ny][nx] == 1) nx++; // �������� �̵�
				else if(map[ny][nx] == 2) nx--; // �������� �̵�
				ny++; // y��+1ĭ �̵��Ѵ�.(�Ʒ��� �̵�)
			}
			
			if(nx != i) return false; // i������ ����ؼ� i������ �������� �ʴ°� �ϳ��� �ִٸ� ����
		}
		
		return true;
	}

}
