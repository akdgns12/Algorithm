package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_복습 {
	// 이분탐색 
	/*
	 *	for문으로 집을 하나씩 탐색하면서, 그 전 집과의 거리를 비교하여 최대거리만큼
	 *  떨어져 있으면 공유기를 설치할 수 있게끔 한다. 
	 */
	static int N, M;
	static int house[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(house);
		binarySearch();
	}
	// 최대 거리를 계산하면서, 갯수를 만족하는지 봐야함.
	public static void binarySearch() {
		int before = 0;
		int start = 1;
		int end = house[N] - house[1];
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int count = 1;
			before = house[1];
			for(int i=2; i<=N; i++) {
				// 이전집과의 거리가 최대거리(mid)만큼 떨어져 있으면
				// 공유기 설치
				if(house[i] - before >= mid) {
					count++;
					before = house[i];
				}
			}
			// 설치하려는 공유기 갯수가 M보다 크거나 같으면 간격을 늘려야 하므로 start = mid + 1;
			if(count >= M) {
				start = mid + 1;
			}
			// 설치하려는 공유기 갯수가 M보다 작으면 간격을 줄여야하므로 right = mid - 1;
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
	}
}
