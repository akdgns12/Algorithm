package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ����
 * 1. ��ȸ�� �Ͽ� �湮���� ���� ��带 �湮�Ѵ�. �� ������ ��� ��带 �湮�� ������ �ݺ�.
 * 2. ��带 �湮�� ������ BFS/DFS Ž�� �˰����� ����Ͽ� �����Ѵ�.
 * 	   �� �� �������� �̵��� ���� ���� ����� ������ ���̰� L�̻� R���Ͽ��� �Ѵ�.
 * 3. �湮�� ������ ���ʴ�� list�� �־��ְ� ��� ���� ���� ���� �����صд�.
 * 4. ��� ����� �湮�� �����ٸ� list�� �־��� ������ �α��̵��� �����Ѵ�.
 * 	  �� �� list�� ũ�Ⱑ 1���� Ŀ�� �̵��� �����Ѵ�.
 * 5. �̵� �ÿ��� ������ ���ǿ� �°� ��� ���� ���� ����� ������� ���� ���� ��� ��忡 ��������ش�.
 * 6. 1~6 ���� ���� �α��̵��� �Ͼ ���� ���ٸ� �� �̻� �̵��� �� �ִ� �α��� �����Ƿ� ��ȸ�� ���߰� �̶��� result���� ��ȯ
 * 
 * �� ������ BFSŽ���� ������ �� �����ؾ��� �κ�. 
 * �湮üũ�� �ϴ� �κ�.. ���� �������� �����ֵ��� ���� ��忡�� �� �� �� �� �� �����̶� �α��� �̵��� �� �ִٸ�
 * �̵��� �� �ִ� ��尡 �ȴ�. �׷��� ó������ �ѹ� Ȯ���� ���� ��� visited = false�� �ٲ���� �ٸ� ���⿡��
 * �α��� �̵��� �� �־ �̵����� ���Ͽ���. �̷��� �Ǽ��� ��������.
 */
public class �α��̵� {
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
	static ArrayList<Node> list; // �α��̵��� �ʿ��� ��� ����Ʈ
	
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
	
	public static int move() { // �� �̻� �α��̵��� �Ͼ�� ���������� �ݺ�
		int result = 0;
		while(true) {
			boolean isMove = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i, j); // bfs Ž������ ���� �� �ִ� ���漱 Ȯ���ϸ� �α��̵��� �� �α��� ��ȯ
						if(list.size() > 1) {
							changePopulation(sum); // ���� ���漱 ���� ���� �α� ����
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
	
	// �α��̵��� �α��� �������ֱ�
	public static void changePopulation(int sum) {
		int avg = sum / list.size();
		for(Node n : list) {
			map[n.x][n.y] = avg;
		}
	}
}