package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10711_모래성 {
	/*
	 * 모래성을 기준으로 하는게 아닌
	 * 모래성이 없는 노드를 기준으로 
	 * 모래성이 없는 노드의 주변에 모래성이 있다면
	 * 하나씩 줄여가는 방식으로 탐색
	 * 어차피 모래성9인 경우 팔방에서 다 줄여도 결국 모래성이 사라지지 않는다.
	 * 줄이다가 모래성이 없어진 경우에는 모래성이 없는 노드에 추가시켜 준다.
	 * 
	 * 새로 모래성이 없어지는 노드가 발생하지 않는 동안 탐색을 하면
	 * 그 시간이 우리가 구하고자 하는 정답
	 */
	static int H,W;
	static char[][] map;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static Queue<Node> noSand = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = str.charAt(j);
				
				// 모래가 없는 곳 큐에 삽입
				if(map[i][j] == '.') {
					noSand.offer(new Node(i,j));
				}
			}
		}
		
		System.out.println(wave());
	}
	/*
	 *  시간초과를 받지 않기 위해 모래성의 주위를 탐색하는 것이 아닌
	 *  모래가 없는 칸을 기준으로 8방향에 모래성의 튼튼함을 1 감소시킨다.
	 *  이때 이미 한번 확인한 모래성이 없는 노드는 다시 확인할 필요가 없기 때문에
	 *  새로 모래성이 없어진 곳만 큐에 삽입해준다.
	 */
	public static int wave() {
		int time = 0;
		
		// 큐에 값이 없으면 더이상 변화가 없는 상태 -> 종료
		while(!noSand.isEmpty()) {
			int size = noSand.size();
			
			// 한 턴에 큐에 쌓인 값들만 처리하고 시간 증가-> 모래성은  한 번에 무너져야 하기 때문에
			while(size --> 0) {
				Node node = noSand.poll();
				
				for(int i=0; i<8; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					
					// 범위내에 있으면서 모래성이 있는 칸은
					if(nx >= 0 && ny >= 0 && nx < H && ny < W) {
						if(map[nx][ny] != '.') {
							map[nx][ny]--; // 모래성의 튼튼함 1감소시킨다.
							
							// 튼튼함이 0이되면 모래가 없는 칸으로 변경하고 큐에 삽입
							if(map[nx][ny] == '0') {
								map[nx][ny] = '.';
								noSand.offer(new Node(nx ,ny));
							}
						}
					}
				}
			}
			time++;
		}
		return time-1;
	}

	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
