package �α��̵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_�α��̵�_16234 {
	static int[][] map;
	static boolean[][] visited;
	static int N,L,R; // n*n ũ�� l �̻� r ����
	static int teamN;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		int time = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // End of Input
		
		int count = 0;
		
		// while �ݺ����� ���� 
		while(true) {
			boolean hasNext = false;
			visited = new boolean[N][N]; // �湮�ʱ�ȭ
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// �湮����, ������ ������ Ȯ���Ͽ� �̹� �Ͽ� ������ �ִ��� Ȯ��
					if(!visited[i][j] && check(i,j) > 1) {
						hasNext = true;
					}
				}
			}
			
			if(hasNext) {
				count++;
			}else {
				break;
			}
		}
		
		System.out.println(count);
	}
	
	// ����Ȯ��
	public static int check(int startX, int startY) {
		
		LinkedList<Nation> allies = new LinkedList<>();
		Queue<Nation> q = new LinkedList<>();
		Nation start = new Nation(startX, startY);
		q.add(start);
		allies.add(start);
		visited[startX][startY] = true;
		int sum = map[startX][startY];
		
		while(!q.isEmpty()) { // ť�� �􋚱���
			
			Nation current = q.poll(); // Nation ť�� �ִ� �����͸� �̴´�.
			
			for(int i=0; i<4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(isMoveable(current,nx,ny)) {
					Nation next = new Nation(nx,ny);
					q.add(next);
					allies.add(next);
					sum += map[nx][ny]; // �α� map�� �����ش�
					visited[nx][ny] = true; // �湮ó�� ���������� ���ش�.
				}
			}
		}
		
		// ������ ������ ������ �α��� ����
		if(allies.size() != 1) {
			int result = sum / allies.size();
			
			for(Nation ally : allies) {
				map[ally.x][ally.y] = result;
			}
		}
		
		return allies.size();
	}
	// �̵� ���� ���� Ȯ��
	public static boolean isMoveable(Nation current, int nx, int ny) {
		if( nx >=0 && nx < N && ny >=0 && ny < N && !visited[nx][ny]) {
			
			// �α����� ���� Ȯ��
			int abs = Math.abs(map[current.x][current.y] - map[nx][ny]);
			
			if( L <= abs && abs <= R)
				return true;
		}
		return false;
	}
	
	static class Nation{
		public int x;
		public int y;
		
		public Nation(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	/*
	// �α� �̵� �ʿ����� ��ü ���� Ȯ��
	public static boolean check() {
		List<Node> n_list;
		boolean isDone = true; // �̵��� ���̻� �ʿ����� ���� ��� true. �ʿ��� ��� false
		for(int i=0; i<N; i++) {	
			for(int j=0; j<N; j++) {
				// �湮���� ���� ���
				if(!visited[i][j]) {
					n_list = new LinkedList<>();
					n_list.add(new Node(i,j));
					//sum - ����Ʈ�� ����� ���� ��.
					int sum = dfs(i,j,n_list,0);
					if(n_list.size() > 1) { // ����Ʈ ũ�Ⱑ 1�̻��� ���(=�α��̵��� �ʿ��� �����Ͱ� ���� ���)
							change(sum, n_list); //��հ� ����ؼ� map ����
							isDone = false;
					}
			}
		}
	}
	return isDone;
	}
	
	public static void change(int sum, List<Node> n_list) {
		int avg = sum/n_list.size();
		for(Node node:n_list) {
			map[node.x][node.y] = avg;
		}
	}
	
	public static int dfs(int x, int y, List<Node> n_list, int sum) {
		visited[x][y] = true;
		sum = map[x][y];
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || nx >= N || ny <0 || ny >=N) {
				continue;
			}
			if(!visited[nx][ny]) {
				int d = Math.abs(map[x][y] - map[nx][ny]);
				if( d >= L && d <= R) {
					n_list.add(new Node(nx,ny));
					sum += dfs(nx,ny,n_list,sum);
				}
			}
		}
		return sum;
	} */
}

