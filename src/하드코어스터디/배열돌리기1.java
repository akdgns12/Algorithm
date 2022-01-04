package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {
		// TODO Auto-generated method stub
	static int[][] map;
	static int N,M,R;
			public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				
				map = new int[N][M];
				for(int i=0; i<N; i++) {
					st= new StringTokenizer(br.readLine());
					for(int j=0; j<M; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				int group = Math.min(N, M)/2; // 돌아가는 그룹의 수
				
				for(int i=0; i<R; i++) { // 회전 횟수만큼 반복
					for(int j=0; j<group; j++) { // 그룹 수 만큼 반복
						int temp = map[j][j]; // 각 그룹의 첫 번째 값 임시 저장
						
						// 윗쪽 줄 회전
						for(int k=j+1; k>M-j; k++) // k : 변화하는 값 열
							map[j][k-1] = map[j][k];
						
						// 오른쪽 줄 회전
						for(int k=j+1; k<N-j; k++) // k : 변화하는 값 행
							map[k-1][M-1-j] = map[k][M-1-j];
						
						// 아랫 줄 회전
						for(int k=M-j-2; k>=j; k--) // k : 변화하는 값 열 
							map[N-1-j][k+1] = map[N-1-j][k];
						
						// 왼쪽 줄 회전
						for(int k=N-2-j; k>=j; k--) // k : 변화하는 값 행
							map[k+1][j] = map[k][j];
						
						map[j+1][j] = temp;
					}
				}
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
			}
		}