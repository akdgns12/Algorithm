package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 뱀_복습한번더 {
	static int n; // 보드의 크기
	static int k; // 사과의 갯수
	static int l; // 뱀 방향 변환 횟수
	static int[][] board; 
	static int time;
	
	static LinkedList<int[]> snake; // 뱀 몸통 정보
	
	static HashMap<Integer, String> dir; // 뱀 머리 방향 정보
	
	static int index = 0;
	static int[] dx = {0,1,0,-1}; // 세로  동,남,서,북
	static int[] dy = {1,0,-1,0}; // 가로
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		board = new int[n+1][n+1];
		// 사과 위치 정보 입력 받기
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			board[row][col] = 1; // 사과 위치 1로 설정
		}
		
		// 방향 정보 입력
		dir = new HashMap<>();
		l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int timeInfo = Integer.parseInt(st.nextToken());
			String directionInfo = st.nextToken();
			
			dir.put(timeInfo, directionInfo); // Hashmap에 (시간, 방향) 넣기
		}
		
		// 뱀 초기위치(1,1) (x,y)
		snake = new LinkedList<>();
		snake.add(new int[] {1,1}); 
		
		
		time = 0;
		int nx, ny; // 다음 움직임
		int cx, cy; // 현재 움직임
		cx = 1;
		cy = 1;
		
		while(true) {
			time++;
			
			// 다음 움직임(머리 데이터)
			nx = cx + dx[index];
			ny = cy + dy[index];
			
			// 끝나는지 확인
			if(isFinish(nx, ny)) break;
			
			// 사과 있는지 확인
			// 사과 있으면 사과 없어지고 머리 늘려서 꼬리 그대로
			if(board[nx][ny] == 1) {
				board[nx][ny] = 0;
				snake.add(new int[] {nx, ny});
			}
			else { 
				// 사과 없다면 머리 늘려주고
				// 꼬리 위치 제거
				snake.add(new int[] {nx,ny});
				snake.remove(0);
			}
			
			cx = nx;
			cy = ny;
			
			// 해당 시간 끝났을 때 방향 정해주기
			if(dir.containsKey(time)) {
				if(dir.get(time).equals("D")) {
					index = (index+1) % 4;
				}
				else
					index = (index + 3) % 4;
					
			}
			
		}
		
		System.out.println(time);
	}

	// 게임 끝나는지 확인
	public static boolean isFinish(int nx, int ny) {
		// 벽에 부딪히거나
		if(nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1)
			return true;
		
		// 몸통에 부딪히거나
		for(int i=0; i<snake.size(); i++) {
			if(nx == snake.get(i)[0] && ny == snake.get(i)[1])
				return true;
		}
		
		return false;
	}
}
