package 매일코딩;

public class 이진변환_복습 {
	class Solution {
	    //s가 1이 될때까지 계속해서 이진변환했을 때
	    // 이진변환의 횟수와 변환 과정에서 제거된 모든 0의 개수
	    public int[] solution(String s) {
	        int[] answer = new int[2];
	        
	        int count = 0;
	        int count_zero = 0;
	        
	        while(!s.equals("1")){
	            int count_one = 0;
	        for(int i=0; i<s.length(); i++){
	            if(s.charAt(i) == '1'){
	                count_one++;
	            }else{
	                count_zero++;
	            }
	        }
	             s = Integer.toBinaryString(count_one);
	            count++;
	        }
	       
	        answer[0] = count;
	        answer[1] = count_zero;
	        
	        return answer;
	    }
	}
}
