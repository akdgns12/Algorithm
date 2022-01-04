package 매일코딩;

import java.util.HashMap;

public class 카카오코테 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		HashMap<String, Integer> map = new HashMap<>();
		
		
		for(int i=0; i<report.length; i++) {
			String[] newReport;
			newReport = report[i].split(" ");
			map.put(newReport[1], map.getOrDefault(newReport[1], 0) + 1);
		}
		
		for(String str : map.keySet()) {
			
		}
		
		
		
		return answer;
	}
}
