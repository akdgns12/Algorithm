package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
	// BOJ_1253 좋다 / 골4 / 투포인터
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int result = 0; // 좋은 수의 개수 
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int find = arr[i];
			int start = 0, end = N-1;
			
			while(start < end) {
				sum = arr[start] + arr[end];
				if(sum == find) {
					if(start != i && end != i) {
						result++;
						break;
					}else if(start == i) start++;
					else if(end == i) end--;
				}else if(sum < find) start++;
				else end--;
			}
		}
		
		System.out.println(result);
	}
}
