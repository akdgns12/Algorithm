package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	static int N, C;
	static int arr[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 이분탐색을 위해 먼저 정렬
		Arrays.sort(arr);
		// 이분탐색을 위한 시작점과 끝점 설정
		int start = arr[0];
		int end = arr[arr.length-1];
		int maxRange = 0;
		int d = 0; // 집 마다 거리 체크하는 변수
		int ans = 0;
		// 이분탐색 실행
		while(start <= end) {
			int mid = (start + end) / 2;
			int reStart = arr[0];
			int count = 1; // 공유기 설치 gap 저장
			for(int i=0; i<N; i++) {
				d = arr[i] - reStart; // 집 마다 거리 체크
				if(d >= mid) { // 공유기 설치 가능한지 여부 체크
					count++;
					start = arr[i]; // 설치했다면 여기집부터 다시 거리체크
				}
			}// end for
			
			if(count >= C) {
				ans = mid;
				start = mid + 1; // 더 많은 gap에서 공유기 설치할 수있는지 여부 확인
			}else {
				end = mid - 1;  // 더 적은 gap에서 공유기 설치할 수 있는지 여부 확인
			}	
		}// end while
		System.out.println(ans);
		
	}
}
