package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_���ÿ� {
	static class Shark{
		int r; //�� ��ġ
		int c; // ����ġ
		int s; // �ӷ�
		int d; // ����
		int z; // ũ��
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int R,C,M;
	static int result = 0;
	static int[] dr = {-1,0,1,0}; // �����Ͽ�
	static int[] dc = {0,-1,0,1};
	
	static Shark[][] map; // �������� ��� ��� ��ü�� ������ RxC�� 2�����迭�� �����.
						 // �׸��� �� �����ǿ� �־��� ����� ������ �������� ��� Ŭ������ �ν��Ͻ��� ����
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// ��� ���� ������ �����, �� ��ġ�� ��� Ŭ������ ���� �ν��Ͻ� ����
		map = new Shark[R][C];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1; // ����� r
			int c = Integer.parseInt(st.nextToken()) - 1; // ����� c
			int s = Integer.parseInt(st.nextToken()); // �ӷ�
			int d = Integer.parseInt(st.nextToken()); // ����
			int z = Integer.parseInt(st.nextToken()); // ũ��
			
			// ���� ���� �ޱ� ���� ���Ͽ���(1,2,3,4) -> �����Ͽ� (0,1,2,3)
			if(d == 1) 
				d = 0;
			else if(d == 4)
				d = 1;
			
			map[r][c] = new Shark(r,c,s,d,z); // �����ǿ� ��� ����
		}
		
		for(int col = 0; col < C; col++) { // ���� ������ �ݺ�
			// 1. ���ÿ� �̵�
			for(int row = 0; row < R; row++) {
				if(map[row][col] != null) {
					result += map[row][col].z; // 2. ���� ����� ��� ũ�� ���� ������ ����
					
					map[row][col] = null; // map���� ��� ���ֱ�
					break;
				}
			}
			
			// 3. ��� �̵�
			Queue<Shark> q = new LinkedList<>();
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] != null) { // ���� map�� �ִ� ���� ť�� �߰�
						q.add(new Shark(i,j,map[i][j].s, map[i][j].d, map[i][j].z));
					}
				}
			}
			
			map = new Shark[R][C]; // ���ο� ������ ����� ���� �迭 �ʱ�ȭ
			
			// ��� ��� �Ѹ����� ������ �̵�
			while(!q.isEmpty()) {
				Shark sm = q.poll();
				
				// �ӷ¸�ŭ ��� �̵� ��Ű��
				int speed = sm.s; // �ð� �ʰ��� �ּ����� �̵��� ���� ������ ����
				
				if(sm.d == 0 || sm.d == 2) // �� ��
					speed %= (R-1) * 2;
				else if(sm.d == 1 || sm.d == 3) // �� ��
					speed %= (C-1) *  2;
				
				for(int s=0; s<speed; s++) {
					// ���� r,c�� ���⿡ �°� 1ĭ�� �߰��ϸ� ��ġ �̵�
					
					int nr = sm.r + dr[sm.d];
					int nc = sm.c + dc[sm.d];
					
					// �̵��� ���ο� ��ġ�� ������ ��� ���� �ε�����
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
						sm.r -= dr[sm.d]; // �ٽ� �� �����ְ�
						sm.c -= dc[sm.d];
						sm.d = (sm.d+2) % 4; // ���� �ݴ��
						
						continue;
					}
					
					// ��ġ ����� �������� ���ο� ��ġ�� �̵�
					sm.r = nr;
					sm.c = nc;
				}
				
				// 4. ���ο� ��ġ�� �� �������� �̹� �� �ִ��� Ȯ��
				if(map[sm.r][sm.c] != null) { //�̹� �� �ִٸ� �� ��� ũ�� ��
					if(map[sm.r][sm.c].z < sm.z) { // ���� ���� ���� �� ũ�ٸ�
						map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z); // ���� ��� �־���
					}
				}else { // ���ٸ� ���� ��� �ٷ� �־���
					map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
				}
				}
		}// �̵� for�� ��
		
		System.out.println(result);
	}
}
