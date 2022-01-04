package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ����2_�巡��Ŀ�� {
	static int N; // �巡�� Ŀ�� ����
	static int x,y; // �巡�� Ŀ�� ������ ��ǥ
	static int d; // ����
	static int g; // ����
	static boolean[][] map = new boolean[101][101];
	static List<Integer> directions;
	
	// 0:x++, 1:y--, 2:x--, 3:y++
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			dragonCurve();
		}
		
		int result = getSquareCnt();
		System.out.println(result);
	}
	
	public static void dragonCurve() {
		directions = new ArrayList<>();
		directions.add(d); // �ʱ� ���� �ֱ�
		
		int dir;
		while(g-->0) {
			for(int i=directions.size()-1; i>=0; i--) {
				dir = (directions.get(i) + 1) % 4;
				directions.add(dir);
			}
		}
		
		//map���� �巡�� Ŀ�갡 ������ ������ �׸���
		int nx,ny;
		int cx = x;
		int cy = y;
		map[x][y] = true;
		for(int i=0; i<directions.size(); i++) {
			dir = directions.get(i);
			
			nx = cx + dx[dir];
			ny = cy + dy[dir];
			
			map[nx][ny] = true;
			
			cx = nx;
			cy = cy;
		}
	}
	
	public static int getSquareCnt() {
		int cnt = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					cnt++;
			}
		}
		
		return cnt;
	}
}
