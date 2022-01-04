package �Ｚ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����Ż��2 {
	static class Marble{
		int rx,ry;
		int bx,by;
		int cnt;
		
		public Marble(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	
	static int N,M;
	static char[][] map;
	// ���������� �Ķ����� ���� �������� ���� ���� ��� �������� class�� ���� ���� �ϳ���!
	static Marble red, blue;
	static int holeX, holeY;
	
	static int[] dx = {-1,1,0,0}; // �����¿�
	static int[] dy = {0,0,-1,1};
	
	// �̰� ��¦ ���ذ� �Ȱ� -> ���� �Ķ� �� ��ġ�� ������� 4���� �迭 ����
	static boolean[][][][] visited; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		// map ���� �޾ƿ� ���� ���� class�� �ְ� ���� ��ġ ��� 
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'O') {
					holeX = i;
					holeY = j;
				}else if(map[i][j] == 'B') {
					// rx , ry, bx, by, cnt : ���� ���� x,y ��ǥ, �Ķ����� x,y ��ǥ, Ƚ��
					blue = new Marble(0,0,i,j,0);
				}else if(map[i][j] == 'R') {
					red = new Marble(i,j,0,0,0);
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
			
			if(curCnt > 10) { // �̵�Ƚ�� 10ȸ �ʰ��� ����
				return -1;
			}
			
			for(int i=0; i<4; i++) {
				int newRx = curRx;
				int newRy = curRy;
				int newBx = curBx;
				int newBy = curBy;
				
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				// �������� �̵� -> # ���� ���� ������ �̵�
				while(map[newRx + dx[i]][newRy + dy[i]] != '#') {
					newRx += dx[i];
					newRy += dy[i];
					
					if(newRx == holeX && newRy == holeY) {
						isRedHole = true;
						break;
					}
				}
				
				// �Ķ����� �̵� -> # ���� ���� ������ �̵�
				while(map[newBx + dx[i]][newBy + dy[i]] != '#') {
					newBx += dx[i];
					newBy += dy[i];
					
					// �̵� �� ������ ���� ���
					if(newBx == holeX && newBy == holeY) {
						isBlueHole = true;
						break;
					}
				}
				
				if(isBlueHole) { // �Ķ� ������ ���ۿ� ������ ������ ����
					continue; // ������ ť������ �ٸ� ��ǥ�� �����ϴ� ��ŵ
				}
				
				if(isRedHole && !isBlueHole) { // ���� ������ ���ۿ� ������ ����
					return curCnt;
				}
				
				// �� �� ���ۿ� ������ �ʾҴµ�, �̵��� ��ġ�� ���� ��� -> ��ġ ����
				if(newRx == newBx && newRy == newBy) {
					if(i == 0) { // �������� ����̱�
						// ��ū x���� ���� ������ �ڷΰ�
						if(curRx > curBx) newRx -= dx[i];
						else newBx -= dx[i];
					}else if(i == 1) { // �Ʒ������� ����̱� 
						// �� ���� x���� ���� ������ �ڷ� ��
						if(curRx < curBx) newRx -= dx[i];
						else newBx -= dx[i];
					}else if(i == 2) { // �������� ����̱�
						// �� ū y���� ���� ������ �ڷΰ�
						if(curRy > curBy) newRy -= dy[i];
						else newBy -= dy[i];
					}else if(i == 3) { // ���������� ����̱�
						// �� ����y���� ���� ������ �ڷΰ�
						if(curRy < curBy) newRy -= dy[i];
						else newBy -= dy[i];
					}
				}
				
				// �� ������ �̵��� ��ġ�� ó�� �湮�ϴ� ���� ��츸 �̵� -> ť �߰�
				if(!visited[newRx][newRy][newBx][newBy]) {
					visited[newRx][newRy][newBx][newBy] = true;
					q.add(new Marble(newRx, newRy, newBx, newBy, curCnt+1));
				}
			} // end of ���� for
		}// end of ť while
		
		
		return -1;
	}
}
