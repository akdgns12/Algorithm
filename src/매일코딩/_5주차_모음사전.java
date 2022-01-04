package 매일코딩;

public class _5주차_모음사전 {
	// 프로그래머스 lv2 / 위클리 5주차 / 모음사전
	class Solution {
	    public int solution(String word) {
	        int answer = 0;
	        char[] ch = {'A', 'E', 'I', 'O', 'U'};
	        int sum = 781;
	        for(int i=0; i<word.length(); i++){
	            for(int j=0; j<5; j++){
	                if(ch[j] == word.charAt(i)){
	                    answer += 1 + j * sum;
	                }
	            }
	            sum = (sum - 1) / 5;
	        }
	        return answer;
	    }
	}
}
