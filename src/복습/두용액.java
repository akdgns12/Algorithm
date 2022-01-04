package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int i = 0;
		int j = arr.length - 1;
		int gap = Integer.MAX_VALUE;
		int sum;
		int temp;
		int ans1 = 0, ans2 = 0;
		while(i < j) {
			sum = arr[i] + arr[j];
			temp = Math.abs(sum);
			if(temp < gap) {
				gap = temp;
				ans1 = arr[i];
				ans2 = arr[j];
			}
			
			if(sum < 0) {
				i++;
			}else {
				j--;
			}
		}
		System.out.println(ans1 + " " + ans2);
	}

}
