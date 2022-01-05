package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_뱀과사다리게임 {
	// BOJ 뱀과사다리 게임 / 실버 1 / 그래프 탐색
	// 목표지점까지 이동하기 위해 굴려야 하는 횟수의 최솟값
	/*
	 * 로직
	 * 방문했던 칸은 다시 방문하지 않게 boolean 배열
	 * 주사위는 1~6 해당 칸에서 6번의 다른 위치로 이동할 기회
	 * 이 때 해당 칸이 사다리나 뱀인지 판단해 사다리나 뱀이면 입력했던
	 * 다른 칸으로 이동하고 아니라면 주사위의 숫자만큼 이동
	 */
	
	static int N,M;
	static int count[] = new int[101];
	static int ladderAndSnake[] = new int[101];
	static boolean[] visited = new boolean[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사다리 수
		M = Integer.parseInt(st.nextToken()); // 뱀 수
		
		// 사다리 정보
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladderAndSnake[x] = y;
		}
		 
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		count[1] = 0; // 칸 인덱스에 따른 이동횟수 저장 배열
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) {
				System.out.println(count[cur]);
				return;
			}
			
			for(int i=1; i<7; i++) { // 주사위 1~6이니까 
				int x = cur + i; // x : 주사위 굴리고 난 후 이동 좌표 
				if(100 < x) continue; // 범위 벗어나면 skip
				if(visited[x]) continue; // 방문했던 곳이면 skip
				visited[x] = true;
				
				if(ladderAndSnake[x] != 0) { // 사다리 또는 뱀의 위치일 때
					if(!visited[ladderAndSnake[x]]) { // 방문한 곳이 아니라면
						q.offer(ladderAndSnake[x]); // 
						visited[ladderAndSnake[x]] = true;
						count[ladderAndSnake[x]] = count[cur] + 1;
					}
				}else { // 아무것도 아닐때(사다리 또는 뱀의 위치가 아닐��)
					q.offer(x);
					count[x] = count[cur] + 1;
				}
			}
		}
	}
}
