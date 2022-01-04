package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class C11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		
		int count =0;
		for(int i=n-1; i>=0; i--) {
			
			// ���� ������ ��ġ�� k���� �۰ų� ���ƾ��� ���������ϴ�.
			if(arr[i]<=k) {
				
				// ���� ��ġ�� �������� ������ �� �ִ� ������ �����ش�.
				count += (k/arr[i]);
				k = k%arr[i];
			}
		}
	}
}
