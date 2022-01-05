package �׷���Ž��;
//
import java.util.LinkedList;
import java.util.Queue;
/*
 * BFS�� �����Ͽ� Ǯ����. �Է¹��� �迭�� boolean �迭�� ��������� ��ȯ�Ͽ���, 
 * 1������ ���� �� ����̴ϱ� ť�� 1�� �ְ� ����Ȯ���ϸ鼭 �ݺ����� ������ �ȴ�.
 */
public class ����ճ��_lv3 {
	public int solution(int n, int[][] edge) {
		
		int dist[] = new int[n+1];
		boolean visited[][] = new boolean[n+1][n+1];
		
		for(int i=0; i<edge.length; i++) {
			//����� �����̴ϱ�
			visited[edge[i][0]][edge[i][1]] = true;
			visited[edge[i][1]][edge[i][0]] = true;
		}
		
		Queue<Integer> queue = new LinkedList();
		queue.add(1); //1�������ʹϱ� 
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
