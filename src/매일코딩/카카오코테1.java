package 매일코딩;

import java.util.ArrayList;
import java.util.HashMap;

public class 카카오코테1 {
	public int[] solution(String[] id_list, String[] report, int k) {
		HashMap<String, Integer> map = new HashMap<>();
     
     for(int i=0; i<report.length; i++){
         String[] newReport;
         newReport = report[i].split(" ");
         System.out.println(newReport[0]);
         map.put(newReport[1], map.getOrDefault(newReport[1], 1)+1);
     }
     
     
     ArrayList<String> ban_user = new ArrayList<>();
     
     for(String key : map.keySet()){
         if(map.get(key) >= k){
             ban_user.add(key);        
         }
     }
     
     ArrayList<Integer> result = new ArrayList<>();
     
     for(int i=0; i<report.length; i++){
         String[] str;
         str = report[i].split(" ");
         int count = 0;
             for(int j=0; j<ban_user.size(); j++){
                 if(str[1].equals(ban_user.get(j))){
                     count += 1;
                 }
             }
         result.add(count);
     }
     
     int[] answer = new int[result.size()];
     for(int i=0; i<result.size(); i++){
         answer[i] = result.get(i);
     }
     return answer;
}
}
