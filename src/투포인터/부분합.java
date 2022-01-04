package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분합 {
	static int N,S;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int end = 0;
		int total = arr[0];
		
		for(int start = 0; start < N; start++) {
			while(end < N && total < S) {
				end++;
				if(end != N)
					total += arr[end];
			}
			if(end == N) break;
			min = Math.min(min, end - start + 1);
			total -= arr[start];
		}
		if(min == Integer.MAX_VALUE) min = 0;
		
		System.out.println(min);
	}

}
