package �ڷᱸ��;

import java.util.PriorityQueue;
import java.util.Scanner;

public class �ּ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				if(pq.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(num);
			}
		}
	}
}
