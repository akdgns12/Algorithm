package 매일코딩;

import java.util.Arrays;

public class 프로그래머스_H_Index {
	 public int solution(int[] citations) {
	        int answer = 0;
	        int n = citations.length;
	        // n편중 h번 이상인게  h편 이상
	        // 나머지는 h번 이하 인용되어야 H-index
	        Arrays.sort(citations);
	        for(int i=0; i<citations.length; i++) {
	        	citations[i]
	        }
	        return answer;
	    }
}
