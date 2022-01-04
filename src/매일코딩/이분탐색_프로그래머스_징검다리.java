package 매일코딩;

import java.util.Arrays;
/*
 이분탐색을 하기 위해 배열을 정렬하고
 바위 사이의 최소거리를 mid로 설정해놓고, 이보다 작으면 최소 거리라 가정한 mid에 반례이므로 제거한다.
 바위를 제거할 경우 다음 바위에서 비교할 이전 바위의 값을 알고 있어야 하므로 lastRock을 두어 제거하지
 않았을 경우 현재까지 중에서 마지막인 바위값을 저장한다.
 마지막 바위와 도착지까지의 거리도 mid와 비교해야 하므로 for문 다음에 if문을 추가한다.
 제거한 바위 갯수 remove가 n보다 크다면 mid가 크다는 뜻이므로 줄이고, 반대라면 늘린다.
 answer에는 remove<=n일때 최댓값을 저장한다.
 */
public class 이분탐색_프로그래머스_징검다리 {
	  public int solution(int distance, int[] rocks, int n) {
	        int answer = 0;
	        Arrays.sort(rocks);
	        
	        int start = 1;
	        int end = distance;
	        int mid; // 바위 사이의 최소거리
	        int remove = 0; //제거한 바위 갯수
	        int lastRock = 0; // 마지막 바위
	        while(start <= end) {
	        	mid = (start + end) / 2;
	        	for(int i=0; i<rocks.length; i++) {
	        	if(rocks[i] - lastRock < mid) remove++;
	        	else
	        		lastRock = rocks[i];
	        }
	        	
	        	if(distance - lastRock < mid) remove++; // 마지막 바위와 도착지간의 거리 체크
	        	
	        	if(remove > n) end = mid - 1;
	        	else {
	        		answer = Math.max(answer, mid); 
	        		start = mid + 1;
	        	}
	        	remove = 0;
	        	lastRock = 0;
	        return answer;
	    }
}
