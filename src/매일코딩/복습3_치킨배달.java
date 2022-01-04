package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 복습3_치킨배달 {
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[] open;
	static ArrayList<Point> person;
	static ArrayList<Point> chicken;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		person = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) { // 가정집
					person.add(new Point(i,j));
				}
				else if(map[i][j] == 2) { // 치킨집
					chicken.add(new Point(i,j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];
		// M개 만큼의 치킨집 골라서 각 집마다의 치킨거리 구하고, 그 중 가장 작은 값 구한다
		dfs(0, 0);
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt == M) {
			int res = 0;
			
			for(int i=0; i<person.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(person.get(i).x - chicken.get(i).x)
								+ Math.abs(person.get(i).y - chicken.get(i).y);
						
						temp = Math.min(temp, distance);
					}
				}
				res += temp;
			}
			ans = Math.min(ans, res);
			
			return;
		}
		
		// 백트래킹
		for(int i=start; i<chicken.size(); i++) {
			open[i] = true;
			dfs(start + 1, cnt + 1);
			open[i] = false;
		}
	}
}
