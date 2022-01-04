package 프로그래머스_Level_1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 정수 배열 numbers가 주어지고 numbers에서 서로 다른 인덱스에 있는
 * 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아
 * return
 */
public class 두개뽑아서_더하기 {
	public int[] solution(int[] numbers	) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++	) {
				int a = numbers[i] + numbers[j];
				if(list.indexOf(a) < 0) {
					list.add(a);
				}
			}
		}
		int [] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
			
		}
		Arrays.sort(answer);
		
		return answer;
	}
}
