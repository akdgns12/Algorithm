package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {
	static class Node{
		int x, y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y =y;
			this.cnt = cnt;
		}
	}
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int R,C;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R;i++) {
			String str = br.readLine();
			for(int j=0; j<C;j ++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'L') {
				visited = new boolean[R][C];
				int val = bfs(i,j);
				result = Math.max(result, val);
				}
			}
		}
		System.out.println(result);
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y, 0));
		visited[x][y] = true;
		int val = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(nx >=0 && ny >=0 && nx < R  && ny <C 
						&& !visited[nx][ny] && map[nx][ny] == 'L') {
					visited[nx][ny] = true;
					q.offer(new Node(nx,ny,node.cnt+1));
					val = Math.max(val, node.cnt+1);
				}
			}
		}
		return val;
	}

}
