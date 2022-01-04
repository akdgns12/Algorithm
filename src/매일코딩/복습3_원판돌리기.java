package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습3_원판돌리기 {
	static int N, M, T;
	static int[][] circlePlate;
	static boolean isFindSameNumber = false;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		circlePlate = new int[N][M];
		for(int i=0; i<N; i++	) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				circlePlate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<=N; j++) {
				if(j % x == 0) {
					rotate(j-1, d, k);
				}
			}
			// 같은 숫자 인접해있는지 검사
			checkPlate();
		}
		System.out.println(sumOfPlate());
	}
	
	// 회전시키기 -> 배열 앞으로 밀거나 뒤로 밀거나
	public static void rotate(int x, int d, int k) {
		int[] rotateXPlate = new int[M];
		int index;
		for(int i=0; i<M; i++) {
			index = calculateIndex(d, i, k);
			rotateXPlate[index] = circlePlate[x][i];
		}
		circlePlate[x] = rotateXPlate;
	}
	
	public static int calculateIndex(int d, int i, int k) {
		if(d == 0) {
			return (i+k)%M;
		}
		if(i - k < 0)
			return M + (i - k);
		return i - k;
	}
	
	public static void checkPlate() {
		int nx, ny;
		boolean isErased = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				isFindSameNumber = false;
				if(circlePlate[i][j] != 0) {
					dfs(i, j, circlePlate[i][j]);
				}
				if(isFindSameNumber) {
					circlePlate[i][j] = 0;
					isErased = true;
				}
			}
		}
		if(!isErased) {
			calculatePlate();
		}
	}
	
	public static void calculatePlate() {
		double sum = 0;
		int totalNumber = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(circlePlate[i][j] != 0) {
					sum += circlePlate[i][j];
					totalNumber++;
				}
			}
		}
		
		double average = sum / totalNumber;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(circlePlate[i][j] != 0 && circlePlate[i][j] < average) {
					circlePlate[i][j] += 1;
				}else if(circlePlate[i][j] != 0 && circlePlate[i][j] > average) {
					circlePlate[i][j] -=1;
				}
			}
		}
	}
	
	public static void dfs(int x, int y, int num) {
		int nx, ny;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = (y + dy[i]) % M;
			if(ny < 0) {
				ny = M - 1;
			}
			if(isRange(nx, ny )) {
				if(circlePlate[nx][ny] == num) {
					isFindSameNumber = true;
					circlePlate[nx][ny] = 0;
					dfs(nx, ny, num);
				}
			}
		}
	}
	
	public static boolean isRange(int x, int y) {
		return (x < 0 || x >= N || y < 0 || y >= M) ? false : true;
	}
	
	public static int sumOfPlate() {
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum += circlePlate[i][j];
			}
		}
		return sum;
	}
	
}
