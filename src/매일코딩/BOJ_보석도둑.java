package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_�������� {
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
		// ���� ���� ������ �������� ����
		Collections.sort(list, (o1, o2) -> o1.w - o2.w);
		int[] bag = new int[K];
		
		for(int i=0; i<K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		// ���� ���� �������� ����
		Arrays.sort(bag);
		
		// �켱���� ť ���ݼ� ������������ ����
		PriorityQueue<Gem> pq = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
		
		long totalPrice = 0;
		int listIdx = 0;
		for(int i=0; i<K; i++) {
			// ���� 1 && ���� 2 ��ġ�� �ٲ� ���� ������� ����� �ٲ� �� �ִ�.
			// ����1�� false�̸� ����2�� �˻����� �ʰ� �ѱ��.
			// �׷��Ƿ� �켱������ �� ������ �Ѵ�.
			// �ؿ��� ������ ���� ������ list.get(listIDx).w�� ���� �˻����� ���
			// listIdx�� ++�� ��� �����ϴµ� listIdx�� ���ѹ����� üũ������ �ʰ�
			// ���� list�� ���ҿ� �����ϸ� �ش� list�� ���� index�� �����ϱ� ������
			// outOfIndex�� ���´�.
			// �׷��Ƿ� listIdx�� list�� ���Ұ��� �������� üũ�ϰ� �� ���� list�� ���ҿ�
			// �����ؾ� �Ѵ�.
			while( listIdx < N && list.get(listIdx).w <= bag[i]) {
				Gem gem = list.get(listIdx++);
				pq.add(new Gem(gem.w, gem.p));
			}
			if(!pq.isEmpty()) totalPrice += pq.poll().p;
		}
		
		System.out.println(totalPrice);
	}
}
