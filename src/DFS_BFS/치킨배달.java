package DFS_BFS;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 삼성SW 역량 테스트 기출
/*
 * N*N의 도시가 주어지고 치킨집의 최대개수 M이 주어졌을 때
 * 주어진 치킨집 중 어떻게 M개를 고르면
 * 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램
 */

/*
 *  <착상>
 *  BFS로 최단거리를 구하고, 재귀함수를 이용하여 해결하려 했지만 시간초과 이슈
 *  <알고리즘>
 *  DFS와 백트래킹을 이용하면 간단하게 풀리는 문제
 *  집과 치킨집의 좌표를 따로 ArraysList에 넣어 관리해줘야 한다
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
	
	static int N,M;
	static int[][] map;
	static boolean[] open;
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		//Input 미리 집과 치킨집에 해당하는 좌표를 ArrayList에 넣어 둠
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new Point(i,j));
				}else if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE; // 최종 도시의 치킨 거리의 최솟값
		open = new boolean[chicken.size()]; // 
		DFS(0,0);
		
		System.out.println(ans);
		
	}

	/*도시의 치킨 거리의 최솟값을 구해야 한다!!!
	  치킨 거리는 집과 가장 가까운 치킨집 사이의 거리. 즉 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다.
	  도시의 치킨 거리는 모든 집의 치킨 거리의 합
	*/
	// ans = 모든 집의 치킨 거리의 합
	/*
	 * 1. 집과 치킨집의 좌표를 각각 list에 저장해둔다
	 * 2. 치킨집이 open 한 개수가 M과 같다면, 모든 집에 대하여 M개의 치킨집 중 최단거리를 계산한다.
	 * 3. 탐색을 시작하는 지점이 치킨집 list의 사이즈가 벗어나게 되면 탐색을 종료한다.
	 */
	static void DFS(int start, int depth) {
		if(depth == M) { // dpeth가 입력된 폐업시키지 않을 최대 치킨집의 개수 M
			int res = 0;
			
			for(int i=0; i<home.size(); i++) {
				int temp = Integer.MAX_VALUE;
			
				//어떤 집과 치킨 집 중 open한 치킨집의 모든 거리를 비교한다
				//그 중, 최소 거리를 구한다 = 집의 치킨 거리
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, distance); //그 중 최소거리
					}
				}
				res += temp; // res 임시 변수에 최소거리 누적 저장
			}
			
			ans = Math.min(ans, res); 
			return;
		}
		
		//백트래킹
		for(int i= start; i<chicken.size(); i++) {
			open[i] = true;
			DFS(i + 1, depth + 1);
			open[i] = false;
		}
	}
}
