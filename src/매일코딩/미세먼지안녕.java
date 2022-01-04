package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. �̼����� �ִ� �� "ť"�� ������ֱ�(���ʸ���)
 * 2. Ȯ�Ž�Ű�� �����ϱ�
 * 3. ����û���� �۵���Ű��
 */
public class �̼������ȳ� {
	static class Dust{
		int r,c,amount;
		
		public Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
	static int R,C; // ��, ��
	static int T; // T�� ��
	static int[][] map;
	static int[] dr = {-1,1,0,0}; // �� �� �� ��
	static int[] dc = {0,0,-1,1};
	
	static Queue<Dust> dust = new LinkedList<>();
	static int[] cleaner = new int[2]; // ���� û���� ��ġ [0] = ���, [1] = �Ϻ�
	static int answer = 0;
	
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
				
				// ���� û���� ��ġ
				if(map[i][j] == -1) {
					cleaner[idx++] = i;
				}
			}
		}
		
		//0. 1���� 2���� ��� �ݺ��ϴ°� 1�ʸ��� �ѹ��� - ����
		for(int t=0; t<T; t++) {
			//1. �̼������� �ִ� ��(��ǥ, ��) - original -> ť�� �� �־�α�
			makeQueue();
			// 2.map = Ȯ���Ű�� ����[������ ť�� �ִ°� �ϳ��� �����鼭]
			spread();
			//test
			//3. ����û���� �۵� ���Ѽ� �̼����� �̵���Ű��
			// * �������� : ����û���� �κа� ���� ��ġ�� ������ �̼��������� �����
			play();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) 
					answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
	
	public static void play() {
		 int top = cleaner[0];
		 int down = cleaner[1];
		 
		 // cleaner ��� �ݽð� ����
		 
		 // ���� �Ʒ��� ����
		 for(int i=top-1; i>0; i--) {
			 map[i][0] = map[i-1][0];
		 }
		 // �������� ����
		 for(int i=0; i<C-1; i++) {
			 map[0][i] = map[0][i+1];
		 }
		 // ���� ��ܿ��� �Ʒ��� ����
		 for(int i=0; i<top; i++) {
			 map[i][C-1] = map[i+1][C-1];
		 }
		 // ���� �����ʿ��� ���ʿ� �ִ°� ����
		 for(int i=C-1; i>1; i--) {
			 map[top][i] = map[top][i-1];
			 if(i == 2)
				 map[top][i-1] = 0;
		 }
		 
		 // ����û���� ��ġ�� �ִ� �� ���� ���ֱ�
		 map[top][0] = -1;
		 // cleaner �Ϻ� �ð� ����
		 // �Ʒ� �ִ°� ���� ����
		 for(int i=down+1; i<R-1; i++) {
			 map[i][0] = map[i+1][0];
		 }
		 // �������� ����
		 for(int i=0; i<C-1; i++) {
			 map[R-1][i] = map[R-1][i+1];
		 }
		 // �Ʒ��� ������
		 for(int i=R-1; i>down; i--) {
			 map[i][C-1] = map[i-1][C-1];
		 }
		 // ���� �����ʿ��� ���ʿ� �ִ°� ����
		 for(int i=C-1; i>1; i--) {
			 map[down][i] = map[down][i-1];
			 if(i == 2) 
				 map[down][i-1] = 0;
		 }
		 map[down][0] = -1;
	}
	
	public static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.println(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void spread() {
		// ���� ť�� �ִ°� �ϳ��� �����鼭 Ȯ�� ��Ű��
		while(!dust.isEmpty()) {
			// �ϳ� ����
			Dust cur = dust.poll();
			int cr = cur.r;
			int cc = cur.c;
			int camount = cur.amount;
			
			// �ֺ��� Ȯ���Ű��, Ȯ��� ���� ������
			int cnt=0;
			int spread_amount = camount / 5;
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				// �ʾȿ� �ְ�, ����û���Ⱑ ���� ��ġ��
				if(isIn(nr,nc) && map[nr][nc] != -1) {
					map[nr][nc] = map[nr][nc] + spread_amount;
					cnt++;
				}
			}
			
			// ���� ��ġ ���ҽ�Ű��
			map[cr][cc] = map[cr][cc] - spread_amount * cnt >= 0 ? map[cr][cc] - spread_amount * cnt : 0;
		}
	}
	
	public static boolean isIn(int nr, int nc) {
		if(nr >= 0 &&  nr < R && nc >=0 && nc < C)
			return true;
		return false;
	}
	
	public static void makeQueue() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				// ���� û���� ��ġ�� �ƴϰ�, ��� ���� ���Դ�, �� + �� + ������ �� ����
				if(map[i][j] !=0 && map[i][j] != -1)
					dust.add(new Dust(i,j,map[i][j]));
			}
		}
	}

}
