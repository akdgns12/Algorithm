package 매일코딩;

public class 문제비교클러스터링 {
	import java.util.*;

	class Solution {
	    public int solution(String str1, String str2) {
	        int answer = 0;
	        // str1 2글자씩 끊은 list
	        ArrayList<String> multiSet1 = new ArrayList<>();
	        // str2 2글자씩 끊은 list
	        ArrayList<String> multiSet2 = new ArrayList<>();
	        // 교집합
	        ArrayList<String> equalSet = new ArrayList<>();
	        // 합집합
	        ArrayList<String> sumSet = new ArrayList<>();
	        
	        // str1, str2 소문자화 시켜준다
	        str1 = str1.toLowerCase();
	        str2 = str2.toLowerCase();
	        
	        for(int i=0; i<str1.length()-1; i++){
	            char first = str1.charAt(i);
	            char second = str1.charAt(i+1);
	            
	            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z'){
	                multiSet1.add(first + "" + second);
	            }
	        }
	        
	        for(int i=0; i<str2.length()-1; i++){
	            char first = str2.charAt(i);
	            char second = str2.charAt(i+1);
	            
	            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z'){
	                multiSet2.add(first + "" + second);
	            }
	        }
	        
	        
	        Collections.sort(multiSet1);
	        Collections.sort(multiSet2);
	        
	        // 합집합 교집합 구하기
	        for(String s : multiSet1){
	            if(multiSet2.contains(s)){
	                // 두 리스트의 공통 원소 교집합에 넣어준다
	                equalSet.add(s);	
	                // 넣어준 공통원소 제거
	                multiSet2.remove(s);
	            }
	            sumSet.add(s);
	        }
	        
	        // 남은 원소 합집합에 넣어준다.
	        for(String s : multiSet2){
	            sumSet.add(s);
	        }
	        
	        double jakard = 0;
	        
	        if(sumSet.size() == 0){
	            jakard = 1;
	        }else{
	            jakard = (double)equalSet.size() / (double)sumSet.size();
	        }
	        
	        
	        return (int)(jakard * 65536);
	    }
	}
}
