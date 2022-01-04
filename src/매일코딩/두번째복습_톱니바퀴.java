package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두번째복습_톱니바퀴 {
	
	static int k;
	static int[][] arr = new int[4][8];
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			// 톱니바퀴 번호는 1~4, 인덱스는 0~3
			solution(idx-1, dir);
		}
		
		cnt = 0;
		if(arr[0][0] == 1) {
			cnt += 1;
		}
		
		if(arr[1][0] == 1) {
			cnt += 2;
		}
		if(arr[2][0] == 1) {
			cnt += 4;
		}
		if(arr[3][0] == 1) {
			cnt += 8;
		}
		
		System.out.println(cnt);
	}
	
	public static void solution(int idx, int dir) {
		left(idx - 1, -dir);
		right(idx + 1, -dir);
		rotate(idx, dir);
	}
	
	public static void left(int idx, int dir) {
		if(idx < 0) return;
		
		if(arr[idx][2] != arr[idx+1][6]) {
			left(idx - 1, -dir);
			rotate(idx, dir);
		}
	}
	
	public static void right(int idx, int dir) {
		if(idx > 3) return;
		
		if(arr[idx][6] != arr[idx-1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
	
	// dir = 1 시계방향, dir = -1 반시계방향
	public static void rotate(int idx, int dir) {
		if(dir == 1) {
			int temp = arr[idx][7];
			
			for(int i=7; i>0; i--) {
				arr[idx][i]	= arr[idx][i-1];
			}
			
			arr[idx][0] = temp;
		}else {
			int temp = arr[idx][0];
			
			for(int i=0; i<7; i++) {
				arr[idx][i] = arr[idx][i+1];
			}
			
			arr[idx][7] = temp;
		}
	}
}
