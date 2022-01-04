package 매일코딩;

public class 프로그래머스_문자열압축 {
	class Solution {
	    public int solution(String s) {
	        int answer = s.length();
	        
	        for(int i=1; i<s.length()/2 + 2; i++){
	            String subStr = s.substring(0, i);
	            String output = "";
	            int count = 1;
	            int lastIndex = 0;
	            
	            for(int j=i; j+i<=s.length(); j+= i){
	                String strToCompare = s.substring(j,j+i);
	                
	                if(subStr.equals(strToCompare)){
	                    count++;
	                    // 연속되지 않는다면
	                }else{
	                    if(count > 1){
	                        output += count;
	                        count = 1;
	                    }
	                    output += subStr;
	                    subStr = strToCompare;
	                }
	                lastIndex = j+i;
	            }
	            
	            // 마지막 round에서 기록된 값 업데이트
	            if(count > 1)
	                output += count;
	            output += subStr;
	            
	            if(lastIndex < s.length()){
	                output += s.substring(lastIndex);
	            }
	            
	            answer = Math.min(answer, output.length());
	        }
	        
	        return answer;
	    }
	}	
}
