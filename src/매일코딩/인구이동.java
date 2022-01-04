package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 로직
 * 1. 순회를 하여 방문하지 않은 노드를 방문한다. 이 과정은 모든 노드를 방문할 때까지 반복.
 * 2. 노드를 방문할 때에는 BFS/DFS 탐색 알고리즘을 사용하여 구현한다.
 * 	   이 때 다음으로 이동할 노드는 현재 노드의 값과의 차이가 L이상 R이하여야 한다.
 * 3. 방문한 노드들을 차례대로 list에 넣어주고 노드 값의 합을 따로 저장해둔다.
 * 4. 모든 노드의 방문이 끝났다면 list에 넣어준 노드들의 인구이동을 시작한다.
 * 	  이 때 list의 크기가 1보다 커야 이동을 시작한다.
 * 5. 이동 시에는 문제의 조건에 맞게 노드 값의 합으 노드의 사이즈로 나눈 값을 모든 노드에 변경시켜준다.
 * 6. 1~6 과정 동안 인구이동이 일어난 적이 없다면 더 이상 이동할 수 있는 인구가 없으므로 순회를 멈추고 이때의 result값을 반환
 * 
 * 이 문제의 BFS탐색을 구현할 때 유의해야할 부분. 
 * 방문체크를 하는 부분.. 문제 예제에도 나와있듯이 현재 노드에서 상 하 좌 우 한 방향이라도 인구가 이동될 수 있다면
 * 이동할 수 있는 노드가 된다. 그런데 처음에는 한번 확인한 노드는 모두 visited = false로 바꿔버려 다른 방향에서
 * 인구가 이동될 수 있어도 이동하지 못하였다. 이러한 실수를 유의하자.
 */
public class 인구이동 {
	public static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1}; 
	static int[] dy = {1,0,-1,0}; 
	static ArrayList<Node> list; // 인구이동이 필요한 노드 리스트
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(move());
	}
	
	public static int move() { // 더 이상 인구이동이 일어나지 않을떄까지 반복
		int result = 0;
		while(true) {
			boolean isMove = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i, j); // bfs 탐색으로 열릴 수 있는 국경선 확인하며 인구이동할 총 인구수 반환
						if(list.size() > 1) {
							changePopulation(sum); // 열린 국경선 내의 노드들 인구 변경
							isMove = true;
						}
					}
				}
			}
			if(!isMove) return result;
			result++;
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();
		
		q.offer(new Node(x, y));
		list.add(new Node(x, y));
		visited[x][y] = true;
		
		int sum = map[x][y];
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
					if( L <= diff && diff <= R) {
						q.offer(new Node(nx, ny));
						list.add(new Node(nx, ny));
						sum += map[nx][ny];
						visited[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}
	
	// 인구이동된 인구로 변경해주기
	public static void changePopulation(int sum) {
		int avg = sum / list.size();
		for(Node n : list) {
			map[n.x][n.y] = avg;
		}
	}
}