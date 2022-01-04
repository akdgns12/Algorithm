package ��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2461 {
	// ��ǥ ���� / ��2 / �� ������
	static int[] arr;
	static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N*M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// �� �ݿ��� ��ǥ�� �̴� ����� �� = mC1 = m, ���� N���̱� ������ M^N�� ����� ��
		/*
		 * ������, �� ������ �ᱹ �� �� ��ǥ�� �� �ִ�-�ּ� ���� ���ؾ� �ϴ� ����
		 * �� �� ��ǥ�� �ɷ�ġ�� 10,20,30,40,100�� ��� 100-10=90�̰� ����������
		 * 10,11,12,13,100�� ��쿡�� 90�̴�.
		 * ��������� �ִ� or �ּ� ���� ��ȭ��Ű�� �ȴ�
		 */
		/*
		 * ����
		 * 1. �� ���� �ɷ�ġ ������ ������������ �����Ѵ�
		 * 2. �� ���� ó�� ��(���� ū ��)�� �ϳ��� �̴´�
		 * 3. �� ���� �� ���� ū ���� ���� ���� ���Ͽ� ����
		 * 4. ���� ū ���� �����ϰ�, �� �ݿ��� �ش� ���� ���� �ε��� ���� �ٽ� ã�´�
		 * 5. �ϳ��� ���� ��� ����� Ž���ߴٸ� �����ϰ�, �ƴϸ� 3������ ���ư��� ��
		 */
		Arrays.sort(arr);
		// ��ǥ�� ���ߵ� ��� �л��� �ɷ�ġ�� �ִ񰪰� �ּڰ� ���̰� �ּҰ� �Ǵ°���� �� return
		int start = arr[0];
		int end = arr[N-1];
		int max = 0;
		int min = 0;
		int ans = 0;
		
	
			
			while(end < arr.length) {
				max = arr[end];
				min = arr[start];
				ans = Math.min(ans, max-min);
				start++;
				end++;
				if(end == arr.length) break;
			}
		
		
		System.out.println(ans);
		
	}
}
