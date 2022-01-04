package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * �ܺΰ���, ���ΰ��� ��� ������ �������� ����
 * 1. (0,0)���� bfsŽ���� �����ؼ� �ܺΰ���鸸 ť�� �����鼭 Ž�� �ܺΰ���� 2�� �ε������ش�
 * ġ��� ���� �ʰ� Ž���߱� ������ ���ΰ��⿡ �������� �ʴ´�. Ž���� �ܺΰ������ 2�� �ε����ϰ�
 * 2. ���� ġ����� Ž���ϸ鼭 2�� �ε��̵� �ܺΰ���� �����ϴ� ���� 2�̻��̸� ���� ����̶�� 3���� �ε���
 * 3. ���� ���(3)���� ǥ��� ġ����� �ܺΰ���� �ٲ��ش�(2)
 * 4. 1~3 �ݺ�
 */

// ������.. ������ ������ �ڹٿ����� ���ʰ� ����..
/*
 * �ذ��� -> �����ؼ� ������ �ٽ� �˻��ϴ� �ͺ��ٴ� ù bfsŽ������
 * �ܺΰ���� �´��� ���� �ִ� ġ� ī�������ִ� �������
 * ���߿� ī������ 2�̻��̸� ����� �ٲ��ִ� �������� �����ؾ� �� ��
 */
public class BOJ2638ġ��_����� {
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int time;
	
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
		
		while(true) {
			boolean flag = false;
			
			bfs(); // (1) ġ�� ��, �ܺ� ���н�Ű��
			
			// (2) ��� ġ�� ĭ���� ������� ���� �� �ִ��� Ȯ���ϱ�
			flag = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					// �ش� ĭ�� ġ���ϰ��
					if(map[i][j] == 1) {
						int cnt = 0;
						// �� ĭ�� ��,��,��,�츦 ���캸�� �ּ� 2ĭ��  �ܺΰ���(2�θ��ε�)������ Ȯ��
						for(int k=0; k<4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							// ���� ���̰�, �ܺΰ���� �����ߴٸ�
							if(nx >= 0 && ny >= 0 && nx < N && ny < M
									&& map[nx][ny] == 2) {
									flag = true;
									cnt++;
							}
						}
						if(cnt >= 2) map[i][j] = 5; // ���˸� 2�̻��̸� ��´������ ǥ�� = 5
					}
				}
			} // end outer for
			
			// (3) ��� ������� ǥ��� ���� ���� ��� �ܺΰ���� �ٲٱ�
			if(flag) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(map[i][j] == 5) {
							map[i][j] = 2;
						}
					}
				}
			}
			time++;
			
			flag = false;
			// ġ� �����ִ��� ��˻�
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						flag = true;
					}
				}
			}
			if(!flag) break;
		} // end while
		
		
		System.out.println(time);
	}
		// �ܺΰ��� ť�� �־��ָ鼭 Ž��
		public static void bfs() {
			
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(0,0)); // 0,0 �� ������ ����ϱ� ������� ����
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					// ���� ����� skip
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					// �湮���� �ʾҰ� && �����̰� && ġ� �ƴ϶��
					if(!visited[nx][ny] && map[nx][ny] == 0 && map[nx][ny] != 1) {
						visited[nx][ny] = true;
						map[nx][ny] = 2; // �ܺΰ��� 2�� ����
						q.offer(new Node(nx, ny));
					}
				}
			} // end while	
		}
		
		static class Node{
			int x, y;
			public Node(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	}

