package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import �����ڵ�.������������̾.Fireball;

public class ����2_������ͻ������̾ {
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
	static int N,M,K;
	static ArrayList<Fireball> list = new ArrayList<>();
	static ArrayList<Fireball>[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N]; // 2���� ArrayList �迭
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new ArrayList<Fireball>(); 
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Fireball(r, c, m, s, d)); // ArrayList�� list�� �־��� ���̾ ������ ����
		}
		
		for(int time = 0; time < K; time++) {
			move();
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
					map[i][j].clear(); // map�� �ʱ�ȭ�ϰ� fireball�� list�� ������
									// �������. ���� move���� ������ �˾Ƽ� ����.
				if(map[i][j].size() < 2)
					continue;
				
				int massSum = 0, speedSum = 0;
				
				boolean even = map[i][j].get(0).d % 2 == 0 ? true : false;
				boolean odd = map[i][j].get(0).d % 2 == 0 ? true : false;
				
				for(Fireball cur : map[i][j]) {
					massSum += cur.m;
					speedSum += cur.s;
					even = even & cur.d % 2 == 0 ? true : false;
					odd = odd & cur.d % 2 == 0 ? true : false;
					
					list.remove(cur);
				}
			}
		}
	}
}
