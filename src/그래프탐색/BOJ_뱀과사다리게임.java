package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_�����ٸ����� {
	// BOJ �����ٸ� ���� / �ǹ� 1 / �׷��� Ž��
	// ��ǥ�������� �̵��ϱ� ���� ������ �ϴ� Ƚ���� �ּڰ�
	/*
	 * ����
	 * �湮�ߴ� ĭ�� �ٽ� �湮���� �ʰ� boolean �迭
	 * �ֻ����� 1~6 �ش� ĭ���� 6���� �ٸ� ��ġ�� �̵��� ��ȸ
	 * �� �� �ش� ĭ�� ��ٸ��� ������ �Ǵ��� ��ٸ��� ���̸� �Է��ߴ�
	 * �ٸ� ĭ���� �̵��ϰ� �ƴ϶�� �ֻ����� ���ڸ�ŭ �̵�
	 */
	
	static int N,M;
	static int count[] = new int[101];
	static int ladderAndSnake[] = new int[101];
	static boolean[] visited = new boolean[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ��ٸ� ��
		M = Integer.parseInt(st.nextToken()); // �� ��
		
		// ��ٸ� ����
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
		count[1] = 0; // ĭ �ε����� ���� �̵�Ƚ�� ���� �迭
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) {
				System.out.println(count[cur]);
				return;
			}
			
			for(int i=1; i<7; i++) { // �ֻ��� 1~6�̴ϱ� 
				int x = cur + i; // x : �ֻ��� ������ �� �� �̵� ��ǥ 
				if(100 < x) continue; // ���� ����� skip
				if(visited[x]) continue; // �湮�ߴ� ���̸� skip
				visited[x] = true;
				
				if(ladderAndSnake[x] != 0) { // ��ٸ� �Ǵ� ���� ��ġ�� ��
					if(!visited[ladderAndSnake[x]]) { // �湮�� ���� �ƴ϶��
						q.offer(ladderAndSnake[x]); // 
						visited[ladderAndSnake[x]] = true;
						count[ladderAndSnake[x]] = count[cur] + 1;
					}
				}else { // �ƹ��͵� �ƴҶ�(��ٸ� �Ǵ� ���� ��ġ�� �ƴҋ�)
					q.offer(x);
					count[x] = count[cur] + 1;
				}
			}
		}
	}
}
