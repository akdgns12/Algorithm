package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_보석도둑 {
	static class Gem{
		int w, p;
		public Gem(int w, int p) {
			this.w = w;
			this.p = p;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Gem> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			list.add(new Gem(w, p));
		}
		// 보석 무게 순으로 오름차순 정렬
		Collections.sort(list, (o1, o2) -> o1.w - o2.w);
		int[] bag = new int[K];
		
		for(int i=0; i<K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		// 가방 무게 오름차순 정렬
		Arrays.sort(bag);
		
		// 우선순위 큐 가격순 내림차순으로 정렬
		PriorityQueue<Gem> pq = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
		
		long totalPrice = 0;
		int listIdx = 0;
		for(int i=0; i<K; i++) {
			// 조건 1 && 조건 2 위치가 바뀜에 따라 결과값이 충분히 바뀔 수 있다.
			// 조건1이 false이면 조건2를 검사하지 않고 넘긴다.
			// 그러므로 우선순위를 잘 따져야 한다.
			// 밑에서 오류가 나는 이유는 list.get(listIDx).w를 먼저 검사했을 경우
			// listIdx는 ++로 계속 증가하는데 listIdx의 제한범위를 체크해주지 않고
			// 먼저 list의 원소에 접근하면 해당 list에 없는 index에 접근하기 떄문에
			// outOfIndex가 나온다.
			// 그러므로 listIdx가 list의 원소개수 이하인지 체크하고 그 다음 list의 원소에
			// 접근해야 한다.
			while( listIdx < N && list.get(listIdx).w <= bag[i]) {
				Gem gem = list.get(listIdx++);
				pq.add(new Gem(gem.w, gem.p));
			}
			if(!pq.isEmpty()) totalPrice += pq.poll().p;
		}
		
		System.out.println(totalPrice);
	}
}
