package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.xml.soap.Node;

public class 복습_인구이동 {
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, L, R;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
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
	public static int move() { // 더이상 인구이동 일어나지 않을때까지 반복
		int day = 0;
		while(true) {
			boolean isMove = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i,j); // bfs탐색으로 열릴 수 있는 국경선 확인하며 인구이동할 총 인구수 반환
						if(list.size() > 1) {
							changePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) return day;
			day++;
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();
		
		q.offer(new Node(x,y));
		list.add(new Node(x,y));
		visited[x][y] = true;
		
		int sum = map[x][y];
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]); // 인구차이
					if(L <= diff && diff >= R) {
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
	// 인구이동 일어난 후 새로운 인구 적용시켜주는 함수
	public static void changePopulation(int sum) {
		int avg = sum / list.size();
		for(Node n : list) {
			map[n.x][n.y] = avg;
		}
	}

}
