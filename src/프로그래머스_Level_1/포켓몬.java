package 프로그래머스_Level_1;

import java.util.HashSet;

/*
 * 연구실에 있는 총 N마리의 포켓몬 중 N/2마리를 가져가도 좋다
 * 중복 허용 x
 * hashset은 중복 허용 x
 */
public class 포켓몬 {
	public int solution(int[] nums) {
				
		int max = nums.length/2;
		
		//중복 제거하기
		HashSet<Integer> numsSet = new HashSet<>();
		
		for(int num : nums) {
			numsSet.add(num);
		}
		
		// 중복을 제거한 셋의 크기가 max보다 크면 max를, 작으면 numsSet의 size를 리턴
		if(numsSet.size()>max) {
			return max;
		} else {
			return numsSet.size();
		}
	}
}
