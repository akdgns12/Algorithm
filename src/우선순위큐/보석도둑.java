package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑 {
	// BOJ 보석도둑 / 골드2 / 우선순위 큐
	static class gem {
		int weight;
		int price;
		
		public gem(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<gem> jurList = new ArrayList<>();
		
		// 보석 무게, 가격을 list형태로 gem클래스에 넣어준다.
		for(int i=0; i<N; i++) {
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			jurList.add(new gem(weight, price));
		}
		
		// 보석 무게를 기준으로 내림차순 정렬
		Collections.sort(jurList, (o1, o2) -> o1.weight - o2.weight); // 보석 무게순 정렬
		
		int[] bagWeight = new int[K];
		
		for(int i=0; i<K; i++) {
			bagWeight[i] = Integer.parseInt(br.readLine());
		}
		
		// 가방무게는 오름차순 정렬
		Arrays.sort(bagWeight);
		
		// 가격순 내림차순 우선순위큐
		PriorityQueue<gem> pq = new PriorityQueue<>((o1,o2) -> o2.price - o1.price);
		
		long totalPrice = 0;
		int listIdx = 0;
		for(int i=0; i<K; i++) { // 가방개수 만큼 돈다
			while(listIdx < N && jurList.get(listIdx).weight <= bagWeight[i]) {
				gem cur = jurList.get(listIdx++);
				pq.add(new gem(cur.weight, cur.price));
			}
			if(!pq.isEmpty()) totalPrice += pq.poll().price;
		}
		
		System.out.println(totalPrice);
	}
}
