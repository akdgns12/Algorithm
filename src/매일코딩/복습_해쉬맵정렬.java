package �����ڵ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ����_�ؽ������� {
	// �־��� car �迭���� 
	// ���� k����ŭ�� car �����ϰ� ���� ���� car�̸� �̾ƶ�
	// ������ �Ȱ��� car�� ������ �ϰ��
	// ���ĺ� ������ ������ ������ ���� ���� car�̸� return
	public String solution(String[] car, int k) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<car.length; i++) {
			map.put(car[i], map.getOrDefault(car[i], 0) + 1);
		}
		
		// value�� �������� �������� ����
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>(){
			public int compare(Entry<String, Integer> o1, Entry<String,Integer> o2) {
				return o1.getValue().compareTo(o2.getValue()); 
			}
		});
		
		
		// entryList���� ���� K�� ã�� ����
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
		
		// ���� �� ����
		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++) {
			answer = result.get(result.size() - 1);
		}
		return answer;
	}
}
