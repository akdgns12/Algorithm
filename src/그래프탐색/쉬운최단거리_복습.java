package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_복습 {
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Node> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) // 시작지점 큐에 넣어주기 
					q.offer(new Node(i,j));
			}
		}
		// 큐에 넣은 시작지점으로부터 bfs를 돌려 거리를 구한다
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > 1) { // 시작위치 값인 2를 빼준다
					sb.append(map[i][j] - 2 + " ");
				}else if(map[i][j] == 1) { // 길인데 도달하지 못한 위치
					sb.append("-1"  + " ");
				}
				else { // 갈 수 없는 곳
					sb.append("0" + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// 범위 벗어나면 skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == 1) {
					map[nx][ny] = map[node.x][node.y] + 1;
					q.offer(new Node(nx,ny));
				}
			}
		}
	}
}
