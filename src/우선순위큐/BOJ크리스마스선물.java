package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ크리스마스선물 {
	// BOJ 14235 크리스마스 선물 실버3 / 우선순위 큐
	static int n; // 거점지 방문 횟수
	static int a; // 거점지에서 충전한 선물의 개수
	// 내림차순 정렬
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				if(pq.isEmpty()) System.out.println(-1);
				else System.out.println(pq.poll());
			}else {
				for(int j=0; j<a; j++) {	
					pq.offer(Integer.parseInt(st.nextToken()));	
				}
			}
		} // end of input
		
	
	}
}
