package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����2_�̼������ȳ� {
	static class Dust{
		int r,c,amount;
		
		public Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
	static int R,C; // ��,��
	static int T; // T ����
	static int[][] map;
	static int[] cleaner = new int[2]; // ����û����
	static int answer = 0;
	
	static int[] dr = {-1,1,0,0}; // �� �� �� ��
	static int[] dc = {0,0,-1,1};
	
	static Queue<Dust> dust = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		int idx = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) { //����û������ ���
					cleaner[idx++] = i;
				}
			}
		}
		
		for(int i=0; i<T; i++) { // ���ʸ��� ����
			makeQueue();
			
			spread();
			
			operate();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0)
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
	
	public static void makeQueue() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				// ���� û���� ��ġ�� �ƴϰ� ��ĭ�� �ƴ� ���� ������ �̼����� ����
				if(map[i][j] != -1 && map[i][j] != 0) {
					dust.add(new Dust(i,j,map[i][j]));
				}
			}
		}
	}
	
	// �̼����� Ȯ���Ű��
	public static void spread() {
		// �̼����� �ϳ��� ���� Ȯ��
		while(!dust.isEmpty()) {
			Dust cur = dust.poll();
			
			int cr = cur.r;
			int cc = cur.c;
			int camount = cur.amount;
			
			int cnt = 0; 
			int spread_amount = camount / 5;
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dr[i];
				
				// ���� ���̰� ����û���� ��ġ�� �ƴ϶��
				if(isRange(nr,nc) && map[nr][nc] != -1) {
					map[nr][nc] = map[nr][nc] + spread_amount;
					cnt++;
				}
			}
			
			// ���ǿ� ���� ���� ��ġ ����
			map[cr][cc] = map[cr][cc] - spread_amount * cnt >= 0 ? map[cr][cc] - spread_amount*cnt : 0;
		}
	}
	
	public static boolean isRange(int nr, int nc) {
		if(nr >=0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
	
	public static void operate() {
		int top = cleaner[0];
		int down = cleaner[1];
		
		// �ݽð� ����
	
		// ������ �Ʒ��� ����
		for(int i=top-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		// ���� �����ʿ��� �������� ����
		for(int i=0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		// ���� ��ܿ��� �Ʒ��� ���� ����
		for(int i=0; i<top; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// ���� �����ʿ��� ���ʿ� �ִ°� ����
		for(int i=C-1; i>1; i--) {
			map[top][i] = map[top][i-1];
			if(i == 2) {
				map[top][i-1] = 0; //����û���⿡�� ���� �ٶ��� 0����
			}
		}
		
		//����û���� ��ġ�� �ִ� �� ���ֱ�
		map[top][0] = -1; 
		
		// �ð� ����
		
		// �Ʒ����� ���δ���
		for(int i=down+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		// �������� ����
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		// ������ �Ʒ��� ����
		for(int i=R-1; i>down; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		// ���ʿ��� ������ ����
		for(int i=C-1; i>1; i--) {
			map[down][i] = map[down][i-1];
			if(i == 2) {
				map[down][i-1] = 0;
			}
		}
		
		// ����û���� ��ġ�� �ִ� �� ���ֱ�
		map[down][0] = -1;
	}
	
}
