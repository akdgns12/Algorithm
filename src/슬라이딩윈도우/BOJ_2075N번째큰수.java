package �����̵�������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075N��°ū�� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st;
		
		//ù ���� �̸� �־�α�(�޸�, �ӵ� ȿ��)
		String line = br.readLine();
		st = new StringTokenizer(line);
		for(int i=0; i<n; i++) {
			pq.offer(Integer.valueOf(st.nextToken()));
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				
				int num = Integer.parseInt(st.nextToken());
				//������ ����ִ� �� �� window�� �°� ����(front�� �ּ�, rear�� �ִ�)
				if(pq.peek() < num) {
					pq.poll();
					pq.offer(num);
				}
				
				//ȿ������ ���� �� �˰����� �ּ�
//				pq.offer(num);
//				
//				//windowũ�⿡ �°� �տ������� �� ������(N��°�� ū ���� ���ϱ� ����)
//				if(pq.size() > n) {
//					pq.poll();
//				}
			}
		}
		
		System.out.println(pq.poll());
	}
}
