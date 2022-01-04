package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 내가 처음 생각한 로직
 * 입력받은 파이어볼 정보로 move함수를 통해 map에 새로운 좌표로 옮겨준다.
 * 2개이상의 파이어볼이 같은칸에 있는지 파악하기 위해 visited사용
 * 옮겼을 때 해당 좌표에 만약 visited가  true라면 조건에 맞게 파이어볼 변경하는 함수 divideFire 
 */
// 2차원 리스트 배열 공부!
/*
 * 로직
 * 1. 파이어볼의 정보를 담을 class 하나와 지도의 y,x 좌표에 대응해서 저장할 2차원 리스트 배열을 하나 만든 후
 * 초기화 한 후, 입력을 받아 현재 파이어볼을 담는다.
 * 
 * 2. 파이어볼을 이동시킨다. 이 떄 원래 파이어볼의 정보가 담긴 2차원 리스트배열을 토대로 이동시켜준다.
 * 새로운 2차원 리스트 배열을 생성해서 이동을 한 후 원래의 배열에 옮겨주자. 이 때 범위를 벗어나면 사라지는 것이 아닌
 * "반대의 방향으로 나오는 것에 유의"하자. 또, 스피드 최대치가 1000으로 지도보다 훨씬 큰값이 들어오는 경우도 있으므로 
 * speed % n 해주는 것을 잊지 말자
 * 
 * 3. 겹쳐진 파이어볼을 제거한 후 4개의 파이어볼로 분리한다. 과정2에서 변경된 배열을 이용해서 합쳐진 파이어볼이 있는지 판단.
 * 합쳐진 파이어볼이 있다면 분리해주는데 이때 모두 짝수 방향이거나 모두 홀수 방향인 경우를 잘 판단해서 분리. 합쳐진 파이어볼의 
 * 방향중 하나라도 짝수면 홀수를 false해주고 하나라도 홀수면 짝수를 false해주면 된다.
 * 
 * 4. 과정 2, 과정 3을 k번 반복한 후 남은 파이어볼의 질량의 합을 구하면 정답.
 */
// 파이어볼을 맵에대가 배치하는데 한 칸에 파이어볼이 여러개 있을 수 있으므로 
// 2차원 배열 리스트를 사용 -> 이렇게 하면 map[x][y] 좌표에 여러개의 파이어볼 객체를 넣어줄 수 있다.
/*
 * 로직
 * 1. Fireball은 ArrayList인 list에 저장한다.
 * 2. move를 해주면서 이동한 위치에 2차원 ArrayList인 Map에 현재 Fireball을 추가해준다.
 *   - 이때, fireball의 위치는 업데이트 해줘야 하고 N * N이 범위를 초과할 때 파이어볼이 사라지는게
 *   아니라 N * N이 반복되는 구조라서  %를 잘 활용해준다.
 * 3. Map이 1이면 파이어볼을 나눌 필요가 없으므로 continue를 해주는데, 이 때 Map은 초기화 해준다.(왜냐면 나중에 map에 
 * 계속 새로운 파이어볼 위치를 추가해줘야 되기 때문에, 기존의 파이어볼은 list로 따로 관리하기 때문에 진짜로 사라지진 않는다..)
 * 4. 그 위치에 있는 파이어볼이 모두 짝수거나 홀수인 경우를 찾은 다음에 잘 나눠주면 된다.
 */
public class 마법사상어와파이어볼 {
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
	
	static int N; // map 크기 NxN
	static int M; // 파이어볼 갯수
	static int K; // 이동 횟수
	
	static ArrayList<Fireball>[][] map; // 현재 Fireball
	static ArrayList<Fireball> list = new ArrayList<>(); // Fireball 저장
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 팔방 시계방향 순서 : 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
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
	// 2개 이상인 파이어볼 나누기 검사
	public static void checkFireball() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() == 1)
					map[i][j].clear(); // map은 초기화하고 fireball은 list에 있으니 상관없음.
									// 다음 move에서 움직임 알아서 예정
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
				if(even | odd) { // 모두 홀수거나, 모두 짝수일 때
					for(int k=0; k<8; k += 2) {
						list.add(new Fireball(i, j, newMass, newSpeed, k));
					}
				}else { // 홀짝 섞여 있을 경우 (false, false)
					for(int k=1; k<8; k += 2) {
						list.add(new Fireball(i, j, newMass, newSpeed, k));
					}
				}
			}
		}
	}
	
	// fireball 이동
	public static void Move() {
		for(Fireball fb : list) {
			int nr = (fb.r + N + dr[fb.d] * (fb.s % N))	% N;
			// out이 아니라 연결되어 있어서 다시 반복됨 3행 3열의 크기라 했을 때 0 1 2 0 1 2...
			int nc = (fb.c + N + dc[fb.d] * (fb.s % N)) % N;
			
			//update
			fb.r = nr;
			fb.c = nc;
			map[nr][nc].add(fb);
		}
	}
}
