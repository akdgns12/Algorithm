package �����ڵ�;

public class ���α׷��ӽ�_���ڿ����� {
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
	                    // ���ӵ��� �ʴ´ٸ�
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
	            
	            // ������ round���� ��ϵ� �� ������Ʈ
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
