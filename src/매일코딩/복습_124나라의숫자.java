package �����ڵ�;

public class ����_124�����Ǽ��� {
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

