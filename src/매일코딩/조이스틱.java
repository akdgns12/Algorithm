package 매일코딩;

public class 조이스틱 {
	// 상하이동, 좌우이동
	// 좌우이동의 경우
	// 오른쪽으로만 순서대로 이동하는 경우 -> len - 1번 이동
	// (오른쪽으로 가다가)연속된 A를 만나 다시 왼쪽으로 돌아가 이동하는 경우
	class Solution {
	    public int solution(String name) {
	        int answer = 0;
	        int len = name.length(); 
	        int move = len - 1; // 오른쪽으로만 순서대로 이동하는 경우 len-1번 이동
	        
	        
	        for(int i=0; i<name.length(); i++){
	            char c = name.charAt(i);
	            // 상하이동
	            if('M' - c >= 0){ // A부터 M사이
	                answer += c - 'A';
	            }else{ // M부터 Z사이
	                answer += 'Z' - c + 1;
	            }
	            
	            int nextIdx = i + 1;
	            // 다음 글자부터 연속된 A가 있는 경우 되돌아가는게 빠른지 확인
	            while(nextIdx < len && name.charAt(nextIdx) == 'A'){
	                nextIdx++;
	            }
	            
	            move = Math.min(move, i+i+len-nextIdx);
	        }
	        
	        answer+=move;
	        return answer;
	    }
	}
}
