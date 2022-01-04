package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_최대힙 {
	// BOJ 최대 힙 11279 / 실버 2 / 우선순위 큐
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 0)
				pq.offer(num);
			else if(num == 0) {
				if(pq.isEmpty()) System.out.println(0);
					else System.out.println(pq.poll());
			}
		}	
		
	}
}
