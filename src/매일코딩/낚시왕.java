package �����ڵ�;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ����
 * sharkŬ������ �����ؼ� ����� ��ǥ, ũ��, �ӷ�, ������ �����ϰ�.
 * �� ������ ��Ƶ� shark HashMap �ڷᱸ�� ���
 * 
 * ����� ũ��� �ߺ����� �ʴ´ٴ� ������ �ֱ� ������ Ű���� ����� ũ��� ����
 * 
 * ��� �� �̵��� �Ŀ� ũ�⸦ ���ϵ��� temp�迭�� ���� �����ؼ� ����� �� �ٽ�
 * arr�迭�� ����� ��� ���
 * 
 * ����� �̵��� �ΰ��� ����� �ִµ� �ϳ��� ��ǥ�� ���� �����ؼ� �ѹ��� ���ϴ°Ű�
 * �ٸ� �ϳ��� �ݺ������� ������ �̵��ϴ� ��.
 * 
 */
public class ���ÿ� {
	public static int R, C, M;
	public static Shark[][] map;
	public static int answer = 0;
	public static int dx[] = {-1, 0, 1, 0}; //�� �� �� �� �� 
	public static int dy[] = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		//�Է� �ޱ� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // ���� ��
		C = Integer.parseInt(st.nextToken()); // ���� ��
		M = Integer.parseInt(st.nextToken()); // ����� ��

		// ��� ���� ������ �����, �� ��ġ�� ��� Ŭ������ ���� �ν��Ͻ� ���� 
		map = new Shark[R][C];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()); // �� ��ġ 
			int c = Integer.parseInt(st.nextToken()); // �� ��ġ 
			int s = Integer.parseInt(st.nextToken()); // �ӷ� 
			int d = Integer.parseInt(st.nextToken()); // �̵� ���� 
			int z = Integer.parseInt(st.nextToken()); // ũ�� 
 
			// ���� ���� �ٲٱ����� �Է¹��� ���Ͽ���(1 2 3 4) -> �����Ͽ�(0 1 2 3)�� ���� 
			if(d == 1)
				d = 0;
			else if(d == 4)
				d = 1;
            
			map[r-1][c-1] = new Shark(r-1, c-1, s, d, z); // �����ǿ� ��� ���� 
		}

		
		for(int col = 0; col < C; col++) { // ���� ������ �ݺ� 
			// 1. ���ÿ� �̵� 
			for(int row = 0; row < R; row++) {
				if(map[row][col] != null) { 
					answer += map[row][col].z; // 2. ���� ����� ��� ũ�� ���� ������ ���� 
					map[row][col] = null; // map���� ��� ���ֱ� 
					break;
				}
			}

			// 3. ��� �̵� 
			Queue<Shark> queue = new LinkedList<>(); 
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] != null) { // ���� map�� �ִ� ���� ť�� �߰� 
						queue.add(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
					}
				}
			}

			map = new Shark[R][C]; // ���ο� ������ ��������� �迭 �ʱ�ȭ 

			// ��� ��� �Ѹ����� ������ �̵� 
			while(!queue.isEmpty()) {
				Shark sm = queue.poll();
                
				// �ӷ¸�ŭ ��� �̵� ��Ű�� 
				int speed = sm.s; // �ð��ʰ��� �ּ����� �̵��� ���� ������ ����
				if(sm.d == 0 || sm.d == 2) //�� ��
					speed %= (R -1) * 2; 
				else if(sm.d == 1 || sm.d == 3) //�� ��
					speed %= (C -1) * 2;
				
				for(int s = 0; s < speed; s++) {
					// ���� r, c�� ���⿡ �°� 1ĭ�� �߰��ϸ� ��ġ �̵� 
					int newR = sm.r + dx[sm.d]; 
					int newC = sm.c + dy[sm.d];

					// �̵��� ���ο� ��ġ�� ������ ��� ���� �ε����� 
					if(newR < 0 || newR >= R || newC < 0 || newC >= C) { 
						sm.r -= dx[sm.d]; // �ٽ� �� �����ְ� 
						sm.c -= dy[sm.d];
						sm.d = (sm.d + 2) % 4; // ���� �ݴ�� 
						continue;
					}

					// ��ġ ����� �������� ���ο� ��ġ�� �̵� 
					sm.r = newR; 
					sm.c = newC;
				}

				// 4. ���ο� ��ġ�� �� �������� �̹� �� �ִ��� Ȯ��
				if(map[sm.r][sm.c] != null) { // �̹� �� �ִٸ� �� ��� ũ�� �� 
					if(map[sm.r][sm.c].z < sm.z) { // ���� ���� ���� �� ũ�ٸ� 
						map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z); // ���� ��� �־��� 
					} 
				} else { // ���ٸ� ���� ��� �ٷ� �־��� 
					map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
				}
			}
		} // �̵� for�� �� 

		System.out.println(answer);
	}
}

//��� ������ ������ ��� Ŭ���� 
class Shark {
	int r;
	int c;
	int s;
	int d;
	int z;

	Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
