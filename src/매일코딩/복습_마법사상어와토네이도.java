package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_�������������̵� {
	static int N;
	static int[][] map;
	static int[] dx = {0,1,0,-1}; // ����̵� x�̵� ����
	static int[] dy = {-1,0,1,0}; // ����̵� y�̵� ����
	static int[] dc = {1,1,2,2}; // ����̵��� �� �������� �̵��ϴ� Ƚ��
	static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0},{-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0},{1,1,0,0,0,0,-1,-1,-2}}; // �𷡰� ������ x����
	static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},{-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}}; // �𷡰� ������ y����
	static int[] sandRatio = {1,1,2,7,7,2,10,10,5}; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = calculateOutSand(N/2, N/2);
		
		System.out.println(result);
	}
	
	public static int calculateOutSand(int x, int y) {
		int totalOutSand = 0;
		
		int curX = x;
		int curY = y;
		
		while(true) {
			for(int d=0; d<4; d++) {
				for(int moveCount =0; moveCount < dc[d]; moveCount++) {
					// ������ġ������ �̵�
					int nx = curX + dx[d];
					int ny = curY + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
						return totalOutSand;
					}
					
					// �̵��� ��ġ�� �� �Ѹ���
					int sand = map[nx][ny];
					map[nx][ny] = 0;
					int spreadTotal = 0;
					
					for(int spread = 0; spread<9; spread++) {
						int sandX = nx + dsx[d][spread];
						int sandY = ny + dsy[d][spread];
						int spreadAmount = (sand * sandRatio[spread]) / 100;
						
						if(sandX < 0 || sandY < 0 || sandX >= N || sandY >= N) {
							totalOutSand += spreadAmount;
						}
						else {
							map[sandX][sandY] += spreadAmount;
						}
						spreadTotal += spreadAmount;
					}
					
					// ����
					int alphaX = nx + dx[d];
					int alphaY = ny + dy[d];
					int alphaAmount = sand - spreadTotal;
					if(alphaX < 0 || alphaY < 0 || alphaX >= N || alphaY >= N	) {
						totalOutSand += alphaAmount;
					}
					else {
						map[alphaX][alphaY] += alphaAmount;
					}
					
					// �̵��� ��ġ�� ������ġ�� ������Ʈ
					curX = nx;
					curY = ny;	
				}
			}
			
			// Ƚ�� ������Ʈ
			for(int index = 0; index < 4; index++) {
				dc[index] += 2;
			}
		}
	}
}
