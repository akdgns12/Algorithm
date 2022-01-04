package 자료구조;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드2 {
	// 이분탐색, upper_bound, lower_bound
	/*
	 * lower_bound : 왼쪽부터 볼 때, 찾고자  하는 값이 같거나 큰경우를 처음 만나는 위치
	 * upper_bound : 찾고자 하는 값을 초과한 값을 처음 만나는 위치(쉽게 말해 찾고자 하는 값보다 큰 값의 위치를 반환하는 것)
	 * 
	 * 이 문제에서 적용
	 * 중복 원소에 대한 길이 : (상한 - 하한)
	 * 
	 * 이분탐색
	 * - 구간 내의 중앙 위치의 값을 기준으로 key값과 비교한뒤, 상한선을 내릴 것인지
	 * 하한선을 올릴 것인지를 결정하는 것
	 * 
	 */
	static  int[] arrN;
	
	public static void main(String[] args) throws IOException{
	Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);	// 이분 탐색을 하기 위해서는 반드시 정렬되어있어야 한다.
		
		int M = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int key = in.nextInt();
 
			// upperBound와 lowerBound의 차이 값을 구한다.
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
	}
 
 
	private static int lowerBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {
 
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
 
			/*
			 *  key 값이 중간 위치의 값보다 작거나 같을 경우
			 *  
			 *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
			 */
			if (key <= arr[mid]) {
				hi = mid;
			}
 
			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
 
	private static int upperBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {
 
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if (key < arr[mid]) {
				hi = mid;
			}
			// 중복원소의 경우 else에서 처리된다.
			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
	
}
