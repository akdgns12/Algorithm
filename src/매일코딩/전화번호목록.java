package �����ڵ�;

public class ��ȭ��ȣ��� {
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
