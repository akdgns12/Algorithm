package 프로그래머스level2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 0또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내주세요
 * 
 */
public class 가장큰수 {
	
	public String solution(int[] numbers) {
		String answer = "";
		
		//int 배열을 String배열로 변환
		String[] arr = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			arr[i] = (String.valueOf(numbers[i]));
		}
		
		//배열 정렬, 정렬 규칙으로는 2개를 더하여 더 큰 쪽이 우선순위가 있도록 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			// a+b와 b+a 중 더 큰 것 기준으로 정렬
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2);
			}
		});
		
		//0000처럼 0으로만 구성되어 있으면 0 return
		if(arr[0].equals("0")) return "0";
		
		//그 외의 경우 순차적으로 연결하여 answer return
		for(int i=0; i<arr.length; i++) {
			answer += arr[i];
		}
		return answer;
	}
}
