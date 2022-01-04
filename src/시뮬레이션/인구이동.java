package �ùķ��̼�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N*Nũ���� ��, ������ ������ ���� �ϳ��� ����
 * r�� c�� A[r][c]���� ��� �ִ�. ������ ���󿡴� ������ ����.
 * �α��̵� ���� - ���ǿ� �°� ���̻� �α��̵��� ���� ������ ���
 * 1. ���漱�� �����ϴ� �� ������ �α����̰� L�� �̻�, R�����϶�� 
 * �γ��� �����ϴ� ���漱�� ���� �Ϸ絿�� ����
 * 2. ���� ���ǿ� ���� ������ϴ� ���漱�� ��� ���ȴٸ�, �α��̵� ����
 * 3. ���漱�� �����־� ������ ĭ���� �̿��� �̵��� �� �ִٸ� �� ����
 * ���� �Ϸ� ������ �����̶��Ѵ�
 * 4.������ �̷�� �ִ� �� ĭ�� �α����� (������ �α���) / (������ �̷�� �ִ� ĭ�� ����)
 * �Ҽ����� ������
 * 5. ������ ��ü�ϰ� ��� ���漱�� �ݴ´�
 */
public class �α��̵� {
	static int N,L,R;
	static int[][] map;
	static int[][] visited = new int[50][50];
	static int cnt; // ������ �̷�� �� ����
	
	static int find(int r, int c, int value) {
		if(r < 0 || r > N-1 || c < 0 || c > N-1) return 0;
		if(visited[r][c] != 0) return 0;
		
		if(value != -1) {
		int diff = Math.abs(value - map[r][c]);
		if(diff < L || diff > R) return 0;
		}
		
		visited[r][c] = 1;
		cnt++;
		
		int sum = map[r][c];
		sum += find(r-1, c, map[r][c]);
		sum += find(r+1, c, map[r][c]);
		sum += find(r, c-1, map[r][c]);
		sum += find(r, c+1, map[r][c]);
		
		return sum; // sum = ������ �̷�� �� �α� ��
	}
	
	static void move(int r, int c, int value) {
		if(r < 0 ||  r > N-1 || c < 0 || c> N-1) return;
		if(visited[r][c] != 1) return;
		
		visited[r][c] = 2;
		
		map[r][c] = value;
		move(r-1, c, value);
		move(r+1, c, value);
		move(r, c-1, value);
		move(r, c+1, value);
	}
	// visited[i][j] = 0, 1, 2 = �湮 �������� ��, ������ �̷�� ����, �α��̵� ��ģ��;
	static int solve() {
		int ret = 0;
		boolean flag;
		
		do {
			flag = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = 0;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] == 0) {
					    cnt = 0;
						int sum = find(i,j,-1);
						if( cnt > 1) { // ������ �̷�� �� ������ 2���̻��̸� move(�α��̵�)����
							flag = true;
							move(i, j, sum / cnt);
						} else {
							visited[i][j] = 2;
						}
					}
				}
			}
			if(flag) ret++;
		}while(flag);
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[50][50];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve());
	}
}
