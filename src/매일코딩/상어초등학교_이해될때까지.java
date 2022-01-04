package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상어초등학교_이해될때까지 {
	static int[][] map;
	static int[][] friend;
	static int[] order;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int N2 = N*N;
		map = new int[N][N]; // 교실자리
		friend = new int[N2+1][4]; // 좋아하는 친구
		order = new int[N2]; // 학생 앉히는 순서
		
		for(int i=0; i<N2; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			order[i] = num;
			friend[num][0] = Integer.parseInt(st.nextToken());
			friend[num][1] = Integer.parseInt(st.nextToken());
			friend[num][2] = Integer.parseInt(st.nextToken());
			friend[num][3] = Integer.parseInt(st.nextToken());
		}
		
		map[1][1] = order[0]; // 첫번째 학생 자리 고정
		
		// 학생 하나씩 앉히기(i=1 부터 == 두번째 학생부터)
		for(int i=1; i<N2; i++) {
			int maxScore = -1;
			int r=-1, c=-1;
			int child = order[i]; // 학생번호
			
			// 전체 교실 확인
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k] != 0)
						continue;
					
					int score = 0;
					for(int d=0; d<4; d++) {
						int nx = j + dx[d];
						int ny = k + dy[d];
						
						// 범위 벗어나면 continue
						if(nx < 0 || nx >= N || ny < 0 || ny >= N)
							continue;
						
						// 빈칸이면 score+1
						if(map[nx][ny] == 0) {
							score++;
							continue;
						}
						
						for(int f=0; f<4; f++) { // 좋아하는 친구면 score+10
							if(map[nx][ny] == friend[child][f])
								score+=10;
						}
					}
					
					// 가중치 max값 업데이트
					if(score > maxScore) {
						maxScore = score;
						r = j;
						c = k;
					}
				}
			}
			map[r][c] = child;
		}
		
		// 만족도 계산
		for(int j=0; j<N; j++) {
			for(int k=0; k<N; k++) {
				int cnt = 0;
				int child = map[j][k];
			}
		}
	}
}
