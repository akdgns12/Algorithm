package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 톱니바퀴
 * 총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 일렬로 놓여져 있다.
 * 톱니는 N극 또는 S극 중 하나
 * 톱니바퀴가 다른 톱니바퀴와 서로 맞닿는 톱니의 극이 다르면 서로 반대방향으로 회전하게 됨
 * 같은 극이라면 회전하지 않는다.
 */
public class 톱니바퀴{
	
	// 톱니바퀴 4개의 톱니 상태(12시 방향부터 시작)(N극은 0, S극은 1)
	static int[][] gear = new int[5][9]; // [1~4][1~8]
	static int k; // 회전횟수
	static int gearIdx; // 회전할 톱니(1~4)
	static int dir; // 입력 받은 값 회전방향
	static int[] gearDir = new int[5]; // 각 톱니바퀴들의 회전 방향(시계방향 : 1, 반시계방향 : -1, 정지 : 0)
	static int result; // 네 톱니바퀴의 점수의 합
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int i=1; i<=4; i++) {
			String s = br.readLine();
			for(int j=1; j<=8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		// 톱니바퀴 회전
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gearIdx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			caculateGearDir();
			rotateGear();
		}
		
		result = 0;
		calculateScore();
		System.out.println(result);
	}
	
	// 입력받은 gearIdx, dir를 이용한 다른 기어 회전 방향 구하기
	public static void caculateGearDir() {
		//초기화
		for(int i=1; i<=4; i++) {
			gearDir[i] = 0;
		}
		
		// 해당 gear방향 입력받은 dir값으로 설정
		gearDir[gearIdx] = dir;
		
		// 다른 톱니바퀴와 만나는 부분 3, 7
		switch(gearIdx) {
		
			// 톱니바퀴 1이 회전할 경우 1->2->3->4
		case 1:
			// 톱니바퀴 1이 회전하고 맞물린 부분이 값이 다를 때 톱니바퀴2 반대방향으로 회전
			if(gearDir[1] != 0 && gear[1][3] != gear[2][7])
				gearDir[2] = gearDir[1] * -1;
			
			// 톱니 2와 톱니 3
			if(gearDir[2] != 0 && gear[2][3] != gear[3][7])
				gearDir[3] = gearDir[2] * -1;
			
			// 톱니 3과 톱니 4
			if(gearDir[3] != 0 && gear[3][3] != gear[4][7])
				gearDir[4] = gearDir[3] * -1;
			
			break;
		
			// 톱니 바퀴 2가 회전하는 경우 2->3->4 , 2-> 1
			
		case 2: 
			// 톱니 2와 1
			if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
				gearDir[3] = gearDir[2] * -1;
			
			// 톱니 2와 3
			if(gearDir[2] != 0 && gear[2][3] != gear[3][7])
				gearDir[3] = gearDir[2] * -1;
			
			if(gearDir[3] != 0 && gear[3][3] != gear[4][7])
				gearDir[4] = gearDir[3] * -1;
			break;
			
			// 톱니 바퀴 3이 회전하는 경우 3->4 , 3->2->1
		case 3:
			// 톱니 3과 4
			if(gearDir[3] != 0 && gear[3][3] != gear[4][7])
				gearDir[4] = gearDir[3] * -1;
			
			// 톱니 3과 2
			if(gearDir[3] != 0 && gear[3][7] != gear[2][3])
				gearDir[2] = gearDir[3] * -1;
		
			// 톱니 2와 1
			if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
				gearDir[1] = gearDir[2] * -1;
			break;
			
			// 톱니바퀴 4가 회전하는 경우 4->3->2->1
		case 4:
			// 톱니 4와 3
			if(gearDir[4] != 0 && gear[4][7] != gear[3][3])
				gearDir[3] = gearDir[4] * -1;
			
			// 톱니 3과 2
			if(gearDir[3] != 0 && gear[3][7] != gear[2][3])
				gearDir[2] = gearDir[3] * -1;
			
			// 톱니 2와 1
			if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
				gearDir[1] = gearDir[2] * -1;
			
			break;
		}
	}
	
	// 각 톱니바퀴 각 gearDir에 맞게 회전
	public static void rotateGear() {
		int[] tempGear;
		
		// 모든 톱니바퀴 gearDir에 맞게 회전시켜줌
		for(int i=1; i<=4; i++) {
			
			tempGear = new int[9];
			
			// 해당 톱니바퀴가 회전 안할 떄(0)는 넘어감
			if(gearDir[i] == 0)
				continue;
			
			// 해당 톱니바퀴가 시계방향(1)
			if(gearDir[i] == 1) {
				tempGear[1] = gear[i][8];
			for(int j=2; j<=8; j++) {
				tempGear[j] = gear[i][j-1];
			}
		}
		
		// 해당 톱니바퀴가 반시계방향(-1)
		else if(gearDir[i] == -1) {
			for(int j=1; j<=7; j++) {
				tempGear[j] = gear[i][j+1];
			}
			tempGear[8] = gear[i][1];
		}
		
		// 회전한 배열을 gear에 다시 저장해줌
		gear[i] = tempGear.clone();
	}
}
	// K번 회전시킨 이후에 네 톱니바퀴 점수의 합 출력
		//1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
		//2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
		//3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
		//4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
	public static void calculateScore() {
		if(gear[1][1] == 1)
			result += 1;
		if(gear[2][1] == 1)
			result += 2;
		if(gear[3][1] == 1)
			result += 4;
		if(gear[4][1] == 1)
			result += 8;
	}
}