package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_톱니바퀴3 {
	static int K;
	static int[][] gear = new int[5][8];
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		// 톱니바퀴 회전
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			// 톱니바퀴 번호는 1~4, 인덱스는 0 ~ 3
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			solution(idx, dir);
		}
		
		cnt = 0;
		if(gear[0][0] == 1) {
			cnt += 1;
		}
		if(gear[1][0] == 1) {
			cnt += 2;
		}
		if(gear[2][0] == 1) {
			cnt += 4;
		}
		if(gear[3][0] == 1) {
			cnt += 8;
		}
		
		System.out.println(cnt);
	}
	
	// 해당 톱니바퀴의 9시 방향은 6, 3시 방향은 2 이지만 해당 톱니바퀴에 맞닿아 
	// 있는 양쪽 톱니바퀴 기준으로는 9시 방향은 2, 3시 방향은 6
	public static void solution(int idx, int dir) {
		left(idx - 1, -dir);
		right(idx + 1, -dir);
		rotate(idx, dir);
	}
	
	// 왼쪽에 있던 톱니바퀴 회전 여부 결정
	public static void left(int idx ,int dir) {
		if(idx < 0) return; // 범위벗어나면 리턴
		
		if(gear[idx][2] != gear[idx+1][6]) {
			left(idx - 1, -dir);
			rotate(idx, dir);
		}
	}
	
	// 오른쪽에 있던 톱니바퀴의 회전 여부 결정
	public static void right(int idx, int dir) {
		if(idx > 3) return;
		
		if(gear[idx][6] != gear[idx-1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
	
	// dir = 1 시계방향, dir = -1 반시계방향
	public static void rotate(int idx ,int dir) {
		if(dir == 1) {
			int temp = gear[idx][7];
			
			for(int i=7; i>0; i--) {
				gear[idx][i] = gear[idx][i-1];
			}
			
			gear[idx][0] = temp;
			
		}else {
			int temp = gear[idx][0];
			
			for(int i=0; i<7; i++) {
				gear[idx][i] = gear[idx][i+1];
			}
			
			gear[idx][7] = temp;
		}
	}
}
