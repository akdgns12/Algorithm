package 매일코딩;

public class 점프와순간이동 {
	import java.util.*;

	public class Solution {
	    public int solution(int n) {
	        int ans = 0;
	        
	        while(n!=0){
	            if(n%2==0){
	                n /=2;
	            }else{
	                n--;
	                ans++;
	            }
	        }

	        return ans;
	    }
	}
}
