package 매일코딩;

public class 튜플 {
	import java.util.*;

	class Solution {
	    public int[] solution(String s) {
	    	//1. 튜플을 만들 ArrayList 객체
	        ArrayList<Integer> result = new ArrayList<>();
	        // 2. 가장 앞의 {{를 제거한다
	        s = s.substring(2, s.length());
	        // 3. 가장 뒤의 }}를 제거한 뒤, },{ 형태의 문자열을 -로 바꾼다
	        s = s.substring(0, s.length()-2).replace("},{", "-");
	        // 4. 위에서 바꾼 문자열을 기준으로 split 해준다.
	        String[] arr = s.split("-");
	        
	        // 5. 나눠진 문자열 배열을 길이에 따라 다시 정렬한다.
	        Arrays.sort(arr, new Comparator<String>(){
	            @Override
	            public int compare(String o1, String o2){
	                return Integer.compare(o1.length(),o2.length());
	            }
	        });
	        
	        
	        // 6. 각 문자열을 탐색
	        for(String x : arr){
	        	// 7. 한 문자열마다 ,를 기준으로 split하여 새로운 문자열 배열을 만든다
	            String[] temp = x.split(",");
	            // 8. 새로 만든 문자열 배열에는 정수값만 존재하며 이를 탐색한다
	            for(int i=0; i<temp.length; i++){
	            	// 9. 각 문자열 값을 정수로 바꾼다
	                int n = Integer.parseInt(temp[i]);
	                // 10. 튜플에 들어있는 값이면 skip, 안들어있다면 추가
	                
	                if(result.contains(n))
	                    continue;
	                result.add(n);
	            }
	        }
	        
	        // 튜플에 있는 값들 answer배열로 복사
	        int[] answer = new int[result.size()];
	        for(int i=0; i<result.size(); i++){
	            answer[i] = result.get(i);
	        }
	        
	        
	        return answer;
	    }
	}
}
