package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질5 {
	static int N,K;
	static boolean[][] visited;
	/*
	 * 수빈이 한 번 방문했던 곳을 2초가 있으면 다시 방문할 수 있다(x-1,x+1)
	 * 수빈이 동생을 앞질러서 동생이 도착할 곳에 미리 도착하고 그 자리를 2초간격으로 유지할 수 있다.
	 * 수빈이 p위치에 도착하는 t초가 짝수이면 짝수 시간때마다 p위치로 돌아오고
	 * 수빈이 p위치에 도착하는 t초가 홀수이면  홀수 시간때마다 p위치로 돌아올 수 있다.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치
		
		visited = new boolean[500001][2];
		// 동생은 결국 해당 초만큼 계속 +해서 이동한다
		if(N == K) {
			System.out.println(0);
		}else {
			System.out.println(bfs(N));
		}
	}
	
	public static int bfs(int start) {
		int time = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start][time] = true; 
		
		while(!q.isEmpty()) {
			// K가 범위를 벗어나는 경우
			if(K > 500000) {
				return -1;
			}
			
			// time의 짝수 홀수
			int newTime = time % 2;
			
			// 만난 경우(짝수, 홀수)
			if(visited[K][newTime]) {
				return time;
			}
			
			// 현재 q의 사이즈 만큼만 돌리기 - 시간 계산을 위해서
			for(int j=0, size=q.size(); j<size; j++) {
				int now = q.poll();
				// 다음 이동의 짝수 홀수 여부
				int nextTime = (time+1) % 2;
				int next;
				
				// 다음에서 영역을 방문처리
				next = now - 1;
				if(next >= 0 && !visited[next][nextTime]) {
					visited[next][nextTime] = true;
					q.offer(next);
				}
				
				next = now + 1;
				if(next < 500001 && !visited[next][nextTime]) {
					visited[next][nextTime] = true;
					q.offer(next);
				}
				
				next = now * 2;
				if(next < 500001 && !visited[next][nextTime]) {
					visited[next][nextTime] = true;
					q.offer(next);
				}
			}
			time++;
			K += time;
		}
		return -1;
	}
}
