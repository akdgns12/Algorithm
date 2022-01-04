package �ָ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {
	
	static int n, m, cnt;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		// �ߺ����� �ؾ��Ѵ�.
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>0; j--) {
				if(arr[i] == arr[j] ) continue;
				else if(arr[i] + arr[j] ==m) {
					cnt++;
					arr[i] = arr[i+1];
				}
			}
		}
		
		System.out.println(cnt);
	}
	
}
