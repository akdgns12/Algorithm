package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class ��������Ǵ� {
	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] dp;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st=  new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
					answer = Math.max(answer, dfs(i,j));
			}
		}
		
		System.out.println(answer);
	}
	
	public static int dfs(int x, int y) {
		// dp�� ����� ���� ���� ��� �� ���� ��ȯ
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		
		// �Ǵٰ� �볪�������� �ּ��� 1���� �� �� �����Ƿ�
		// dp[x][y] = 1�� �ʱ�ȭ �� �� ����
		dp[x][y] = 1;
		
		// �����¿� �˻�
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// �������� ����� ��� continue;
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			
			// ���� �볪�� ������ �� ���� ���� �볪���� �ִ� ���
			if(map[x][y] < map[nx][ny]) {
				// �����¿� �߿��� ���� �������� ������ �� �ִ� �Ⱓ�� ����Ѵ�.
				dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
				dfs(nx,ny);
			}
		}
		return dp[x][y];
	} 
}
