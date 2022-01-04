package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이3 {
	static long m,n;
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		if(m>n) {
			sb.append(((n-1)*2+1)+"\n");
		}else {
			sb.append(((m-1)*2)+"\n");
		}
		
		if(m==n) {
			if(m%2==1) {
				sb.append((m/2+1)+" "+(n/2+1) +"\n");
			}else {
				sb.append((m/2+1)+" "+(n/2) +"\n");
			}
	 	}else if(m>n) {
	 		if(n%2==0) {
	 			sb.append((n/2+1) +" "+(n/2)+"\n");
	 		}else {
	 			sb.append((n/2+1+(m-n)) +" "+(n/2+1)+"\n");
	 		}
	 	}else {
	 		if(m%2==0) {
	 			sb.append((m/2+1) +" "+(m/2)+"\n");
	 		}else {
	 			sb.append((m/2+1)+" "+(m/2+1+(n-m))+"\n");
	 		}
	 	}
		System.out.println(sb.toString());
		
	}
}
