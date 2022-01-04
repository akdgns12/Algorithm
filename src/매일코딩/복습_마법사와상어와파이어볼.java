package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 복습_마법사와상어와파이어볼 {
	static class Fireball{
		int r,c,m,s,d;
		
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
		
		map = new ArrayList[N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Fireball(r,c,m,s,d));
		}
		
		for(int time = 0; time<K; time++) {
			Move();
			checkFireball();
		}
		
		int answer = 0;
		for(Fireball cur : list) {
			answer += cur.m;
		}
		
		System.out.println(answer);
	}
	
	public static void checkFireball() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() == 1)
					map[i][j].clear();
				
				if(map[i][j].size() < 2)
					continue;
				
				boolean even = map[i][j].get(0).d % 2 == 0 ? true : false;
				
				boolean odd = map[i][j].get(0).d % 2 == 1 ? true : false;
				
				int massSum =0, speedSum = 0;
				
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
				if(even | odd) { // 모두 홀수거나, 모두 짝수일 떄
					for(int k=0; k<8; k += 2) {
						list.add(new Fireball(i,j,newMass,newSpeed,k));
					}
				}else { // 홀짝 섞여 있을 경우 (false, false)
					for(int k=1; k<8; k += 2) {
						list.add(new Fireball(i,j,newMass, newSpeed,k));
					}
				}
			}
		}
	}
	
	public static void Move() {
		for(Fireball fb : list) {
			int nr = (fb.r + N + dr[fb.d] * (fb.s % N)) % N;
			int nc = (fb.c + N + dr[fb.d] * (fb.s % N)) % N;
			
			// update
			fb.r = nr;
			fb.c = nc;
			map[nr][nc].add(fb);
		}
	}
}	
