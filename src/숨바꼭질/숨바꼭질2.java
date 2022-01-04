package 숨바꼭질;
//BOJ_12851

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨바꼭질2 {
	
	static int N,K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		4N -3  = K;
	}
	
}
/*
 * <알고리즘>
 * 수빈이 1초당 x좌표 1씩 움진인다, 순간이동 시 2*x
 * 동생의 위치는 k에 고정
 * 
 */