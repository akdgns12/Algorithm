package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �����⼳ġ_���� {
	// �̺�Ž�� 
	/*
	 *	for������ ���� �ϳ��� Ž���ϸ鼭, �� �� ������ �Ÿ��� ���Ͽ� �ִ�Ÿ���ŭ
	 *  ������ ������ �����⸦ ��ġ�� �� �ְԲ� �Ѵ�. 
	 */
	static int N, M;
	static int house[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(house);
		binarySearch();
	}
	// �ִ� �Ÿ��� ����ϸ鼭, ������ �����ϴ��� ������.
	public static void binarySearch() {
		int before = 0;
		int start = 1;
		int end = house[N] - house[1];
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int count = 1;
			before = house[1];
			for(int i=2; i<=N; i++) {
				// ���������� �Ÿ��� �ִ�Ÿ�(mid)��ŭ ������ ������
				// ������ ��ġ
				if(house[i] - before >= mid) {
					count++;
					before = house[i];
				}
			}
			// ��ġ�Ϸ��� ������ ������ M���� ũ�ų� ������ ������ �÷��� �ϹǷ� start = mid + 1;
			if(count >= M) {
				start = mid + 1;
			}
			// ��ġ�Ϸ��� ������ ������ M���� ������ ������ �ٿ����ϹǷ� right = mid - 1;
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
	}
}
