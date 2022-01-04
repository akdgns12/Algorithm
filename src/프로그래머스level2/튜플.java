package 프로그래머스level2;

import java.util.HashSet;
import java.util.Set;

/*
 * s 문자열이 주어질 때,
 * <해결순서>
 * 로직 
 * 입력으로 받은 튜플을 각 집합의 길이 오름차순으로 정렬
 * 이 집합을 순회하면서 Set을 이용해서 중복체크를 해준다
 * 만약 Set에 없는 원소라면 추가해주고 있는 원소라면 skip
 * 
 */
public class 튜플 {
	public int[] solution(String s) {
		String[] tmp = s.split("\\{");
		String[] str = new String[tmp.length-2];
		for(int i=0; i<str.length; i++) {
			str[i]=tmp[i+2].substring(0, tmp[i+2].length()-2);
		}
		
		int[] answer = new int[str.length];
		Set <String> set = new HashSet<>();
		Arrays.sort(str, (o1,o2)->o1.length() - o2.length());
		
		for(int i=0; i<str.length; i++) {
			String[] divide = str[i].split(",");
			for(int j=0; j<divide.length; j++) {
				if(set.contains(divide[j])) continue;
				answer[i] = Integer.parseInt(divide[j]);
				set.add(divide[j]);
			}
		}
		return answer;
	}
}
