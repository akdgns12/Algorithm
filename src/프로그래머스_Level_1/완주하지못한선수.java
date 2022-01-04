package 프로그래머스_Level_1;

import java.util.HashMap;

//import java.util.Arrays;

/*
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의
 * 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 
 * return 하도록 하는 solution함수
 */
/*
 * <착상>
 * 
 */
/*
public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		String temp = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i=0;
		while(i<completion.length) {
			if(!completion[i].equals(participant[i])) {
				temp = participant[i];
				break;
			}else {
				i++;
			}
		}
		
		if(!temp.equals("")) {
			answer = temp;
		}else {
			answer = participant[participant.length-1];
		}
		
		return answer;
	}
}
*/
// 다른 풀이 hashmap 사용
public class 완주하지못한선수{
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		//hashmap, getOrDefault(key, 0) 찾는키의 값이 존재하면 키의 값을 반환하고 없다면 0반환
		for(String player : participant) hm.put(player, hm.getOrDefault(player,0)+1);
		for(String player : completion) hm.put(player, hm.get(player) - 1);
		
		//keySet map의 키값 다 받아옴, entrySet map의 key값과 value값 다 뽑아옴
		for(String key : hm.keySet()) {
			if(hm.get(key) !=0	) {
				answer = key;
			}
		}
		return answer;
	}
}