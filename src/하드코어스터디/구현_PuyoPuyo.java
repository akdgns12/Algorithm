package 하드코어스터디;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구현_PuyoPuyo {
	// BOJ 11559 골 5 / 푸요푸요 / 구현
	// bfs
	/*
	 * 1. 상하좌우 인접한 뿌요가 4개이상일 경우 터진다.
	 * 이 조건으로 BFS탐색을 하면서 각 뿌요의 좌표를 저장해야한다.
	 * 뿌요의 수가 4개이상일 경우 해당 뿌요들의 자리를 '.'으로 교체하는 것이 터뜨리는 행위
	 * 그렇기 떄문에 좌표와 갯수를 파악하기 쉬운 자료구조는 List
	 * 2. 한 라운드에 4개 이상인 뿌요가 여러개 있어도 연쇄반응은 1회로 간주
	 * 반복문을 돌릴 때 연쇄반응을 카운트하는 ans 변수의 증가 타이밍 중요
	 * 3. 한 라운드가 끝난 뒤에 남아있는 모든 뿌요들을 아래방향으로 내린다.
	 */
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static ArrayList<Color> list;
	static int N= 12, M = 6;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		// map을 탐색하여 4개 이상 뭉쳐있는 노드 확인
		while(true) {
			boolean isFinished = true;
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != '.') {
						list = new ArrayList<>();
						bfs(i,j,map[i][j]);
						
						if(list.size() >= 4) {
							isFinished = false; // 연쇄가 일어났으므로 더 탐색해야한다.
							for(int k=0; k<list.size(); k++) {
								map[list.get(k).x][list.get(k).y] = '.'; // 터트려서 없앰
							}
						}
					}
				}
			}
			if(isFinished) break;
			gravity(); // 중력작용
			count++;
		}
		System.out.println(count);
	}
	
	// 중력작용
	public static void gravity() {
		for(int i=0; i<M; i++) { // 한 열의 번호
			for(int j=10; j>=0; j--) { // 한 열에 대한 행 번호
				for(int k=11; k>j; k--) // 해당 좌표 밑에 있는 것 비교위한 for문 k
					if(map[j][i] != '.' && map[k][i] == '.') {
						map[k][i] = map[j][i];
						map[j][i] = '.';
						break;
					}
			}
		}
	}
	// 인접한 곳 같은 색인지 탐색
	public static void bfs(int x, int y, char color) {
		Queue<Color> q = new LinkedList<>();
		list.add(new Color(x,y));
		q.add(new Color(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Color cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >=N || ny >= M) continue;
				if(!visited[nx][ny] && map[nx][ny] == color) { // 방문한적 없고 같은색깔이면
					visited[nx][ny] = true; // 방문처리해주고
					q.add(new Color(nx, ny));
					list.add(new Color(nx, ny));
				}
			}
		}
	}
	static class Color{
		int x, y;
		public Color(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
