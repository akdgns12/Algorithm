package �켱����ť;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class �������� {
	// BOJ �������� / ���2 / �켱���� ť
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
		
		// ���� ����, ������ list���·� gemŬ������ �־��ش�.
		for(int i=0; i<N; i++) {
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			jurList.add(new gem(weight, price));
		}
		
		// ���� ���Ը� �������� �������� ����
		Collections.sort(jurList, (o1, o2) -> o1.weight - o2.weight); // ���� ���Լ� ����
		
		int[] bagWeight = new int[K];
		
		for(int i=0; i<K; i++) {
			bagWeight[i] = Integer.parseInt(br.readLine());
		}
		
		// ���湫�Դ� �������� ����
		Arrays.sort(bagWeight);
		
		// ���ݼ� �������� �켱����ť
		PriorityQueue<gem> pq = new PriorityQueue<>((o1,o2) -> o2.price - o1.price);
		
		long totalPrice = 0;
		int listIdx = 0;
		for(int i=0; i<K; i++) { // ���氳�� ��ŭ ����
			while(listIdx < N && jurList.get(listIdx).weight <= bagWeight[i]) {
				gem cur = jurList.get(listIdx++);
				pq.add(new gem(cur.weight, cur.price));
			}
			if(!pq.isEmpty()) totalPrice += pq.poll().price;
		}
		
		System.out.println(totalPrice);
	}
}
