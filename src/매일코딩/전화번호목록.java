package 매일코딩;

public class 전화번호목록 {
	import java.util.*;

	class Solution{
	    public boolean solution(String[] phone_book){
	        boolean answer = true;
	        HashMap<String, String> map = new HashMap<>();
	        
	        for(int i=0; i<phone_book.length; i++){
	            map.put(phone_book[i], "prefix");
	        }
	        
	        for(String phone : phone_book){
	            for(int j=0; j<phone.length(); j++){
	                if(map.containsKey(phone.substring(0, j))){
	                    answer = false;
	                }
	            }
	        }
	        
	        
	            
	        
	        return answer;
	    }
	}
}
