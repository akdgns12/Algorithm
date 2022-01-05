package �׷���Ž��;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ġ�� {
	/*
	 * DFS�� �̿��Ͽ� Ǯ �� �ִ� ����
	 * �ܺΰ���� �´��� ġ� ��µ�,�� �ʸ��� ��� ġ� ���� ���̰�, �� ��� 1�������� 
	 * �� ���� ġ� �־����� ���ϴ°� �ٽ�.
	 * ó���� ġ� �������� �����¿� ���⿡ ���Ⱑ �ִ��� Ȯ���ϰ�, ���Ⱑ ������ ����� �������
	 * ������ ¥���� ������, ġ�� �ȿ� ���Ⱑ ���� ���� ġ� ���� �ʴ� �ݷʰ� �ִ�.
	 * 
	 * �׷��� ġ� �ƴ�, ���⸦ �������� �����¿� �������� DFS�� Ž���ϸ鼭 �ܺ� ����� �´��� ġ�
	 * ã�ƾ� �Ѵ�.
	 * �������� ���� �׵θ����� ġ� ��ġ�� �� ���ٰ� �߱� ������ (0,0)�� �ݵ�� ����
	 * 
	 * �׸��� ��������.
	 * (0,0)���� �����ؼ� �ܺ� ����� �´��� ġ� ã���� ��, �ٷ� map[i][j] = 0�� ���� �� ġ�
	 * ��� ����� ����� �ȵȴ�.
	 * 
	 * ����, Ư�� ���� "011"�� ������ �ִٰ� �����ϸ�, ���ʿ��� 2��° �ִ� 1�� ����� �´�� �ִ� ���� �ڸ��ϴ�.
	 * ������, �� 1�� �ٷ� 0���� ���������� ���ÿ� �����ʿ��� 1��°�� �ִ� 1�� �ܺ� ����� �´�� �ִٰ� �Ǵ��ϰ� �ȴ�.
	 * 
	 * ���� �ٷ� map[i][j] = 0���� ó���ϴ� ���� �ƴ϶�, ������ ���ڸ� �־ "1�� �� ���� ������ ġ��"���
	 * �ǹ̸� ��ƾ� �Ѵ�. ���� 2��� ���ڸ� �ֱ�� �ߴ�.
	 * 
	 * ���� DFS�� �����鼭 ���������� Ž���� �����ٰ� �սô�.
	 * ������ ������ Ž���� �����ٴ� �ǹ̴� 1�ʰ� �����ٴ� ���̱� ������ "1�ʵ� ���� ������ ġ��"�� ��� �쿩��� �Ѵ�.
	 * 
	 * ���⼭, ���� isCheese()��� ��ȯ���� boolean�� �޼ҵ��ϳ� ����
	 * �� �޼ҵ�� "1�� �� ���� ������ ġ��"�� ��� �쿩�ְ�, �� ��ü�� �ϳ��� �����ִ��� Ȯ���ϴ� �޼ҵ�
	 * 
	 * �� �޼ҵ��� ��ȯ���� true �Ǵ� false�̱� ������ ���� �޼ҵ��� �ݺ����� �������� �����ϸ�, �� �ʵڿ�
	 * ġ� ����� �Ǵ��ϱ� �����ϴ�.
	 * 
	 */
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cheesCnt;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// 0 : ġ� ���� �κ�, 1 : ġ� �ִ� �κ�
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		int ans;
		for(ans = 0; isCheese(); ans++) {
			// �ʱ� ����
			for(boolean[] arr : visited) {
				Arrays.fill(arr,false);
			}
			
			visited[0][0] = true;
			count = 0;
			
			dfs(0,0);
		}
		
		System.out.println(ans);
	}
	
	// �� ���� ġ� �����ϴ°�?
	public static boolean isCheese() {
		// map[i][j] = 2�� ǥ�õ� �κ��� ����� �´��� ġ���̹Ƿ�
		// ���� ����� �ٲ���� ��.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
		
		// �� ���� ġ� �����ϴ��� üũ.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) { 
				if(map[i][j] == 1) { // ġ� �����Ѵٸ�
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(!visited[nx][ny]) {
				visited[nx][ny] = true;
				if(map[nx][ny] == 1) { // ġ����
					map[nx][ny] = 2;
					count++; // ������ ������ ġ���� ����
				}else {
					dfs(nx,ny);
				}
			}
		} // end for
		
	} // end dfs

}
