package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번쨰큰수_슬라이딩윈도우 {
	// BOJN번째 큰 수 / 슬라이딩 윈도우 / N 번째 큰 수를 찾는 로직
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
		 * N = 5였을 때
		 * 첫쨰줄 고정 부분배열로 잡고 pq에 넣어준다
		 * 다음 줄 부터 받아오는 숫자들 pq.peek() < num
		 * 이면 pq.poll()하고 pq.add(num)해준다
		 * pq에서 알아서 오름차순 정렬해준다.
		 * 최종적으로 pq에 고정 부분배열의 길이만큼 숫자 남게되고
		 * pq에 있는 수들은 5번쨰 큰수부터 4,3,2,1 순위로 큰 숫자
		 * pq에 있는 상태가 된다.
		 * 즉, pq.poll() 하면 5번쨰 큰 수 추출 가능
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
