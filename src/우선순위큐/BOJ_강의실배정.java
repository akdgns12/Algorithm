package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_강의실배정 {
	// BOJ 강의실 배정 골드 5 / 우선순위 큐 
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/*
		 * 1. input data를 2차원배열로 받는다
		 * 2. 입력 데이터를 오름차순으로 정렬(시작시간이 같다면, 끝나는 시간을 오름차순으로 정렬)
		 * 3. 우선순위큐 만들어주고, 정렬된 첫번쨰 원소의 끝나는 시간 넣어줌
		 * 4. 배열을 두번째 값부터 순회하면서 start가 PriorityQueue의 peek()보다 작거나 같다면, pq에서 하나 뺀다
		 *  4-1 . 순회하면서, 현재 end값을 pq에 넣어준다.
		 * 5. pq에 남아있는 데이터의 갯수가 필요한 강의실의 갯수이다.
		 */
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		// 1. Input 데이터를 2차원 배열로 받는다. 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 입력 데이터를 오름차순으로 정렬해준다. (시작시간이 같다면, 끝나는 시간을 오름차순으로 정렬)
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		// 3.PriorityQueue(우선순위 큐)를 만들어주고, (정렬된)배열의 첫 번째 end값을 큐에 넣는다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0][1]);
		
		// 4. 배열을 두 번째 값부터 순회하면서,
		for(int i=1; i<N; i++) {
			// start가 PriorityQueue의 peek()보다 크거나 같다면, pq에서 하나 뺀다.
			if(pq.peek() <= arr[i][0]) pq.poll();
			
			// 4-1. 순회하면서, 현재 end값을 새로 pq에 넣어준다.
			pq.add(arr[i][1]);
		}
		
		// 5. pq에 남아있는 데이터의 갯수가 필요한 강의실의 갯수이다
		System.out.println(pq.size());
	}
} 
