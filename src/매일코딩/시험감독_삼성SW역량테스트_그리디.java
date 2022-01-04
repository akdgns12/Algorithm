package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독_삼성SW역량테스트_그리디 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long total = n;
		for(int i=0; i<n; i++) {
			// 총감독관은 무조건 한명씩필요
			arr[i] -= b;
			
			//부감독관으로 나머지 채우기
			if(arr[i] > 0) {
				total += arr[i] / c;
				
				if(arr[i] % c != 0) {
					total++;
				}
			}
		}
		
		System.out.println(total);
	}
}
