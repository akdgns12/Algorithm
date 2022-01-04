package Greedy;

import java.util.Scanner;

public class BOJ5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = {500, 100, 50, 10, 5, 1};
		int cost = 1000 - n;
		int count = 0;
		
		for(int i=0; i<6; i++) {
				if(cost/arr[i]>0) {
					count += cost/arr[i];
					cost = cost%arr[i];
				}
		}
		System.out.println(count);
	}
}
