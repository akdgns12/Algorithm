package 프로그래머스level2;

import java.util.Arrays;
import java.util.Collections;

/*
 * 두 배열에서 두 배열의 길이만큼 반복하며
 * 하나씩 뽑아 곱한수를 누적해서 더한다 이 때 최솟값 구하라
 * 
 */
//A에서 가장 작은수 * B에서 가장 큰수 이런식으로 하면 될 듯?

public class 최솟값만들기 {
	public int solution(int []A, int []B) {
		int answer = 0;
		 //A오름차순 정렬
		Arrays.sort(A);
		//B내림차순 정렬
		B = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		
		for(int i=0;i <A.length; i++) {
			
		}
		return answer;
	}
}
