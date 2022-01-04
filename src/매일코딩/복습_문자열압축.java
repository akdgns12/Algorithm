package 매일코딩;
/*
 * 실행순서
 * 1. Outter For문으로 index 0 - i까지의 substring 지정
 * 2. Inner For문으로 i길이만큼씩 텍스트를 잘라가며 output 완성
 * 3. output의 길이와 answer 값중 더 작은 값으로 answer 갱신
 * 4. answer 반환
 */
class 복습_문자열압축 {
    public int solution(String s) {
    	int answer = 1000;
    	
    	for(int i=1; i<s.length()/2+2; i++) {
    		String subStr = s.substring(0, i);
    		String output = "";
    		int count = 1;
    		int lastIndex = 0;
    		
    		for(int j=i; j+i<=s.length(); j+= i) {
    			String strToCompare = s.substring(j, j+i);
    			
    			// 연속되는 경우
    			if(subStr.equals(strToCompare)) {
    				count++;
    				// 연속되지 않은 경우
    			}else {
    				if(count > 1) {
    					output += count;
    					count = 1;
    				}
    				output += subStr;
    				subStr = strToCompare;
    			}
    			lastIndex = j+i;
    			
    			if(count > 1) {
        			output += count;
        			output += subStr;
        		}
    			
    			if(lastIndex < s.length()) {
    				output += s.substring(lastIndex);
    			}
    			
    			answer = Math.min(answer, output.length());
    		}
    		
    		
    	}
    	
    	return answer;
    }
}
