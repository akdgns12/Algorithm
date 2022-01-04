package �켱����ť;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_ũ������������ {
	// BOJ 11286 / �ǹ� 1 / �켱���� ť
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// ������ ���� ��� �� �߿��� ���� ������ �������� �����ϰ�,
		// �ƴ� ��� ������ ���� ������ �������� ����
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->
			Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
		);
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				}else {
					System.out.println(0);
				}
			}else {
				pq.offer(num);
			}
				
		}
	}
}
