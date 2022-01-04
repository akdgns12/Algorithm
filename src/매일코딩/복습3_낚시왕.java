package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����3_���ÿ� {
	static class Shark {
		int r,c,s,d,z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			
		}
	}
	static int R,C,M;
	static Shark[][] map;
	static int[] dr = {};
	static int[] dc = {};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(d == 1)
				d = 0;
			else if(d == 4)
				d = 1;
			
			map[r][c] = new Shark(r,c,s,d,z);
		}
		
		for(int col = 0; col < C; col++) {
			// ���ÿ� �̵�
			for(int row = 0; row < R; row++) {
				if(map[row][col] != null) { // �ΰ��� �ƴ϶�� �� �ִ� �� -> ��´�
					answer += map[row][col].z; // ���� ����� ��� ũ�� ���� ������ ����
					
					map[row][col] = null; // ��� ���� ��ġ null �� �ٲ��ְ�
					break;
				}
			}
			
			// ����̵�
			Queue<Shark> q = new LinkedList<>();
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) { // ���� map�� �ִ� ���� �߰�
					if(map[i][j] != null) {
						q.add(new Shark(i,j,map[i][j].s, map[i][j].d, map[i][j].z));
					}
				}
			}
			
			map = new Shark[R][C]; // ���ο� ������ ������ش�
			
			// ��� ��� �Ѹ����� ������ �̵�
			while(!q.isEmpty()) {
				Shark sm = q.poll();
				
				int speed = sm.s;
				
				if(sm.d == 0 || sm.d == 2) // �� ��
					speed %= (R-1) * 2;
				else if(sm.d == 1 || sm.d == 3) // �� ��
					speed %= (C-1) * 2;
				
				for(int s=0; s<speed; s++) {
					int nr = sm.r + dr[sm.d];
					int nc = sm.c + dc[sm.d];
					// ���� ��� ���� �ε�����
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
						sm.r -= dr[sm.d]; // �ٽ� �� �����ְ� ���� �ٲ۴�
						sm.c -= dc[sm.d];
						sm.d = (sm.d + 2) % 4;
						continue;
					}
					
					// ��ġ ����� ���� ���� ���ο� ��ġ�� �̵�
					sm.r = nr;
					sm.c = nc;
					
				}
				
				// ���ο� ��ġ�� ��������� �̹� �� �ִ� �������� Ȯ��
				if(map[sm.r][sm.c] != null) { // �̹� �� �ִٸ�
					if(map[sm.r][sm.c].z < sm.z) { // ���� ���� ���� �� ũ�ٸ�
						map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
					}else { // ���ٸ� ���� ��� �ٷ� �־���
						map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
					}
				}
			}// �̵� for�� ��
			System.out.println(answer);
		}
	}
}
