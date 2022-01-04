import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 드래곤_커브{
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int n;
	static int x,y,d,g;
	
	static int solve() {
		int ret = 0;
		// i 행 j 열
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				// 현재위치 1 && 아래도 1 && 오른쪽도 1 && 오른쪽 아래도 1
				if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) {
					ret++;
				}
			}
		}
		return ret;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[101][101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			ArrayList<Integer> curves = new ArrayList<Integer>();
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			curves.add(d);
			for(int j=0; j<g; j++) {
				for(int k= curves.size()-1; k >=0; k--) {
					curves.add((curves.get(k)+1)%4);
				}
			}
			
			
			map[y][x] = 1;
			for(int dir : curves) {
				x += dx[dir];
				y += dy[dir];
				map[y][x] = 1;
			}
		}
		
		System.out.println(solve());
	}
}