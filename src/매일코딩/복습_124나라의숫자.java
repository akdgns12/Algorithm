package 매일코딩;

public class 복습_124나라의숫자 {
	    public String solution(int n){
	        String answer = "";
	        
	        String[] str = {"4","1","2"};
	        
	        while(n > 0){
	            answer = str[n%3] + answer;
	            
	            n = n%3 == 0 ? (n-1) / 3 : n/3;
	        }
	        
	        return answer;
	    }
	}

