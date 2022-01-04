package DFS_BFS;
// ����Ž��(��Ʈ��ŷ)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���� �ɰ� �� �� ��Ȯ�� 1�� �Ŀ� ���� �ɴ�.
 * �ɹ��� N*N�� ũ��, ���� ������ 3���ۿ� ����
 * ������ �߽����� 4���� Ž���� �ؼ� �ٸ� ������ �ɾ��� ������ 4���� Ž���� �̷���� ���� ��ġ�� �ʾƾ� ���� ����
 * 
 */
/*
 * ���� �� ���ٹ��
 * �⺻���� ��Ʈ��ŷ�� ������ �ʿ��� ����
 * �ϴ� �����¿쿡 ������ �����ؾ��ϱ� ������ ���� 1��ŭ �׵ڴ� ����� �ʿ䰡 ����.
 * �׷��� 2,2 ���� Ž���� ����(�ð��� ���̱� ����)
 * viisted �迭�� ��ĭ�� ������ �ִ��� �Ǵ��Ѵ�. ������ �湮���� �ʾҰ� && �����¿쿡 ������ ���� ��쿡�� Ž���Ѵ�
 * �̶�, ����� ���ؾ� �ϹǷ� �����¿��� ����� �����ش�.
 * �� ��, ��Ʈ��ŷ���� ���� ������Ű�鼭 ã�� ���� 3���� �Ǵ� ��� �ּ� ���� ��� �������ش�.
 * ��Ͱ� ���� �Ŀ��� �湮ó���� �����ؾ� �ϱ� ������ ���� �ִ� ��ġ�� ��� false�� �����Ѵ�.
 */
public class �ɱ� {
	static int n;
	static int[][] map; // ȭ���� ������ ������ �迭
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,-0,-1};
	static int result=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		//Input
		StringTokenizer st;
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println(result);
	}
	
	static void dfs(int count, int sum) {
	
		if(count == 3) {
			
			result = Math.min(result, sum);
		}else {
			for(int i=2; i<n; i++) {
				for(int j=2; j<n; j++) {
					if(!visited[i][j] && check(i,j)) {
						visited[i][j] = true;
						int hap = sum(i,j); // �� ��
						
						dfs(count+1, sum + hap);
						
						visitedclear(i,j);
						visited[i][j] = false;
					}
				}
			}
		}
		
		
	}
	
	static boolean check(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
				
			if(visited[nx][ny]) {
				return false;
			}
		}
		
		return true;
	} //check
	
	private static void visitedclear(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx =x +dx[i];
			int ny = y +dy[i];
			
			visited[nx][ny] = false;
		}
	} // visitedclear
	
	private static int sum(int x, int y) {
		int hap = map[x][y];
		
		for(int i=0; i<4; i++) {
			int nx= x + dx[i];
			int ny = y +dy[i];
			
			visited[nx][ny] = true;
			hap += map[nx][ny];
		}
		
		return hap;
	}// sum
}

