package 해시;
import java.util.HashMap;
import java.util.HashSet;

public class 위장_level2 {
	public int solution(String[][] clothes) {
		int answer = 1; //곱셉을 위하여 1로 바꿔줌
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//key = 종류, value= 이름
		
		for(int i=0; i<clothes.length; i++) {
			//의상종류, 갯수
				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);	// map에 종류 ,이름 넣음
		}
		
		
		HashSet<String> keySet = new HashSet<String>(map.keySet());
		
		for(String key : keySet) {
			answer *= map.get(key) +1 ; //각 종류들은 하나를 입거나, 
			//안입거나의 선택지가 있기 때문에 옷의 개수에 안입는 선택지를 하나 추가한다
			// 그리고 옷을 고르는 선택은 동시에 일어나는 일이기 때문에, 각 옷들을 곱해 경우의 수를 구한다.
			}
		
		return answer-1; //아무것도 안입는 경우를 빼준다
	}
}
