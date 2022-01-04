package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * CCTV 사각지대 최소 크기
 */
public class 감시 {
	static final int INF = 987654321;
	static int N,M;
	static int[][] map;
	static int CamCnt;
	static int[] CamType = new int[8];
	static int[] CamRow = new int[8];
	static int[] CamCol = new int[8];
	static int[] Dr = {0,-1,0,1}; // 0=right, 1=up, 2=left, 3=down
	static int[] Dc = {1,0,-1,0};
	static int[][] Dcam = {
			{1,0,0,0,4},
			{1,0,1,0,2},
			{1,1,0,0,4},
			{1,1,1,0,4},
			{1,1,1,1,1}
	};
	
	static void watch(int r, int c, int dir) {
		int srow = r, scol = c;
		for(;;) {
			int nr = srow + Dr[dir];
			int nc = scol + Dc[dir];
			if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) return;
			if(map[nr][nc] == 6	) return;
			map[nr][nc] = 7; // 감시할 수 있는 영역
			srow = nr;
			scol = nc;
			
		}
	}
	
	static void copymap(int[][] dst, int[][] src) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dst[i][j] = src[i][j];
			}
		}
	}
	static int solve(int pos) {
		if(pos == CamCnt) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 0) sum++;
					
					return sum;
				}
			}
		}
		
		int[][] backup = new int[8][8];
		int ret = INF;
		
		int type = CamType[pos] - 1;
		for(int i=0; i<Dcam[type][4]; i++) {
			copymap(backup, map); // 백업
			
			for(int j=0; j<4; j++) {
				if(Dcam[type][j] == 1)
					watch(CamRow[pos], CamCol[pos], (i+j)%4 );
			}
			
			ret = Math.min(ret,solve(pos + 1));
			
			copymap(map,backup); // 복원
		}
		return ret;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[8][8];
		
		CamCnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5	) {
					CamType[CamCnt] = map[i][j];
					CamRow[CamCnt] = i;
					CamCol[CamCnt++] = j;
				}
			}
		}
		
		System.out.println(solve(0));
		
	}
}
