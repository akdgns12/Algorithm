package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 0 : 빈 칸, 1 : 집, 2 : 치킨 집
// 치킨 거리 = 집과 가장 가까운 치킨집 사이의 거리
// 도시의 치킨거리 = 모든 집의 치킨거리의 합
// 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업
// 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하라.
// 가장 먼 치킨집을 제외하고 골라야함.
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 로직
 * 1. 집과 치킨집의 좌표를 각각 list에 넣어준다. 
 * 2. 치킨집이 open한 개수가 M과 같을경우, 모든 집에 대하여 M개의 치킨집 중 최단거리를 계산
 * 3. 탐색을 시작하는 지점이 치킨집 list의 사이즈를 벗어나게 되면 탐색 종료
 */
class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class 치킨배달 {
	static int N, M;
	static int[][] map;
	static ArrayList<Point> person;
	static ArrayList<Point> chicken;
	static int ans;
	static boolean[] open;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		person = new ArrayList<>();
		chicken = new ArrayList<>();
		
		// 미리 집과 치킨집에 해당하는 좌표를 ArrayList에 넣어 둠
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			
				if(map[i][j] == 1) {
					person.add(new Point(i,j));
				}else if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];
		
		dfs(0, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt == M) {
			int res = 0;
			
			for(int i=0; i<person.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				// 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
				// 그 중, 최소 거리를 구한다.
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(person.get(i).x - chicken.get(j).x)
								+ Math.abs(person.get(i).y - chicken.get(j).y);
						
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
			dfs(i+1, cnt+1);
			open[i] = false;
		}
	}
	
}
