package 프로그래머스level3;

import java.util.HashSet;

public class 풍선터트리기 {
	public int solution(int[] a) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		int min = a[0];
		//접근방식
		//left,right 방식으로 2개의 풍선의 기준으로 보았을 때,
		//제일 왼쪽,오른쪽 풍선은 마지막까지 남길 수 있다.
		//가운데 풍선의 경우, left와 right중 하나가 되기위해서는 왼,오보다
		//숫자가 작아야한다.
		
			for(int i=1; i<a.length; i++) {
				set.add(min);
				min = Math.min(a[0], min);
			}
			
			min = a[a.length-1];
			for(int i=a.length-2; i>=0; i--) {
				set.add(min);
				min = Math.min(a[i], min);
			}
		
		
		
		return set.size();
	}
}
