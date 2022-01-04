package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼성기출_컨베이어벨트위의로봇 {
	static int N,K;
	static int[] map;
	static boolean[] robot; // 로봇 위치했는지 판단할 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[2*N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(simulation(0));
	}
	
	public static int simulation(int cnt) {
		while(isOk()) {
			int temp = map[map.length-1]; // 한 칸만 회전
			for(int i=map.length-1; i>0; i--) { // 1. 벨트 회전
				map[i] = map[i-1];
			}
			map[0] = temp;
			
			// 벨트와 함께 로봇도 회전
			for(int i=robot.length-1; i>0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false; // 올리는 위치
			robot[N-1] = false; // 내리는 위치
			
			// 2. 로봇 이동가능하면 위치 이동
			for(int i=N-1; i>0; i--) {
				if(robot[i-1] && !robot[i] && map[i] > 0) {
					robot[i] = true; // 로봇 이동 후의 위치 true 방문표시
					robot[i-1] = false; // 로봇 이동 전의 원래 위치 false 초기화
					map[i]--; // 내구도 감소
				}
			}
			
			// 3. 올라가는 위치에 로봇 올리기
			if(map[0] > 0) {
				robot[0] = true;
				map[0]--;
			}
			
			cnt++;
		}
		return cnt;
	}
	
	public static boolean isOk() {
		int cnt = 0;
		
		for(int i=0; i<map.length; i++) {
			if(map[i] == 0) {
				cnt++;
			}
			if(cnt >= K) {
				return false;
			}
		}
		
		return true;
	}
	
}
