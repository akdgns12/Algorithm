package 매일코딩;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class 해쉬맵정렬 {
	public static void main(String[] args) {
		String[] car = {"AVANTE","SONATA","SPOTAGE", "BENZ","BMW","AUDI",
				"TOYOTA","AVANTE","AVANTE","SONATA","SONATA","SPOTAGE","BMW"};
		
		
	}
	
	public String solution(String[] car, int k) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<car.length; i++) {
			map.put(car[i], map.getOrDefault(car[i], 0) + 1);
		}
		
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>(){
			public int compare(Entry<String,Integer> o1, Entry<String, Integer> o2) {
				// 오름차순
				//return o1.getValue().compareTo(o2.getValue());
				// 내림차순
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for(int i=0; i<k; i++) {
			entryList.remove(i);
		}
		
		ArrayList<String> result = new ArrayList<String>();
		
		int min = 0;
		String minKey = "";
		for(Entry<String, Integer> entry : entryList) {
			if(min > entry.getValue()) {
				min = entry.getValue();
			}
		}
		
		for(Entry<String, Integer> entry : entryList) {
			if(entry.getValue() == min) {
				result.add(entry.getKey());
			}
		}
		
		Collections.sort(result);
	
		for(int i=0; i<result.size(); i++) {
			answer = result.get(result.size() - 1);
		}
		
		return answer;
	}
}
