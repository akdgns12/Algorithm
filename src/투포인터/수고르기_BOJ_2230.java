package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_BOJ_2230 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		
		int min = Integer.MAX_VALUE;
		int end = 0;
		
		for(int start = 0; start < N; start++) {
			while(end < N && arr[end] - arr[start] < M) 
				end++;
			if(end == N) break;
			min = Math.min(min, arr[end] - arr[start]);
				
		}
		
		System.out.println(min);
	}

}
