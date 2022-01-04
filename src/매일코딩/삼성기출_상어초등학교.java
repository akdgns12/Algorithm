package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 	조건에 맞게 map에 학생들 자리배치시키고 
 	각 학생들의 만족도 구한 후 총합 return
 * 
 * 만족도
   0명 : 0, 1명 : 1, 2명 : 10, 3명 : 100, 4명 : 1000
 */
/*
 * <아이디어> 자료구조
 * 클래스 선언
 * - 좌표 정보와 친한친구 목록을 담은 Student 클래스를 만들어 두어야 풀이가 수월할 듯.
 * 한 사람의 좌석을 선택할 때, 친한 친구들의 위치를 먼저 파악하기도 해야하고, 마지막에 정답을 출력할 때 만족도 계산을 위해서도 필요
 * 
 * 정보를 담을 리스트
 * 번호를 가지고, 학생들을 다루기 위해 Map을 사용
 * 학생들의 리스트라는 뜻으로 변수명 list
 * key값으로 학생번호, value값으로 Student 객체
 * 한 학생이 자리를 고르고 나면, list에 집어넣는다.
 */
public class 삼성기출_상어초등학교 {

	// nearEmptySeatCnt
	/*
	 * 본격적으로 학생들의 자리를 선정하기 전에, 미리 [N][N]의 크기의 배열로
	 * 주변에 비어있는 자리가 얼마나 있는지를 저장
	 */
	static int[][] map, nearEmptySeatCnt;
	static int N;
	static int[] dx = {-1,1,0,0}; // 상 하 좌 우 (인접한 곳)
	static int[] dy = {0,0,-1,1};
	
	static class Student{
		int x;
		int y;
		int[] flist;
		
		public Student(int x, int y, int[] flist) {
			this.x = x;
			this.y = y;
			this.flist = flist;
		}
	}
	
	// key : 학생번호, value : Student 객체
	static Map<Integer, Student> list = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.valueOf(br.readLine());
		int N2 = N*N;
		int answer = 0;
		map = new int[N][N];
		fillNearEmptySeat();
		
		for(int i=0; i<N2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.valueOf(st.nextToken());
			int s1 = Integer.valueOf(st.nextToken());
			int s2 = Integer.valueOf(st.nextToken());
			int s3 = Integer.valueOf(st.nextToken());
			int s4 = Integer.valueOf(st.nextToken());
			
			findSeat(num, new int[] {s1,s2,s3,s4});
		}
		
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

	private static void findSeat(int num, int[] friends) {
		int[][] nearScore = new int[N][N]; //주변에 친한 친구가 많은 위치를 찾기 위한 배열
		for(int friend : friends) {
			if(list.containsKey(friend)) {
				Student student = list.get(friend);
				int x = student.x;
				int y = student.y;
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx>=0 && nx <N && ny >=0 && ny < N && map[nx][ny] == 0) {
						nearScore[nx][ny]++;
					}
				}
			}
		}
		
		int emptyCntMax = -1;
		int nearScoreMax = -1;
		int choiceX = -1;
		int choiceY = -1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) continue;
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
		
		map[choiceX][choiceY] = num;
		list.put(num, new Student(choiceX,choiceY, friends));
		
		for(int i=0; i<4; i++) {
			int nx = choiceX+dx[i];
			int ny = choiceY+dy[i];
			if(nx>=0 && nx <N && ny >=0 && ny < N && map[nx][ny] == 0) {
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
