package 그래프탐색;
//
import java.util.LinkedList;
import java.util.Queue;
/*
 * BFS로 접근하여 풀었다. 입력받은 배열을 boolean 배열로 양방향으로 변환하였고, 
 * 1번에서 가장 먼 노드이니까 큐에 1을 넣고 연결확인하면서 반복문을 돌리면 된다.
 */
public class 가장먼노드_lv3 {
	public int solution(int n, int[][] edge) {
		
		int dist[] = new int[n+1];
		boolean visited[][] = new boolean[n+1][n+1];
		
		for(int i=0; i<edge.length; i++) {
			//양방향 연결이니까
			visited[edge[i][0]][edge[i][1]] = true;
			visited[edge[i][1]][edge[i][0]] = true;
		}
		
		Queue<Integer> queue = new LinkedList();
		queue.add(1); //1번노드부터니까 
		int max = 0;
		
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			for(int j=2; j<=n; j++) {
				if(dist[j] == 0 && visited[idx][j]) {
					dist[j] = dist[idx] + 1;
					queue.add(j);
				}
			}
		}
		
		for(int i=0; i<n+1; i++) {
			max = Math.max(max, dist[i]);
		}
		
		int cnt = 0;
		for(int i=0; i<n+1; i++) {
			if(max == dist[i])
			cnt++;
		}
		
		return cnt;
	}
}
