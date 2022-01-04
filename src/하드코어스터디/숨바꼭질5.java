package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ���ٲ���5 {
	static int N,K;
	static boolean[][] visited;
	/*
	 * ������ �� �� �湮�ߴ� ���� 2�ʰ� ������ �ٽ� �湮�� �� �ִ�(x-1,x+1)
	 * ������ ������ �������� ������ ������ ���� �̸� �����ϰ� �� �ڸ��� 2�ʰ������� ������ �� �ִ�.
	 * ������ p��ġ�� �����ϴ� t�ʰ� ¦���̸� ¦�� �ð������� p��ġ�� ���ƿ���
	 * ������ p��ġ�� �����ϴ� t�ʰ� Ȧ���̸�  Ȧ�� �ð������� p��ġ�� ���ƿ� �� �ִ�.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ������ ��ġ
		K = Integer.parseInt(st.nextToken()); // ���� ��ġ
		
		visited = new boolean[500001][2];
		// ������ �ᱹ �ش� �ʸ�ŭ ��� +�ؼ� �̵��Ѵ�
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
			// K�� ������ ����� ���
			if(K > 500000) {
				return -1;
			}
			
			// time�� ¦�� Ȧ��
			int newTime = time % 2;
			
			// ���� ���(¦��, Ȧ��)
			if(visited[K][newTime]) {
				return time;
			}
			
			// ���� q�� ������ ��ŭ�� ������ - �ð� ����� ���ؼ�
			for(int j=0, size=q.size(); j<size; j++) {
				int now = q.poll();
				// ���� �̵��� ¦�� Ȧ�� ����
				int nextTime = (time+1) % 2;
				int next;
				
				// �������� ������ �湮ó��
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
