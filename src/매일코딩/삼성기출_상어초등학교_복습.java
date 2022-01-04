package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class 삼성기출_상어초등학교_복습 {
	static int[][] classroom, nearEmptySeatCnt;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Student{ // 학생들의 좌표정보와 친한친구 목록을 담은 리스트
		int x;
		int y;
		int[] flist;
		
		public Student(int x, int y, int[] flist) {
			this.x = x;
			this.y = y;
			this.flist = flist;
		}
	}
	
	static Map<Integer, Student> list = new HashMap<>(); // key : 학생번호, value : Student 객체, 한 학생이 자리를 고르고 나면 list에 넣는다

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.valueOf(br.readLine());
		int N2 = N*N;
		int answer = 0;
		classroom = new int[N][N];
		// 본격적으로 학생들의 자리를 선정하기 전에, 주변에 비어있는 자리가 얼마나 있는지 저장
		fillNearEmptySeat();
		
		// 정보입력
		// 자리를 찾아갈 findSeat함수의 파라미터로 num과 int[]를 넘겨준다.
		// int[] 배열은 자리찾기에서 이미 자리를 찾은 친한 친구가 있는지 찾는데 사용되고
		// 자리를 찾고나서 친구목록을 담아 student 객체를 list에 넣을때도 사용된다.
		for(int i=0; i<N2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.valueOf(st.nextToken());
			int s1 = Integer.valueOf(st.nextToken());
			int s2 = Integer.valueOf(st.nextToken());
			int s3 = Integer.valueOf(st.nextToken());
			int s4 = Integer.valueOf(st.nextToken());
			
			findSeat(num, new int[] {s1,s2,s3,s4});
		}
		
		// 만족도 검사
		// list에서 1번 학생부터 꺼내서 친한 친구들과의 거리를 잰다.
		// 거리가 1이면 인접하므로 cnt를 1씩 증가시킨다.
		// 4명을 다돌아서 cnt값이 정해지면, 해당되는 만족도를 answer에 더해준다.
		for(int i=1; i<=N2; i++) {
			Student student = list.get(i);
			int cnt = 0;
			for(int friend : student.flist) {
				if(Math.abs(list.get(friend).x -student.x) + Math.abs(list.get(friend).y - student.y) == 1) {
					cnt++;
				}
			}
			
			if(cnt==1) answer+=1;
			else if(cnt==2) answer+=10;
			else if(cnt==3) answer+=100;
			else if(cnt==4) answer+=1000;
		}
		
		System.out.println(answer);
		
	}
	
	// 2차원 배열 nearScore를 선언. 이 배열은 친한친구 자리가 이미 선정 되었다면
	// 친구와 인접한 곳의 점수를 높여 우선적으로 선택할 수 있게 체크하는 배열
	// 먼저 넘겨받은 int 배열을 가지고 list에 등록된(이미 자리를 찾은)친구들이 있는지 확인한다.
	// 그 친구들의 4방 중 빈곳의 점수를 높인다.
	// 0,0부터 탐색하면서 nearScoreMax(nearScore 중 점수가 높은 곳)을 1순위로, 그 다음은
	// emptyCntMax(nearEmptySeatCnt 중 점수가 높은 곳)를 2순위로 적당한 자리를 찾아나간다.
	// 자리를 찾은 이후에는 list에 집어넣고, 선정된 자리의 nearEmptySeatCnt 4방을 1씩 낮춰준다.
	private static void findSeat(int num, int[] friends) {
		int[][] nearScore = new int[N][N]; //주변에 친한 친구가 많은 위치를 찾기 위한 배열(1번 조건 만족시키기 위해 진행하는 과정)
		for(int friend : friends) {
			if(list.containsKey(friend)) {
				Student student = list.get(friend);
				int x = student.x;
				int y = student.y;
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx>=0 && nx <N && ny >=0 && ny < N && classroom[nx][ny] == 0) {
						nearScore[nx][ny]++;
					}
				}
			}
		}
		
		int emptyCntMax = -1;
		int nearScoreMax = -1;
		int choiceX = -1;
		int choiceY = -1;
		
		// 2번 조건 만족을 위해 수행하는 과정
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(classroom[i][j] != 0) continue; // 빈칸이 아니라면 스킵
				if(nearScoreMax < nearScore[i][j]) {
					choiceX = i;
					choiceY = j;
					nearScoreMax = nearScore[i][j];
					emptyCntMax = nearEmptySeatCnt[i][j];
				} else if(nearScoreMax == nearScore[i][j] && emptyCntMax < nearEmptySeatCnt[i][j]) {
					emptyCntMax = nearEmptySeatCnt[i][j];
					choiceX = i;
					choiceY = j;
				}
			}
		}
		
		classroom[choiceX][choiceY] = num;
		list.put(num, new Student(choiceX,choiceY, friends));
		
		for(int i=0; i<4; i++) {
			int nx = choiceX+dx[i];
			int ny = choiceY+dy[i];
			if(nx>=0 && nx <N && ny >=0 && ny < N && classroom[nx][ny] == 0) {
				nearEmptySeatCnt[nx][ny]--;
			}
		}
	}
	
	private static void fillNearEmptySeat() {
		nearEmptySeatCnt = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 4;
				if(i==0 || i==N-1) cnt--;
				if(j==0 || j==N-1) cnt--;
				nearEmptySeatCnt[i][j] = cnt;
			}
		}
	}

}
