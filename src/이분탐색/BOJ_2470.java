package �̺�Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2470 {
	// �� ��� / �� 5 / �̺�Ž�� ����� ����
	/*
	 *  1. ����, ����� ���� �迭�� �켱 �������� ����
	 *   -> �� ������ ���� ���� ����, �� �������� ���� ū ���
	 *   ����� ������ ���� ������ �۾�����.
	 *  2. �׷��� �� ������ �����ؼ� Ž���� �����Ѵ�.
	 *  ���� index�� i, ������ index�� j��� �� ��
	 *  i -> , <- j
	 *  �� �����ϸ� i�� j���� Ŀ���� ������ while���� �����ϴ� �ݺ����� §��
	 *  3. �׷��� i�� ���ҿ� j�� ������ ���� ������ �����ϸ�
	 *  ������ ����ߴ� ���񰪺��� ū�� ������ ��
	 *  
	 *  ���� ������ ���񰪺��� ���� ���
	 *  ���信 ��������� ������
	 *  �� �� ���Ҹ� ������ �����صΰ�, �� ������ �̹��� ����ؼ� ���� �������� ����
	 *  �̸� while ������ ��� ������ �ݺ�
	 */
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		binarySearch();
	}
	// ������ ���� ��ƾ� �ϴ��� ���
	/*
	 * �迭 ���� �� �� ������ �� 
	 * target = 0;
	 * �� ������ ���� Ÿ�ٿ� ���� ����� �� ã�ƾ� �ϹǷ�
	 * 
	 */
	public static void binarySearch() {		
		int i = 0;
		int j = arr.length-1;
		
		int gap = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		
		int sum;
		int temp;
		
		while(i < j) {
			sum = arr[i] + arr[j];
			temp = Math.abs(sum); // �� ������ ���� ����
			if(temp < gap) {
				gap = temp;
				ans1 = arr[i];
				ans2 = arr[j];
			}
			if(sum > 0) // ���� ������ j�� �ٿ� ���� 0�� ������
				j--;
			else  // �ݴ�� ���� ������� i�� �÷� ���� 0�� ������
				i++;
				
		}
		System.out.println(ans1 + " " + ans2);
	}
}
