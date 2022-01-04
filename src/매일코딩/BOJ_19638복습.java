package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19638복습 {
	static int N;
	static int Hcenti;
	static int T;
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
				if(tallest == 1) {
					pq.offer(tallest);
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
			System.out.println("NO");
			System.out.println(pq.peek());
		}
	}
}
