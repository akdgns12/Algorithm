package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/*
 * [문제 풀이 생각]
 * 1. 2차원 int 배열 map에는 각 영역의 색깔을 저장하고, 2차원 ArrayList 배열 order의 각 위치에는
 * 	  말들을 저장한다.
 * 2. turn의 횟수가 1000이 넘어가거나 말이 한개씩 움직였을 때 쌓인 말의 개수가 4개가 될 때까지 while문 반복
 * 
 * 3. k개의 말을 처음부터 한개씩 움직이기 시작하는데, 현재 말이 제일 밑에 있을 수도 있지만 쌓인 중간에 있을 수도
 * 있기 때문에 idx라는 변수를 통해서 말의 위치를 구한다
 * 
 * 4. 현재 말부터 위에 쌓인 말들을 모두 queue에 저장한다. queue는 각 영역으로 움직일 때 순서가 바뀌기 때문에 Deque 자료구조 사용
 * 
 * 5. 다음 말이 움직이는 위치(nx,ny)를 구하고 그 좌표의 색깔을 확인한다
 * 
 * 6. 범위를 벗어나거나 파랑색 영역이면 이동 방향을 바꾸고 한칸 이동
 * 
 * 7. 움직인 좌표가 범우를 벗어나거나 파랑색 영역이면 반대방향으로 움직인다. 이 동작은 결국 원래자리로 가는 것
 * 
 * 8. 흰색 영역이면 queue의 앞부터 poll해서 쌓아준다.
 * 
 * 9. 빨강색 영역이면 queue의 뒤부터 쌓아줘야 하기 때문에 pollLast메소드를 사용한다
 * 
 * 10. 옮겨진 말의 값을 갱신한다.
 */
public class 복습_새로운게임2 {
	static int[][] horses, map;
	static int n;
	static Deque<Integer>[][] horseIndexs;
	static int[] moveX = { 1, -1, 0, 0 }; // 오, 왼, 위, 아래
	static int[] moveY = { 0, 0, -1, 1 };
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		horses = new int[k + 1][3]; // 1 ~ k 인덱스 말.  0: x, 1: y, 2: direction  
		map = new int[n + 1][n + 1];
		horseIndexs = new ArrayDeque[n + 1][n + 1];
		
		// 맵 그리기 (칸의 색)
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int element = Integer.valueOf(st.nextToken());
				map[i][j] = element;	
				horseIndexs[i][j] = new ArrayDeque<Integer>();
			}
		}
		
		// 말 맵에 집어넣기
		for(int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.valueOf(st.nextToken());
			int x = Integer.valueOf(st.nextToken());
			int direction = Integer.valueOf(st.nextToken()) - 1;
			
			horses[i][0] = x;
			horses[i][1] = y;
			horses[i][2] = direction; 
			horseIndexs[y][x].offer(i);
			
		}
		
		int time = 1;
		while(time <= 1000) {
			for(int i = 1; i <= k; i++) {
				int x = horses[i][0];
				int y = horses[i][1];
				int direction = horses[i][2];
				
				if(move(x, y, direction, i, false)) {
					System.out.println(time);
					return;
				}	
			}			
			time++;
		}
		System.out.println(-1);
	}
	
	// true : 종료,  false : 계속 진행
	static boolean move(int x, int y, int direction, int index, boolean visitedBlue) {
		int nextX = x + moveX[direction];
		int nextY = y + moveY[direction];
		Deque<Integer> tempDeque = new ArrayDeque<Integer>();
		int color;
		boolean checked = false;
		
		if(isOutOfMap(nextX, nextY)) {
			color = 2;
		}
		else {
			color = map[nextY][nextX];
		}


		switch(color) {
		case 0:	// 흰색
			for(int ele : horseIndexs[y][x]) {
				if(checked) {
					horseIndexs[nextY][nextX].offerLast(ele);
					horses[ele][0] = nextX;
					horses[ele][1] = nextY;
				}
				else {
					if(ele == index) {
						horseIndexs[nextY][nextX].offerLast(ele);
						horses[ele][0] = nextX;
						horses[ele][1] = nextY;
						checked = true;
					}
					else {
						tempDeque.offer(ele);	
					}	
				}
			}
			horseIndexs[y][x] = tempDeque;
			return horseIndexs[nextY][nextX].size() >= 4 ? true : false;
		case 1:	// 빨간색
			while(!checked) {
				if(horseIndexs[y][x].peekLast() == index) {
					checked = true;
				}
				int moveIndex = horseIndexs[y][x].pollLast();
				horseIndexs[nextY][nextX].offerLast(moveIndex);
				horses[moveIndex][0] = nextX;
				horses[moveIndex][1] = nextY;
			}
			return horseIndexs[nextY][nextX].size() >= 4 ? true : false;
		case 2:	// 파란색
			// 주어진 방향 정수의 뜻에 맞게 반대 방향 구하기
			int oppositeDirection = direction % 2 == 0 ? direction + 1 : direction - 1;
			if(!visitedBlue) {	// 이미 파란색을 만나서 뒤돌은 경우
				horses[index][2] = oppositeDirection;
				return move(x, y, oppositeDirection, index, true);
			}
			return false;
		}
		return false;	// 임시. 에러 시
	}
	
	// 맵 벗어났는지 판단
	static boolean isOutOfMap(int x, int y) {
		return x > n || x <= 0 || y > n || y <= 0 ? true : false;  
	}
}