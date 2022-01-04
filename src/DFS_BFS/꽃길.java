package DFS_BFS;
// 완전탐색(백트래킹)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 꽃을 심고 난 뒤 정확히 1년 후에 꽃이 핀다.
 * 꽃밭은 N*N의 크기, 꽃의 씨앗은 3개밖에 없음
 * 씨앗을 중심으로 4방향 탐색을 해서 다른 씨앗이 심어진 곳에서 4방향 탐색이 이루어진 곳과 겹치지 않아야 조건 만족
 * 
 */
/*
 * 착상 및 접근방법
 * 기본적인 백트래킹에 응용이 필요한 문제
 * 일단 상하좌우에 꽃잎이 존재해야하기 때문에 길이 1만큼 테뒤는 고려할 필요가 없다.
 * 그래서 2,2 부터 탐색을 시작(시간을 줄이기 위해)
 * viisted 배열은 그칸에 꽃잎이 있는지 판단한다. 때문에 방문하지 않았고 && 상하좌우에 꽃잎이 없는 경우에만 탐색한다
 * 이때, 비용을 구해야 하므로 상하좌우의 비용을 더해준다.
 * 그 후, 백트래킹으로 합을 누적시키면서 찾은 꽃이 3개가 되는 경우 최소 합을 계속 갱신해준다.
 * 재귀가 끝난 후에는 방문처리를 해제해야 하기 때문에 꽃이 있던 위치를 모두 false로 변경한다.
 */
public class 꽃길 {
	static int n;
	static int[][] map; // 화단의 가격을 저장할 배열
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
						int hap = sum(i,j); // 꽃 합
						
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

