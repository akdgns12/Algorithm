package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N����ū��_�����̵������� {
	// BOJN��° ū �� / �����̵� ������ / N ��° ū ���� ã�� ����
	static int map[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		/**
		 * N = 5���� ��
		 * ù���� ���� �κй迭�� ��� pq�� �־��ش�
		 * ���� �� ���� �޾ƿ��� ���ڵ� pq.peek() < num
		 * �̸� pq.poll()�ϰ� pq.add(num)���ش�
		 * pq���� �˾Ƽ� �������� �������ش�.
		 * ���������� pq�� ���� �κй迭�� ���̸�ŭ ���� ���Եǰ�
		 * pq�� �ִ� ������ 5���� ū������ 4,3,2,1 ������ ū ����
		 * pq�� �ִ� ���°� �ȴ�.
		 * ��, pq.poll() �ϸ� 5���� ū �� ���� ����
		 */
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(pq.peek() < num) {
					pq.poll();
					pq.add(num);
				}
			}
		}
		
		System.out.println(pq.poll());
		
		
	}
}
