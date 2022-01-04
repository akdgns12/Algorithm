package 카카오기출;
import java.util.*;
public class 메뉴리뉴얼 {
	//coures 배열 = 코스요리 개수
	//orders배열 손님이 주문한 담품메뉴 조합
	//return coures의 수에 맞는 단품메뉴 조합 중 2번이상 나온것
	static ArrayList<String> list = new ArrayList<>();
	public String[] solution(String[] orders, int[] course) {
		String[] answer;
		
		//orders배열의 원소들을 각각 한글자씩 분리.
		//orders 이중 for문으로 돌며 각 문자열마다 문자의 조합 구한뒤 
		//그 조합이 2개이상이고 코스의 단어 수에 맞는지 검사
		//그 문자열들의 합 = arrayList에 담고
		for(int i=0; i<orders.length; i++) { //한 order씩 char array로 변환 -> 오름차순 정렬
			char[] orders_char = orders[i].toCharArray();
			Arrays.sort(orders_char);
			
			for(int index = 0; i<orders_char.length-1; index++) { //한글자씩 차례대로 선택, course 하나씩 바꿔가면서 dfs호출
				for(int j=0; j<course.length; j++) {
					dfs(orders_char, index, 1, course[j], String.valueOf(orders_char[index]));
				}
			}
		}
		
		Map<String, Integer> map = new HashMap<>();
		for(String key : list) {
			map.put(key,  map.getOrDefault(key, 0) +1);
		}
		ArrayList<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		
		ArrayList<String> ansList = new ArrayList<>();
		for(int i=0; i<course.length; i++) {
			int max_value = 0;
			
			for(String key : keySetList) {
				if(map.get(key) >= 2 && key.length() == course[i]) {
					if(map.get(key) >= max_value) {
					ansList.add(key);
					max_value = map.get(key);
				}
			}
		}
	}
	Collections.sort(ansList);
	answer = new String[ansList.size()];
	ansList.toArray(answer);
		
		return answer;
	}
	
	public static void dfs(char[] arr, int idx, int length, int course, String str	) {
		if(length == course) { //단어의 길이가 course의 길이와 같다면 list에 추가
			list.add(str);
		}
		
		for(int i=idx+1; i<arr.length; i++) {
			dfs(arr, i, length+1, course, str+arr[i]);
		}
	}
}
