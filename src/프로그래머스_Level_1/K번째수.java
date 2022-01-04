package 프로그래머스_Level_1;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 빈 리스트를 만든다
 * 시작범위, 끝 범위에 해당하는 배열을 리스트에 넣는다
 * 리스트를 정렬하고 해당하는 원소의 인덱스를 넣는다
 */
public class K번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<commands.length; i++) {
			list.clear();
			int start = commands[i][0]-1;
			int end = commands[i][1]-1;
			int stop = commands[i][2]-1;
			
			for(int j=start; j<=end; j++) {
				list.add(array[j]);
			}
			
			Collections.sort(list);
			answer[i] = list.get(stop);
		}
		
		
		return answer;
	}
}
