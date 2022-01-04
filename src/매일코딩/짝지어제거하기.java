package 매일코딩;

public class 짝지어제거하기 {
	import java.util.*;

	class Solution{
	    public int solution(String s){
	        int answer = 0;
	        Stack<String> st = new Stack<>();
	        
	        for(int i=0; i<s.length(); i++){
	            if(st.isEmpty()){
	                st.push(String.valueOf(s.charAt(i)));
	            }else{
	                String lastWord = st.peek();
	                String currWord = String.valueOf(s.charAt(i));
	                if(lastWord.equals(currWord)){
	                    st.pop();
	                }else{
	                    st.push(currWord);
	                }
	            }
	        }
	        
	        return st.size() == 0 ? 1 : 0;
	    }
	}
}
