package 프로그래머스_Level_1;

	import java.util.ArrayList;
	import java.util.Arrays;

/*
 * array의 각 element중 divisor로 나누어 떨어지는 값을 오름차순으로
 * 정렬한 배열을 반환하는 함수, solution
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아
 * 반환
 */
public class 나누어떨어지는숫자배열 {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};	
		ArrayList<Integer> list = new ArrayList<>();	
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%divisor == 0) {
					list.add(arr[i]);
			}
		}
		
		if(list.isEmpty()) {
			list.add(-1);
		}
		answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
}
