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
			
			// 현재 동전의 가치가 k보다 작거나 같아야지 구성가능하다.
			if(arr[i]<=k) {
				
				// 현재 가치의 동전으로 구성할 수 있는 개수를 더해준다.
				count += (k/arr[i]);
				k = k%arr[i];
			}
		}
	}
}
