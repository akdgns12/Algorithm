package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * ���� ó�� ������ ����
 * �Է¹��� ���̾ ������ move�Լ��� ���� map�� ���ο� ��ǥ�� �Ű��ش�.
 * 2���̻��� ���̾�� ����ĭ�� �ִ��� �ľ��ϱ� ���� visited���
 * �Ű��� �� �ش� ��ǥ�� ���� visited��  true��� ���ǿ� �°� ���̾ �����ϴ� �Լ� divideFire 
 */
// 2���� ����Ʈ �迭 ����!
/*
 * ����
 * 1. ���̾�� ������ ���� class �ϳ��� ������ y,x ��ǥ�� �����ؼ� ������ 2���� ����Ʈ �迭�� �ϳ� ���� ��
 * �ʱ�ȭ �� ��, �Է��� �޾� ���� ���̾�� ��´�.
 * 
 * 2. ���̾�� �̵���Ų��. �� �� ���� ���̾�� ������ ��� 2���� ����Ʈ�迭�� ���� �̵������ش�.
 * ���ο� 2���� ����Ʈ �迭�� �����ؼ� �̵��� �� �� ������ �迭�� �Ű�����. �� �� ������ ����� ������� ���� �ƴ�
 * "�ݴ��� �������� ������ �Ϳ� ����"����. ��, ���ǵ� �ִ�ġ�� 1000���� �������� �ξ� ū���� ������ ��쵵 �����Ƿ� 
 * speed % n ���ִ� ���� ���� ����
 * 
 * 3. ������ ���̾�� ������ �� 4���� ���̾�� �и��Ѵ�. ����2���� ����� �迭�� �̿��ؼ� ������ ���̾�� �ִ��� �Ǵ�.
 * ������ ���̾�� �ִٸ� �и����ִµ� �̶� ��� ¦�� �����̰ų� ��� Ȧ�� ������ ��츦 �� �Ǵ��ؼ� �и�. ������ ���̾�� 
 * ������ �ϳ��� ¦���� Ȧ���� false���ְ� �ϳ��� Ȧ���� ¦���� false���ָ� �ȴ�.
 * 
 * 4. ���� 2, ���� 3�� k�� �ݺ��� �� ���� ���̾�� ������ ���� ���ϸ� ����.
 */
// ���̾�� �ʿ��밡 ��ġ�ϴµ� �� ĭ�� ���̾�� ������ ���� �� �����Ƿ� 
// 2���� �迭 ����Ʈ�� ��� -> �̷��� �ϸ� map[x][y] ��ǥ�� �������� ���̾ ��ü�� �־��� �� �ִ�.
/*
 * ����
 * 1. Fireball�� ArrayList�� list�� �����Ѵ�.
 * 2. move�� ���ָ鼭 �̵��� ��ġ�� 2���� ArrayList�� Map�� ���� Fireball�� �߰����ش�.
 *   - �̶�, fireball�� ��ġ�� ������Ʈ ����� �ϰ� N * N�� ������ �ʰ��� �� ���̾�� ������°�
 *   �ƴ϶� N * N�� �ݺ��Ǵ� ������  %�� �� Ȱ�����ش�.
 * 3. Map�� 1�̸� ���̾�� ���� �ʿ䰡 �����Ƿ� continue�� ���ִµ�, �� �� Map�� �ʱ�ȭ ���ش�.(�ֳĸ� ���߿� map�� 
 * ��� ���ο� ���̾ ��ġ�� �߰������ �Ǳ� ������, ������ ���̾�� list�� ���� �����ϱ� ������ ��¥�� ������� �ʴ´�..)
 * 4. �� ��ġ�� �ִ� ���̾�� ��� ¦���ų� Ȧ���� ��츦 ã�� ������ �� �����ָ� �ȴ�.
 */
public class ������������̾ {
	static class Fireball{
		int r, c, m, s, d;
		
		Fireball(int r, int c, int m, int s, int d){
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N; // map ũ�� NxN
	static int M; // ���̾ ����
	static int K; // �̵� Ƚ��
	
	static ArrayList<Fireball>[][] map; // ���� Fireball
	static ArrayList<Fireball> list = new ArrayList<>(); // Fireball ����
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // �ȹ� �ð���� ���� : ��, ���, ��, ����, ��, ����, ��, �»�
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; 
	
	static ArrayList<Integer> dir = new ArrayList<>();
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Fireball(r, c, m, s, d));
		}
		
		for(int i=0; i<K; i++) {
			Move();
			checkFireball();
		}
		
		int answer = 0;
		for(Fireball cur : list) 
			answer += cur.m;
			
			System.out.println(answer);
	}
	// 2�� �̻��� ���̾ ������ �˻�
	public static void checkFireball() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() == 1)
					map[i][j].clear(); // map�� �ʱ�ȭ�ϰ� fireball�� list�� ������ �������.
									// ���� move���� ������ �˾Ƽ� ����
				if(map[i][j].size() < 2)
					continue;
				
				int massSum = 0, speedSum = 0;
				
				boolean even = map[i][j].get(0).d % 2 == 0 ? true : false;
				
				boolean odd = map[i][j].get(0).d % 2 == 1 ? true : false;
				
				for(Fireball cur : map[i][j]) {
					massSum += cur.m;
					speedSum += cur.s;
					even = even & cur.d % 2 == 0 ? true : false;
					odd = odd & cur.d % 2 == 1 ? true : false;
					
					list.remove(cur);
				}
				
				int newMass = massSum / 5;
				int size = map[i][j].size();
				map[i][j].clear();
				
				if(newMass == 0)
					continue;
				int newSpeed = speedSum / size;
				if(even | odd) { // ��� Ȧ���ų�, ��� ¦���� ��
					for(int k=0; k<8; k += 2) {
						list.add(new Fireball(i, j, newMass, newSpeed, k));
					}
				}else { // Ȧ¦ ���� ���� ��� (false, false)
					for(int k=1; k<8; k += 2) {
						list.add(new Fireball(i, j, newMass, newSpeed, k));
					}
				}
			}
		}
	}
	
	// fireball �̵�
	public static void Move() {
		for(Fireball fb : list) {
			int nr = (fb.r + N + dr[fb.d] * (fb.s % N))	% N;
			// out�� �ƴ϶� ����Ǿ� �־ �ٽ� �ݺ��� 3�� 3���� ũ��� ���� �� 0 1 2 0 1 2...
			int nc = (fb.c + N + dc[fb.d] * (fb.s % N)) % N;
			
			//update
			fb.r = nr;
			fb.c = nc;
			map[nr][nc].add(fb);
		}
	}
}
