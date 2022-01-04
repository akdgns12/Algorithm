package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_크리스마스선물 {
	// BOJ 11286 / 실버 1 / 우선순위 큐
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 절댓값이 같은 경우 그 중에서 작은 값으로 오름차순 정렬하고,
		// 아닌 경우 절댓값이 작은 순으로 오름차순 정렬
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
