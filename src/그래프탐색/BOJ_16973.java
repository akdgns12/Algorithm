package �׷���Ž��;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16973 {
	static int N, M;
	static int H,W,Sx,Sy,Fx,Fy;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ������� ���簢���� ũ�� H(����), W(����)
		// ������ǥ Sx,Sy, ������ǥ Fx, Fy
		st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			Sx = Integer.parseInt(st.nextToken())-1;
			Sy = Integer.parseInt(st.nextToken())-1;
			Fx = Integer.parseInt(st.nextToken())-1;
			Fy = Integer.parseInt(st.nextToken())-1;
		
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(Sx,Sy,0));
		visited[Sx][Sy] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx == Fx && ny == Fy) {
					ans = node.dist+1;
					return;
				}
				
				// ���� ����ų� �湮�ߴٸ� skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// �湮���� �ʾҰ�, ������ǥ ���� �ƴ϶��
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					// �ش� ���簢�� �����ȿ� ���ִ��� ����, ���� ������� üũ
					if(!check(nx, ny)) {
						continue;
					}
					q.offer(new Node(nx,ny,node.dist+1));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static boolean check(int nx, int ny) {
		if(nx + H - 1 >= N || ny + W - 1 >= M) {
			return false;
		}
		
		for(int i=nx; i<nx+H; i++) {
			for(int j=ny; j<ny+W; j++) {
				if(map[i][j] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static class Node{
		int x,y,dist;
		
		public Node(int x, int y,int dist) {
			this.x =x;
			this.y = y;
			this.dist = dist;
		}
	}
}
