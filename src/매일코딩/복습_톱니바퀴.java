package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_톱니바퀴 {
	static int[][] arr = new int[4][8];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		// 톱니바퀴 회전
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			// 톱니바퀴 번호는 1~4, 인덱스는 0~3
			solution(idx - 1, dir);
		}
		
		// 점수 계산
		int score = 0;
		for(int i=0; i<4; i++) {
			score += arr[i][0] * (1 << i);
		}
		
		System.out.println(score);
	}
	
	// 오른쪽 톱니의 9시 방향은 왼쪽 톱니의 2,왼쪽 톱니의 3시 방향은 오른쪽 톱니의 6
	public static void solution(int idx, int dir) {
		left(idx - 1, -dir); // -dir인 이유 : 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하기 떄문에
		right(idx + 1, -dir);
		rotate(idx, dir);
	}
	
	// 왼쪽에 있던 톱니바퀴 회전 여부 결정
	public static void left(int idx, int dir) {
		if(idx < 0) return;
		
		if(arr[idx][2] != arr[idx+1][6]) {
			left(idx - 1, -dir);
			rotate(idx ,dir);
		}
	}
	
	// 오른쪽에 있던 톱니바퀴 회전 여부 결정
	public static void right(int idx, int dir) {
		if(idx > 3) return;
		
		if(arr[idx][6] != arr[idx-1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
	
	// dir = 1 시계방향, dir = -1 반시계 방향
	public static void rotate(int idx, int dir) {
		if(dir == 1) {
			int temp = arr[idx][7];
			
			for(int i=7; i>0; i--) {
				arr[idx][i] = arr[idx][i-1];
			}
			
			arr[idx][0] = temp;
	
		}else {
			int temp = arr[idx][0];
			
			for(int i=0; i<7; i++) {
				arr[idx][i] = arr[idx][i+1];
			}
			
			arr[idx][7]	= temp;
		}
		
	}
}
