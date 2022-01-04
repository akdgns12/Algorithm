package DP;

import java.util.Arrays;

public class 땅따먹기_level2 {
	// 프로그래머스 lv2 / DP / bottom-up 방식
	// i+1의 값의 최댓값은 "i의 최댓값 + i+1에서 선택할 수 있는 최댓값.
	public int solution(int[][] land) {
		for(int i=1; i<land.length; i++) {
			land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
			land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
			land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
			land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
		}
		int[] answer = land[land.length-1];
		Arrays.sort(answer);
		return answer[answer.length-1];
	}
}
