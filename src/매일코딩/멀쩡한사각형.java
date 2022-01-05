package 매일코딩;
//
public class 멀쩡한사각형 {


	class Solution{
	    public long solution(int w, int h){
	        long answer = 0;
	        for(int i=0; i<w; i++){
	                answer += (Long.valueOf(h) * i) / Long.valueOf(w);
	            
	        }
	         return answer*2;
	    }
	}
}
