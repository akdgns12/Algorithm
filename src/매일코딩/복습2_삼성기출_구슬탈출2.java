package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����2_�Ｚ����_����Ż��2 {
	static class Marble{
		int rx, ry;
		int bx, by;
		int cnt;
		
		public Marble(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	static int N, M;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Marble red, blue;
	static int holeX, holeY;
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'O') {
					holeX = i;
					holeY = j;
				}else if(map[i][j] == 'R') {
					red = new Marble(i,j,0,0,0);
				}else if(map[i][j] == 'B') {
					blue = new Marble(0,0,i,j,0);
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Marble> q = new LinkedList<>();
		q.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
		visited[red.rx][red.ry][blue.bx][blue.by] = true;
		
		while(!q.isEmpty()) {
			Marble marble = q.poll();
			
			int curRx = marble.rx;
			int curRy = marble.ry;
			int curBx = marble.bx;
			int curBy = marble.by;
			int curCnt = marble.cnt;
			
			if(curCnt > 10) { // �̵�Ƚ�� 10ȸ �Ѿ�� -1 ����
				return -1;
			}
			
			for(int i=0; i<4; i++) {
				int nextRx = curRx;
				int nextRy = curRy;
				int nextBx = curBx;
				int nextBy = curBy;
				
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				// �������� �̵� -> �� ����������
				while(map[nextRx + dx[i]][nextRy + dx[i]] != '#') {
					nextRx += dx[i];
					nextRy += dy[i];
					
					// ������ ������
					if(nextRx == holeX && nextRy == holeY) {
						isRedHole = true;
						break;
					}
				}
				
				// �Ķ����� �̵� -> ������������
				while(map[nextBx + dx[i]][nextBy + dy[i]] != '#') {
					nextBx += dx[i];
					nextBy += dy[i];
					
					// ������ ������
					if(nextBx == holeX && nextBy == holeY) {
						isBlueHole = true;
						break;
					}
				}
				
				if(isBlueHole) { // �Ķ������� ���ۿ� ������ ����
					continue;  // ť�� ���� ���� ��ǥ�鵵 ������� �ϴ� �ϴ� ��ŵ
				}
				
				if(isRedHole && !isBlueHole) { // ���������� ���ۿ� ������ ����
					return curCnt;
				}
				
				// �� �� ���ۿ� ������ �ʾҴµ� �̵��� ��ġ�� ���ٸ� -> ��ġ ����
				if(nextRx == nextBx && nextRy == nextBy) {
					if(i == 0) { // ���� ����̱�
						// �� ū x���� ���� ������ �ڷΰ�
						if(curRx > curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 1) { // �Ʒ��� ����̱�
						// �� ���� x���� ���� ������ �ڷΰ�
						if(curRx < curBx) nextRx -= dx[i];
						else nextBx -= dx[i];
					}else if(i == 2) { // �������� ����̱�
						// �� ū y���� ���� ������ �ڷΰ�
						if(curRy > curBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					}else if(i == 3) {// ���������� ����̱�
						// �� ���� y���� ���� ������ �ڷΰ�
						if(curRy < curBy) nextRy -= dy[i];
						else nextBy -= dy[i];
					}
				}
				
				// �湮���� ���� ���� ��� �湮 ó�� �� ť�� �߰�
				if(!visited[nextRx][nextRy][nextBx][nextBy]) {
					visited[nextRx][nextRy][nextBx][nextBy] = true;
					q.add(new Marble(nextRx, nextRy, nextBx, nextBy, curCnt + 1));
				}
			}
		}
		return -1;
	}
}
