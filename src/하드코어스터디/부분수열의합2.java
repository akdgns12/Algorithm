package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합2 {
	/*
	 * 투 포인터 풀이
	 */
	static int N,S;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int size = N/2;
		int[] a = new int[1<<(N-size)];
		int[] b = new int[1<<(size)];
		for(int i=0; i<(1<<N-size); i++) {
			for(int j=0; j<N-size; j++) {
				if((i&(1<<j)) == (1<<j)) {
					a[i] += arr[j];
				}
			}
		}
		
		for(int i=0; i<(1<<size); i++) {
			for(int j=0; j<size; j++) {
				if((i&(1<<j)) == (1<<j)) {
					b[i] += arr[j+(N-size)];
				}
			}
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int ap = 0;
		int bp = b.length-1;
		long cnt = 0;
		while(ap < a.length && bp > - 1) {
			int av = a[ap], bv = b[bp];
			if(av + bv == S) {
				long ac = 0, bc = 0;
				while(ap < a.length && av == a[ap]) {
					ac++;
					ap++;
				}
				
				while(bp > -1 && bv == b[bp]) {
					bc++;
					bp--;
				}
				cnt += ac * bc;
			}
			
			if(av + bv < S) {
				ap++;
			}else if(av + bv > S) {
				bp--;
			}
		}
		if(S == 0) cnt--;
		System.out.println(cnt);
	}

}
