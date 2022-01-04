package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게리맨더링2 {
	static int N;
	static int[][] map;
	static int totalPeople = 0;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				totalPeople += map[i][j];
			}
		}
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				for(int d1=1; d1<N; d1++) {
					for(int d2=1; d2<N; d2++) {
						if(x + d1 + d2 >= N)
							continue;
						if(y - d1 < 0 || y + d2 >= N)
							continue;
						
						solution(x,y,d1,d2);
					}
				}
			}
		}
		System.out.println(min);
	}
	
	public static void solution(int x, int y, int d1, int d2) {
		boolean[][] border = new boolean[N][N];
		
		// 경계선 세팅
		for(int i=0; i<=d1; i++) {
			border[x+i][y-i] = true; // 좌상 경계선
			border[x+d2+i][y+d2-i] = true; // 우하 경계선
		}
		
		for(int i=0; i<=d2; i++) {
			border[x+i][y+i] = true;
			border[x+d1+i][y-d1+i] = true;
		}
		
		int[] peopleSum = new int[5];
		
		// 1구역 인구수
		for(int i=0; i<x+d1; i++) {
			for(int j=0; j<=y; j++) {
				if(border[i][j]) break;
				peopleSum[0] += map[i][j];
			}
		}
		
		//2구역 인구수
		for(int i=0; i<=x+d2; i++) {
			for(int j=N-1; j>y; j--) {
				if(border[i][j]) break;
				peopleSum[1] += map[i][j];
			}
		}
		
		//3구역 인구수
		for(int i=x+d1; i<N; i++) {
			for(int j=0; j<y-d1+d2; j++) {
				if(border[i][j]) break;
				peopleSum[2] += map[i][j];
			}
		}
		
		//4구역 인구수
		for(int i=x+d2+1; i<N; i++) {
			for(int j=N-1; j>=y-d1+d2; j--) {
				if(border[i][j]) break;
				peopleSum[3] += map[i][j];
			}
		}
			
			//5구역 인구수
			peopleSum[4] = totalPeople;
			
			for(int i=0; i<4; i++) {
				peopleSum[4] -= peopleSum[i];
			}
			
			Arrays.sort(peopleSum);
			
			// 최대 - 최소
			min = Math.min(min, peopleSum[4] - peopleSum[0]);
		}

	}

