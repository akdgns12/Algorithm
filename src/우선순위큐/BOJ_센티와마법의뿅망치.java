package �켱����ť;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_��Ƽ�͸����ǻи�ġ {
	// BOJ 19638 ��Ƽ�͸����ǻи�Ī / �ǹ� 1 / �켱���� ť
	static int N; // �α�
	static int Hcenti; // ��Ƽ Ű
	static int T; // ��ġ �ε��� Ƚ��
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Hcenti = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			int giantH = Integer.parseInt(br.readLine());
			pq.offer(giantH);
		}
		
		int temp = T;
		while(temp > 0) {
			int tallest = pq.poll();
			if(tallest < Hcenti) {
				pq.offer(tallest);
				break;
			}else {
				// Ű�� 1�� ��� �� �پ�� ���� ���� �и�ġ ���� x
				// Ű�� 1�̸� /2 == 0
				if(tallest == 1) {
					pq.offer(1);
					break;
				}else {
					pq.offer(tallest / 2);
				}
			}
			temp--;
		}
		
		if(pq.peek() < Hcenti) {
			System.out.println("YES");
			System.out.println(T - temp);
		}else {
			System.out.println("No");
			System.out.println(pq.peek());
		}
	}
}
