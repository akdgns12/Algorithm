package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 회의실 배정

/*
 * N개의 회의, 각 회의 i에 대해 시작시간, 종료시간 주어짐.
 * 서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 할 수 있다.
 * 종료 시간 기준으로 정렬 *종료시간이 같은 경우가 있기 때문에 이런 경우에는 시작시점을 기준으로 오름차순으로 정렬해줘야한다.
 */
public class BOJ1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		
		int[][] arr = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			arr[i][0]=sc.nextInt();	
			arr[i][1]=sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] start, int[] end) {
				if(start[1]==end[1]) {
					//종료시간이 같을경우엔 시작시간으로 정렬
					return Integer.compare(start[0],end[0]);
				}
				return Integer.compare(start[1],end[1]);
			}
		});
		
		int count = 0;
		int end = -1;
		for(int i=0; i<n; i++) {
			if(arr[i][0]>=end) {
				end=arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}