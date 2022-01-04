package DP;

import java.util.Arrays;

public class �����Ա�_level2 {
	// ���α׷��ӽ� lv2 / DP / bottom-up ���
	// i+1�� ���� �ִ��� "i�� �ִ� + i+1���� ������ �� �ִ� �ִ�.
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
