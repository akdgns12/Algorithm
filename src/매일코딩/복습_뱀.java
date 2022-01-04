package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 복습_뱀 {
	static int n; // 보드의 크기
	static int k; // 사과의 갯수
	static int l; // 뱀의 방향변환 횟수
	static int[][] board;
	
	static LinkedList<int[]> snake; // 뱀 몸통 정보
	
	static HashMap<Integer, String> dir; // 뱀 방향 정보
	
	// 처음 시작은 오른쪽 방향 보고있음
	// 0 : 오른쪽, 1 : 아래, 2 : 왼쪽, 3 : 위
	static int index = 0;
	static int[] dx = {0,1,0,-1}; // 세로
	static int[] dy = {1,0,-1,0}; // 가로
	
	static int time; // 게임 시간
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		// (1,1)이 맨 위 맨 좌측
		board = new int[n+1][n+1];
		// 사과 정보 입력 받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int row = Integer.parseInt(st.nextToken()); // row
			int col = Integer.parseInt(st.nextToken()); // col
			
			board[row][col] = 1; // 사과 위치 1로 설정
		}
		
		//방향 정보 입력 받기
		l = Integer.parseInt(br.readLine());
		dir = new HashMap<>();
		for(int i=0; i<l; i++) {
			int timeInfo = Integer.parseInt(br.readLine());
			String directionInfo = br.readLine();
			
			dir.put(timeInfo, directionInfo);
		}
		
		// 뱀 시작지점(1,1) (x,y)
		snake = new LinkedList<>();
		snake.add(new int[] {1,1});
		
		time = 0;
		int nx, ny; // 다음 움직임
		int cx, cy; // 현재 움직임(1,1)
		cx = 1;
		cy = 1;
		
		// 뱀 움직임 시작
		while(true) {
			time++;
			
			// 다음 움직임(머리 데이터)
			nx = cx + dx[index];
			ny = cy + dy[index];
			
			// 끝나는지 확인
			if(isFinish(nx,ny)) break;
			
			// 사과 있는지 확인
			// 사과 있으면 사과 없어지고 머리 늘려서 꼬리 그대로
			if(board[nx][ny] == 1) {
				board[nx][ny] = 0; // 사과 없어지고
				snake.add(new int[] {nx,ny}); // 머리 정보 추가
			}
			// 사과 없으면 머리 늘려서 꼬리가 위치한 칸 비워줌
			else {
				snake.add(new int[] {nx,ny}); // 머리 정보 추가
				snake.remove(0); // 꼬리 index는 0
			}
			
			cx = nx;
			cy = ny;
			
			// 해당 시간 끝났을 때 다음 방향 정해주기
			if(dir.containsKey(time)) {
				// D(오른쪽)가 나오면 index++
				if(dir.get(time).equals("D")) {
					index++;
					if(index == 4)
						index = 0;
				}
				// L(왼쪽)이 나오면 index--
				if(dir.get(time).equals("L")) {
					index--;
					if(index == -1)
						index = 3;
				}
			}
		}
		System.out.println(time);
	}
	
	// 게임이 끝나는지 확인
	static boolean isFinish(int nx, int ny) {
		
		// 벽에 부딪히거나
		if(nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1)
			return true;
		
		// 자기 몸통에 닿거나
		for(int i=0; i<snake.size(); i++) {
			if(nx == snake.get(i)[0] && ny == snake.get(i)[1])
				return true;
		}
		
		return false;
	}

}
