package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선물 {
	// BOJ 1166 선물 / 실 3
	// AxAxA가 가능한 A의 최댓값
	// 입력값 범위 10억이 넘어감..이분탐색
	static long N;
	static long L,W,H;
	static double answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 박스의 개수
		
		L = Integer.parseInt(st.nextToken()); // 차례대로 정육면체 가로,세로,높이
		W = Integer .parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 찾으려는 정육면체 박스의 한변 길이 = mid로 설정해 이분탐색
		double start = 0;
		double end;
		double A;
		
		end = Math.max(L, Math.max(W, H));
		for(int i=0; i<1000; i++) {
			A = (start + end) / 2;
			if((long)(L/A) * (long)(W / A) *
					(long)(H / A) >= N) // 큰상자에 넣을 수 상자의 개수 >= N
				start = A;
			else end = A;
		}
		System.out.println(start);
	} 
}
