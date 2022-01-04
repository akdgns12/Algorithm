package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import 매일코딩.마법사상어와파이어볼.Fireball;

public class 복습3_마법사와상어와파이어볼{
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
	
	public static void main(String[] args)  throws IOException{
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
		int r = Integer.parseInt(st.nextToken());  // 행
		int c = Integer.parseInt(st.nextToken());  // 열
		int m = Integer.parseInt(st.nextToken());  // 질량
		int s = Integer.parseInt(st.nextToken());  // 속도(칸)
		int d = Integer.parseInt(st.nextToken());  // 방향
		
		list.add(new Fireball(r,c,m,s,d)); // ArrayList인 list에 입력받은 파이어볼 정보를 저장
	}
	
	for(int time = 0; time < K; time++) {
		Move();
		checkFireball();
	}
	
	int answer = 0;
	for(Fireball cur : list) {
		answer += cur.m;
	}
	System.out.println(answer);
	
	}
	
	// 2개 이상인 파이어볼 나누기 검사
	public static void checkFireball() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() == 1)
					map[i][j].clear(); // map은 초기화하고 fireball은 list에 있으니
									// 상관없음. 다음 move에서 움직일 알아서 예정
				if(map[i][j].size() < 2) // 2개이상이 아니라면 skip
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
				if(even | odd) { // 모두 홀수거나, 모두 짝수일 떄
					for(int k=0; k<8; k += 2) {
						list.add(new Fireball(i,j,newMass,newSpeed,k));
					}
				}else { // 홀짝 섞여 있을 경우 (false, false)
						for(int k=1; k<8; k += 2) {
							list.add(new Fireball(i,j,newMass, newSpeed, k));
						}
					}
				}
			}
		}
		
		//fireball 이동
		public static void Move() {
			
			for(Fireball fb : list) {
				int nr = (fb.r + N + dr[fb.d] * (fb.s % N)) % N;
				// 범위 벗어나는게 아니라 연결되어 있어서 다시 반복됨 0 1 2 0 1 2... 만약 N이 3이라했을때
				int nc = (fb.c + N + dc[fb.d] * (fb.s % N)) % N;
				
				//update
				fb.r = nr;
				fb.c = nc;
				map[nr][nc].add(fb);
			}
		}
	}
