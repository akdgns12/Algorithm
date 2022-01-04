package 매일코딩;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class 복습_해쉬맵정렬 {
	// 주어진 car 배열에서 
	// 상위 k개만큼의 car 제외하고 가장 작은 car이름 뽑아라
	// 개수가 똑같은 car가 여러대 일경우
	// 알파벳 순으로 나열한 순서가 가장 뒤인 car이름 return
	public String solution(String[] car, int k) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<car.length; i++) {
			map.put(car[i], map.getOrDefault(car[i], 0) + 1);
		}
		
		// value값 기준으로 내림차순 정렬
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>(){
			public int compare(Entry<String, Integer> o1, Entry<String,Integer> o2) {
				return o1.getValue().compareTo(o2.getValue()); 
			}
		});
		
		
		// entryList에서 상위 K개 찾아 제거
		for(int i=0; i<k; i++) {
			entryList.remove(i); 
		}
		
		int min = 0;
		String minKey = "";
		for(Entry<String, Integer> entry : entryList) {
			if(min > entry.getValue()) {
				min = entry.getValue();
			}
			minKey = entry.getKey();
		}
		
		ArrayList<String> result = new ArrayList<>();
		for(Entry<String, Integer> entry : entryList) {
			if(min == entry.getValue()) {
				result.add(entry.getKey());
			}
		}
		
		// 사전 순 정렬
		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++) {
			answer = result.get(result.size() - 1);
		}
		return answer;
	}
}
