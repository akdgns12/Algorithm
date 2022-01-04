package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어른상어 {
	// BOJ 19237 / 골드 3 / 어른상어 / 완탐
	static class Shark{ // 1번부터 M번까지 상어의 좌표와 방향정보
		int x, y, dir;
		
		public Shark(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int N, M, K;
	static int[][] restTime; // 각 칸마다 냄새가 없어지기까지 남은 시간
	static int[][] smell;; // 각 칸에의 냄새를 뿌린 상어의 번호(냄새가 없으면 번호0)
	static int[][][] priority; // 상어마다 현재 방향에서의 우선순위  ex) priority[m][1][0] m번 상어의 방향이 위쪽(1)일때, 0번쨰 우선순위
	static Shark[] shark; // 1번부터 M번까지 상어의 좌표와 방향정보
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 상어 갯수
		K = Integer.parseInt(st.nextToken()); // 냄새시간 -> 냄새시간 사라질때까지 이동
		
		restTime = new int[N+1][N+1];
		smell = new int[N+1][N+1];
		priority = new int[M+1][5][4];
		shark = new Shark[M+1];
		
		// 상어 정보 입력받고 Shark 클래스에 x,y, 방향 0으로 일단 넣기
		// 냄새시간 K
		// smell 해당 칸에 냄새를 뿌린 상어 번호(냄새 없으면 0)
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(n > 0) { // 상어번호
					shark[n] = new Shark(i,j,0);
					restTime[i][j] = K;
					smell[i][j] = n;
				}
			}
		}
		
		// 초기 상어 방향
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			shark[i].dir = Integer.parseInt(st.nextToken());
		}
		
		for(int m=1; m<=M; m++) {
			for(int i=1; i<=4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				priority[m][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}	
		
		System.out.println(solve());
		/*
		 * 1 상하좌우 중에서 상어의 새로운 이동위치(nx, ny)를 찾는다
		 *  1-1. 상어의 현재 방향을 기준으로 가장 우선순위가 높은 방향부터 탐색한다
		 *  탐색 도중, 냄새가 없고 인접한 위치를 찾으면 탐색 종료
		 * 2. 만약 모두 탐색했는데 냄새가 없는 곳이 없다면, 자기 자신의 냄새가 있는 
		 * 인접한 곳을 찾는다.
		 * 마찬가지로 현재 방향을 기준으로 가장 우선순위가 높은 방향부터 탐색한다.
		 */
	}
	
	public static int solve() {
		int time = 0;
		
		while(true) {
			int count = 0; // 남은 상어 갯수 세기 용도의 변수
			for(int m=1; m<=M; m++) {
				if(shark[m] != null) {
					count++;
				}
			}
			
			if(count == 1 && shark[1] != null) { // 1번 상어 혼자남은 경우
				return time;
			}
			
			// 1000초 지난 경우
			if(time >= 1000)
				return -1;
			
			// 임시배열(현재 상어보다 이전에 움직인 상어가 이동한 결과 넣을 곳)
			int[][] temp = new int[N+1][N+1];
			
			for(int m=1; m<=M; m++) {
				if(shark[m] != null) { // 상어가 경계안에 있다면
					moveShark(temp, m);
				}
			}
			
			
			// M마리의 상어 이동 모두 완료하고 나면, 각 칸마다 냄새 정보 업데이트 해야함
			// 시간이 하나 지났으므로 냄새의 유효시간을 하나씩 빼준다.
			// 냄새 유효기간 하나씩 줄이기
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(restTime[i][j] > 0) 
						restTime[i][j] --;
						
					if(restTime[i][j] == 0) // 냄새가 없으면
						smell[i][j] = 0; // 상어 번호 0 = 상어 없어짐
					
				}
			}
			
			
			// 4. 상어가 모두 이동한 후, 상어의 새로운 위치의 냄새정보와 위치를 설정해줌.
			// 아까 상어가 이동하면서 이동한 결과를 temp 2차원 배열에 저장함.
			// temp 2차원 배열을 하나씩 탐색하면서, (i,j)위치에 잇는 상어 번호 확인한 후,
			// 해당 위치의 냄새 유효기간(resttime[i][j])을 k로 설정하고, 냄새(smell[i][j])도 상어 번호를 넣어준다.
			// 이동 후의 상어 위치의 냄새 정보와 유효기간 초기화
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(temp[i][j] > 0) {
						restTime[i][j] = K;
						smell[i][j] = temp[i][j];
					}
				}
			}
			time++;
		} // end While
	}
	
	public static void moveShark(int[][] temp, int m) {
		int nx = 0;
		int ny = 0;
		int d = 0;
		
		boolean flag = false;
		
		// 1-1. 높은 우선순위부터 차례대로 탐색
		for(int i=0; i<4; i++) {
			d = priority[m][shark[m].dir][i];
			nx = shark[m].x + dx[d];
			ny = shark[m].y + dy[d];
			
			// 경계를 벗어나지 않으면서, 냄새가 없는 곳을 찾으면 break로 빠져나옴
			if( (nx >= 1 && nx <= N) && (ny >=1 && ny <= N) && smell[nx][ny] == 0) {
				flag = true;
				break;
			}
		}
		
		// 1-2. 냄새가 없는 곳이 없는 경우
		if(!flag) {
			for(int i=0; i<4; i++) {
				d = priority[m][shark[m].dir][i];
				nx = shark[m].x + dx[d];
				ny = shark[m].y + dy[d];
				// 범위를 벗어나지 않고, 자기자신의 냄새가 있는 곳을 찾아 빠져나옴
				if((nx >= 1 && nx <= N) && (ny >= 1 && ny <= N) && smell[nx][ny] == m) {
					break;
				}
			}
			
			// 2.
			if(temp[nx][ny] == 0) { // 이전에 이동한 상어가 없다는 뜻(비어있으니까)
				// 이 자리에 현재 상어의 번호 넣어주고 현재상어의 위치정보와 방향 변경해준다.
				temp[nx][ny] = m;
				shark[m].x = nx;
				shark[m].y = ny;
				shark[m].dir = d;
			}else { // temp[nx][ny] !=0 -> 이전에 이동한 상어가 해당좌표에 이미 있다.
				// for문으로 인해 이전 상어의 번호는 현재상어보다 작다. 즉, 현재상어는 쫓겨난다.
				shark[m] = null; // 쫓겨나는걸 의미
			}
		}
	}
}
