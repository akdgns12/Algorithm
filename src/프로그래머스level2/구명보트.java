package 프로그래머스level2;

import java.util.Arrays;

/*
 * 구명보트는 한 번에 최대 2명씩 탑승, 무게제한 있다
 * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하라
 * 몸무게를 담은 배열 people, 구명보트의 무게제한 limit
 * 모든 사람을 구출하기 위해 필요한 보트 개수의 최솟값을 return
 */
public class 구명보트 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		
		//몸무게가 적게 나가는 사람 index
		int index = 0;
		for(int i=people.length-1; i>=index; i--) {
			
			//최대 최소 합이 limit보다 크면 제일 무거운 사람 먼저 보냄
			if(people[i] + people[index] > limit) {
				answer++;
			}
			
			// 최대 최소 합이 limit보다 작거나 같으면 둘다 보냄
			else {
				index++;
				answer++;
			}
		}
		
		return answer;
	}
}
