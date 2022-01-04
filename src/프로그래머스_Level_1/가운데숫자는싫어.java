package 프로그래머스_Level_1;

import java.util.ArrayList;

/*
 * 배열 arr가 주어지고, 각 원소는 0~9까지로 이뤄짐
 * 연속적으로 나타나는 숫자는 하나만 남기고 제거
 * 제거된 후 남은 수들 반환
 */
public class 가운데숫자는싫어 {
	public int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		int current = 10; //조건이 0~9까지이므로 10이면 무조건 밑에 if문 만족
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != current) {
				list.add(arr[i]);
				current = arr[i];
			}
		}
		
		int [] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
