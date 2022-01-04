package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int prev = 0; // 이전까지의 대기시간 총합
		int sum = 0; //대기시간 총합
		
		for(int i=0;i<n;i++) {
			// 이전까지의 대기시간과 현재사람이 걸리는 시간을 더해준다
			sum +=prev + arr[i];
			// 이전까지의 누적합에 현재 걸리는 시간을 더해준다.
			prev += arr[i];
		}
		System.out.println(sum);
	}
}
