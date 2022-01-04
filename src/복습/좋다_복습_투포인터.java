package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_복습_투포인터 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			int find = arr[i];
			int start = 0, end = N-1;
			
			while(start < end) {
				int sum = arr[start] + arr[end];
				if(sum == find) {
					if(start != i && end != i) {
						result++;
						break;
					}
					else if(start == i) {
						start++;
					}
					else if(end == i) {
						end--;
					}
				}
				else if(sum > find) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		
		System.out.println(result);
	}

}
