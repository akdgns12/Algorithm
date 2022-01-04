package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_센티와마법의뿅망치 {
	// BOJ 19638 센티와마법의뿅망칭 / 실버 1 / 우선순위 큐
	static int N; // 인구
	static int Hcenti; // 센티 키
	static int T; // 망치 두들기는 횟수
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
				// 키가 1인 경우 더 줄어들 수가 없어 뿅망치 영향 x
				// 키가 1이면 /2 == 0
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
