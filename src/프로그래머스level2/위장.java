package 프로그래머스level2;

import java.util.HashMap;
import java.util.Set;

/*
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장한다.
 * 서로 다른 조합의 옷들을 구성해야한다.
 * key값과 value값으로 구성? hahsmap 사용해보자 
 */
public class 위장 {
	public int solution(String[][] clothes) {
		int answer = 1; //곱셈을 위해 1로 선언
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//map 구하기
		for(int i=0; i<clothes.length; i++) {
				// HashMap getOrDefault 사용하면 배열에서 중복되는 값이 몇 개 있는지 확인할 수 있다.
				//의상종류, 갯수
				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1 ); // map.getOrDefault(clothes[i][1], 0) +1) clothes[i][1]라는 키, clothes[i][1]의 값이 존재하면 그 값을 넣어주고 없다면 0), 그리고 +1
		// getOrDefault 찾는키가 존재한다면 찾는키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
		// HashMap의 경우 동일 키 값을 추가할 경우 Value의 값이 덮어쓰기가 된다.따라서 기존 key값의 value를 계속 사용하고 싶을 경우 getOrDefault메서드를 사용한다.
		}
		//조합
		Set<String> keySet = map.keySet(); // 의상종류.
		
		for(String key : keySet) {
			//1.각 종류마다 아무것도 선택하지 않는 경우가 있기 때문에 +1
			//2. 그렇게 구한 값들을 모두 곱해준다.
			//3. 최종적으로 여기서 전부 아무것도 선택하지 않는 경우 하나 빼주면 answer
			answer *= map.get(key) + 1;
		}
		
		return answer-1;
	}
}
