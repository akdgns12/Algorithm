package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
	// BOJ_2110 / 공유기설치 / 이분탐색 / 실버 1
	static int N, M;
	static int house[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new int[N];
		
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		// 이분탐색 전 정렬
		Arrays.sort(house);
		// 집마다의 거리를 기준으로 이분탐색
		int start = 1; // 가질 수 있는 최소 거리
		int end = house[N-1] - house[0]; // 가질 수 있는 최대거리
		
		while(start < end) {
			int mid = (start + end) / 2;
			/*
			 * mid 거리에 대해 설치가능한 공유기 개수가 M개수에 못미치면
			 * 거리를 좁혀야 하기 때문에 hi를 줄인다.
			 */
			if(callInstall(mid) < M) {
				end = mid;
			}
			else {
				/*
				 * 설치가능한 공유기 개수가 M개수보다 크거나 같으면
				 * 거리를 벌리면서 최소거리가 가질 수 있는 최대거리를
				 * 찾아낸다.
				 */
				start = mid + 1;
			}
		}
		
		/*
		 * Upper Bound는 탐색값을 초과하는 첫 번째 값을 가리키므로
		 * 1을 뺴준 값이 조건식을 만족하는 최댓값이 됨.
		 */
		System.out.println(start - 1);
	}
	// distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
	public static int callInstall(int distance) {
		// 첫번째 집은 무조건 설치한다고 가정
		int count = 1;
		int lastLocate = house[0];
		
		for(int i=1; i<house.length; i++) {
			int locate = house[i];
			
			/*
			 * 현재 탐색하는 집의 위치와 직전에설치했던 집의 위치간 거리가
			 * 최소 거리(distance)보다 크거나 같을 때 공유기 설치개수를 늘려주고
			 * 마지막 설치 위치를 갱신해준다.
			 */
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
	}
}
