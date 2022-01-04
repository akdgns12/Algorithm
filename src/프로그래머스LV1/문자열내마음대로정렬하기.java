import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<strings.length; i++) {
            //n번째 인덱스 문자를 strings각각의 문자의 맨앞에 저장
			list.add(strings[i].charAt(n) + strings[i]);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i).substring(1);
		}
        return answer;
    }
}