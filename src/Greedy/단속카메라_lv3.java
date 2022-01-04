package Greedy;

import java.util.Arrays;

public class 단속카메라_lv3 {
	public int solution(int[][] routes) {
		int answer = 0; //카메라의 갯수
		int camera = -30001; //카메라 초기 위치
		
		//나간시점을 기준으로 오름차순으로 정렬
		Arrays.sort(routes, (a,b) -> Integer.compare(a[1],  a[1]));
		
		//카메라위치와 나간시점을 기준으로 정렬된 차의 들어온 시점을 비교
		//카메라 위치보다 들어온 시점이 더 크다면 범위를 벗어나므로
		//카메라 한대 늘려주고 카메라 위치를 차량이 나가는 지점에 설치.
		for(int[] route : routes) {
			if(camera < route[0]) {
				camera = route[1];
				answer++;
			}
		}
		
		
		
		
		
		
		
		return answer;
	}
}
